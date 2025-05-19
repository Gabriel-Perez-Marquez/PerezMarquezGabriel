package com.salesianostriana.dam.perezmarquezgabriel.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "habitacion_id")
	private Habitacion habitacion;
	private String nombreTitular;
	private String apellidosTitular;
	private int telefono;
	private int numClientes;
	private int numAdultos;
	private int numNiños;
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "promocion_id")
	private Promocion promocion;

	
	
	
	
	// metodos helper
	public void agregarAPromocion(Promocion p) {
		this.promocion = p;
		p.getReservas().add(this);
	}

	public void eliminarDeCategoria(Promocion p) {
		p.getReservas().remove(this);
		this.promocion = null;
	}
	
	
	
}