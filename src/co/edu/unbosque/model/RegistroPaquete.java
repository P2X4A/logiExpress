package co.edu.unbosque.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class RegistroPaquete {
	protected String nombreEnvio;
	protected String nombreDestinatario;
	protected String direccionDestinatario;
	protected String ciudadEnvio;
	protected int codigoPostal;
	protected int numeroTelefonoDestinatario;
	protected int pesoEnKilogramos;
	protected int costoServicio;
	protected int costoPaquete;
	//ID y hora y fecha del sistema.
	protected UUID idPaquete = UUID.randomUUID();
	protected LocalDateTime horaYFecha = LocalDateTime.now();
	
	public RegistroPaquete(String nombreEnvio, String nombreDestinatario, String direccionDestinatario,
			String ciudadEnvio, int codigoPostal, int numeroTelefonoDestinatario, int pesoEnKilogramos,
			int costoServicio, int costoPaquete, UUID idPaquete, LocalDateTime horaYFecha) {
		super();
		this.nombreEnvio = nombreEnvio;
		this.nombreDestinatario = nombreDestinatario;
		this.direccionDestinatario = direccionDestinatario;
		this.ciudadEnvio = ciudadEnvio;
		this.codigoPostal = codigoPostal;
		this.numeroTelefonoDestinatario = numeroTelefonoDestinatario;
		this.pesoEnKilogramos = pesoEnKilogramos;
		this.costoServicio = costoServicio;
		this.costoPaquete = costoPaquete;
		this.idPaquete = idPaquete;
		this.horaYFecha = horaYFecha;
	}

	public String getNombreEnvio() {
		return nombreEnvio;
	}

	public void setNombreEnvio(String nombreEnvio) {
		this.nombreEnvio = nombreEnvio;
	}

	public String getNombreDestinatario() {
		return nombreDestinatario;
	}

	public void setNombreDestinatario(String nombreDestinatario) {
		this.nombreDestinatario = nombreDestinatario;
	}

	public String getDireccionDestinatario() {
		return direccionDestinatario;
	}

	public void setDireccionDestinatario(String direccionDestinatario) {
		this.direccionDestinatario = direccionDestinatario;
	}

	public String getCiudadEnvio() {
		return ciudadEnvio;
	}

	public void setCiudadEnvio(String ciudadEnvio) {
		this.ciudadEnvio = ciudadEnvio;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public int getNumeroTelefonoDestinatario() {
		return numeroTelefonoDestinatario;
	}

	public void setNumeroTelefonoDestinatario(int numeroTelefonoDestinatario) {
		this.numeroTelefonoDestinatario = numeroTelefonoDestinatario;
	}

	public int getPesoEnKilogramos() {
		return pesoEnKilogramos;
	}

	public void setPesoEnKilogramos(int pesoEnKilogramos) {
		this.pesoEnKilogramos = pesoEnKilogramos;
	}

	public int getCostoServicio() {
		return costoServicio;
	}

	public void setCostoServicio(int costoServicio) {
		this.costoServicio = costoServicio;
	}

	public int getCostoPaquete() {
		return costoPaquete;
	}

	public void setCostoPaquete(int costoPaquete) {
		this.costoPaquete = costoPaquete;
	}

	public UUID getIdPaquete() {
		return idPaquete;
	}

	public void setIdPaquete(UUID idPaquete) {
		this.idPaquete = idPaquete;
	}

	public LocalDateTime getHoraYFecha() {
		return horaYFecha;
	}

	public void setHoraYFecha(LocalDateTime horaYFecha) {
		this.horaYFecha = horaYFecha;
	}
	
	

}
	
