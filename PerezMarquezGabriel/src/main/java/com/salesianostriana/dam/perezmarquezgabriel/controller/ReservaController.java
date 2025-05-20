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
	public String agregarReservaCatalogo(@PathVariable("id") Long idHabitacion, Model model) {
		String today;
		Reserva reserva = new Reserva();
	    Optional<Habitacion> optionalHabitacion = habitacionService.findById(idHabitacion);
	    if (optionalHabitacion.isPresent()) {
	    	reserva.setHabitacion(optionalHabitacion.get()); 
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
	
	
	@GetMapping("/add-new-reservation")
	public String agregarReservaParametro(@RequestParam(required = false) int numHabitacion, Model model) {
		String today;
		Reserva reserva = new Reserva();
	    Optional<Habitacion> optionalHabitacion = habitacionService.findByNumHabitacion(numHabitacion);
	    if (optionalHabitacion.isPresent() && optionalHabitacion.get() != null) {
	    	reserva.setHabitacion(optionalHabitacion.get()); 
		    model.addAttribute("reserva", reserva);
		    model.addAttribute("habitacion", optionalHabitacion.get());
		    model.addAttribute("categorias", categoriaService.findAll());
		    today = LocalDate.now().toString();
	        model.addAttribute("today", today);
		    return "reserva/reservation-form";
	    } else {
	    	model.addAttribute("reservas", reservaService.findAll());
	    	model.addAttribute("error", "La habitación con ese número no existe ");
	    	return "reserva/reservas";
	    }
	}
	
	


	@PostMapping("/save")
	public String guardarReserva(@ModelAttribute("reserva") Reserva reserva, Model model) {
	    Long idHabitacion = reserva.getHabitacion().getId();
	    Optional<Habitacion> habitacionOpt = habitacionService.findById(idHabitacion);

	    if (!habitacionOpt.isPresent()) {
	        model.addAttribute("error", "Habitación no válida");
	        return "reserva/reservation-form";
	    }

	    // Verificar solapamientos
	    if (reservaService.haySolapamiento(idHabitacion, reserva.getFechaEntrada(), reserva.getFechaSalida())) {
	        model.addAttribute("error", "La habitación ya está reservada en esas fechas.");
	        model.addAttribute("habitacion", habitacionOpt.get());
	        model.addAttribute("reserva", reserva);
	        model.addAttribute("categorias", categoriaService.findAll());
	        return "reserva/reservation-form";
	    }
	    
	    reserva.setHabitacion(habitacionOpt.get());
	    reservaService.save(reserva);

	    return "redirect:/reservas";
	}

	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		Reserva r = reservaService.findById(id).orElseThrow();
		Optional<Habitacion> habitacionOptional = habitacionService.findById(id);
		
		if(habitacionOptional.isPresent()) {
			model.addAttribute("reserva", r);
			model.addAttribute("categorias", categoriaService.findAll());
			model.addAttribute("habitacion", habitacionOptional.get());
			return "reserva/reservation-form";
		} else {
			model.addAttribute("error", "Esa reserva no es válida");
	    	model.addAttribute("reservas", reservaService.findAll());
			return "reserva/reservas";
		}
		
	}

	@GetMapping("/delete/{id}")
	public String borrar(@PathVariable("id") Long id) {
		System.out.println(id);
		reservaService.delete(reservaService.findById(id).get());

		return "redirect:/reservas";
	}
	
	
}
