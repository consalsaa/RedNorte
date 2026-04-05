package com.rednorte.ms_listas_espera.entity;

public class AtencionFactory {

    public static Atencion crearAtencion(String tipo, Paciente paciente, Integer prioridad, String detalle) {
        if ("CONSULTA".equalsIgnoreCase(tipo)) {
            return new AtencionConsulta(paciente, prioridad, detalle); // detalle = especialidad
        } else if ("CIRUGIA".equalsIgnoreCase(tipo)) {
            return new AtencionCirugia(paciente, prioridad, detalle, true); // detalle = tipoCirugia
        } else {
            throw new IllegalArgumentException("Tipo de atención no soportado: " + tipo);
        }
    }
}
