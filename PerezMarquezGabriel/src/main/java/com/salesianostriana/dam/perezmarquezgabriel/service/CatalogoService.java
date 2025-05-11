package com.salesianostriana.dam.perezmarquezgabriel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.perezmarquezgabriel.model.Categoria;
import com.salesianostriana.dam.perezmarquezgabriel.model.Habitacion;
import com.salesianostriana.dam.perezmarquezgabriel.repository.CategoriaRepositorio;
import com.salesianostriana.dam.perezmarquezgabriel.repository.HabitacionRepositorio;

@Service
public class CatalogoService {

	@Autowired
	private HabitacionRepositorio habitacionRepositorio;
	
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	
	public void agregar(Habitacion h) {
		habitacionRepositorio.save(h);
	}
	
	public void borrar(Long id) {
		habitacionRepositorio.delete(habitacionRepositorio.findById(id).orElse(null));
	}
	
	public Habitacion buscarPorId(Long id) {
		return habitacionRepositorio.findById(id).orElse(null);
	}
	
	public List<Categoria> getCategorias(){
		return categoriaRepositorio.findAll();
	}
	
	public List<Habitacion> buscarTodos(){
		return habitacionRepositorio.findAll();
	}
	
	public List<Habitacion> buscarPorNombre (String nombre){
		return habitacionRepositorio.buscarPorNombre(nombre);
	}
	
	public Habitacion buscarPorNumHabitacion(int num){
		return habitacionRepositorio.findByNumHabitacion(num);
	}

	
	
	
	
	
	
}
