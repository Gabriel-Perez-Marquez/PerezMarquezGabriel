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
@RequestMapping("/categories")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	
	@GetMapping("/manage-categories")
	public String gestionCategorias(Model model) {

		model.addAttribute("categorias", categoriaService.findAll());
		model.addAttribute("activePage", "categorias");
		return "categoria/categorias";
	}
	
	
	@GetMapping("/manage-categories/add-new-category")
	public String addNewCategory(Model model) {
		
		model.addAttribute("categoria", new Categoria());
		
		return "categoria/category-form";
	}

	@PostMapping("/manage-categories/save")
	public String guardarCategoria(@ModelAttribute Categoria c) {

		categoriaService.save(c);

		return "redirect:/categories/manage-categories";
	}

	@GetMapping("/manage-categories/edit/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		Categoria c = categoriaService.findById(id).orElseThrow();

		model.addAttribute("categoria", c);

		return "categoria/category-form";
	}

	@GetMapping("/manage-categories/delete/{id}")
	public String borrar(@PathVariable("id") Long id, Model model) {

	    Categoria categoria = categoriaService.findById(id)
	            .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada"));

	    if (!categoria.getListHabitaciones().isEmpty()) {
	        model.addAttribute("mensajeError", "Esta categoría tiene habitaciones asignadas");
	        model.addAttribute("categorias", categoriaService.findAll());
	        return "categoria/categorias";
	    }

	    categoriaService.delete(categoria);
	    return "redirect:/categories/manage-categories";
	}


	
	
	
}
