package com.example.skenariolabs.model.building.coordinates;

import com.example.skenariolabs.model.building.properties.Building;
import lombok.*;
import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "coordinates")
public class Coordinates {
    @Id
    @SequenceGenerator(
            name = "coordinates_sequence",
            sequenceName = "coordinates_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "coordinates_sequence"
    )
    @Column(name = "id")
    private Long id;
    private Double latitude;
    private Double longitude;

    @OneToOne(mappedBy = "buildingCoordinates")
    private Building building;

    public Coordinates(Double latitude, Double longitude, Building building) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.building = building;
    }
}
