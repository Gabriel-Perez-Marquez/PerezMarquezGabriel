package com.salesianostriana.dam.perezmarquezgabriel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.perezmarquezgabriel.service.CategoriaService;
import com.salesianostriana.dam.perezmarquezgabriel.service.HabitacionService;

@Controller
public class MainController {
	 
	
	@Autowired
	private HabitacionService habitacionService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	
	
	@GetMapping("/")
	public String welcome() {
		return "index";
	}
	
	@GetMapping("/catalogo")
	public String goToCatalogo(@RequestParam(value = "categoria", required = false) List<Long> ids, Model model) {
		
		if(ids != null) {
			model.addAttribute("habitaciones", habitacionService.buscarPorCategoria(ids));
		} else {
			model.addAttribute("habitaciones", habitacionService.findAll());
		}
		
		model.addAttribute("categorias", categoriaService.findAll());
		model.addAttribute("categoriasSeleccionadas", ids);
		return "catalogo";
	}
	
	
	@GetMapping("/habitaciones")
	public String gestionHabitaciones(Model model) {
		
		model.addAttribute("habitaciones", habitacionService.findAll());
		model.addAttribute("categorias", categoriaService.findAll());
		
		return "habitaciones";
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
