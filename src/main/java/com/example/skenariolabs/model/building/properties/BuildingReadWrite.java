package com.example.skenariolabs.model.building.properties;

import com.example.skenariolabs.model.building.coordinates.Coordinates;
import com.example.skenariolabs.model.building.coordinates.CoordinatesReadWrite;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BuildingReadWrite  {
    private String buildingName, buildingStreet,
            buildingNumber, buildingCity, buildingCountry,
            buildingDescription;
    private Integer buildingPostalCode;
    private CoordinatesReadWrite buildingCoordinates;

    public BuildingReadWrite(String buildingName,
                             String buildingStreet,
                             String buildingNumber,
                             String buildingCity,
                             String buildingCountry,
                             String buildingDescription,
                             Integer buildingPostalCode) {
        this.buildingName = buildingName;
        this.buildingStreet = buildingStreet;
        this.buildingNumber = buildingNumber;
        this.buildingCity = buildingCity;
        this.buildingCountry = buildingCountry;
        this.buildingDescription = buildingDescription;
        this.buildingPostalCode = buildingPostalCode;
    }

    public BuildingReadWrite(String buildingName,
                             String buildingDescription) {
        this.buildingName = buildingName;
        this.buildingDescription = buildingDescription;
    }

    @JsonIgnore
    public String getFullAddress() {
        return  String.format("%s %s, %s %s, %s",
                buildingStreet,
                buildingNumber,
                buildingPostalCode,
                buildingCity,
                buildingCountry);
    }
}
