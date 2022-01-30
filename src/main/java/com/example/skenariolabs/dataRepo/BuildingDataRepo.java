package com.example.skenariolabs.dataRepo;


import com.example.skenariolabs.model.building.properties.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository

public interface BuildingDataRepo extends JpaRepository<Building, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Building b SET b.buildingName = ?2, b.buildingDescription = ?3 WHERE b.buildingName = ?1")
    void updateBuilding(String buildingName, String newBuildingName,
                        String buildingDescription);


}
