package com.rednorte.ms_portal_paciente.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Servicio que orquesta y formatea la información proveniente de otros
 * microservicios, entregando datos limpios y optimizados al portal del paciente.
 * Utiliza Circuit Breaker para resiliencia.
 */
@Service
public class CitasServiceImpl implements CitasService {

    private static final Logger log = LoggerFactory.getLogger(CitasServiceImpl.class);

    private static final String LISTAS_ESPERA_URL = "http://MS-LISTAS-ESPERA";

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Consulta las atenciones de un paciente en ms-listas-espera.
     * Circuit Breaker protege contra fallos en la comunicación inter-servicio.
     */
    @Override
    @CircuitBreaker(name = "listasEsperaService", fallbackMethod = "fallbackObtenerCitas")
    public List<Map<String, Object>> obtenerCitasPorRut(String rut) {
        log.info("Consultando citas del paciente con RUT: {}", rut);

        String url = LISTAS_ESPERA_URL + "/api/listas-espera/atenciones/paciente/" + rut;
        ResponseEntity<List<Map<String, Object>>> response = restTemplate.exchange(
                url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Map<String, Object>>>() {});

        return response.getBody();
    }

    /**
     * Fallback: cuando ms-listas-espera no está disponible.
     * Devuelve lista vacía con mensaje informativo.
     */
    public List<Map<String, Object>> fallbackObtenerCitas(String rut, Throwable t) {
        log.error("Circuit Breaker activado al consultar citas para RUT {}: {}", rut, t.getMessage());
        return Collections.singletonList(Map.of(
                "mensaje", "El servicio de citas está temporalmente no disponible. Intente más tarde.",
                "rut", rut
        ));
    }
}
