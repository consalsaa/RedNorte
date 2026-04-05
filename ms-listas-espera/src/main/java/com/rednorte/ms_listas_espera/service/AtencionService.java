package com.rednorte.ms_listas_espera.service;

import com.rednorte.ms_listas_espera.entity.Atencion;
import com.rednorte.ms_listas_espera.controller.AtencionDTO;

import java.util.List;

public interface AtencionService {
    Atencion registrarAtencion(AtencionDTO dto);
    List<Atencion> obtenerListaEspera();
    Atencion actualizarEstado(Long id, String nuevoEstado);
}
