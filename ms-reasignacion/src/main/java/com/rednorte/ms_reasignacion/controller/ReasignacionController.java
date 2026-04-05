package com.rednorte.ms_reasignacion.controller;

import com.rednorte.ms_reasignacion.entity.Reasignacion;
import com.rednorte.ms_reasignacion.service.ReasignacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reasignacion")
public class ReasignacionController {

    @Autowired
    private ReasignacionService reasignacionService;

    /**
     * Procesa la cancelación de una atención y reasigna automáticamente.
     * Este es el endpoint principal que activa el motor de reasignación.
     */
    @PostMapping("/procesar/{atencionId}")
    public ResponseEntity<Reasignacion> procesarCancelacion(@PathVariable Long atencionId) {
        Reasignacion resultado = reasignacionService.procesarCancelacion(atencionId);
        return new ResponseEntity<>(resultado, HttpStatus.CREATED);
    }

    /**
     * Obtiene el historial completo de reasignaciones.
     */
    @GetMapping("/historial")
    public ResponseEntity<List<Reasignacion>> obtenerHistorial() {
        return ResponseEntity.ok(reasignacionService.obtenerHistorial());
    }

    /**
     * Obtiene las reasignaciones de un paciente específico.
     */
    @GetMapping("/paciente/{rut}")
    public ResponseEntity<List<Reasignacion>> obtenerPorPaciente(@PathVariable String rut) {
        return ResponseEntity.ok(reasignacionService.obtenerPorPaciente(rut));
    }
}
