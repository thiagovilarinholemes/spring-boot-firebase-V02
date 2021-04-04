package com.firebasecrud.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IndexController {

	@GetMapping("/index")
	public ResponseEntity<String> index(){
		return ResponseEntity.ok().body("Tudo OK!!!");
	}
}
