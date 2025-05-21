package com.salesianostriana.dam.perezmarquezgabriel.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.perezmarquezgabriel.model.Habitacion;
import com.salesianostriana.dam.perezmarquezgabriel.model.Reserva;
import com.salesianostriana.dam.perezmarquezgabriel.repository.ReservaRepositorio;
import com.salesianostriana.dam.perezmarquezgabriel.service.base.BaseServiceImpl;

@Service
public class ReservaService extends BaseServiceImpl<Reserva, Long, ReservaRepositorio> {
		
	
	@Autowired
	private ReservaRepositorio reservaRepositorio;
	
	
	
	public boolean comprobarSolapamiento(Long idHabitacion, LocalDate fechaEntrada, LocalDate fechaSalida) {
	    List<Reserva> solapadas = reservaRepositorio.buscarReservasSolapadas(idHabitacion, fechaEntrada, fechaSalida);
	    return !solapadas.isEmpty();
	}
	
	
	public boolean comprobarSolapamientoAlEditar(Long idHabitacion, LocalDate fechaEntrada, LocalDate fechaSalida, Long idReserva) {
	    List<Reserva> solapadas = reservaRepositorio.buscarReservasSolapadasAlEditar(idHabitacion, fechaEntrada, fechaSalida, idReserva);
	    return !solapadas.isEmpty();
	}
	
	
	public double calcularPrecioReserva(Habitacion h, LocalDate fechaEntrada, LocalDate fechaSalida) {
		long noches = ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
		
		if(h.getCategoria().getDescuento() != 0) {
			return h.getPrecio()*h.getCategoria().getDescuento() / 100;
		}
			
		return h.getPrecio() * noches;
	}


	public List<Reserva> filtrarPorCategoria(List<Reserva> reservas, List<Long> categorias) {
		reservas = reservas.stream()
				.filter(r -> r.getHabitacion().getCategoria() != null && categorias.contains(r.getHabitacion().getCategoria().getId()))
				.collect(Collectors.toList());
		return reservas;
	}
	
	
	public double calcularRecaudacionTotal(List<Reserva> reservas) {
	    double total = 0.0;

	    total = reservaRepositorio.findAll().stream()
		        .mapToDouble(Reserva::getPrecio)
		        .sum();

	    return total;
	}
	
	
	public String obtenerReservaMasLarga() {
	    return reservaRepositorio.findAll()
	        .stream()
	        .max(Comparator.comparingLong(reserva ->
	            ChronoUnit.DAYS.between(reserva.getFechaEntrada(), reserva.getFechaSalida())))
	        .map(reserva -> reserva.getNombreTitular() + " (" +
	            ChronoUnit.DAYS.between(reserva.getFechaEntrada(), reserva.getFechaSalida()) + " noches)")
	        .orElse("-");
	}
	

}
