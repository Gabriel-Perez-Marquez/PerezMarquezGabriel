# 🏨 Sistema de Gestión de Reservas de Habitaciones

Una aplicación web desarrollada en **Java + Spring Boot** para la administración 
eficiente de habitaciones, categorías y reservas hoteleras. Incluye estadísticas de 
recaudación, validaciones en tiempo real y lógica personalizada para asignar números 
de habitación por planta.

---

## 🌟 Características principales

✨ Gestión completa:
- 📈 Cuando una habitación tiene 5 o más reservas se vuelve popular y
  aparece en la página de inicio
- 📋 CRUD de **habitaciones**, **categorías** y **reservas**
- 🧾 Estadísticas: recaudación total, por habitación y por categoría
- 🛌 Cálculo automático del precio con descuentos por categoría
- 🧠 Asignación inteligente de número de habitación por planta
- 📊 Filtrado de habitaciones por rango de precio
- ✅ Validaciones en frontend y backend

---

## 🛠️ Tecnologías utilizadas

| Tecnología     | Descripción                        |
|----------------|------------------------------------|
| Spring Boot    | Framework backend principal        |
| Thymeleaf      | Motor de plantillas HTML           |
| Bootstrap 5    | Estilos responsive                 |
| JavaScript     | Validaciones del lado del cliente  |
| JPA / Hibernate| Persistencia con base de datos     |
| H2             | Bases de datos soportadas          |

---

## 📁 Estructura del proyecto
├── 📂 java
│ ├── 📂 com.salesianostriana.dam.perezmarquezgabriel
│ ├── 📂 com.salesianostriana.dam.perezmarquezgabriel.controller # Lógica de controladores
│ ├── 📂 com.salesianostriana.dam.perezmarquezgabriel.model # Entidades JPA (Habitacion, Categoria, Reserva)
│ ├── 📂 com.salesianostriana.dam.perezmarquezgabriel.repository # Interfaces JpaRepository
│ ├── 📂 com.salesianostriana.dam.perezmarquezgabriel.service # Lógica de negocio
│ │ ├── 📁 com.salesianostriana.dam.perezmarquezgabriel.service.servicioBase 
├── 📂 resources
│ ├── 📁 templates # Vistas Thymeleaf
│ ├── 📁 static 
│ │ ├── 📁 Img
│ │ ├── 📁 js
│ │ ├── 📁 css
│ └── 📄 application.properties

---

## 📈 Módulo de Estadísticas

✔️ Cálculo de:
- 💰 Recaudación **total**
- 🏷️ Recaudación **por habitación**
- 🗂️ Recaudación **por categoría**
- ⏳ Reserva **más larga**

---

## 🧪 Validaciones implementadas

### Frontend (JavaScript)
- ⛔ Fechas inválidas (salida ≤ entrada)
- 👨‍👩‍👧 Coincidencia de adultos + niños = clientes
- 👶 Niños no pueden reservar sin adultos
- 💸 Validación en tiempo real de rangos de precio

### Backend (Spring)
- ❗ Prevención de números de habitación duplicados
- 🏷️ Generación automática del nombre de la habitación
- 📌 Validación de inputs requeridos

---
