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
import com.salesianostriana.dam.perezmarquezgabriel.model.Reserva;
import com.salesianostriana.dam.perezmarquezgabriel.service.CategoriaService;
import com.salesianostriana.dam.perezmarquezgabriel.service.HabitacionService;
import com.salesianostriana.dam.perezmarquezgabriel.service.ReservaService;


@Controller
@RequestMapping("/reservations")
public class ReservaController {


	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private HabitacionService habitacionService;
	
	@Autowired
	private ReservaService reservaService;

	
	@GetMapping("/manage-reservations")
	public String gestionReservas(@RequestParam(required = false) List<Long> categorias,
			Model model) {
		
		List<Reserva> reservas= reservaService.findAll();
		
		if(categorias != null && !categorias.isEmpty()) {
			reservas = reservaService.filtrarPorCategoria(reservas, categorias);
		}
		
		model.addAttribute("categoriasSeleccionadas", categorias);
		model.addAttribute("reservas", reservas);
		model.addAttribute("categorias", categoriaService.findAll());
		model.addAttribute("activePage", "reservas");
		return "reserva/reservas";
	}
	
	
	@GetMapping("/reserve")
	public String reservar(Model model) {
		Habitacion h = new Habitacion();
		Reserva r = new Reserva();

		model.addAttribute("habitacion", h);
		model.addAttribute("reserva", r);
		model.addAttribute("categorias", categoriaService.findAll());
		return "new-reservation-form";
	}
	
	
	@GetMapping("/manage-reservations/add-new-reservation/{id}")
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
	    	return "redirect:/reservations/manage-reservations";
		}		
	}
	
	
	@GetMapping("/manage-reservations/add-new-reservation")
	public String agregarReservaParametro(@RequestParam(required = false) int numHabitacion, Model model) {
		LocalDate today = LocalDate.now();
		Reserva reserva = new Reserva();
	    Optional<Habitacion> optionalHabitacion = habitacionService.findByNumHabitacion(numHabitacion);
	    if (optionalHabitacion.isPresent() && optionalHabitacion.get() != null) {
	    	reserva.setHabitacion(optionalHabitacion.get()); 
		    model.addAttribute("reserva", reserva);
		    model.addAttribute("habitacion", optionalHabitacion.get());
		    model.addAttribute("categorias", categoriaService.findAll());
	        model.addAttribute("today", today);
		    return "reserva/reservation-form";
	    } else {
	    	model.addAttribute("reservas", reservaService.findAll());
	    	model.addAttribute("error", "La habitación con ese número no existe ");
	    	return "reserva/reservas";
	    }
	}
	
	


	@PostMapping("/manage-reservations/save")
	public String guardarReserva(@ModelAttribute("reserva") Reserva reserva, Model model) {
	    Long idHabitacion = reserva.getHabitacion().getId();
	    Optional<Habitacion> habitacionOpt = habitacionService.findById(idHabitacion);

	    if (!habitacionOpt.isPresent()) {
	        model.addAttribute("error", "Habitación no válida");
	        return "reserva/reservation-form";
	    }

	    
	    
	    
	    // Verificar solapamientos
	    System.out.println(reserva.getId());
	    if(reserva.getId() != null ) {
	    	if (reservaService.comprobarSolapamientoAlEditar(idHabitacion, reserva.getFechaEntrada(), reserva.getFechaSalida(), reserva.getId())) {
		        model.addAttribute("error", "La habitación ya está reservada en esas fechas.");
		        model.addAttribute("habitacion", habitacionOpt.get());
		        model.addAttribute("reserva", reserva);
		        model.addAttribute("categorias", categoriaService.findAll());
		        return "reserva/reservation-form";
		    } else {
		    	reserva.setHabitacion(habitacionOpt.get());
			    reserva.setPrecio(reservaService.calcularPrecioReserva(habitacionOpt.get(), reserva.getFechaEntrada(), reserva.getFechaSalida()));
			    reservaService.save(reserva);
			}
	    } else {
	    	if (reservaService.comprobarSolapamiento(idHabitacion, reserva.getFechaEntrada(), reserva.getFechaSalida())) {
		        model.addAttribute("error", "La habitación ya está reservada en esas fechas.");
		        model.addAttribute("habitacion", habitacionOpt.get());
		        model.addAttribute("reserva", reserva);
		        model.addAttribute("categorias", categoriaService.findAll());
		        return "reserva/reservation-form";
		    } else {
		    	reserva.setHabitacion(habitacionOpt.get());
			    reserva.setPrecio(reservaService.calcularPrecioReserva(habitacionOpt.get(), reserva.getFechaEntrada(), reserva.getFechaSalida()));
			    reservaService.save(reserva);
			}
		}
	    
	 
	    
	    
	    return "redirect:/reservations/manage-reservations";
	}

	@GetMapping("/manage-reservations/edit/{id}")
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

	@GetMapping("/manage-reservations/delete/{id}")
	public String borrar(@PathVariable("id") Long id) {
		System.out.println(id);
		reservaService.delete(reservaService.findById(id).get());

		return "redirect:/reservations/manage-reservations";
	}
	
	@GetMapping("/estadistics")
	public String estadisticasReservas (Model model) {
		model.addAttribute("totalRecaudado", reservaService.calcularRecaudacionTotal(reservaService.findAll()));
		model.addAttribute("numHabitaciones", habitacionService.contarHabitaciones());
		model.addAttribute("numCategorias", categoriaService.contarCategorias());
		model.addAttribute("reservaMasLarga", reservaService.obtenerReservaMasLarga());
		model.addAttribute("recaudadoPorHabitacion", habitacionService.calcularRecaudacionTodasHabitaciones(habitacionService.findAll()));
		model.addAttribute("recaudadoPorCategoria", categoriaService.calcularRecaudacionTodasCategorias(categoriaService.findAll()));
		return "reserva/estadisticas";
	}
	
	
}
