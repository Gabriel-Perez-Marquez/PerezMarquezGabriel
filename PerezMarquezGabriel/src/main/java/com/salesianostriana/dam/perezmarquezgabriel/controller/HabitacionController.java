package com.salesianostriana.dam.perezmarquezgabriel.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.salesianostriana.dam.perezmarquezgabriel.model.Habitacion;
import com.salesianostriana.dam.perezmarquezgabriel.service.CategoriaService;
import com.salesianostriana.dam.perezmarquezgabriel.service.HabitacionService;

@Controller
@RequestMapping("/rooms")
public class HabitacionController {

	@Autowired
	private HabitacionService habitacionService;

	@Autowired
	private CategoriaService categoriaService;
	

	@GetMapping("/manage-rooms/add-new-room")
	public String addNewRoom(Model model) {
		Habitacion h = new Habitacion(habitacionService.obtenerSiguienteNumeroHabitacion(habitacionService.findAll()));

		model.addAttribute("habitacion", h);
		model.addAttribute("categorias", categoriaService.findAll());
		return "habitacion/room-form";
	}

	
	@GetMapping("/manage-rooms")
	public String gestionHabitaciones(@RequestParam(required = false) List<Long> categorias,
			@RequestParam(required = false, defaultValue = "0") Integer minPrecio,
			@RequestParam(required = false) Integer maxPrecio,
			Model model) {

		List<Habitacion> habitaciones= habitacionService.findAll();
		
		if(categorias != null && !categorias.isEmpty()) {
			habitaciones = habitacionService.filtrarPorCategoria(habitaciones, categorias);
		}
		
		habitaciones = habitacionService.filtrarPorPrecio(habitaciones, minPrecio, maxPrecio);
		
		model.addAttribute("habitaciones", habitaciones);
		model.addAttribute("categorias", categoriaService.findAll());
		model.addAttribute("minPrecio", minPrecio);
		model.addAttribute("maxPrecio", maxPrecio);
		model.addAttribute("categoriasSeleccionadas", categorias);
		model.addAttribute("activePage", "habitaciones");
		return "habitacion/habitaciones";
	}
	
	
	
	@GetMapping("/catalog")
	public String catalogo(@RequestParam(required = false) List<Long> categorias,
			@RequestParam(required = false, defaultValue = "0") Integer minPrecio,
			@RequestParam(required = false) Integer maxPrecio,
			@RequestParam(value = "orden", required = false, defaultValue = "0") int orden, Model model) {

		List<Habitacion> habitaciones;

		habitaciones = habitacionService.gestionarOrdenar(orden);

		if (categorias != null && !categorias.isEmpty()) {
			habitaciones = habitacionService.filtrarPorCategoria(habitaciones, categorias);
		}


		habitaciones = habitacionService.filtrarPorPrecio(habitaciones, minPrecio, maxPrecio);
		
		
		model.addAttribute("habitaciones", habitaciones);
		model.addAttribute("categorias", categoriaService.findAll());
		model.addAttribute("categoriasSeleccionadas", categorias);
		model.addAttribute("minPrecio", minPrecio);
		model.addAttribute("maxPrecio", maxPrecio);
		model.addAttribute("orden", orden);

		return "habitacion/catalogo";
	}
	
	
	@PostMapping("manage-rooms/save")
	public String guardarHab(@ModelAttribute Habitacion h) {
		
		
		String nombreAuto = "Habitacion " + h.getCategoria().getNombre() + " " + h.getNumHabitacion();
		h.setNombre(nombreAuto);

		
		
		habitacionService.save(h);
		

		return "redirect:/rooms/manage-rooms";
	}

	@GetMapping("/manage-rooms/edit/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		Habitacion h = habitacionService.findById(id).orElseThrow();

		model.addAttribute("habitacion", h);
		model.addAttribute("categorias", categoriaService.findAll());

		return "habitacion/room-form";
	}

	@GetMapping("/manage-rooms/delete/{id}")
	public String borrar(@PathVariable("id") Long id, Model model) {
		
		Habitacion h= habitacionService.findById(id).orElseThrow();
		
		if (h.getReservas() != null && !h.getReservas().isEmpty()) {
	        model.addAttribute("mensajeError", "Esta habitación tiene reserva asignada");
	        model.addAttribute("categorias", categoriaService.findAll());
	        model.addAttribute("habitaciones", habitacionService.findAll());
	        return "habitacion/habitaciones";
	    }
		
		
		habitacionService.delete(habitacionService.findById(id).orElseThrow());

		return "redirect:/rooms/manage-rooms";
	}


	@GetMapping("/catalog/search")
	public String buscarPorNombre(@RequestParam("nombre") String nombre, Model model) {
		model.addAttribute("nombre", nombre);
		model.addAttribute("habitaciones", habitacionService.buscarPorNombre(nombre));
		model.addAttribute("categorias", categoriaService.findAll());
		return "habitacion/catalogo";
	}
	
	
	@GetMapping("/catalog/view/{id}")
	public String verDetalleHabitacion(@PathVariable Long id, Model model) {
		String today;
	    Optional<Habitacion> habitacionOpt = habitacionService.findById(id);
	    if (habitacionOpt.isPresent()) {
	        model.addAttribute("habitacion", habitacionOpt.get());
	        today = LocalDate.now().toString();
	        model.addAttribute("today", today);
	        return "habitacion/verDetalles"; 
	    } else {
	        return "redirect:/rooms/catalog"; 
	    }
	}


}
