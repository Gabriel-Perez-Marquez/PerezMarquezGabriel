package com.salesianostriana.dam.perezmarquezgabriel.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.perezmarquezgabriel.model.Habitacion;
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
	public String addNewRoom(Model model) {
		Habitacion h= new Habitacion();
		
		model.addAttribute("habitacion", h);
		model.addAttribute("categorias", catalogoService.getCategorias());
		return "new-room-form";
	}
	
	 @GetMapping("/buscar")
	    public String buscarPorNombre(@RequestParam("nombre") String nombre, Model model) {
		 	model.addAttribute("nombre", nombre);
	        model.addAttribute("habitaciones", catalogoService.buscarPorNombre(nombre));
	        return "catalogo"; 
	    }
	
	
	 @PostMapping("/save")
	 public String guardarHab(@ModelAttribute Habitacion h) {
		 
		 String nombreAuto = "Habitacion " + h.getCategoria().getNombre() + " " + h.getNumHabitacion();
		 h.setNombre(nombreAuto);
		 
		 catalogoService.agregar(h);
		 
		 return "redirect:/catalogo";
	 }
	 
	 
	 @GetMapping("/edit/{id}")
	 public String editar(@PathVariable("id") Long id , Model model) {
		Habitacion h=catalogoService.buscarPorId(id).orElseThrow();
		
		model.addAttribute("habitacion", h);
		model.addAttribute("categorias", catalogoService.getCategorias());
		
		return "new-room-form"; 
	 }
	 
	 @GetMapping("/delete/{id}")
	 public String borrar(@PathVariable("id") Long id) {
		
		 catalogoService.borrar(id);
		 
		return "redirect:/catalogo"; 
	 }
	
	 
	 @GetMapping("/reserve")
		public String reservar(Model model) {
			Habitacion h= new Habitacion();
			
			model.addAttribute("habitacion", h);
			model.addAttribute("categorias", catalogoService.getCategorias());
			return "new-room-form";
		}
	
}
