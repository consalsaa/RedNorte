package com.rednorte.ms_listas_espera.controller;

import com.rednorte.ms_listas_espera.entity.Paciente;
import com.rednorte.ms_listas_espera.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listas-espera/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> registrar(@RequestBody Paciente paciente) {
        Paciente nuevoPaciente = pacienteService.registrarPaciente(paciente);
        return new ResponseEntity<>(nuevoPaciente, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> listarTodos() {
        return ResponseEntity.ok(pacienteService.obtenerTodos());
    }

    @GetMapping("/{rut}")
    public ResponseEntity<Paciente> obtenerPorRut(@PathVariable String rut) {
        return ResponseEntity.ok(pacienteService.obtenerPorRut(rut));
    }
}
