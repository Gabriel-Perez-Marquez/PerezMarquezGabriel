function calcularPrecio() {

	const precioPorNoche = parseFloat(document.getElementById('precioPorNoche').textContent);
	const fechaEntradaInput = document.getElementById('fechaEntrada');
	const fechaSalidaInput = document.getElementById('fechaSalida');

	const fechaEntrada = new Date(fechaEntradaInput.value);
	const fechaSalida = new Date(fechaSalidaInput.value);

	// Limpiar errores previos
	fechaSalidaInput.setCustomValidity('');

	// Validar fechas
	if (fechaSalida <= fechaEntrada) {
		fechaSalidaInput.setCustomValidity('La fecha de salida debe ser posterior a la fecha de entrada.');
		fechaSalidaInput.reportValidity();
		return;
	}

	// Calcular noches
	const diffTime = Math.abs(fechaSalida - fechaEntrada);
	const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));

	const precioTotal = diffDays * precioPorNoche;

	// Mostrar resultado
	if (fechaEntradaInput.value !== '' && fechaSalidaInput.value !== '') {
		document.getElementById('resultadoPrecio').textContent =
			`Precio total para ${diffDays} noche(s): ${precioTotal} €`;
	}
}



function validarFormReserva () {
	
	document.addEventListener("DOMContentLoaded", function () {
		const form = document.getElementById("formReserva");
		if (!form) return;

		form.addEventListener("submit", function (event) {
			const numClientesInput = document.getElementById("numClientes");
			const numAdultosInput = document.getElementById("numAdultos");
			const numNinosInput = document.getElementById("numNiños");
			const fechaEntradaInput = document.getElementById('fechaEntrada');
			const fechaSalidaInput = document.getElementById('fechaSalida');

			// Resetear mensajes de error anteriores
			[numClientesInput, numAdultosInput, numNinosInput, fechaEntradaInput, fechaSalidaInput].forEach(input => {
				input.setCustomValidity('');
			});

			const numClientes = parseInt(numClientesInput.value) || 0;
			const numAdultos = parseInt(numAdultosInput.value) || 0;
			const numNinos = parseInt(numNinosInput.value) || 0;
			const fechaEntrada = new Date(fechaEntradaInput.value);
			const fechaSalida = new Date(fechaSalidaInput.value);

			let tieneErrores = false;

			// Validar fechas
			if (fechaSalida <= fechaEntrada) {
				event.preventDefault();
				fechaSalidaInput.setCustomValidity('La fecha de salida debe ser posterior a la fecha de entrada.');
				fechaSalidaInput.reportValidity();
				tieneErrores = true;
				return; // Cortar aquí porque no tiene sentido seguir si las fechas están mal
			}

			// Validar número de clientes
			if (numAdultos + numNinos !== numClientes) {
				event.preventDefault();
				numClientesInput.setCustomValidity("La suma de adultos y niños debe ser igual al número total de clientes.");
				numClientesInput.reportValidity();
				tieneErrores = true;
			}

			// Validar si hay niños sin adultos
			if (numNinos > 0 && numAdultos === 0) {
				event.preventDefault();
				numAdultosInput.setCustomValidity("Debe haber al menos un adulto si hay niños.");
				numAdultosInput.reportValidity();
				tieneErrores = true;
			}

			if (tieneErrores) {
				event.preventDefault(); // Por si acaso
			}
		});
	});
}



function initPrecioAuto() {
	document.addEventListener("DOMContentLoaded", function () {
		const entrada = document.getElementById("fechaEntrada");
		const salida = document.getElementById("fechaSalida");

		console.log(entrada.value)
		console.log(salida.value)

		
		entrada.addEventListener("change", calcularPrecio);
		salida.addEventListener("change", calcularPrecio);
		
	});
}




initPrecioAuto()
validarFormReserva()