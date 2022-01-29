package com.example.skenariolabs.model.building;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity(
        name="Building"
)
@Table(name = "buildings")
public class Building {
    @Id
    @SequenceGenerator(
            name = "building_sequence",
            sequenceName = "building_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "building_sequence"
    )
    private Long buildingId;
    private String buildingName, buildingStreet,
    buildingNumber, buildingCity, buildingCountry,
    buildingDescription;
    private Integer buildingPostalCode;

    public Building(String buildingName,
                    String buildingStreet, String buildingNumber,
                    String buildingCity, String buildingCountry,
                    String buildingDescription, Integer
                            buildingPostalCode) {
        this.buildingName = buildingName;
        this.buildingStreet = buildingStreet;
        this.buildingNumber = buildingNumber;
        this.buildingCity = buildingCity;
        this.buildingCountry = buildingCountry;
        this.buildingDescription = buildingDescription;
        this.buildingPostalCode = buildingPostalCode;
    }
}
