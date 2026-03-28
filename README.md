# Plataforma RedNorte

Arquitectura de microservicios para la gestión de listas de espera hospitalarias.

## Estructura del proyecto

- `eureka-server/` - Servidor de descubrimiento de servicios basado en Spring Cloud Netflix Eureka.
- `api-gateway/` - Pasarela de API para enrutar peticiones hacia los microservicios internos.
- `ms-listas-espera/` - Microservicio principal de gestión de listas de espera con Spring Data JPA.
- `ms-reasignacion/` - Microservicio independiente para la reasignación de pacientes o turnos con Spring Data JPA.
- `ms-portal-paciente/` - Backend For Frontend (BFF) para el portal de pacientes.

## Uso inicial

Cada módulo es un proyecto Maven independiente generado con Spring Initializr.

1. Iniciar `eureka-server`.
2. Iniciar `api-gateway`.
3. Iniciar los microservicios necesarios (`ms-listas-espera`, `ms-reasignacion`, `ms-portal-paciente`).

## Objetivo

Proveer una base escalable para el desarrollo de la plataforma, con servicios desacoplados y un gateway centralizado.
