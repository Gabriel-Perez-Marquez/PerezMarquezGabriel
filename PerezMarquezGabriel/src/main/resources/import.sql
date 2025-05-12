--Importamos las categorias

INSERT INTO categoria (id, nombre, num_personas) VALUES (1, 'Individual', 1);
INSERT INTO categoria (id, nombre, num_personas) VALUES (2, 'Doble', 2);
INSERT INTO categoria (id, nombre, num_personas) VALUES (3, 'Estándar', 4);
INSERT INTO categoria (id, nombre, num_personas) VALUES (4, 'Familiar', 8);
INSERT INTO categoria (id, nombre, num_personas) VALUES (5, 'Suite', 3);
INSERT INTO categoria (id, nombre, num_personas) VALUES (6, 'Suite Royal', 5);
INSERT INTO categoria (id, nombre, num_personas) VALUES (7, 'Suite Deluxe', 6);



--Importamos las habitaciones
INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, limpia, url_image, nombre) VALUES (101, 'Habitación sencilla con vista al jardín', 1, 50.0, TRUE, 'https://images.mirai.com/INFOROOMS/10733683/YV1DKeEL4DJs7X8RGHO2/YV1DKeEL4DJs7X8RGHO2_original.jpg', 'Habitacion Individual 101');

INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, limpia, url_image, nombre) VALUES (102, 'Habitación doble, baño privado', 2, 85.0, FALSE, 'https://www.cataloniahotels.com/es/blog/wp-content/uploads/2024/01/tipos-habitaciones-hotel.jpg', 'Habitacion Doble 102');

INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, limpia, url_image, nombre) VALUES (103, 'Suite con jacuzzi', 5, 250.0, TRUE, 'https://hotelcaballeroerrante.com/wp-content/uploads/habitacion-con-hidromasaje-03.webp', 'Habitacion Suite 103');

INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, limpia, url_image, nombre) VALUES (104, 'Habitación estándar', 3, 70.0, FALSE, 'https://www.hotelesbenidorm.com/wp-content/uploads/2020/10/hotel-presidente-triple-std-2.jpg', 'Habitacion Estándar 104');

INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, limpia, url_image, nombre) VALUES (105, 'Habitación familiar', 4, 160.0, TRUE, 'https://www.hotelavenida.com/wp-content/uploads/sites/151/2024/06/HOTEL-AVENIDA-HABITACION-FAMILIAR-CUADRUPLE.jpg', 'Habitacion Familiar 105');

INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, limpia, url_image, nombre) VALUES (106, 'Suite Royal con terraza privada, vistas panorámicas y servicio exclusivo', 6, 380.0, TRUE, 'https://cdn.aquotic.com/images/noticias/ROYAL-CARIBBEAN-Cruceros_RoyalCaribbean_Suites_1735039000.jpg', 'Habitacion Suite Royal 106');

INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, limpia, url_image, nombre) VALUES (107, 'Suite Deluxe con sala de estar, minibar y camas king size', 7, 300.0, FALSE, 'https://ap-hotelsresorts.com/wp-content/uploads/2021/01/Principal-3-scaled.jpg', 'Habitacion Suite Deluxe 107');
