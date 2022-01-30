package com.example.skenariolabs.service;


import com.example.skenariolabs.model.building.properties.dtaos.BuildingUpdate;
import com.example.skenariolabs.repository.BuildingRepository;
import com.example.skenariolabs.model.building.coordinates.dtaos.CoordinatesReadWrite;
import com.example.skenariolabs.model.building.properties.Building;
import com.example.skenariolabs.model.building.properties.dtaos.BuildingReadWrite;
import com.example.skenariolabs.model.response.ResponseObject;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class BuildingService {
    private final MappingServices mappingServices;
    private final BuildingRepository buildingDataRepo;
    private final ExternalApiService externalApiService;

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
        } catch (Exception e) {
            responseObject.setError(true);
            responseObject.setErrorText("Insertion failed for the reason " + e);
        }

        return responseObject;
    }

    public ResponseObject getAllBuilding() {
        List<Building> allBuildings = buildingDataRepo.findAll();
        List<BuildingReadWrite> buildingReadWrites = mappingServices.mapToBuildingReadWriteArray(allBuildings);
        ResponseObject responseObject = new ResponseObject(buildingReadWrites);
        return responseObject;
    }

    public ResponseObject updateBuilding(String buildingName,
                                         BuildingUpdate buildingUpdate) {
        ResponseObject responseObject = new ResponseObject(buildingUpdate);
        List<Building> buildingFound = buildingDataRepo
                .getBuildingByBuildingName(buildingName);
        if (buildingFound.size() == 0) {
            responseObject.setNote("No building with that name is found");
        } else {

            try {
                buildingDataRepo.updateBuilding(buildingName,
                        buildingUpdate.getBuildingName(),
                        buildingUpdate.getBuildingDescription());

            } catch (Exception e) {
                responseObject.setError(true);
                responseObject.setErrorText("Update data failed for the reason " + e);
            }
        }
        return responseObject;
    }

    public ResponseObject getBuildingByBuildingName(String buildingName) {
        List<Building> buildingFound = buildingDataRepo
                .getBuildingByBuildingName(buildingName);
        ResponseObject responseObject = new ResponseObject();
        if (buildingFound.size() == 0) {
            responseObject.setNote("No building found with that name");
        } else {
            List<BuildingReadWrite> buildingFoundRead =
                    mappingServices.mapToBuildingReadWriteArray(buildingFound);
            responseObject.setData(buildingFoundRead);
        }
        return responseObject;
    }


}
