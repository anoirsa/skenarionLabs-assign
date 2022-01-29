package com.example.skenariolabs.dataRepo;


import com.example.skenariolabs.model.building.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingDataRepo extends JpaRepository<Building, Long> {

}
