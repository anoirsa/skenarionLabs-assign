package com.example.skenariolabs.model.building.properties;


import com.example.skenariolabs.model.building.coordinates.Coordinates;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity(name ="Building")
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
    @Column(name = "id")
    private Long id;
    private String buildingName, buildingStreet,
    buildingNumber, buildingCity, buildingCountry,
    buildingDescription;
    private Integer buildingPostalCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coordinates_id",referencedColumnName = "id")
    private Coordinates buildingCoordinates;

    public Building(String buildingName,
                    String buildingStreet,
                    String buildingNumber,
                    String buildingCity,
                    String buildingCountry,
                    String buildingDescription,
                    Integer buildingPostalCode,
                    Coordinates buildingCoordinates) {
        this.buildingName = buildingName;
        this.buildingStreet = buildingStreet;
        this.buildingNumber = buildingNumber;
        this.buildingCity = buildingCity;
        this.buildingCountry = buildingCountry;
        this.buildingDescription = buildingDescription;
        this.buildingPostalCode = buildingPostalCode;
        this.buildingCoordinates = buildingCoordinates;
    }
}
