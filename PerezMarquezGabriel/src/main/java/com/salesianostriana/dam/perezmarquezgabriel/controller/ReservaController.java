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

import com.salesianostriana.dam.perezmarquezgabriel.model.Habitacion;
import com.salesianostriana.dam.perezmarquezgabriel.model.Reserva;
import com.salesianostriana.dam.perezmarquezgabriel.service.CategoriaService;
import com.salesianostriana.dam.perezmarquezgabriel.service.HabitacionService;
import com.salesianostriana.dam.perezmarquezgabriel.service.ReservaService;



@Controller
@RequestMapping("/reservas")
public class ReservaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private HabitacionService habitacionService;
	
	@Autowired
	private ReservaService reservaService;
	
	
	
	@GetMapping("/reserve")
	public String reservar(Model model) {
		Habitacion h = new Habitacion();
		Reserva r = new Reserva();

		model.addAttribute("habitacion", h);
		model.addAttribute("reserva", r);
		model.addAttribute("categorias", categoriaService.findAll());
		return "new-reservation-form";
	}
	
	
	@GetMapping("/add-new-reservation/{id}")
	public String agregarReserva(@PathVariable("id") Long idHabitacion, Model model) {
		String today;
		Reserva reserva = new Reserva();
	    Optional<Habitacion> optionalHabitacion = habitacionService.findById(idHabitacion);
	    if (optionalHabitacion.isPresent()) {
	    	reserva.setH(optionalHabitacion.get()); 
		    model.addAttribute("reserva", reserva);
		    model.addAttribute("habitacion", optionalHabitacion.get());
		    model.addAttribute("categorias", categoriaService.findAll());
		    today = LocalDate.now().toString();
	        model.addAttribute("today", today);
		    return "reserva/reservation-form";
	    } else {
	    	return "redirect:/reservas";
		}		
	}


	@PostMapping("/save")
	public String guardarReserva(@ModelAttribute("reserva") Reserva reserva, Model model) {
	    Long idHabitacion = reserva.getH().getId();
	    Optional<Habitacion> habitacionOpt = habitacionService.findById(idHabitacion);
	    if (!habitacionOpt.isPresent()) {
	        model.addAttribute("error", "Habitación no válida");
	        return "reserva/reservation-form";
	    }

	    reserva.setH(habitacionOpt.get());
	    
	    habitacionOpt.get().setReserva(reserva);

	    reservaService.save(reserva);

	    return "redirect:/reservas";
	}


	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		Habitacion h = habitacionService.findById(id).orElseThrow();

		model.addAttribute("habitacion", h);
		model.addAttribute("categorias", categoriaService.findAll());

		return "new-room-form";
	}

	@GetMapping("/delete/{id}")
	public String borrar(@PathVariable("id") Long id) {

		habitacionService.delete(habitacionService.findById(id).orElseThrow());

		return "redirect:/habitaciones";
	}
	
	
}
