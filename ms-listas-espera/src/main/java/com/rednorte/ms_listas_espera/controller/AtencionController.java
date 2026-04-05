package com.rednorte.ms_listas_espera.controller;

import com.rednorte.ms_listas_espera.entity.Atencion;
import com.rednorte.ms_listas_espera.service.AtencionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listas-espera/atenciones")
public class AtencionController {

    @Autowired
    private AtencionService atencionService;

    @PostMapping
    public ResponseEntity<Atencion> registrar(@RequestBody AtencionDTO dto) {
        Atencion nuevaAtencion = atencionService.registrarAtencion(dto);
        return new ResponseEntity<>(nuevaAtencion, HttpStatus.CREATED);
    }

    @GetMapping("/pendientes")
    public ResponseEntity<List<Atencion>> listarPendientes() {
        return ResponseEntity.ok(atencionService.obtenerListaEspera());
    }

    @GetMapping
    public ResponseEntity<List<Atencion>> listarTodas() {
        return ResponseEntity.ok(atencionService.obtenerTodas());
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<Atencion> actualizarEstado(
            @PathVariable Long id,
            @RequestParam String nuevoEstado) {
        Atencion atencionActualizada = atencionService.actualizarEstado(id, nuevoEstado);
        return ResponseEntity.ok(atencionActualizada);
    }
}
