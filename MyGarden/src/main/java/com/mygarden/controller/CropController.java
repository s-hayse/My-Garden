package com.mygarden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mygarden.repository.HarvestRepository;
import com.mygarden.repository.PlantingRepository;
import com.mygarden.repository.SeedRepository;
import com.mygarden.entity.Harvest;
import com.mygarden.entity.Plant;
import com.mygarden.entity.Seed;

//import com.mygarden.service.SendMail;

@CrossOrigin
@RestController
public class CropController {

	@Autowired
	PlantingRepository plantingRepository;
	
	@Autowired
	HarvestRepository harvestRepository;
	
	@Autowired
	SeedRepository seedRepository;
	
//	@Autowired
//	private SendMail sendEmail;
	
	@PostMapping("/saveCultivation")
	private void saveCultivation(@RequestBody Plant plant) {
		this.plantingRepository.save(plant);
		System.out.println("New garden saved.");
	}
	
	@PostMapping("/saveSeed")
	private void submitSeed(@RequestBody Seed seed) {
		this.seedRepository.save(seed);
		System.out.println("New seed variant created.");
	}
	
	@PostMapping("/saveHarvest")
	private void submitHarvest(@RequestBody Harvest harvest) {
		this.harvestRepository.save(harvest);
		System.out.println("Harvest statistics saved.");
	}
	
	@PostMapping("/deleteCultivation")
	private void deleteCultivation(@RequestBody Plant plant) {
		for(int i = 0; i < plantingRepository.count(); ++i) {
			Plant delPlant = plantingRepository.findPlantByCultivation(i);
			if (plantingRepository.findPlantByCultivation(i).equals(delPlant)) {
				plantingRepository.delete(plant);
			}
		}
	}
	
	@PostMapping("/deleteSeed")
	private void deleteSeed(@RequestBody Seed seed) {
		for(int i = 0; i < seedRepository.count(); ++i) {
			Seed delSeed = seedRepository.findSeedByType(seed.getSeed_type());
			if(seedRepository.findSeedByType(seed.getSeed_type()).equals(delSeed)) {
				seedRepository.delete(seed);
			}
		}
	}
	
//	@GetMapping("/allSeeds") //tested in Postman - works
//	private ResponseEntity<List<Seed>> allSeeds(@RequestBody Seed[] seed){
//		List<Seed> allSeeds = seedRepository.findAllSeeds(seed);
//		return new ResponseEntity<List<Seed>>(allSeeds, HttpStatus.OK);
//	}
	
	@PostMapping("/allSeedsPost") //tested in Postman - works
	private ResponseEntity<List<Seed>> allSeedsPost(@RequestBody Seed[] seed){
		List<Seed> allSeeds = seedRepository.findAllSeeds(seed);
		return new ResponseEntity<List<Seed>>(allSeeds, HttpStatus.OK);
	}
	
//	@GetMapping("/allGardens") //tested in Postman - works
//	private ResponseEntity<List<Plant>> viewAllGardens(@RequestBody Plant[] plant) {
//			List<Plant> selectedCultivation = plantingRepository.findAllPlant(plant);
//			return new ResponseEntity<List<Plant>>(selectedCultivation, HttpStatus.OK) ;
//		}
	
	@PostMapping("/allGardensPost") //tested in Postman - works
	private ResponseEntity<List<Plant>> viewAllGardensPost(@RequestBody Plant[] plant) {
			List<Plant> selectedCultivation = plantingRepository.findAllPlant(plant);
			return new ResponseEntity<List<Plant>>(selectedCultivation, HttpStatus.OK) ;
		}
	
	@GetMapping("/findCultivationByEmail") //not working
	private ResponseEntity<List<Plant>> findCultivationByEmail(@RequestBody String email){
		List<Plant> userGardens = plantingRepository.findCultivationByEmail(email);
		return new ResponseEntity<List<Plant>>(userGardens, HttpStatus.OK);
	}
	
	@GetMapping("/findPlantByCultivation") //not working
	private ResponseEntity<Plant> findPlantByCultivation(@RequestBody int cultivation_id) {
			Plant selectedCultivation = plantingRepository.findPlantByCultivation(cultivation_id);
			return new ResponseEntity<Plant>(selectedCultivation, HttpStatus.OK) ;
		}
	
	//Code snippets for later
	
//	@PostMapping("/inventory")
//	public String handleDetails(Model model, @ModelAttribute("vehicle") Vehicle vehicle, HttpSession session) {
//	
//		model.addAttribute("selectedVehicle", vehicle);
//		if (vehicle != null) {
//			Vehicle selectedVehicle = vehicleService.findVin(vehicle);
//			model.addAttribute("vehicle", selectedVehicle);
//			return "details";
//		}
//		return "/";
//	}
//	
//	@GetMapping("/details")
//	public ModelAndView details(Model model, HttpSession session) {
////		model.addAttribute("vehicle", vehicle)
//		return new ModelAndView("details", "vehicle", session);
//	}
	
	//@PostMapping("/deleteCultivation")
//	public void deleteCultivation(String VIN) {
//		for(int i = 0; i < vehicles.size(); ++i) {
//			Vehicle vehicle = vehicles.get(i);
//			if (vehicle.getVIN().equals(VIN)) {
//				vehicles.remove(i);
//			}
//		}
//	}
	
	
	//@PostMapping("/findByName") //for searching seeds to plant
//	public Vehicle findVin(Vehicle vehicle) {
//		Vehicle selectedVehicle = vehicle;
//		String selVin = selectedVehicle.getVIN();
//		
//		for(Vehicle selected : vehicles) {
//			if (selected.getVIN().equals(selVin)) {
//				selectedVehicle = selected;
//				System.out.println(selectedVehicle.getMileage() + " mileage inside findVin");
//				return selectedVehicle;
//			}
//		}
//		return null;
//	}
	
	//for iterating through saved gardens
//	@GetMapping("/inventory")
//	public ModelAndView dealerInv(Model model, @ModelAttribute("vehicle") Vehicle vehicle,  HttpSession session) {
//		List<Vehicle> allVehicles = vehicleService.findAll();
////		Object[] allVehicles = vehicleService.findAll().toArray();
//		model.addAttribute("vehicle", allVehicles);
//		System.out.println("vehicle list: " + allVehicles);
//		return new ModelAndView("inventory");
//	}
//	
	
	
	
}
