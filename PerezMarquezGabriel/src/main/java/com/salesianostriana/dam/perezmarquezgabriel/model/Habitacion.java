package com.salesianostriana.dam.perezmarquezgabriel.model;

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

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	private double precio;
	

	private boolean limpia;
	private String urlImage;
	
	
	public Habitacion(int numHabitacion, String descripcion, Categoria categoria, double precio, boolean limpia, String urlImage) {
		super();
		this.numHabitacion = numHabitacion;
		this.nombre = "Habitacion" + categoria + ' ' + numHabitacion;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.precio = precio;
		this.limpia = limpia;
		this.urlImage = urlImage;
	}
	
	
	
	
	
}
