package com.rednorte.ms_portal_paciente.controller;

import com.rednorte.ms_portal_paciente.entity.Paciente;
import com.rednorte.ms_portal_paciente.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/portal-paciente/perfil")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> crearPerfil(@RequestBody Paciente paciente) {
        Paciente nuevo = pacienteService.registrarPerfil(paciente);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    @GetMapping("/{rut}")
    public ResponseEntity<Paciente> obtenerPerfil(@PathVariable String rut) {
        return ResponseEntity.ok(pacienteService.obtenerPerfilPorRut(rut));
    }

    @PutMapping("/{rut}")
    public ResponseEntity<Paciente> actualizarPerfil(@PathVariable String rut, @RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.actualizarPerfil(rut, paciente));
    }
}
