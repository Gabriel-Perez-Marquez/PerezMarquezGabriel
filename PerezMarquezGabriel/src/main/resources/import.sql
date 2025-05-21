--Importamos las categorias

INSERT INTO categoria (nombre, num_personas, descuento) VALUES ('Individual', 1, 0);
INSERT INTO categoria (nombre, num_personas, descuento) VALUES ('Doble', 2, 0);
INSERT INTO categoria (nombre, num_personas, descuento) VALUES ('Estándar', 4, 0);
INSERT INTO categoria (nombre, num_personas, descuento) VALUES ('Familiar', 8, 0);
INSERT INTO categoria (nombre, num_personas, descuento) VALUES ('Suite', 3, 0);
INSERT INTO categoria (nombre, num_personas, descuento) VALUES ('Suite Royal', 5, 0);
INSERT INTO categoria (nombre, num_personas, descuento) VALUES ('Suite Deluxe', 6, 0);



--Importamos las habitaciones
INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, url_image, nombre, texto_alt) VALUES  (101, 'Habitación sencilla con vista al jardín', 1, 50.0, 'https://images.mirai.com/INFOROOMS/10733683/YV1DKeEL4DJs7X8RGHO2/YV1DKeEL4DJs7X8RGHO2_original.jpg', 'Habitacion Individual 101', 'Habitación con vista al jardín');
INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, url_image, nombre, texto_alt) VALUES  (102, 'Habitación doble, baño privado', 2, 85.0, 'https://www.cataloniahotels.com/es/blog/wp-content/uploads/2024/01/tipos-habitaciones-hotel.jpg', 'Habitacion Doble 102', 'Habitación doble con baño');
INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, url_image, nombre, texto_alt) VALUES  (103, 'Suite con jacuzzi', 5, 250.0, 'https://hotelcaballeroerrante.com/wp-content/uploads/habitacion-con-hidromasaje-03.webp', 'Habitacion Suite 103', 'Suite con jacuzzi');
INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, url_image, nombre, texto_alt) VALUES  (104, 'Habitación estándar', 3, 70.0, 'https://www.hotelesbenidorm.com/wp-content/uploads/2020/10/hotel-presidente-triple-std-2.jpg', 'Habitacion Estándar 104', 'Habitación estándar triple');
INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, url_image, nombre, texto_alt) VALUES  (105, 'Habitación familiar', 4, 160.0, 'https://www.hotelavenida.com/wp-content/uploads/sites/151/2024/06/HOTEL-AVENIDA-HABITACION-FAMILIAR-CUADRUPLE.jpg', 'Habitacion Familiar 105', 'Habitación familiar cuádruple');
INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, url_image, nombre, texto_alt) VALUES  (106, 'Suite Royal con terraza privada, vistas panorámicas y servicio exclusivo', 6, 380.0, 'https://cdn.aquotic.com/images/noticias/ROYAL-CARIBBEAN-Cruceros_RoyalCaribbean_Suites_1735039000.jpg', 'Habitacion Suite Royal 106', 'Suite Royal con terraza');
INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, url_image, nombre, texto_alt) VALUES  (107, 'Suite Deluxe con sala de estar, minibar y camas king size', 7, 300.0, 'https://ap-hotelsresorts.com/wp-content/uploads/2021/01/Principal-3-scaled.jpg', 'Habitacion Suite Deluxe 107', 'Suite Deluxe con sala y minibar');

