package com.mygarden.repository;

//import java.awt.Image;
//import java.sql.Blob;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mygarden.entity.Gardener;

@Repository
public interface GardenerRepository extends JpaRepository <Gardener, String>{
	
	@Query("Select U from Gardener U where U.email = ?1")
	Gardener findGardenerByEmail(String email);
	
	@Query("Select U from Gardener U where U.email = ?1 and U.password = ?2")
	Gardener loginGardener(String email, String password);
	
	@Query("Select U from Gardener U")
	List<Gardener> findAll(Gardener gardener);	
	
	@Transactional
	@Modifying
	@Query("Update Gardener set G = ?1 where G = ?2")
	Gardener editGardener(Gardener gardener);
	
//	@Modifying
//	@Query("Insert into Gardener G.picture value =?1 and G.picture_name value =?2")
//	Gardener saveImage(Blob picture, String picture_name);

}
