package com.salesianostriana.dam.perezmarquezgabriel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.perezmarquezgabriel.model.Categoria;
import com.salesianostriana.dam.perezmarquezgabriel.repository.CategoriaRepositorio;
import com.salesianostriana.dam.perezmarquezgabriel.service.base.BaseServiceImpl;

@Service
public class CategoriaService extends BaseServiceImpl<Categoria, Long, CategoriaRepositorio> {

	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	public long contarCategorias() {
	    return categoriaRepositorio.count();
	}
	
	
}
