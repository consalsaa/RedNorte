package com.rednorte.ms_reasignacion.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    /**
     * RestTemplate con @LoadBalanced permite usar nombres de servicio
     * registrados en Eureka (ej: "MS-LISTAS-ESPERA") en lugar de IPs/puertos.
     * Esto habilita el balanceo de carga del lado del cliente.
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
