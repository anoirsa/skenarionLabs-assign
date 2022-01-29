package com.example.skenariolabs.service;


import com.example.skenariolabs.dataRepo.BuildingDataRepo;
import com.example.skenariolabs.model.building.Building;
import com.example.skenariolabs.model.building.BuildingReadWrite;
import com.example.skenariolabs.model.response.ResponseObject;
import lombok.AllArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.core.Constants;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BuildingService {
    private final MappingServices mappingServices;
    private final BuildingDataRepo buildingDataRepo;


    public ResponseObject addBuilding(BuildingReadWrite building) {
        Building newBuilding = mappingServices.mapToBuilding(building);
        ResponseObject responseObject = new ResponseObject(building);
        try {
        Building buildingAdded = buildingDataRepo.save(newBuilding);
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
