package com.salesianostriana.dam.perezmarquezgabriel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.salesianostriana.dam.perezmarquezgabriel.service.HabitacionService;

@Controller
public class MainController {

	@Autowired
	private HabitacionService habitacionService;


	@GetMapping("/")
	public String welcome(Model model) {
		model.addAttribute("habitacionesPopulares", habitacionService.buscarHabitacionesPopulares(habitacionService.findAll()));
		return "index";
	}	
	

	@GetMapping("/error")
	public String error() {
		return "error";
	}

	@GetMapping("/whoWeAre")
	public String quienesSomos() {
		return "quienessomos";
	}

}
