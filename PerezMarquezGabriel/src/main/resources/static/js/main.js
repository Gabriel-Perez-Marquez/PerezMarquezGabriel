function calcularPrecio() {

	const precioPorNoche = parseFloat(document.getElementById('precioPorNoche').textContent);
	const fechaEntradaInput = document.getElementById('fechaEntrada').value;
	const fechaSalidaInput = document.getElementById('fechaSalida').value;

	if (!fechaEntradaInput || !fechaSalidaInput) {
		alert('Por favor, introduce ambas fechas.');
		return;
	}

	const fechaEntrada = new Date(fechaEntradaInput);
	const fechaSalida = new Date(fechaSalidaInput);

	if (fechaSalida <= fechaEntrada) {
		alert('La fecha de salida debe ser posterior a la fecha de entrada.');
		return;
	}



	const diffTime = Math.abs(fechaSalida - fechaEntrada);
	const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));

	const precioTotal = diffDays * precioPorNoche;

	document.getElementById('resultadoPrecio').textContent =
		`Precio total para ${diffDays} noche(s): ${precioTotal} €`;
}