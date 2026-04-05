package com.rednorte.ms_portal_paciente.service;

import com.rednorte.ms_portal_paciente.entity.Paciente;

public interface PacienteService {
    Paciente registrarPerfil(Paciente paciente);
    Paciente obtenerPerfilPorRut(String rut);
    Paciente actualizarPerfil(String rut, Paciente datosNuevos);
}
