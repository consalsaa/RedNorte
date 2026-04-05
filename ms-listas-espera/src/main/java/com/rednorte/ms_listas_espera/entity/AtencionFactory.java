package com.rednorte.ms_listas_espera.entity;

public class AtencionFactory {

    /**
     * Factory Method Pattern: Crea la instancia correcta de Atencion
     * según el tipo solicitado (CONSULTA, CIRUGIA, EMERGENCIA).
     * Cada tipo tiene sus propias reglas de negocio y atributos específicos.
     */
    public static Atencion crearAtencion(String tipo, Paciente paciente, Integer prioridad, String detalle) {
        if ("CONSULTA".equalsIgnoreCase(tipo)) {
            return new AtencionConsulta(paciente, prioridad, detalle); // detalle = especialidad
        } else if ("CIRUGIA".equalsIgnoreCase(tipo)) {
            return new AtencionCirugia(paciente, prioridad, detalle, true); // detalle = tipoCirugia
        } else if ("EMERGENCIA".equalsIgnoreCase(tipo)) {
            return new AtencionEmergencia(paciente, prioridad, detalle, false); // detalle = motivoEmergencia
        } else {
            throw new IllegalArgumentException("Tipo de atención no soportado: " + tipo);
        }
    }
}
