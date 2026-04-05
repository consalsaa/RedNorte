package com.rednorte.ms_portal_paciente.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "paciente_portal")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 15, unique = true)
    private String rut;

    @Column(nullable = false, length = 100)
    private String nombres;

    @Column(nullable = false, length = 100)
    private String apellidos;

    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    @Column(length = 250)
    private String direccion;

    @Column(length = 15)
    private String telefono;

    @Column(length = 100)
    private String correo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Prevision prevision;

    @Column(columnDefinition = "TEXT")
    private String historialClinicoBasico;

    public Paciente() {
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRut() { return rut; }
    public void setRut(String rut) { this.rut = rut; }
    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public Prevision getPrevision() { return prevision; }
    public void setPrevision(Prevision prevision) { this.prevision = prevision; }
    public String getHistorialClinicoBasico() { return historialClinicoBasico; }
    public void setHistorialClinicoBasico(String historialClinicoBasico) { this.historialClinicoBasico = historialClinicoBasico; }
}
