package com.salesianostriana.dam.perezmarquezgabriel.controller;

import java.time.LocalDate;
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
@RequestMapping("/habitaciones")
public class HabitacionController {

	@Autowired
	private HabitacionService habitacionService;

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/add-new-room")
	public String addNewRoom(Model model) {
		Habitacion h = new Habitacion();

		model.addAttribute("habitacion", h);
		model.addAttribute("categorias", categoriaService.findAll());
		return "habitacion/room-form";
	}

	@PostMapping("/save")
	public String guardarHab(@ModelAttribute Habitacion h) {

		String nombreAuto = "Habitacion " + h.getCategoria().getNombre() + " " + h.getNumHabitacion();
		h.setNombre(nombreAuto);

		habitacionService.save(h);

		return "redirect:/habitaciones";
	}

	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		Habitacion h = habitacionService.findById(id).orElseThrow();

		model.addAttribute("habitacion", h);
		model.addAttribute("categorias", categoriaService.findAll());

		return "habitacion/room-form";
	}

	@GetMapping("/delete/{id}")
	public String borrar(@PathVariable("id") Long id, Model model) {
		
		Habitacion h= habitacionService.findById(id).orElseThrow();
		
		if (h.getReservas() != null && !h.getReservas().isEmpty()) {
	        model.addAttribute("mensajeError", "Esta habitación tiene reserva asignada");
	        model.addAttribute("categorias", categoriaService.findAll());
	        model.addAttribute("habitaciones", habitacionService.findAll());
	        return "habitacion/habitaciones";
	    }
		
		
		habitacionService.delete(habitacionService.findById(id).orElseThrow());

		return "redirect:/habitaciones";
	}


	@GetMapping("/buscar")
	public String buscarPorNombre(@RequestParam("nombre") String nombre, Model model) {
		model.addAttribute("nombre", nombre);
		model.addAttribute("habitaciones", habitacionService.buscarPorNombre(nombre));
		model.addAttribute("categorias", categoriaService.findAll());
		return "habitacion/catalogo";
	}
	
	
	@GetMapping("/view/{id}")
	public String verDetalleHabitacion(@PathVariable Long id, Model model) {
		String today;
	    Optional<Habitacion> habitacionOpt = habitacionService.findById(id);
	    if (habitacionOpt.isPresent()) {
	        model.addAttribute("habitacion", habitacionOpt.get());
	        today = LocalDate.now().toString();
	        model.addAttribute("today", today);
	        return "habitacion/verDetalles"; 
	    } else {
	        return "redirect:habitacion/habitaciones"; 
	    }
	}


}
