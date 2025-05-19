package com.salesianostriana.dam.perezmarquezgabriel.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	private String urlImage;
	public String textoAlt;	
	@OneToMany(mappedBy = "habitacion")
	private List<Reserva> reservas;
	
	
	public Habitacion(int numHabitacion, String descripcion, Categoria categoria, double precio, String urlImage, String textoAlt) {
		super();
		this.numHabitacion = numHabitacion;
		this.nombre = "Habitacion" + categoria + ' ' + numHabitacion;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.precio = precio;
		this.urlImage = urlImage;
		this.textoAlt = textoAlt;
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
	
	

	public void agregarReserva(Reserva reserva) {
	    reservas.add(reserva);
	    reserva.setHabitacion(this);
	}

	public void eliminarReserva(Reserva reserva) {
	    reservas.remove(reserva);
	    reserva.setHabitacion(null);
	}


	
	
}
