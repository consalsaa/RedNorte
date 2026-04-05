package com.rednorte.ms_listas_espera.repository;

import com.rednorte.ms_listas_espera.entity.Atencion;
import com.rednorte.ms_listas_espera.entity.EstadoAtencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtencionRepository extends JpaRepository<Atencion, Long> {
    List<Atencion> findByEstadoOrderByPrioridadAscFechaSolicitudAsc(EstadoAtencion estado);
}
