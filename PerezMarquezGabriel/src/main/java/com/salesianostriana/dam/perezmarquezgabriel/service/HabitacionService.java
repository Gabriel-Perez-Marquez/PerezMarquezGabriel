package com.salesianostriana.dam.perezmarquezgabriel.service;

import java.util.Comparator;
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

	
	public double calcularPrecioDescuentoHab(Habitacion h) {
		if(h.getCategoria().getDescuento() != 0) {
			return h.getPrecio() * h.getCategoria().getDescuento() / 100;
		} else {
			return h.getPrecio();
		}
		
	}
	
	
	public List<Habitacion> filtrarPorPrecio(List<Habitacion> habitaciones, Integer minPrecio, Integer maxPrecio) {

		if (minPrecio != null && maxPrecio != null) {
			habitaciones = habitaciones.stream()
					.filter(h -> calcularPrecioDescuentoHab(h) >= minPrecio && calcularPrecioDescuentoHab(h) <= maxPrecio)
					.collect(Collectors.toList());
		} else if (minPrecio != null) {
			habitaciones = habitaciones.stream()
					.filter(h -> calcularPrecioDescuentoHab(h) >= minPrecio)
					.collect(Collectors.toList());
		}
		return habitaciones;
	}

	public List<Habitacion> filtrarPorCategoria(List<Habitacion> habitaciones, List<Long> categorias) {
		habitaciones = habitaciones.stream()
				.filter(h -> h.getCategoria() != null && categorias.contains(h.getCategoria().getId()))
				.collect(Collectors.toList());
		return habitaciones;
	}

	public List<Habitacion> gestionarOrdenar(int orden) {
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
			habitaciones = habitacionRepositorio.ordenarPorNumeroReservas();
		}

		return habitaciones;
	}

	public List<Habitacion> buscarHabitacionesPopulares(List<Habitacion> habitaciones) {

		return habitaciones.stream().filter(h -> h.getReservas().size() >= 5)
				.sorted(Comparator.comparingInt(h -> h.getReservas().size())).limit(3).collect(Collectors.toList());

	}
	
	
	public long contarHabitaciones() {
	    return habitacionRepositorio.count();
	}
	
	
	public double calcularRecaudacionTotalHab(Habitacion h) {
		return h.getReservas().stream()
			.mapToDouble(reserva -> {
				long numeroNoches = java.time.temporal.ChronoUnit.DAYS.between(
					reserva.getFechaEntrada(), 
					reserva.getFechaSalida()
				);
				return numeroNoches * h.getPrecio();
			})
			.sum();
	}
	
	
	public List<Habitacion> calcularRecaudacionTodasHabitaciones(List<Habitacion> habitaciones){
		return habitaciones.stream()
			.peek(h -> h.setTotalRecaudado(calcularRecaudacionTotalHab(h)))
			.collect(Collectors.toList());
	}
	
	public boolean comprobarNumHabRepetido(Habitacion h, List<Habitacion> habitaciones) {
		for (Habitacion h1 : habitaciones) {
			if(h.getNumHabitacion() == h1.getNumHabitacion()) {
				return true;
			}
		}
		return false;
	}
	
	public int obtenerSiguienteNumeroHabitacion(List<Habitacion> habitaciones) {
	    if (habitaciones.isEmpty()) return 100;


	    int maxNum = habitaciones.stream()
	        .mapToInt(Habitacion::getNumHabitacion)
	        .max()
	        .orElse(100);

	    int siguiente = maxNum + 1;

	    if (siguiente % 100 == 10) {
	        siguiente = ((siguiente / 100) + 1) * 100 + 1;
	    }

	    return siguiente;
	}
	
	

}
