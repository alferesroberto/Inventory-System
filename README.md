📦 Inventory Management System – Technical Test

Sistema de Gestión de Inventario y Ventas desarrollado como prueba técnica para Backend Developer.

El proyecto implementa una API REST con Spring Boot, MySQL y autenticación JWT, además de un frontend en React + TypeScript y un entorno Dockerizado para facilitar su ejecución.

🧱 Arquitectura
inventory-system/
│
├── backend/        # API Spring Boot
├── frontend/       # React + TypeScript
├── docker-compose.yml
└── README.md

🛠️ Tecnologías
Backend

Java 21

Spring Boot 3

Spring Data JPA

Spring Security + JWT

MySQL

Maven

Frontend

React

TypeScript

Vite

Infraestructura

Docker

Docker Compose

⚙️ Requisitos

Docker

Docker Compose

(No es necesario tener Java, Node ni MySQL instalados localmente)

🚀 Cómo ejecutar el proyecto

Desde la raíz del proyecto:

docker compose up --build


O en segundo plano:

docker compose up -d

🌐 Servicios disponibles

Backend API:
http://localhost:8080

Frontend:
http://localhost:5173

MySQL:
localhost:3306

Credenciales MySQL:

Database: inventorydb
User: inventory
Password: inventory123

🧪 Ejecutar pruebas

Entrar al contenedor backend:

docker exec -it inventory_backend bash


Luego:

mvn test

📌 Funcionalidades

CRUD de productos

Paginación y filtros

Registro de ventas

Control de stock

Transacciones atómicas

Autenticación con JWT

Manejo de concurrencia con Optimistic Locking

Pruebas unitarias e integración

🔐 Estrategia de Concurrencia

Se utiliza Optimistic Locking mediante el campo version en la entidad Producto.

Cada vez que se actualiza el stock, Hibernate valida que la versión no haya cambiado.
Si dos transacciones intentan modificar el mismo registro al mismo tiempo, una de ellas falla automáticamente, evitando stock negativo.

Además, el proceso de venta se ejecuta dentro de una transacción:

@Transactional


Esto garantiza rollback completo si ocurre cualquier error.

📖 Documentación API

Swagger disponible en:

http://localhost:8080/swagger-ui.html

🧾 Autor

Roberto Antonio Alferes Gómez