package com.salesianostriana.dam.perezmarquezgabriel.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.perezmarquezgabriel.model.Habitacion;
import com.salesianostriana.dam.perezmarquezgabriel.model.Reserva;
import com.salesianostriana.dam.perezmarquezgabriel.service.CategoriaService;
import com.salesianostriana.dam.perezmarquezgabriel.service.HabitacionService;
import com.salesianostriana.dam.perezmarquezgabriel.service.PromocionService;
import com.salesianostriana.dam.perezmarquezgabriel.service.ReservaService;

@Controller
public class MainController {

	@Autowired
	private HabitacionService habitacionService;

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private ReservaService reservaService;

	@Autowired
	private PromocionService promocionService;




	@GetMapping("/")
	public String welcome() {
		return "index";
	}

	@GetMapping("/catalogo")
	public String catalogo(@RequestParam(required = false) List<Long> categorias,
			@RequestParam(required = false, defaultValue = "0") Integer minPrecio,
			@RequestParam(required = false) Integer maxPrecio,
			@RequestParam(value = "orden", required = false, defaultValue = "0") int orden, Model model) {

		List<Habitacion> habitaciones;

		habitaciones = habitacionService.gestionarOrdenar(orden);

		if (categorias != null && !categorias.isEmpty()) {
			habitaciones = habitacionService.filtrarPorCategoria(habitaciones, categorias);
		}

		if (minPrecio != null && maxPrecio != null) {
			habitaciones = habitacionService.filtrarPorPrecio(habitaciones, minPrecio, maxPrecio);
		}

		model.addAttribute("habitaciones", habitaciones);
		model.addAttribute("categorias", categoriaService.findAll());
		model.addAttribute("categoriasSeleccionadas", categorias);
		model.addAttribute("minPrecio", minPrecio);
		model.addAttribute("maxPrecio", maxPrecio);
		model.addAttribute("orden", orden);
		model.addAttribute("promociones", promocionService.findAll());

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
	public String gestionReservas(@RequestParam(required = false) List<Long> categorias,
			@RequestParam(required = false, defaultValue = "0") Integer minPrecio,
			@RequestParam(required = false) Integer maxPrecio,
			Model model) {
		
		List<Reserva> reservas= reservaService.findAll();
		
		if(categorias != null && !categorias.isEmpty()) {
			reservas = reservaService.filtrarPorCategoria(reservas, categorias);
		}
		
		if(minPrecio != null) {
			reservas = reservaService.filtrarPorPrecio(reservas, minPrecio, maxPrecio);
		}
		
		model.addAttribute("categoriasSeleccionadas", categorias);
		model.addAttribute("minPrecio", minPrecio);
		model.addAttribute("maxPrecio", maxPrecio);
		model.addAttribute("reservas", reservas);
		model.addAttribute("categorias", categoriaService.findAll());
		return "reserva/reservas";
	}
	
	
	
	@GetMapping("/promociones")
	public String gestionPromociones(Model model) {
		
		model.addAttribute("promociones", promocionService.findAll());
		
		return "promocion/promociones";
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
