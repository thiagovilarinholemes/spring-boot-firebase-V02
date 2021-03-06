package com.firebasecrud.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class IndexController {

	@GetMapping("/index")
	public ResponseEntity<String> index(){
		return ResponseEntity.ok().body("Tudo OK!!!");
	}
}
