package com.salesianostriana.dam.perezmarquezgabriel.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.perezmarquezgabriel.model.Reserva;
import com.salesianostriana.dam.perezmarquezgabriel.repository.ReservaRepositorio;
import com.salesianostriana.dam.perezmarquezgabriel.service.base.BaseServiceImpl;

@Service
public class ReservaService extends BaseServiceImpl<Reserva, Long, ReservaRepositorio> {
		
	
	
	public List<Reserva> filtrarPorPrecio(List<Reserva> reservas, Integer minPrecio, Integer maxPrecio) {
		if(minPrecio != null) {
			if( maxPrecio != null && maxPrecio >= minPrecio) {
				reservas = reservas.stream()
						.filter(r -> r.getHabitacion().getPrecio() >= minPrecio && r.getHabitacion().getPrecio() <= maxPrecio)
						.collect(Collectors.toList());
			} else {
				reservas = reservas.stream()
						.filter(r -> r.getHabitacion().getPrecio()>= minPrecio)
						.collect(Collectors.toList());
			}
		}
		
		return reservas;
	}

	public List<Reserva> filtrarPorCategoria(List<Reserva> reservas, List<Long> categorias) {
		reservas = reservas.stream()
				.filter(r -> r.getHabitacion().getCategoria() != null && categorias.contains(r.getHabitacion().getCategoria().getId()))
				.collect(Collectors.toList());
		return reservas;
	}
}
