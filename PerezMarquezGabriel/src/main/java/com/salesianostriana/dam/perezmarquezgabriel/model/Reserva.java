package com.salesianostriana.dam.perezmarquezgabriel.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Reserva {

	@Id
	@GeneratedValue
	private Long id;
	@OneToOne
	private Habitacion h;
	private String nombreTitular;
	private String apellidosTitular;
	private int telefono;
	private int numClientes;
	private int numAdultos;
	private int numNiños;
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	
}