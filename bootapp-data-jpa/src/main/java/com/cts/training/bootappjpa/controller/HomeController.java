package com.cts.training.bootappjpa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.bootappjpa.dto.LoginDto;
import com.cts.training.bootappjpa.exception.ProductErrorResponse;

@RestController
@CrossOrigin("http://localhost:4200")
public class HomeController {
	
	@GetMapping("/home")
	public String home() {
		return "This is home response!";
	}
	
	@GetMapping("/login")
	public ResponseEntity<LoginDto> login() {
		LoginDto loginDto = new LoginDto("Logged In", System.currentTimeMillis());
		ResponseEntity<LoginDto> response = new ResponseEntity<LoginDto>(loginDto, HttpStatus.OK);
		return response;
	}
}
