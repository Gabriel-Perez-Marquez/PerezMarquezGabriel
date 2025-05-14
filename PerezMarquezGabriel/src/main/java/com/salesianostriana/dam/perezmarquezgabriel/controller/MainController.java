package com.salesianostriana.dam.perezmarquezgabriel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	 
	@GetMapping("/")
	public String welcome() {
		return "index";
	}
	
	
	@GetMapping("/error")
	public String error() {
		return "error";
	}
	
	@GetMapping("/QuienesSomos")
	public String quienesSomos() {
		return "quienessomos";
	}
	
}
