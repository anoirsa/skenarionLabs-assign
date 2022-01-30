package com.example.skenariolabs;

import com.example.skenariolabs.repository.BuildingRepository;
import com.example.skenariolabs.model.building.properties.Building;
import com.example.skenariolabs.model.building.properties.BuildingReadWrite;
import com.example.skenariolabs.service.BuildingService;
import com.example.skenariolabs.service.MappingServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;




@SpringBootTest
class SkenariolabsApplicationTests {

	@Autowired
	BuildingService buildingService;
	@Autowired
	BuildingRepository buildingDataRepo;
	@Autowired
	MappingServices mappingServices;

	@Test
	public void testReposAdd() {
		BuildingReadWrite newBuilding = new BuildingReadWrite("Vaasa university of applied sciences",
				"Wolffintie","30","Vaasa","Finland",
				"Education institution",65200);
		buildingService.addBuilding(newBuilding);
		BuildingReadWrite buildingSupposed = mappingServices
				.mapToBuildingReadWrite(buildingDataRepo.findById(1L).orElse(null));
		System.out.println(buildingSupposed.toString());

		// Test if the building really added to the repository
		Assertions.assertEquals(buildingSupposed.getBuildingName(), newBuilding.getBuildingName());
		// Test that coordinates are added
		Assertions.assertNotNull(buildingSupposed.getBuildingCoordinates().getLatitude());

	}
	@Test
	public void testReposGet() {
		BuildingReadWrite otherBuilding = new BuildingReadWrite("Novia university of applied sciences",
				"Wolffintie","33","Vaasa","Finland",
				"Education institution",65200);
		buildingService.addBuilding(otherBuilding);
		List<Building> all = buildingDataRepo.findAll();
		// Assert that another building must be added
		Assertions.assertEquals(all.size(), 2);
	}
	@Test
	public void testRepoGetUnique() {
		List<BuildingReadWrite> findByName = mappingServices.mapToBuildingReadWriteArray
				(buildingDataRepo.getBuildingByBuildingName("Vaasa university of applied sciences"));
		// Assert that we find the building that we want to
		Assertions.assertEquals(findByName.size(), 1);
		Assertions.assertEquals(findByName.get(0).getBuildingDescription(), "Education institution");
	}

	@Test
	public void testReposPut() {
		BuildingReadWrite modification = new BuildingReadWrite("Novia university of applied sciences",
				"Education school");
		buildingService.updateBuilding("Novia university of applied sciences", modification);

		BuildingReadWrite buildingUpdated = mappingServices
				.mapToBuildingReadWrite(buildingDataRepo.findById(2L).orElse(null));

		// Test that update really did happen
		Assertions.assertNotSame("Education institution", buildingUpdated.getBuildingDescription());
		Assertions.assertEquals("Education school", buildingUpdated.getBuildingDescription());
	}



}
