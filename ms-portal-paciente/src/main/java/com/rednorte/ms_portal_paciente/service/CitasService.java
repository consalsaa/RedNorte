package com.rednorte.ms_portal_paciente.service;

import java.util.List;
import java.util.Map;

public interface CitasService {

    /**
     * Consulta las citas/atenciones de un paciente desde ms-listas-espera.
     * El portal-paciente orquesta datos de otros microservicios.
     */
    List<Map<String, Object>> obtenerCitasPorRut(String rut);
}
