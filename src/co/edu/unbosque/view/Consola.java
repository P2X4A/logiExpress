package co.edu.unbosque.view;

import java.util.Scanner;

/**
 * Vista de consola de LogiExpress: presenta el menu y captura los datos
 * de cada envio mediante el teclado.
 */
public class Consola {

	private final Scanner consola = new Scanner(System.in);

	/**
	 * Muestra el menu principal y devuelve la opcion elegida.
	 *
	 * @return opcion seleccionada por el usuario
	 */
	public int mostrarConsola() {
		System.out.println("""
				===== LOGIEXPRESS =====
				1. Registrar Envio Usuario
				2. Registrar Envio Documento(s)
				3. Registrar Envios Internacionales
				4. Listar Paquetes Con Envio Mayor a 500 USD
				5. Salir Del Programa
				""");
		return leerEntero("Seleccione una opcion: ");
	}

	/**
	 * Metodo generico para leer enteros sin romper el flujo ante una entrada invalida.
	 *
	 * @param mensaje texto a mostrar antes de leer
	 * @return entero leido
	 */
	private int leerEntero(String mensaje) {
		while (true) {
			System.out.print(mensaje);
			if (consola.hasNextInt()) {
				return consola.nextInt();
			}
			consola.next(); // descarta lo que no es un numero
			System.out.println("Entrada invalida, intente de nuevo.");
		}
	}

	private String leerTexto(String mensaje) {
		System.out.println(mensaje);
		return consola.nextLine();
	}

	public String pedirNombreEnvio() {
		return leerTexto("Ingrese El Nombre De El Emisor Del Paquete: ");
	}

	public String pedirNombreDestinatario() {
		return leerTexto("Ingrese El Nombre Del Destinatario: ");
	}

	public String pedirDireccionDeDestinatario() {
		return leerTexto("Ingrese La Direccion Del Destinatario: ");
	}

	public String pedirCiudadEnvio() {
		return leerTexto("Ingrese La Ciudad De Envio: ");
	}

	public int pedirCodigoPostal() {
		return leerEntero("Ingrese El Codigo Postal Del Destinatario: ");
	}

	public int pedirNumeroTelefonoDestinatario() {
		return leerEntero("Ingrese El Numero De Telefono Del Destinatario: ");
	}

	public int pedirPesoPaqueteKilogramos() {
		return leerEntero("Ingrese El Peso Del Paquete En Kilogramos: ");
	}

	public int pedirCostoDelServicio() {
		return leerEntero("Ingrese El Costo Del Servicio: ");
	}

	public int pedirCostoDelPaquete() {
		return leerEntero("Ingrese El Costo Del Paquete: ");
	}

	public int pedirLargoPaquete() {
		return leerEntero("Ingrese El Largo Del Paquete (cm): ");
	}

	public int pedirAnchoPaquete() {
		return leerEntero("Ingrese El Ancho Del Paquete (cm): ");
	}

	public int pedirAltoPaquete() {
		return leerEntero("Ingrese El Alto Del Paquete (cm): ");
	}

	public int pedirPesoDocumento() {
		return leerEntero("Ingrese El Peso Del Documento (kg, maximo 2): ");
	}

	public boolean pedirSelloDeSeguridad() {
		return leerEntero("El paquete incluye sello de seguridad? (1 = si, 0 = no): ") == 1;
	}

	public String pedirPaisDestino() {
		return leerTexto("Ingrese El Pais De Destino (EEUU / España / otro): ");
	}

	public int pedirMonedaDeclarada() {
		return leerEntero("Ingrese El Valor Declarado En Dolares: ");
	}

	public void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
}