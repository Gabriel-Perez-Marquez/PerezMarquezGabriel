--Importamos las categorias

INSERT INTO categoria (id, nombre, num_personas) VALUES (1, 'Individual', 1);
INSERT INTO categoria (id, nombre, num_personas) VALUES (2, 'Doble', 2);
INSERT INTO categoria (id, nombre, num_personas) VALUES (3, 'Estándar', 4);
INSERT INTO categoria (id, nombre, num_personas) VALUES (4, 'Familiar', 8);
INSERT INTO categoria (id, nombre, num_personas) VALUES (5, 'Suite', 3);
INSERT INTO categoria (id, nombre, num_personas) VALUES (6, 'Suite Royal', 5);
INSERT INTO categoria (id, nombre, num_personas) VALUES (7, 'Suite Deluxe', 6);



--Importamos las habitaciones
INSERT INTO habitacion (num_habitacion, descripcion, nombre_cliente, categoria_id, precio, num_clientes, fecha_entrada, fecha_salida, limpia, url_image, nombre) VALUES (101, 'Habitación sencilla con vista al jardín', 'Ana Torres', 1, 50.0, 1, '2025-05-01', '2025-05-03', TRUE, 'https://images.mirai.com/INFOROOMS/10733683/YV1DKeEL4DJs7X8RGHO2/YV1DKeEL4DJs7X8RGHO2_original.jpg', 'Habitacion Individual 101');

INSERT INTO habitacion (num_habitacion, descripcion, nombre_cliente, categoria_id, precio, num_clientes, fecha_entrada, fecha_salida, limpia, url_image, nombre) VALUES (102, 'Habitación doble, baño privado', 'Luis Gómez', 2, 85.0, 2, '2025-05-02', '2025-05-05', FALSE, 'https://www.cataloniahotels.com/es/blog/wp-content/uploads/2024/01/tipos-habitaciones-hotel.jpg', 'Habitacion Doble 102');

INSERT INTO habitacion (num_habitacion, descripcion, nombre_cliente, categoria_id, precio, num_clientes, fecha_entrada, fecha_salida, limpia, url_image, nombre) VALUES (103, 'Suite con jacuzzi', 'María Pérez', 5, 250.0, 2, '2025-05-05', '2025-05-10', TRUE, 'https://hotelcaballeroerrante.com/wp-content/uploads/habitacion-con-hidromasaje-03.webp', 'Habitacion Suite 103');

INSERT INTO habitacion (num_habitacion, descripcion, nombre_cliente, categoria_id, precio, num_clientes, fecha_entrada, fecha_salida, limpia, url_image, nombre) VALUES (104, 'Habitación estándar', 'Carlos Díaz', 3, 70.0, 1, '2025-05-03', '2025-05-06', FALSE, 'https://www.hotelesbenidorm.com/wp-content/uploads/2020/10/hotel-presidente-triple-std-2.jpg', 'Habitacion Estándar 104');

INSERT INTO habitacion (num_habitacion, descripcion, nombre_cliente, categoria_id, precio, num_clientes, fecha_entrada, fecha_salida, limpia, url_image, nombre) VALUES (105, 'Habitación familiar', 'Laura Sánchez', 4, 160.0, 4, '2025-05-04', '2025-05-07', TRUE, 'https://www.hotelavenida.com/wp-content/uploads/sites/151/2024/06/HOTEL-AVENIDA-HABITACION-FAMILIAR-CUADRUPLE.jpg', 'Habitacion Familiar 105');

INSERT INTO habitacion (num_habitacion, descripcion, nombre_cliente, categoria_id, precio, num_clientes, fecha_entrada, fecha_salida, limpia, url_image, nombre) VALUES (106, 'Suite Royal con terraza privada, vistas panorámicas y servicio exclusivo', 'Isabel Romero', 6, 380.0, 2, '2025-05-06', '2025-05-09', TRUE, 'https://cdn.aquotic.com/images/noticias/ROYAL-CARIBBEAN-Cruceros_RoyalCaribbean_Suites_1735039000.jpg', 'Habitacion Suite Royal 106');

INSERT INTO habitacion (num_habitacion, descripcion, nombre_cliente, categoria_id, precio, num_clientes, fecha_entrada, fecha_salida, limpia, url_image, nombre) VALUES (107, 'Suite Deluxe con sala de estar, minibar y camas king size', 'Ricardo Mejía', 7, 300.0, 6, '2025-05-07', '2025-05-10', FALSE, 'https://ap-hotelsresorts.com/wp-content/uploads/2021/01/Principal-3-scaled.jpg', 'Habitacion Suite Deluxe 107');
