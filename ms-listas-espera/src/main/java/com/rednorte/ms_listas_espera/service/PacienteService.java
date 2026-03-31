package com.rednorte.ms_listas_espera.service;

import com.rednorte.ms_listas_espera.entity.Paciente;
import java.util.List;

public interface PacienteService {
    Paciente registrarPaciente(Paciente paciente);
    List<Paciente> obtenerTodos();
    Paciente obtenerPorRut(String rut);
}
