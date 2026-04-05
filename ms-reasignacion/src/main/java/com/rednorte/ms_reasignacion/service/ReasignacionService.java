package com.rednorte.ms_reasignacion.service;

import com.rednorte.ms_reasignacion.entity.Reasignacion;

import java.util.List;
import java.util.Map;

public interface ReasignacionService {

    /**
     * Procesa una cancelación de atención: busca la siguiente atención
     * prioritaria en la lista de espera y la reasigna a la hora disponible.
     */
    Reasignacion procesarCancelacion(Long atencionId);

    /**
     * Obtiene el historial completo de reasignaciones realizadas.
     */
    List<Reasignacion> obtenerHistorial();

    /**
     * Obtiene las reasignaciones asociadas a un paciente específico.
     */
    List<Reasignacion> obtenerPorPaciente(String rut);
}
