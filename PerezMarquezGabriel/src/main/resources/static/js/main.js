function calcularPrecio() {
	console.log("Hola")
	const precioPorNoche = parseFloat(document.getElementById('precioPorNoche').textContent);
	const fechaEntradaInput = document.getElementById('fechaEntrada').value;
	const fechaSalidaInput = document.getElementById('fechaSalida').value;

	const fechaEntrada = new Date(fechaEntradaInput);
	const fechaSalida = new Date(fechaSalidaInput);

	if (fechaSalida <= fechaEntrada) {
		alert('La fecha de salida debe ser posterior a la fecha de entrada.');
		return;
	}



	const diffTime = Math.abs(fechaSalida - fechaEntrada);
	const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));

	const precioTotal = diffDays * precioPorNoche;


	if(fechaEntradaInput != '' && fechaSalidaInput != ''){
		document.getElementById('resultadoPrecio').textContent =
		`Precio total para ${diffDays} noche(s): ${precioTotal} €`;
	}
	

	
}


function validarFormReserva () {
	console.log("Hola")
	document.addEventListener("DOMContentLoaded", function () {
		let form;

		if (document.getElementById("formReserva")) {
			form = document.getElementById("formReserva");
		}

    form.addEventListener("submit", function (event) {
		const numClientes = parseInt(document.getElementById("numClientes").value) || 0;
        const numAdultos = parseInt(document.getElementById("numAdultos").value) || 0;
        const numNinos = parseInt(document.getElementById("numNiños").value) || 0;
		const fechaEntradaInput = document.getElementById('fechaEntrada').value;
		const fechaSalidaInput = document.getElementById('fechaSalida').value;


		const fechaEntrada = new Date(fechaEntradaInput);
		const fechaSalida = new Date(fechaSalidaInput);

		if (fechaSalida <= fechaEntrada) {
			event.preventDefault();
			alert('La fecha de salida debe ser posterior a la fecha de entrada.');
			return;
		}

		
        let errores = [];
		
        if (numAdultos + numNinos !== numClientes) {
            errores.push("La suma de adultos y niños debe ser igual al número total de clientes.");
        }

        if (numNinos > 0 && numAdultos === 0) {
            errores.push("Debe haber al menos un adulto si hay niños.");
        }

        if (errores.length > 0) {
			event.preventDefault();
            alert(errores.join("\n"));
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