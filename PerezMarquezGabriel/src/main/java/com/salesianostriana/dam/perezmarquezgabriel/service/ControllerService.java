package com.salesianostriana.dam.perezmarquezgabriel.service;

import org.springframework.stereotype.Service;

@Service
public class ControllerService {

	
	
	public String [] getCategorias() {
		return new String []  {"Individual", "Doble", "+2"};
	}
	
	
}
