package co.edu.unbosque.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class EnvioInternacional extends RegistroPaquete {

	private String paisDestino;
	private int monedaDeclarada;

	public EnvioInternacional(String nombreEnvio, String nombreDestinatario, String direccionDestinatario,
			String ciudadEnvio, int codigoPostal, int numeroTelefonoDestinatario, int pesoEnKilogramos,
			int costoServicio, int costoPaquete, UUID idPaquete, LocalDateTime horaYFecha, String paisDestino,
			int monedaDeclarada) {
		super(nombreEnvio, nombreDestinatario, direccionDestinatario, ciudadEnvio, codigoPostal,
				numeroTelefonoDestinatario, pesoEnKilogramos, costoServicio, costoPaquete, idPaquete, horaYFecha);
		this.paisDestino = paisDestino;
		this.monedaDeclarada = monedaDeclarada;
	}

	public String getPaisDestino() {
		return paisDestino;
	}

	public void setPaisDestino(String paisDestino) {
		this.paisDestino = paisDestino;
	}

	public int getMonedaDeclarada() {
		return monedaDeclarada;
	}

	public void setMonedaDeclarada(int monedaDeclarada) {
		this.monedaDeclarada = monedaDeclarada;
	}

}
