package com.rednorte.ms_reasignacion.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reasignaciones")
public class Reasignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long atencionCanceladaId;

    @Column(nullable = false)
    private Long atencionReasignadaId;

    @Column(nullable = false, length = 15)
    private String rutPacienteOriginal;

    @Column(nullable = false, length = 15)
    private String rutPacienteReasignado;

    @Column(length = 100)
    private String especialidad;

    @Column(nullable = false)
    private LocalDateTime fechaReasignacion;

    @Column(nullable = false, length = 30)
    private String estado; // EXITOSA, FALLIDA, PENDIENTE

    @Column(columnDefinition = "TEXT")
    private String observaciones;

    public Reasignacion() {
        this.fechaReasignacion = LocalDateTime.now();
        this.estado = "EXITOSA";
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getAtencionCanceladaId() { return atencionCanceladaId; }
    public void setAtencionCanceladaId(Long atencionCanceladaId) { this.atencionCanceladaId = atencionCanceladaId; }
    public Long getAtencionReasignadaId() { return atencionReasignadaId; }
    public void setAtencionReasignadaId(Long atencionReasignadaId) { this.atencionReasignadaId = atencionReasignadaId; }
    public String getRutPacienteOriginal() { return rutPacienteOriginal; }
    public void setRutPacienteOriginal(String rutPacienteOriginal) { this.rutPacienteOriginal = rutPacienteOriginal; }
    public String getRutPacienteReasignado() { return rutPacienteReasignado; }
    public void setRutPacienteReasignado(String rutPacienteReasignado) { this.rutPacienteReasignado = rutPacienteReasignado; }
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    public LocalDateTime getFechaReasignacion() { return fechaReasignacion; }
    public void setFechaReasignacion(LocalDateTime fechaReasignacion) { this.fechaReasignacion = fechaReasignacion; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}
