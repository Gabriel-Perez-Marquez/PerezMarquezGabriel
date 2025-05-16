package com.salesianostriana.dam.perezmarquezgabriel.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.perezmarquezgabriel.model.Habitacion;
import com.salesianostriana.dam.perezmarquezgabriel.service.CategoriaService;
import com.salesianostriana.dam.perezmarquezgabriel.service.HabitacionService;
import com.salesianostriana.dam.perezmarquezgabriel.service.ReservaService;

@Controller
public class MainController {
	 
	
	@Autowired
	private HabitacionService habitacionService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	
	@Autowired
	private ReservaService reservaService;
	
	
	@GetMapping("/")
	public String welcome() {
		return "index";
	}
	
	@GetMapping("/catalogo")
	public String catalogo(@RequestParam(required = false) List<Long> categoria,
	                       @RequestParam(required = false, defaultValue = "0") Integer minPrecio,
	                       @RequestParam(required = false) Integer maxPrecio,
	                       Model model) {

	    List<Habitacion> habitaciones = habitacionService.findAll();

	    // Filtrar por categoría
	    if (categoria != null && !categoria.isEmpty()) {
	    	habitaciones=habitacionService.filtrarPorCategoria(habitaciones, categoria);
	    }

	    // Filtrar por precio
	    if (minPrecio != null && maxPrecio != null) {    	
	    		habitaciones=habitacionService.filtrarPorPrecio(habitaciones, minPrecio, maxPrecio);
	    }

	    // Paginación opcional (si estás usándola)
	    model.addAttribute("habitaciones", habitaciones);
	    model.addAttribute("categorias", categoriaService.findAll());
	    model.addAttribute("categoriasSeleccionadas", categoria);
	    model.addAttribute("minPrecio", minPrecio);
	    model.addAttribute("maxPrecio", maxPrecio);

	    return "habitacion/catalogo";
	}

	
	
	@GetMapping("/habitaciones")
	public String gestionHabitaciones(Model model) {
		
		model.addAttribute("habitaciones", habitacionService.findAll());
		model.addAttribute("categorias", categoriaService.findAll());
		
		return "habitacion/habitaciones";
	}
	
	
	@GetMapping("/categorias")
	public String gestionCategorias(Model model) {
		
		model.addAttribute("categorias", categoriaService.findAll());
		
		return "categoria/categorias";
	}
	
	
	@GetMapping("/reservas")
	public String gestionReservas(Model model) {
		model.addAttribute("reservas", reservaService.findAll());
		return "reserva/reservas";
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
