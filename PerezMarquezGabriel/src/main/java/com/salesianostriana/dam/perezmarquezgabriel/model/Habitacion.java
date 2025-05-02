package com.salesianostriana.dam.perezmarquezgabriel.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Habitacion {

	@Id
	@GeneratedValue
	private long id;
	private int numHabitacion;
	private String descripcion;
	private String nombreCliente;
//	private Categoria categoria;
	private double precio;
	private int numClientes;
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	private boolean limpia;
	private String urlImage;
	
	
	
}
