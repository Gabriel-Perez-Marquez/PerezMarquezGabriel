package com.salesianostriana.dam.perezmarquezgabriel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.perezmarquezgabriel.model.Categoria;
import com.salesianostriana.dam.perezmarquezgabriel.model.Habitacion;

public interface HabitacionRepositorio extends JpaRepository<Habitacion, Long> {
	
	@Query("SELECT h FROM Habitacion h WHERE LOWER(h.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
	List<Habitacion> buscarPorNombre(@Param("nombre") String nombre);
	
	
	Habitacion findByNumHabitacion(int numHabitacion);
	
	@Query("SELECT h FROM Habitacion h WHERE h.categoria.id IN (:ids)")
	List<Habitacion> findByCategoria(@Param("ids")List<Long> idsCategorias);

}