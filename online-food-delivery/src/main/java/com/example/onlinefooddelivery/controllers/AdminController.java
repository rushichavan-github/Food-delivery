package com.example.onlinefooddelivery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlinefooddelivery.entities.Admin;
import com.example.onlinefooddelivery.exceptions.AdminAlreadyExistsException;
import com.example.onlinefooddelivery.services.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adServ;
	
	@PostMapping("/saveAdmin")
	public ResponseEntity<Admin> saveAdmin(@RequestBody Admin ad) throws AdminAlreadyExistsException{
		Admin savedAdmin = adServ.saveAdmin(ad);
		return new ResponseEntity<Admin>(savedAdmin,HttpStatus.OK);
	}
	
	@PostMapping("/loginAdmin")
	public ResponseEntity<String> loginAdmin(@RequestBody Admin ad){
		String string = adServ.loginAdmin(ad);
		return new ResponseEntity<String>(string,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/getAdmin")
	public ResponseEntity<List<Admin>> getAdmin(){
		return new ResponseEntity<List<Admin>>(adServ.getAdmin(),HttpStatus.OK);
	}
}
