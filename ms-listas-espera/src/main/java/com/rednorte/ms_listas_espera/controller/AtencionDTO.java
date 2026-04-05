package com.rednorte.ms_listas_espera.controller;

public class AtencionDTO {
    private String rutPaciente;
    private String tipo; // CONSULTA, CIRUGIA
    private Integer prioridad;
    private String detalle; // Especialidad o Tipo de Cirugia

    // Getters y setters
    public String getRutPaciente() { return rutPaciente; }
    public void setRutPaciente(String rutPaciente) { this.rutPaciente = rutPaciente; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public Integer getPrioridad() { return prioridad; }
    public void setPrioridad(Integer prioridad) { this.prioridad = prioridad; }
    public String getDetalle() { return detalle; }
    public void setDetalle(String detalle) { this.detalle = detalle; }
}
