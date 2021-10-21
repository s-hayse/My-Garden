package com.mygarden.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mygarden.entity.Seed;

@Repository
public interface SeedRepository extends JpaRepository<Seed, String>{
	
	@Query("Select S from Seed S")
	List<Seed> findAllSeeds(Seed[] seed);

	@Query("Select S from Seed S where S.seed_type = ?1")
	Seed findSeedByType(String seed_type);

}
