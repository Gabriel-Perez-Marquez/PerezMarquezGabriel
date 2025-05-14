package com.salesianostriana.dam.perezmarquezgabriel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
	
	@Lob
	private String descripcion;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	private double precio;
	private boolean limpia;
	private String urlImage;
	
	@OneToOne
	@JoinColumn(name="reserva_id")
	private Reserva reserva;
	
	
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
	
	
	//metodos helper
	public void agregarACategoria(Categoria c) {
		this.categoria = c;
		c.getListHabitaciones().add(this);
	}
	
	public void eliminarDeCategoria(Categoria c) {
		c.getListHabitaciones().remove(this);
		this.categoria = null;		
	}
	
	
	
}
