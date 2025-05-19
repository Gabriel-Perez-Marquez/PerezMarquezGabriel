package com.salesianostriana.dam.perezmarquezgabriel.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.salesianostriana.dam.perezmarquezgabriel.model.Habitacion;
import com.salesianostriana.dam.perezmarquezgabriel.repository.HabitacionRepositorio;
import com.salesianostriana.dam.perezmarquezgabriel.service.base.BaseServiceImpl;

@Service
public class HabitacionService extends BaseServiceImpl<Habitacion, Long, HabitacionRepositorio> {

	@Autowired
	private HabitacionRepositorio habitacionRepositorio;

	public List<Habitacion> buscarPorCategoria(List<Long> ids) {
		return habitacionRepositorio.findByCategoria(ids);
	}

	public Optional<Habitacion> findByNumHabitacion(int numHabitacion) {
		return habitacionRepositorio.findByNumHabitacion(numHabitacion);
	}

	public List<Habitacion> buscarPorNombre(String nombre) {
		return habitacionRepositorio.buscarPorNombre(nombre);
	}

	public List<Habitacion> filtrarPorPrecio(List<Habitacion> habitaciones, Integer minPrecio, Integer maxPrecio) {
		habitaciones = habitaciones.stream().filter(h -> h.getPrecio() >= minPrecio && h.getPrecio() <= maxPrecio)
				.collect(Collectors.toList());
		return habitaciones;
	}

	public List<Habitacion> filtrarPorCategoria(List<Habitacion> habitaciones, List<Long> categorias) {
		habitaciones = habitaciones.stream()
				.filter(h -> h.getCategoria() != null && categorias.contains(h.getCategoria().getId()))
				.collect(Collectors.toList());
		return habitaciones;
	}

	
	
	public List<Habitacion> gestionarOrdenar (int orden) {
		List<Habitacion> habitaciones;
		switch (orden) {
	        case 1:
	            habitaciones = habitacionRepositorio.ordenarPorNombreAsc();
	            break;
	        case 2:
	            habitaciones = habitacionRepositorio.ordenarPorNombreDesc();
	            break;
	        case 3:
	            habitaciones = habitacionRepositorio.ordenarPorPrecioAsc();
	            break;
	        case 4:
	            habitaciones = habitacionRepositorio.ordenarPorPrecioDesc();
	            break;
	        default:
	            habitaciones =  habitacionRepositorio.ordenarPorNumeroReservas();
	    }
		
		return habitaciones;
	}
}
