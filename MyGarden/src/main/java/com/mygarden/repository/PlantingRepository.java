package com.mygarden.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mygarden.entity.Plant;

@Repository
public interface PlantingRepository extends JpaRepository <Plant, String>{
	
	@Query("Select P from Plant P")
	List<Plant> findAllPlant(Plant[] plant);
	
	@Query("Select P from Plant P where P.cultivation_id = ?1")
	Plant findPlantByCultivation(int cultivation_id);
	
	@Query("Select P from Plant P where P.email = ?1")
	List<Plant> findCultivationByEmail(String email);

}
