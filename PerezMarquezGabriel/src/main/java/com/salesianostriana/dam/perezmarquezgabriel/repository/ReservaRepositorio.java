package com.salesianostriana.dam.perezmarquezgabriel.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.perezmarquezgabriel.model.Reserva;

public interface ReservaRepositorio extends JpaRepository<Reserva, Long> {

	@Query("SELECT r FROM Reserva r WHERE r.habitacion.id = :idHabitacion AND r.fechaEntrada < :fechaSalida AND r.fechaSalida > :fechaEntrada")
	List<Reserva> buscarReservasSolapadas(@Param("idHabitacion") Long idHabitacion,
	                                      @Param("fechaEntrada") LocalDate fechaEntrada,
	                                      @Param("fechaSalida") LocalDate fechaSalida);


}
