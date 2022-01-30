package com.example.skenariolabs.service;


import com.example.skenariolabs.model.building.properties.Building;
import com.example.skenariolabs.model.building.properties.dtaos.BuildingReadWrite;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MappingServices {
    private DozerBeanMapper mapper;

    public MappingServices() {
        this.mapper = new DozerBeanMapper();
    }
    public Building mapToBuilding(BuildingReadWrite buildingReadWrite) {
        Building building = mapper.map(buildingReadWrite, Building.class);
        return  building;
    }

    public BuildingReadWrite mapToBuildingReadWrite(Building building) {
        BuildingReadWrite buildingReadWrite = mapper.map(building, BuildingReadWrite.class);
        return buildingReadWrite;
    }

    public List<BuildingReadWrite> mapToBuildingReadWriteArray(List<Building> buildings) {
        List<BuildingReadWrite> mappedArray = buildings.stream()
                .map(building -> mapper.map(building, BuildingReadWrite.class)).collect(Collectors.toList());
        return mappedArray;
    }


}
