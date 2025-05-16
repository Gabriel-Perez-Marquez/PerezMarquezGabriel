package com.salesianostriana.dam.perezmarquezgabriel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.perezmarquezgabriel.model.Categoria;
import com.salesianostriana.dam.perezmarquezgabriel.service.CategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	
	@GetMapping("/add-new-category")
	public String addNewCategory(Model model) {
		
		model.addAttribute("categoria", new Categoria());
		
		return "categoria/category-form";
	}

	@PostMapping("/save")
	public String guardarCategoria(@ModelAttribute Categoria c) {

		categoriaService.save(c);

		return "redirect:categoria/categorias";
	}

	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		Categoria c = categoriaService.findById(id).orElseThrow();

		model.addAttribute("categoria", c);

		return "categoria/category-form";
	}

	@GetMapping("/delete/{id}")
	public String borrar(@PathVariable("id") Long id, Model model) {

	    Categoria categoria = categoriaService.findById(id)
	            .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada"));

	    if (!categoria.getListHabitaciones().isEmpty()) {
	        model.addAttribute("mensajeError", "Esta categoría tiene habitaciones asignadas");
	        model.addAttribute("categorias", categoriaService.findAll());
	        return "categoria/categorias";
	    }

	    categoriaService.delete(categoria);
	    return "redirect:/categorias";
	}


	
	
	
}
