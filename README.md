# 📦 Inventory Management System – Prueba Técnica

Sistema de Gestión de Inventario y Ventas desarrollado con **Spring Boot + MySQL + React + Docker**.  
Incluye autenticación JWT, control de concurrencia con Optimistic Locking, transacciones y consumo desde frontend.

---

## 🚀 Tecnologías Utilizadas

### Backend
- Java 21  
- Spring Boot 3  
- Spring Data JPA  
- Spring Security + JWT  
- MySQL  
- Maven  

### Frontend
- React  
- TypeScript  
- TailwindCSS v4  
- Axios  

### Infraestructura
- Docker  
- Docker Compose  

---

## 📐 Arquitectura

```
inventory/
 ├── backend/   -> API REST Spring Boot
 ├── frontend/  -> React + Tailwind
 └── docker-compose.yml
```

Arquitectura basada en capas:

```
Controller → Service → Repository → Database
           → DTOs
```

Las entidades **no se exponen directamente** al cliente.

---

## 🗄 Modelo de Datos

- categorias  
- productos  
- ventas  
- detalle_ventas  

Incluye:

- Relación Producto → Categoría  
- Relación Venta → DetalleVenta  
- Campo `@Version` en Producto para control de concurrencia (Optimistic Locking)

---

## 🔐 Seguridad

- Login mediante `/auth/login`  
- Autenticación con JWT  
- Endpoints protegidos requieren:

```
Authorization: Bearer <TOKEN>
```

---

## ⚙️ Configuración del Proyecto

### Clonar repositorio

```
git clone <repo_url>
cd inventory
```

---

### Ejecutar con Docker

```
docker compose up -d
```

Servicios:

- Backend → http://localhost:8080  
- Frontend → http://localhost:5173  
- MySQL → 3306  

---

### Ejecutar manual

Backend:

```
cd backend
mvn clean package
mvn spring-boot:run
```

Frontend:

```
cd frontend
npm install
npm run dev
```

---

## 📑 Swagger

```
http://localhost:8080/swagger-ui.html
```

---

## 🧪 Credenciales

```
Usuario: admin
Password: admin123
```

---

## 📌 Funcionalidades

### Categorías
- Crear  
- Listar  
- Editar  
- Eliminar  

### Productos
- CRUD completo  
- Paginación  
- Filtros  

### Ventas
- Crear venta  
- Validar stock  
- Actualizar inventario  

---

## 🛒 Flujo de Venta

1. Seleccionar productos  
2. Agregar al carrito  
3. Comprar  
4. Backend valida stock y guarda venta  

Si no hay stock → rollback.

---

## 🔁 Concurrencia

Optimistic Locking:

```
@Version
private Long version;
```

---

## 🧪 Pruebas

```
mvn test
```

---

## 📌 Decisiones Técnicas

- DTOs  
- JWT  
- Transacciones  
- Docker  

---

## 👨‍💻 Autor

Roberto Antonio Alferes Gómez
