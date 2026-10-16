package co.edu.unbosque.controller;

import co.edu.unbosque.model.LogiExpress;
import co.edu.unbosque.model.RegistroPaquete;
import co.edu.unbosque.view.Consola;

import java.util.List;

/**
 * Controlador de LogiExpress: conecta la vista de consola con el modelo
 * de envios y mantiene el bucle principal del menu.
 */
public class Controlador {

	private final Consola consola = new Consola();
	private final LogiExpress modelo = new LogiExpress();
	private boolean ejecutando;

	/**
	 * Punto de entrada del flujo de la aplicacion.
	 * Muestra el menu en un bucle hasta que el usuario elija salir.
	 */
	public void ejecutar() {
		ejecutando = true;
		consola.mostrarMensaje("Bienvenido a LogiExpress, su empresa de paqueteria internacional.");

		while (ejecutando) {
			int opcion = consola.mostrarConsola();
			switch (opcion) {
				case 1 -> registrarEnvioUsuario();
				case 2 -> registrarEnvioDocumentos();
				case 3 -> registrarEnvioInternacional();
				case 4 -> listarPaquetesMayores500();
				case 5 -> ejecutando = false;
				default -> consola.mostrarMensaje("Opcion no valida, intente de nuevo.");
			}
		}
		consola.mostrarMensaje("Saliendo del programa. Hasta pronto.");
	}

	/**
	 * Opcion 1: registra un envio normal de un usuario.
	 * El peso usado es el mayor entre el peso real y el peso volumetrico.
	 */
	private void registrarEnvioUsuario() {
		consola.mostrarMensaje("--- Registro de envio de usuario ---");
		String nombreEnvio = consola.pedirNombreEnvio();
		String nombreDestinatario = consola.pedirNombreDestinatario();
		String direccionDestinatario = consola.pedirDireccionDeDestinatario();
		String ciudadEnvio = consola.pedirCiudadEnvio();
		int codigoPostal = consola.pedirCodigoPostal();
		int telefonoDestinatario = consola.pedirNumeroTelefonoDestinatario();
		int peso = consola.pedirPesoPaqueteKilogramos();
		int costoServicio = consola.pedirCostoDelServicio();
		int costoPaquete = consola.pedirCostoDelPaquete();
		int largo = consola.pedirLargoPaquete();
		int ancho = consola.pedirAnchoPaquete();
		int alto = consola.pedirAltoPaquete();

		modelo.registrarEnvioDelUsuario(nombreEnvio, nombreDestinatario, direccionDestinatario, ciudadEnvio,
				codigoPostal, telefonoDestinatario, peso, costoServicio, costoPaquete,
				null, null, largo, ancho, alto);

		consola.mostrarMensaje("Envio registrado. Peso volumetrico calculado: "
				+ LogiExpress.calcularPesoVolumetrico(largo, ancho, alto) + " kg");
	}

	/**
	 * Opcion 2: registra el envio de documentos (maximo 2 kg de documento).
	 */
	private void registrarEnvioDocumentos() {
		consola.mostrarMensaje("--- Registro de envio de documentos ---");
		String nombreEnvio = consola.pedirNombreEnvio();
		String nombreDestinatario = consola.pedirNombreDestinatario();
		String direccionDestinatario = consola.pedirDireccionDeDestinatario();
		String ciudadEnvio = consola.pedirCiudadEnvio();
		int codigoPostal = consola.pedirCodigoPostal();
		int telefonoDestinatario = consola.pedirNumeroTelefonoDestinatario();
		int peso = consola.pedirPesoPaqueteKilogramos();
		int costoServicio = consola.pedirCostoDelServicio();
		int costoPaquete = consola.pedirCostoDelPaquete();
		int pesoDocumento = consola.pedirPesoDocumento();
		boolean sello = consola.pedirSelloDeSeguridad();

		boolean registrado = modelo.envioDocumentos(nombreEnvio, nombreDestinatario, direccionDestinatario,
				ciudadEnvio, codigoPostal, telefonoDestinatario, peso, costoServicio, costoPaquete,
				null, null, sello, pesoDocumento);

		if (registrado) {
			consola.mostrarMensaje("Envio de documentos registrado.");
		} else {
			consola.mostrarMensaje("No se pudo registrar: el documento supera el maximo de 2 kg.");
		}
	}

	/**
	 * Opcion 3: registra un envio internacional y calcula el impuesto
	 * segun el pais de destino.
	 */
	private void registrarEnvioInternacional() {
		consola.mostrarMensaje("--- Registro de envio internacional ---");
		String nombreEnvio = consola.pedirNombreEnvio();
		String nombreDestinatario = consola.pedirNombreDestinatario();
		String direccionDestinatario = consola.pedirDireccionDeDestinatario();
		String ciudadEnvio = consola.pedirCiudadEnvio();
		int codigoPostal = consola.pedirCodigoPostal();
		int telefonoDestinatario = consola.pedirNumeroTelefonoDestinatario();
		int peso = consola.pedirPesoPaqueteKilogramos();
		int costoServicio = consola.pedirCostoDelServicio();
		int costoPaquete = consola.pedirCostoDelPaquete();
		String paisDestino = consola.pedirPaisDestino();
		int monedaDeclarada = consola.pedirMonedaDeclarada();

		modelo.enviosInternacionales(nombreEnvio, nombreDestinatario, direccionDestinatario, ciudadEnvio,
				codigoPostal, telefonoDestinatario, peso, costoServicio, costoPaquete,
				null, null, paisDestino, monedaDeclarada);

		double impuesto = modelo.calcularImpuesto(monedaDeclarada, paisDestino);
		consola.mostrarMensaje("Envio internacional registrado. Impuesto a pagar: " + impuesto);
	}

	/**
	 * Opcion 4: lista los envios internacionales cuyo costo supera los 500 USD.
	 */
	private void listarPaquetesMayores500() {
		List<RegistroPaquete> lista = modelo.getListarPaquetesUsd500();
		consola.mostrarMensaje("Paquetes con envio mayor a 500 USD: " + lista.size());
		for (RegistroPaquete paquete : lista) {
			consola.mostrarMensaje("  - Destinatario: " + paquete.getDireccionDestinatario()
					+ " | Paquete: " + paquete.getIdPaquete());
		}
	}

	public List<RegistroPaquete> getListarPaquetes() {
		return modelo.getListarPaquetes();
	}

	public List<RegistroPaquete> getListarPaquetesUsd500() {
		return modelo.getListarPaquetesUsd500();
	}
}