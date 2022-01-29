package com.example.skenariolabs.service;


import com.example.skenariolabs.dataRepo.BuildingDataRepo;
import com.example.skenariolabs.model.building.coordinates.CoordinatesReadWrite;
import com.example.skenariolabs.model.building.properties.Building;
import com.example.skenariolabs.model.building.properties.BuildingReadWrite;
import com.example.skenariolabs.model.response.ResponseObject;
import lombok.AllArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BuildingService {
    private final MappingServices mappingServices;
    private final BuildingDataRepo buildingDataRepo;
    private final  ExternalApiService externalApiService;


    public ResponseObject addBuilding(BuildingReadWrite building) {
        CoordinatesReadWrite coordinatesFound = externalApiService.getCoordinates(building.getFullAddress());
        ResponseObject responseObject = new ResponseObject(building);
        building.setBuildingCoordinates(coordinatesFound);
        Building newBuilding = mappingServices.mapToBuilding(building);
        if (coordinatesFound == null) {
            responseObject.setError(true);
            responseObject.setErrorText("API call failure");
        }
        try {
        buildingDataRepo.save(newBuilding);
        }
        catch (ConstraintViolationException e) {
            responseObject.setError(true);
            responseObject.setErrorText("Insertion failed, constraints problem");
        }

        return responseObject;
    }

    public ResponseObject getAllBuilding() {
        List<Building> allBuildings = buildingDataRepo.findAll();
        List<BuildingReadWrite> buildingReadWrites = mappingServices.mapToBuildingReadWriteArray(allBuildings);
        ResponseObject responseObject = new ResponseObject(buildingReadWrites);
        return  responseObject;
    }

}
