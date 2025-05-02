package com.salesianostriana.dam.perezmarquezgabriel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CatalogoController {
	
	@GetMapping("/catalogo")
	public String goToCatalogo() {
		return "catalogo";
	}
	
	@GetMapping("/add-new-room")
	public String addNewRoom(String categorias, Model model) {
		model.addAttribute("categorias", categorias);
		return "new-room-form";
	}
}
