package com.loga.work.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
		
	@GetMapping("/")	
	public ResponseEntity<?> getWelcomeMsg(){
		return ResponseEntity.ok("hello");
	}
	
	@GetMapping("/admin")	
	@RolesAllowed("ADMINISTRATOR")
	public ResponseEntity<?> getWelcomeMsgAdmin(){
		return ResponseEntity.ok("hello admin");
	}
	
	@GetMapping("/developer")	
	@RolesAllowed("DEVELOPER")
	public ResponseEntity<?> getWelcomeMsgDeveloper(){
		return ResponseEntity.ok("hello dev");
	}

}
