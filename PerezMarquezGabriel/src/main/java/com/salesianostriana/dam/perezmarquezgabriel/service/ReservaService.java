package com.salesianostriana.dam.perezmarquezgabriel.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.perezmarquezgabriel.model.Reserva;
import com.salesianostriana.dam.perezmarquezgabriel.repository.ReservaRepositorio;
import com.salesianostriana.dam.perezmarquezgabriel.service.base.BaseServiceImpl;

@Service
public class ReservaService extends BaseServiceImpl<Reserva, Long, ReservaRepositorio> {
		
	
	@Autowired
	private ReservaRepositorio reservaRepositorio;
	
	
	public boolean haySolapamiento(Long idHabitacion, LocalDate fechaEntrada, LocalDate fechaSalida) {
	    List<Reserva> solapadas = reservaRepositorio.buscarReservasSolapadas(idHabitacion, fechaEntrada, fechaSalida);
	    return !solapadas.isEmpty();
	}


	public List<Reserva> filtrarPorCategoria(List<Reserva> reservas, List<Long> categorias) {
		reservas = reservas.stream()
				.filter(r -> r.getHabitacion().getCategoria() != null && categorias.contains(r.getHabitacion().getCategoria().getId()))
				.collect(Collectors.toList());
		return reservas;
	}
}
