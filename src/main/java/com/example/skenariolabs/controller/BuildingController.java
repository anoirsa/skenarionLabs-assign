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

    @PostMapping("/addbuilding")
    public @ResponseBody
    ResponseObject addBuilding (@RequestBody BuildingReadWrite buildingReadWrite) {
        return buildingService.addBuilding(buildingReadWrite);
    }




}
