--Importamos las categorias

INSERT INTO categoria (nombre, num_personas) VALUES ('Individual', 1);
INSERT INTO categoria (nombre, num_personas) VALUES ('Doble', 2);
INSERT INTO categoria (nombre, num_personas) VALUES ('Estándar', 4);
INSERT INTO categoria (nombre, num_personas) VALUES ('Familiar', 8);
INSERT INTO categoria (nombre, num_personas) VALUES ('Suite', 3);
INSERT INTO categoria (nombre, num_personas) VALUES ('Suite Royal', 5);
INSERT INTO categoria (nombre, num_personas) VALUES ('Suite Deluxe', 6);



--Importamos las habitaciones
INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, limpia, url_image, nombre, texto_alt) VALUES (101, 'Habitación sencilla con vista al jardín', 1, 50.0, TRUE, 'https://images.mirai.com/INFOROOMS/10733683/YV1DKeEL4DJs7X8RGHO2/YV1DKeEL4DJs7X8RGHO2_original.jpg', 'Habitacion Individual 101', 'Habitación con vista al jardín');
INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, limpia, url_image, nombre, texto_alt) VALUES  (102, 'Habitación doble, baño privado', 2, 85.0, FALSE, 'https://www.cataloniahotels.com/es/blog/wp-content/uploads/2024/01/tipos-habitaciones-hotel.jpg', 'Habitacion Doble 102', 'Habitación doble con baño');
INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, limpia, url_image, nombre, texto_alt) VALUES  (103, 'Suite con jacuzzi', 5, 250.0, TRUE, 'https://hotelcaballeroerrante.com/wp-content/uploads/habitacion-con-hidromasaje-03.webp', 'Habitacion Suite 103', 'Suite con jacuzzi');
INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, limpia, url_image, nombre, texto_alt) VALUES  (104, 'Habitación estándar', 3, 70.0, FALSE, 'https://www.hotelesbenidorm.com/wp-content/uploads/2020/10/hotel-presidente-triple-std-2.jpg', 'Habitacion Estándar 104', 'Habitación estándar triple');
INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, limpia, url_image, nombre, texto_alt) VALUES  (105, 'Habitación familiar', 4, 160.0, TRUE, 'https://www.hotelavenida.com/wp-content/uploads/sites/151/2024/06/HOTEL-AVENIDA-HABITACION-FAMILIAR-CUADRUPLE.jpg', 'Habitacion Familiar 105', 'Habitación familiar cuádruple');
INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, limpia, url_image, nombre, texto_alt) VALUES  (106, 'Suite Royal con terraza privada, vistas panorámicas y servicio exclusivo', 6, 380.0, TRUE, 'https://cdn.aquotic.com/images/noticias/ROYAL-CARIBBEAN-Cruceros_RoyalCaribbean_Suites_1735039000.jpg', 'Habitacion Suite Royal 106', 'Suite Royal con terraza');
INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, limpia, url_image, nombre, texto_alt) VALUES  (107, 'Suite Deluxe con sala de estar, minibar y camas king size', 7, 300.0, FALSE, 'https://ap-hotelsresorts.com/wp-content/uploads/2021/01/Principal-3-scaled.jpg', 'Habitacion Suite Deluxe 107', 'Suite Deluxe con sala y minibar');



--Importamos las promociones
INSERT INTO promocion (titulo, texto, porcentaje_descuento) VALUES ('Reserva Anticipada', '10% de descuento reservando con al menos 30 días de antelación.', 10.0);
INSERT INTO promocion (titulo, texto, porcentaje_descuento) VALUES ('3 Noches al Precio de 2', 'Quédate 3 noches y paga solo 2. Válido de lunes a jueves.', 33.33);
INSERT INTO promocion (titulo, texto, porcentaje_descuento) VALUES ('Descuento por Larga Estancia', '15% de descuento en estancias de 7 noches o más.', 15.0);