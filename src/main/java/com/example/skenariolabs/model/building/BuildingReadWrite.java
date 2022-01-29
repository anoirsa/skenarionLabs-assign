package com.example.skenariolabs.model.building;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor

public class BuildingReadWrite  {
    private String buildingName, buildingStreet,
            buildingNumber, buildingCity, buildingCountry,
            buildingDescription;
    private Integer buildingPostalCode;
}
