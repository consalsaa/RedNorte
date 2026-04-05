package com.rednorte.ms_portal_paciente.controller;

import com.rednorte.ms_portal_paciente.entity.Paciente;
import com.rednorte.ms_portal_paciente.service.CitasService;
import com.rednorte.ms_portal_paciente.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/portal-paciente/perfil")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private CitasService citasService;

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

    /**
     * Endpoint de orquestación: consulta el estado de las citas/derivaciones
     * del paciente desde ms-listas-espera. Formatea y entrega los datos
     * al frontend del portal del paciente.
     */
    @GetMapping("/{rut}/citas")
    public ResponseEntity<List<Map<String, Object>>> obtenerCitas(@PathVariable String rut) {
        return ResponseEntity.ok(citasService.obtenerCitasPorRut(rut));
    }
}
