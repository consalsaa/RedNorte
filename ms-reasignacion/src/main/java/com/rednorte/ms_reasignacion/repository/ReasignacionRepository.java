package com.rednorte.ms_reasignacion.repository;

import com.rednorte.ms_reasignacion.entity.Reasignacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository Pattern: Abstrae el acceso a datos de reasignaciones
 * mediante Spring Data JPA, permitiendo cambiar el motor de BD
 * sin afectar la lógica de negocio.
 */
@Repository
public interface ReasignacionRepository extends JpaRepository<Reasignacion, Long> {
    List<Reasignacion> findByRutPacienteReasignado(String rut);
    List<Reasignacion> findByEstado(String estado);
}
