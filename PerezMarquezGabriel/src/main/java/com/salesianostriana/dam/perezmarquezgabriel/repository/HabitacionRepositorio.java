package com.salesianostriana.dam.perezmarquezgabriel.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.perezmarquezgabriel.model.Habitacion;

public interface HabitacionRepositorio extends JpaRepository<Habitacion, Long> {

	@Query("SELECT h FROM Habitacion h WHERE LOWER(h.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
	List<Habitacion> buscarPorNombre(@Param("nombre") String nombre);

	Optional<Habitacion> findByNumHabitacion(int numHabitacion);
	
	@Query("SELECT h FROM Habitacion h WHERE h.categoria.id IN (:ids)")
	List<Habitacion> findByCategoria(@Param("ids") List<Long> idsCategorias);


	@Query("SELECT h FROM Habitacion h ORDER BY h.nombre ASC")
	List<Habitacion> ordenarPorNombreAsc();

	@Query("SELECT h FROM Habitacion h ORDER BY h.nombre DESC")
	List<Habitacion> ordenarPorNombreDesc();


	@Query("SELECT h FROM Habitacion h ORDER BY h.precio ASC")
	List<Habitacion> ordenarPorPrecioAsc();
	
	@Query("SELECT h FROM Habitacion h ORDER BY h.precio DESC")
	List<Habitacion> ordenarPorPrecioDesc();

	@Query("""
			    SELECT h FROM Habitacion h
			    LEFT JOIN Reserva r ON r.habitacion = h
			    GROUP BY h
			    ORDER BY COUNT(r) DESC
			""")
	List<Habitacion> ordenarPorNumeroReservas();

}