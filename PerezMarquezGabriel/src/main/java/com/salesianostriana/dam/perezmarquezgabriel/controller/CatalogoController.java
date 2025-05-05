package com.salesianostriana.dam.perezmarquezgabriel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.perezmarquezgabriel.service.CatalogoService;


@Controller
public class CatalogoController {
	
	@Autowired
	private CatalogoService catalogoService;
	
	
	@GetMapping("/catalogo")
	public String goToCatalogo(Model model) {
		
		model.addAttribute("habitaciones", catalogoService.buscarTodos());
		
		return "catalogo";
	}
	
	@GetMapping("/add-new-room")
	public String addNewRoom(String categorias, Model model) {
		model.addAttribute("categorias", categorias);
		return "new-room-form";
	}
	
	
	
	
}
