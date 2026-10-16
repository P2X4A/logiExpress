package co.edu.unbosque.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class RegistroUsuario extends RegistroPaquete {

	private int largoPaquete;
	private int anchoPaquete;
	private int altoPaquete;

	public RegistroUsuario(String nombreEnvio, String nombreDestinatario, String direccionDestinatario,
			String ciudadEnvio, int codigoPostal, int numeroTelefonoDestinatario, int pesoEnKilogramos,
			int costoServicio, int costoPaquete, UUID idPaquete, LocalDateTime horaYFecha, int largoPaquete,
			int anchoPaquete, int altoPaquete) {
		super(nombreEnvio, nombreDestinatario, direccionDestinatario, ciudadEnvio, codigoPostal,
				numeroTelefonoDestinatario, pesoEnKilogramos, costoServicio, costoPaquete, idPaquete, horaYFecha);
		this.largoPaquete = largoPaquete;
		this.anchoPaquete = anchoPaquete;
		this.altoPaquete = altoPaquete;
	}

	public int getLargoPaquete() {
		return largoPaquete;
	}

	public void setLargoPaquete(int largoPaquete) {
		this.largoPaquete = largoPaquete;
	}

	public int getAnchoPaquete() {
		return anchoPaquete;
	}

	public void setAnchoPaquete(int anchoPaquete) {
		this.anchoPaquete = anchoPaquete;
	}

	public int getAltoPaquete() {
		return altoPaquete;
	}

	public void setAltoPaquete(int altoPaquete) {
		this.altoPaquete = altoPaquete;
	}
}
