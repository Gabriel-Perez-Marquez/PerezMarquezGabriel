DROP TABLE IF EXISTS habitaciones;

CREATE TABLE habitaciones (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    num_habitacion INT NOT NULL,
    descripcion VARCHAR(255),
    nombre_cliente VARCHAR(100),
    precio DOUBLE,
    num_clientes INT,
    fecha_entrada DATE,
    fecha_salida DATE,
    limpia BOOLEAN,
    url_image VARCHAR(255)
);

INSERT INTO habitaciones (num_habitacion, descripcion, nombre_cliente, precio, num_clientes, fecha_entrada, fecha_salida, limpia, url_image)
VALUES (101, 'Habitación sencilla con vista al jardín', 'Ana Torres', 50.0, 1, '2025-05-01', '2025-05-03', TRUE, 'url1.jpg');

INSERT INTO habitaciones (num_habitacion, descripcion, nombre_cliente, precio, num_clientes, fecha_entrada, fecha_salida, limpia, url_image)
VALUES (102, 'Habitación doble, baño privado', 'Luis Gómez', 80.0, 2, '2025-05-02', '2025-05-05', FALSE, 'url2.jpg');

INSERT INTO habitaciones (num_habitacion, descripcion, nombre_cliente, precio, num_clientes, fecha_entrada, fecha_salida, limpia, url_image)
VALUES (103, 'Suite con jacuzzi', 'María Pérez', 150.0, 2, '2025-05-05', '2025-05-10', TRUE, 'url3.jpg');

INSERT INTO habitaciones (num_habitacion, descripcion, nombre_cliente, precio, num_clientes, fecha_entrada, fecha_salida, limpia, url_image)
VALUES (104, 'Habitación estándar', 'Carlos Díaz', 60.0, 1, '2025-05-03', '2025-05-06', FALSE, 'url4.jpg');

INSERT INTO habitaciones (num_habitacion, descripcion, nombre_cliente, precio, num_clientes, fecha_entrada, fecha_salida, limpia, url_image)
VALUES (105, 'Habitación familiar', 'Laura Sánchez', 120.0, 4, '2025-05-04', '2025-05-07', TRUE, 'url5.jpg');

INSERT INTO habitaciones (num_habitacion, descripcion, nombre_cliente, precio, num_clientes, fecha_entrada, fecha_salida, limpia, url_image)
VALUES (106, 'Doble con terraza', 'Pedro Ramírez', 90.0, 2, '2025-05-06', '2025-05-09', TRUE, 'url6.jpg');

INSERT INTO habitaciones (num_habitacion, descripcion, nombre_cliente, precio, num_clientes, fecha_entrada, fecha_salida, limpia, url_image)
VALUES (107, 'Suite presidencial', 'Claudia López', 200.0, 2, '2025-05-07', '2025-05-11', FALSE, 'url7.jpg');

INSERT INTO habitaciones (num_habitacion, descripcion, nombre_cliente, precio, num_clientes, fecha_entrada, fecha_salida, limpia, url_image)
VALUES (108, 'Habitación básica', 'Esteban Martínez', 45.0, 1, '2025-05-02', '2025-05-04', TRUE, 'url8.jpg');

INSERT INTO habitaciones (num_habitacion, descripcion, nombre_cliente, precio, num_clientes, fecha_entrada, fecha_salida, limpia, url_image)
VALUES (109, 'Vista al mar', 'Sara Núñez', 130.0, 2, '2025-05-03', '2025-05-06', FALSE, 'url9.jpg');

INSERT INTO habitaciones (num_habitacion, descripcion, nombre_cliente, precio, num_clientes, fecha_entrada, fecha_salida, limpia, url_image)
VALUES (110, 'Habitación con escritorio', 'Miguel Herrera', 70.0, 1, '2025-05-01', '2025-05-02', TRUE, 'url10.jpg');

INSERT INTO habitaciones (num_habitacion, descripcion, nombre_cliente, precio, num_clientes, fecha_entrada, fecha_salida, limpia, url_image)
VALUES (201, 'Doble con balcón', 'Lucía Ortega', 95.0, 2, '2025-05-08', '2025-05-11', TRUE, 'url11.jpg');

INSERT INTO habitaciones (num_habitacion, descripcion, nombre_cliente, precio, num_clientes, fecha_entrada, fecha_salida, limpia, url_image)
VALUES (202, 'Habitación matrimonial', 'Javier Moreno', 85.0, 2, '2025-05-09', '2025-05-12', FALSE, 'url12.jpg');

INSERT INTO habitaciones (num_habitacion, descripcion, nombre_cliente, precio, num_clientes, fecha_entrada, fecha_salida, limpia, url_image)
VALUES (203, 'Habitación de lujo', 'Beatriz Torres', 180.0, 2, '2025-05-10', '2025-05-14', TRUE, 'url13.jpg');

INSERT INTO habitaciones (num_habitacion, descripcion, nombre_cliente, precio, num_clientes, fecha_entrada, fecha_salida, limpia, url_image)
VALUES (204, 'Habitación con cocina', 'Iván Cruz', 100.0, 3, '2025-05-12', '2025-05-15', FALSE, 'url14.jpg');

INSERT INTO habitaciones (num_habitacion, descripcion, nombre_cliente, precio, num_clientes, fecha_entrada, fecha_salida, limpia, url_image)
VALUES (205, 'Doble con TV', 'Rosa Aguirre', 75.0, 2, '2025-05-03', '2025-05-05', TRUE, 'url15.jpg');

INSERT INTO habitaciones (num_habitacion, descripcion, nombre_cliente, precio, num_clientes, fecha_entrada, fecha_salida, limpia, url_image)
VALUES (206, 'Suite moderna', 'Tomás Ríos', 160.0, 2, '2025-05-04', '2025-05-07', TRUE, 'url16.jpg');

INSERT INTO habitaciones (num_habitacion, descripcion, nombre_cliente, precio, num_clientes, fecha_entrada, fecha_salida, limpia, url_image)
VALUES (207, 'Triple con baño privado', 'Natalia Blanco', 110.0, 3, '2025-05-06', '2025-05-08', FALSE, 'url17.jpg');

INSERT INTO habitaciones (num_habitacion, descripcion, nombre_cliente, precio, num_clientes, fecha_entrada, fecha_salida, limpia, url_image)
VALUES (208, 'Habitación con escritorio y wifi', 'Adrián Vidal', 65.0, 1, '2025-05-02', '2025-05-03', TRUE, 'url18.jpg');

INSERT INTO habitaciones (num_habitacion, descripcion, nombre_cliente, precio, num_clientes, fecha_entrada, fecha_salida, limpia, url_image)
VALUES (209, 'Habitación económica', 'Eva Silva', 40.0, 1, '2025-05-01', '2025-05-02', FALSE, 'url19.jpg');

INSERT INTO habitaciones (num_habitacion, descripcion, nombre_cliente, precio, num_clientes, fecha_entrada, fecha_salida, limpia, url_image)
VALUES (210, 'Vista panorámica', 'Jorge Navarro', 140.0, 2, '2025-05-05', '2025-05-09', TRUE, 'url20.jpg');
