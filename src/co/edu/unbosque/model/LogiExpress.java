package co.edu.unbosque.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LogiExpress {

    private List<RegistroPaquete> listarPaquetes = new ArrayList<>();
    private List<RegistroPaquete> listarPaquetesUsd500 = new ArrayList<>();

    public static double calcularPesoVolumetrico(int largoPaquete, int anchoPaquete, int altoPaquete) {
        return (largoPaquete * anchoPaquete * altoPaquete) / 5000.0;
    }

    // Registro de envíos normales (usuario)
    public void registrarEnvioDelUsuario(String nombreEnvio, String nombreDestinatario, String direccionDestinatario,
            String ciudadEnvio, int codigoPostal, int numeroTelefonoDestinatario, int pesoEnKilogramos,
            int costoServicio, int costoPaquete, UUID idPaquete, LocalDateTime horaYFecha, int largoPaquete,
            int anchoPaquete, int altoPaquete) {
    	
        if (idPaquete == null) {
            idPaquete = UUID.randomUUID();
        }
        if (horaYFecha == null) {
            horaYFecha = LocalDateTime.now();
        }

        double pesoVolumetrico = calcularPesoVolumetrico(largoPaquete, anchoPaquete, altoPaquete);

        // si el peso volumétrico es mayor, se usa ese (redondeado hacia arriba a kg)
        
        int pesoUsado = pesoEnKilogramos;
        
        if (pesoVolumetrico > pesoEnKilogramos) {
            pesoUsado = (int) Math.ceil(pesoVolumetrico);
        }

        RegistroUsuario registroUsuario = new RegistroUsuario(nombreEnvio, nombreDestinatario, direccionDestinatario,
                ciudadEnvio, codigoPostal, numeroTelefonoDestinatario, pesoUsado, costoServicio, costoPaquete,
                idPaquete, horaYFecha, largoPaquete, anchoPaquete, altoPaquete);

        listarPaquetes.add(registroUsuario);
    }

    // Envío de documentos — devuelve true si se pudo registrar (ejemplo: documentos hasta 2 kg)
    public boolean envioDocumentos(String nombreEnvio, String nombreDestinatario, String direccionDestinatario,
            String ciudadEnvio, int codigoPostal, int numeroTelefonoDestinatario, int pesoEnKilogramos,
            int costoServicio, int costoPaquete, UUID idPaquete, LocalDateTime horaYFecha, boolean selloDeSeguridad,
            int pesoDocumento) {

        if (idPaquete == null) {
            idPaquete = UUID.randomUUID();
        }
        if (horaYFecha == null) {
            horaYFecha = LocalDateTime.now();
        }

        // Validación: documento de 0 a 2 kg (ajustar según regla del enunciado)
        if (pesoDocumento >= 0 && pesoDocumento <= 2) {
            RegistroDocumento registroDocumento = new RegistroDocumento(nombreEnvio, nombreDestinatario,
                    direccionDestinatario, ciudadEnvio, codigoPostal, numeroTelefonoDestinatario, pesoEnKilogramos,
                    costoServicio, costoPaquete, idPaquete, horaYFecha, selloDeSeguridad, pesoDocumento);

            listarPaquetes.add(registroDocumento);
            return true;
        }

        return false;
    }

    // Envíos internacionales: si costoServicio >= 500 se guardan en listaUsd500
    public void enviosInternacionales(String nombreEnvio, String nombreDestinatario, String direccionDestinatario,
            String ciudadEnvio, int codigoPostal, int numeroTelefonoDestinatario, int pesoEnKilogramos,
            int costoServicio, int costoPaquete, UUID idPaquete, LocalDateTime horaYFecha, String paisDestino,
            int monedaDeclarada) {

        if (idPaquete == null) {
            idPaquete = UUID.randomUUID();
        }
        if (horaYFecha == null) {
            horaYFecha = LocalDateTime.now();
        }

        EnvioInternacional envioInternacional = new EnvioInternacional(nombreEnvio, nombreDestinatario,
                direccionDestinatario, ciudadEnvio, codigoPostal, numeroTelefonoDestinatario, pesoEnKilogramos,
                costoServicio, costoPaquete, idPaquete, horaYFecha, paisDestino, monedaDeclarada);

        if (costoServicio >= 500) {
            listarPaquetesUsd500.add(envioInternacional);
        } else {
            listarPaquetes.add(envioInternacional);
        }
    }

    // Cálculo de impuesto simple basado en país
    public double calcularImpuesto(double montoDeclarado, String paisDestino) {
        double tasaEEUU = 0.10;
        double tasaEspaña = 0.20;
        double tasaExterior = 0.15;

        double tasa = tasaExterior; // por defecto

        if (paisDestino != null) {
            if (paisDestino.equalsIgnoreCase("EEUU") || paisDestino.equalsIgnoreCase("USA")
                    || paisDestino.equalsIgnoreCase("Estados Unidos")) {
                tasa = tasaEEUU;
            } else if (paisDestino.equalsIgnoreCase("España") || paisDestino.equalsIgnoreCase("España")) {
                tasa = tasaEspaña;
            } else {
                tasa = tasaExterior;
            }
        }

        return montoDeclarado * tasa;
    }

    // Getters para revisar listas desde consola
    public List<RegistroPaquete> getListarPaquetes() {
        return listarPaquetes;
    }

    public List<RegistroPaquete> getListarPaquetesUsd500() {
        return listarPaquetesUsd500;
    }
}
