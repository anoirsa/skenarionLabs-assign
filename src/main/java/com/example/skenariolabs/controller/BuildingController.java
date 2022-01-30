package com.example.skenariolabs.controller;

import com.example.skenariolabs.model.building.properties.BuildingReadWrite;
import com.example.skenariolabs.model.response.ResponseObject;
import com.example.skenariolabs.service.BuildingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v4/buildings")
@AllArgsConstructor
public class BuildingController {

    private final BuildingService buildingService;

    @GetMapping
    public @ResponseBody
    ResponseObject getBuilding() {
      return buildingService.getAllBuilding();
    }

    @GetMapping("/find/buildingName={buildingName}")
    public  @ResponseBody
    ResponseObject getBuildingByName(@PathVariable String buildingName ) {
        return buildingService.getBuildingByBuildingName(buildingName);
    }

    // Don't add any coordinates, the coordinates will be found out by the building address
    @PostMapping("/addbuilding")
    public @ResponseBody
    ResponseObject addBuilding (@RequestBody BuildingReadWrite buildingReadWrite) {
        return buildingService.addBuilding(buildingReadWrite);
    }

    // Add just the new name you would like to have and the new description
    @PutMapping("/update/buildingName={buildingName}")
    public @ResponseBody
    ResponseObject updateBuilding(@PathVariable String buildingName,
                                  @RequestBody BuildingReadWrite buildingReadWrite) {
        return buildingService.updateBuilding(buildingName, buildingReadWrite);
    }




}
