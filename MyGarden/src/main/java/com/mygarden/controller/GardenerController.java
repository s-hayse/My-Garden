package com.mygarden.controller;

//import java.sql.Blob;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mygarden.entity.Gardener;
import com.mygarden.repository.GardenerRepository;
import com.mygarden.service.SendMail;

@CrossOrigin
@RestController
public class GardenerController {
	
	@Autowired
	GardenerRepository gardenerRepository;
	
	@Autowired
	private SendMail sendEmail;
	
	@PostMapping("/save")
	private void createUser(@RequestBody Gardener gardener) {
		this.gardenerRepository.save(gardener);
		System.out.println("Gardener saved");
		this.sendEmail.sendEmail(gardener.getEmail(), "Account created", "Thank you! Your account has been successfully created.");
	}
	
	@PostMapping("/contactUs")
	private void contactUs(@RequestBody String full_name, String email, String subject, String message) {
		this.sendEmail.sendEmail(email, "My Garden", "Thank you for contacting My Garden.  Your input is important to us! I will reply to your message (if necessary) as soon as possible.");    
		this.sendEmail.sendEmail("my.garden.dummy.acct@gmail.com", subject, message);
		System.out.println("Contact message sent");
	}
	
	@PostMapping("/editGardener") //test
	private ResponseEntity<Gardener> editGardener(@RequestBody Gardener gardener) {
		Gardener editGardener = gardenerRepository.loginGardener(gardener.getEmail(), gardener.getPassword());
		gardener = (editGardener);
//		String[] tempGardener = new String[]{editGardener.toString()};
		
//		for (int i = 0; i < tempGardener.length; i++) {
			
			//Iterate through the 5 index places and update as needed
//		}
		//returns the updated gardener
//		this.gardenerRepository.save(gardener);
		return new ResponseEntity<Gardener>(HttpStatus.OK);
	}
	
	@PostMapping("/login")
	private ResponseEntity<Gardener> loginGardener(@RequestBody Gardener gardener) {
		Gardener loginUser = gardenerRepository.loginGardener(gardener.getEmail(), gardener.getPassword());
		if (loginUser != null) {
			return new ResponseEntity<Gardener>(loginUser, HttpStatus.OK);
		}else {
			System.out.println("No such user found");
			return new ResponseEntity<Gardener>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@PostMapping("/logout")
	private ResponseEntity<Gardener> logoutUser(Gardener gardener){
		Gardener logoutUser = null;
		return new ResponseEntity<Gardener>(logoutUser, HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
	private ResponseEntity<List<Gardener>> findAllUsers(Gardener gardener){
		List<Gardener> users = gardenerRepository.findAll(gardener);
		return new ResponseEntity<List<Gardener>>(users, HttpStatus.OK);
	}
	
	@GetMapping("/findGardenerByEmail")
	private ResponseEntity<Gardener> findGardenerByEmail(String email){
		Gardener loginGardener = this.gardenerRepository.findGardenerByEmail(email);
		return new ResponseEntity<Gardener>(loginGardener, HttpStatus.OK);
	}
	
//	@PostMapping("/saveImage")
//	private void saveImage(@RequestBody Blob picture, String picture_name){
//		this.gardenerRepository.saveImage(picture, picture_name);
//	}

}
