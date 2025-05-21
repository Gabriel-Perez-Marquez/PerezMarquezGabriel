package com.salesianostriana.dam.perezmarquezgabriel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.perezmarquezgabriel.model.Categoria;
import com.salesianostriana.dam.perezmarquezgabriel.model.Habitacion;
import com.salesianostriana.dam.perezmarquezgabriel.repository.CategoriaRepositorio;
import com.salesianostriana.dam.perezmarquezgabriel.service.base.BaseServiceImpl;

@Service
public class CategoriaService extends BaseServiceImpl<Categoria, Long, CategoriaRepositorio> {

	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	@Autowired
	private HabitacionService habitacionService;
	
	
	public long contarCategorias() {
	    return categoriaRepositorio.count();
	}
	
	
	public double calcularRecaudacionTotalCategoria(Categoria categoria) {
	    double total = 0.0;
	    for (Habitacion habitacion : categoria.getListHabitaciones()) {
	        total += habitacionService.calcularRecaudacionTotalHab(habitacion);
	    }
	    return total;
	}

	public List<Categoria> calcularRecaudacionTodasCategorias(List<Categoria> categorias) {
	    for (Categoria categoria : categorias) {
	        double total = calcularRecaudacionTotalCategoria(categoria);
	        categoria.setTotalRecaudado(total);
	    }
	    return categorias;
	}

	
}
