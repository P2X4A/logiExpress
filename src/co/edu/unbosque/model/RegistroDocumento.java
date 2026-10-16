package co.edu.unbosque.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class RegistroDocumento extends RegistroPaquete {

	private boolean selloDeSeguridad;
	private int pesoDocumento;

	public RegistroDocumento(String nombreEnvio, String nombreDestinatario, String direccionDestinatario,
			String ciudadEnvio, int codigoPostal, int numeroTelefonoDestinatario, int pesoEnKilogramos,
			int costoServicio, int costoPaquete, UUID idPaquete, LocalDateTime horaYFecha, boolean selloDeSeguridad,
			int pesoDocumento) {
		super(nombreEnvio, nombreDestinatario, direccionDestinatario, ciudadEnvio, codigoPostal,
				numeroTelefonoDestinatario, pesoEnKilogramos, costoServicio, costoPaquete, idPaquete, horaYFecha);
		this.selloDeSeguridad = selloDeSeguridad;
		this.pesoDocumento = pesoDocumento;
	}

	public boolean isSelloDeSeguridad() {
		return selloDeSeguridad;
	}

	public void setSelloDeSeguridad(boolean selloDeSeguridad) {
		this.selloDeSeguridad = selloDeSeguridad;
	}

	public int getPesoDocumento() {
		return pesoDocumento;
	}

	public void setPesoDocumento(int pesoDocumento) {
		this.pesoDocumento = pesoDocumento;
	}

}
