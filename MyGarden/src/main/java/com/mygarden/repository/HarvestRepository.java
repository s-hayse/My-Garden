package com.mygarden.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mygarden.entity.Harvest;

@Repository
public interface HarvestRepository extends JpaRepository <Harvest, String>{
	
	@Query("Select H from Harvest H")
	List<Harvest> findAllHarvest(Harvest harvest);
	
//	@Query("Select H from Harvest H where H.harvest_id = ?1")
//	Harvest findHarvestById(int harvest_id);
	
}
