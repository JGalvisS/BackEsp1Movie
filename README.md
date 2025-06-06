# BackEsp1Movie 🎬

Este proyecto es una arquitectura de microservicios desarrollada en Java con Spring Boot y Spring Cloud. Su propósito es servir como backend para un sistema de catálogo de películas, implementado como parte de una evaluación parcial del curso **Backend Developer** de **Digital House**.

## 📝 Contexto

Este proyecto corresponde a una **actividad de evaluación parcial** del curso en Digital House. La consigna oficial del ejercicio puede encontrarse en el siguiente PDF dentro de este mismo repositorio:  
[Nueva Consigna evaluación parcial.pdf](./Nueva%20Consigna%20evaluaci%C3%B3n%20parcial.pdf)

## 🔧 Servicios y Arquitectura

El sistema está compuesto por los siguientes microservicios:

- **Eureka Service**: Servicio de descubrimiento.
- **Config Server**: Servidor de configuración centralizada.
- **Catalog Service**: Maneja el catálogo de películas por género.
- **Movie Service**: Administra la información de películas.
- **Gateway Service**: API Gateway para enrutar peticiones a los servicios correspondientes.

## 📦 Configuración Centralizada

Las configuraciones centralizadas de todos los microservicios se encuentran en el siguiente repositorio:

🔗 [ConfigBackEsp1Movie](https://github.com/JGalvisS/ConfigBackEsp1Movie)

## 🚀 Tecnologías Utilizadas

- Java 17
- Spring Boot
- Spring Cloud (Eureka, Gateway, Config Server)
- Maven
- Docker (opcional para despliegue)
- Postman (para pruebas)
- GitHub (repositorio y control de versiones)

## ▶️ Ejecución del Proyecto

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/JGalvisS/BackEsp1Movie.git
   ```

2. Clonar el repositorio de configuraciones:
   ```bash
   git clone https://github.com/JGalvisS/ConfigBackEsp1Movie.git
   ```

3. Asegurarse de que el servidor de configuración (`config-server`) está apuntando correctamente al repositorio remoto/local.

4. Levantar los servicios en el siguiente orden:
   - Config Server
   - Eureka Service
   - Gateway Service
   - Movie Service
   - Catalog Service

5. Realizar peticiones a través del Gateway (`localhost:8080`), por ejemplo:
   ```bash
   curl http://localhost:8080/catalog/Terror
   ```

## 👩🏻‍💻 Autora

Jessica Katherine Galvis Silva  
Desarrolladora Backend - Estudiante de Certified Tech Developer (Digital House)  
🔗 [GitHub @JGalvisS](https://github.com/JGalvisS)

---

> Proyecto realizado con fines académicos para la formación como Backend Developer.

![image](https://github.com/user-attachments/assets/f50ff45f-fe4c-47f3-815b-9088658a0b7d)
