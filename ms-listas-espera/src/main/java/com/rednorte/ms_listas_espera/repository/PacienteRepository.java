package com.rednorte.ms_listas_espera.repository;

import com.rednorte.ms_listas_espera.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    
    // Método de búsqueda personalizado usando Repository Pattern
    Optional<Paciente> findByRut(String rut);
}
