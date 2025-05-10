package com.salesianostriana.dam.perezmarquezgabriel.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor 
@Entity
public class Habitacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int numHabitacion;
	private String nombre;
	private String descripcion;
	private String nombreCliente;
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	private double precio;
	private int numClientes;
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	private boolean limpia;
	private String urlImage;
	
	
	public Habitacion(Long id, int numHabitacion, String descripcion, String nombreCliente,
			Categoria categoria, double precio, int numClientes, LocalDate fechaEntrada, LocalDate fechaSalida,
			boolean limpia, String urlImage) {
		super();
		this.id = id;
		this.numHabitacion = numHabitacion;
		this.nombre = "Habitacion" + categoria + ' ' + numHabitacion;
		this.descripcion = descripcion;
		this.nombreCliente = nombreCliente;
		this.categoria = categoria;
		this.precio = precio;
		this.numClientes = numClientes;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.limpia = limpia;
		this.urlImage = urlImage;
	}
	
	
	
	
	
}
