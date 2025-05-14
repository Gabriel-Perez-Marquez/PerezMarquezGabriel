package com.salesianostriana.dam.perezmarquezgabriel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.perezmarquezgabriel.model.Habitacion;
import com.salesianostriana.dam.perezmarquezgabriel.repository.HabitacionRepositorio;
import com.salesianostriana.dam.perezmarquezgabriel.service.base.BaseServiceImpl;


@Service
public class HabitacionService extends BaseServiceImpl<Habitacion, Long, HabitacionRepositorio>{

	@Autowired
	private HabitacionRepositorio habitacionRepositorio;
	
	public List<Habitacion> buscarPorCategoria(List<Long> ids){
		return  habitacionRepositorio.findByCategoria(ids);
	}
	
	
	public Habitacion buscarPorNumHabitacion(int num){
		return habitacionRepositorio.findByNumHabitacion(num);
	}
	
	
	public List<Habitacion> buscarPorNombre (String nombre){
		return habitacionRepositorio.buscarPorNombre(nombre);
	}
	
}
