--Importamos las categorias

INSERT INTO categoria (nombre, num_personas, descuento) VALUES ('Individual', 1, 0);
INSERT INTO categoria (nombre, num_personas, descuento) VALUES ('Doble', 2, 5);
INSERT INTO categoria (nombre, num_personas, descuento) VALUES ('Estándar', 4, 0);
INSERT INTO categoria (nombre, num_personas, descuento) VALUES ('Familiar', 8, 10);
INSERT INTO categoria (nombre, num_personas, descuento) VALUES ('Suite', 3, 0);
INSERT INTO categoria (nombre, num_personas, descuento) VALUES ('Suite Royal', 5, 0);
INSERT INTO categoria (nombre, num_personas, descuento) VALUES ('Suite Deluxe', 6, 20);



--Importamos las habitaciones
INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, url_image, nombre, texto_alt) VALUES  (101, 'Habitación sencilla con vista al jardín', 1, 50.0, 'https://images.mirai.com/INFOROOMS/10733683/YV1DKeEL4DJs7X8RGHO2/YV1DKeEL4DJs7X8RGHO2_original.jpg', 'Habitacion Individual 101', 'Habitación con vista al jardín');
INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, url_image, nombre, texto_alt) VALUES  (102, 'Habitación doble, baño privado', 2, 85.0, 'https://www.cataloniahotels.com/es/blog/wp-content/uploads/2024/01/tipos-habitaciones-hotel.jpg', 'Habitacion Doble 102', 'Habitación doble con baño');
INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, url_image, nombre, texto_alt) VALUES  (103, 'Suite con jacuzzi', 5, 250.0, 'https://hotelcaballeroerrante.com/wp-content/uploads/habitacion-con-hidromasaje-03.webp', 'Habitacion Suite 103', 'Suite con jacuzzi');
INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, url_image, nombre, texto_alt) VALUES  (104, 'Habitación estándar', 3, 70.0, 'https://www.hotelesbenidorm.com/wp-content/uploads/2020/10/hotel-presidente-triple-std-2.jpg', 'Habitacion Estándar 104', 'Habitación estándar triple');
INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, url_image, nombre, texto_alt) VALUES  (105, 'Habitación familiar', 4, 160.0, 'https://www.hotelavenida.com/wp-content/uploads/sites/151/2024/06/HOTEL-AVENIDA-HABITACION-FAMILIAR-CUADRUPLE.jpg', 'Habitacion Familiar 105', 'Habitación familiar cuádruple');
INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, url_image, nombre, texto_alt) VALUES  (106, 'Suite Royal con terraza privada, vistas panorámicas y servicio exclusivo', 6, 380.0, 'https://cdn.aquotic.com/images/noticias/ROYAL-CARIBBEAN-Cruceros_RoyalCaribbean_Suites_1735039000.jpg', 'Habitacion Suite Royal 106', 'Suite Royal con terraza');
INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, url_image, nombre, texto_alt) VALUES  (107, 'Suite Deluxe con sala de estar, minibar y camas king size', 7, 300.0, 'https://ap-hotelsresorts.com/wp-content/uploads/2021/01/Principal-3-scaled.jpg', 'Habitacion Suite Deluxe 107', 'Suite Deluxe con sala y minibar');
INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, url_image, nombre, texto_alt) VALUES (108, 'Habitación económica con cama individual', 1, 45.0, 'https://www.hotelmedici.com/images/stories/camere/singola_1200/singola_1_1200.jpg', 'Habitacion Individual 108', 'Habitación económica individual');
INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, url_image, nombre, texto_alt) VALUES (109, 'Habitación doble con balcón', 2, 90.0, 'https://www.hotelairesdelemporda.com/assets/cache/uploads/752x503/dsc0610-copia-1681991940.jpg', 'Habitacion Doble 109', 'Habitación doble con balcón');
INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, url_image, nombre, texto_alt) VALUES (201, 'Habitación estándar con tres camas', 3, 75.0, 'https://cdn2.paraty.es/casual-corporativa/images/1b1945034efc539=s1140', 'Habitacion Estándar 201', 'Habitación estándar tres camas');
INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, url_image, nombre, texto_alt) VALUES (202, 'Habitación familiar con dos dormitorios', 4, 170.0, 'https://www.pateosolares.com/xms/img/1024x/62d03/cT04NiZmbHRyW109dXNt/L08zbS8tME0zWnJTbS95b3NJdVpuN2ptL2F1a1NuTWpuU20vTVJ5WnFWNnl0ZGty.jpg', 'Habitacion Familiar 202', 'Habitación familiar con dos dormitorios');
INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, url_image, nombre, texto_alt) VALUES (203, 'Suite con vistas al mar', 5, 260.0, 'https://images.rosewoodhotels.com/is/image/rwhg/oceanview-king-junior-suite-ovk', 'Habitacion Suite 203', 'Suite con vistas al mar');
INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, url_image, nombre, texto_alt) VALUES (204, 'Habitación estándar interior', 3, 65.0, 'https://media-cdn.tripadvisor.com/media/photo-s/0c/66/4e/71/habitacion-familiar-para.jpg', 'Habitacion Estándar 204', 'Habitación estándar sin vista');
INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, url_image, nombre, texto_alt) VALUES (205, 'Suite Royal con jacuzzi y terraza privada', 6, 390.0, 'https://hotelessoloadultos.com/wp-content/uploads/2023/08/ABaC-Restaurant-Hotel-Barcelona-GL-Monumento-1024x673.jpg', 'Habitacion Suite Royal 205', 'Suite Royal con jacuzzi y terraza');
INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, url_image, nombre, texto_alt) VALUES (206, 'Habitación doble con decoración moderna', 2, 88.0, 'https://hotelsanmillan.es/wp-content/uploads/2016/02/San-Millan-Habitaciones-dobles-hotel-en-santander.jpg', 'Habitacion Doble 206', 'Habitación doble moderna');
INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, url_image, nombre, texto_alt) VALUES (207, 'Suite Deluxe con cocina integrada', 7, 310.0, 'https://cf.bstatic.com/xdata/images/hotel/max1024x768/444553066.jpg?k=250d5eb19a4d7f6027c361312da30a7810bc0e03d2900b45928cdbde2f1ac39a&o=&hp=1', 'Habitacion Suite Deluxe 207', 'Suite Deluxe con cocina');
INSERT INTO habitacion (num_habitacion, descripcion, categoria_id, precio, url_image, nombre, texto_alt) VALUES (208, 'Habitación individual adaptada para personas con movilidad reducida', 1, 55.0, 'https://images.mirai.com/INFOROOMS/100022963/gkaTcvQIbsAgiNhOJR42/gkaTcvQIbsAgiNhOJR42_large.jpg', 'Habitacion Individual 208', 'Habitación adaptada para movilidad reducida');


--Importamos las reservas
INSERT INTO reserva (habitacion_id, nombre_titular, apellidos_titular, telefono, num_clientes, num_adultos, num_niños, fecha_entrada, fecha_salida, precio) VALUES (1, 'Ana', 'López', 600123456, 1, 1, 0, '2025-06-01', '2025-06-03', 100.00);
INSERT INTO reserva (habitacion_id, nombre_titular, apellidos_titular, telefono, num_clientes, num_adultos, num_niños, fecha_entrada, fecha_salida, precio) VALUES (2, 'Carlos', 'Martínez', 600234567, 2, 2, 0, '2025-07-10', '2025-07-15', 403.75);
INSERT INTO reserva (habitacion_id, nombre_titular, apellidos_titular, telefono, num_clientes, num_adultos, num_niños, fecha_entrada, fecha_salida, precio) VALUES (4, 'Laura', 'Sánchez', 600345678, 3, 2, 1, '2025-08-05', '2025-08-07', 140.00);
INSERT INTO reserva (habitacion_id, nombre_titular, apellidos_titular, telefono, num_clientes, num_adultos, num_niños, fecha_entrada, fecha_salida, precio) VALUES (5, 'David', 'Fernández', 600456789, 4, 2, 2, '2025-08-01', '2025-08-06', 720.00);
INSERT INTO reserva (habitacion_id, nombre_titular, apellidos_titular, telefono, num_clientes, num_adultos, num_niños, fecha_entrada, fecha_salida, precio) VALUES (6, 'Sara', 'Gómez', 600567890, 2, 2, 0, '2025-07-20', '2025-07-23', 1140.00);
INSERT INTO reserva (habitacion_id, nombre_titular, apellidos_titular, telefono, num_clientes, num_adultos, num_niños, fecha_entrada, fecha_salida, precio) VALUES (7, 'Javier', 'Ruiz', 600678901, 3, 3, 0, '2025-06-15', '2025-06-18', 720);
INSERT INTO reserva (habitacion_id, nombre_titular, apellidos_titular, telefono, num_clientes, num_adultos, num_niños, fecha_entrada, fecha_salida, precio) VALUES (9, 'Elena', 'Torres', 600789012, 2, 2, 0, '2025-09-01', '2025-09-04', 256.5);
INSERT INTO reserva (habitacion_id, nombre_titular, apellidos_titular, telefono, num_clientes, num_adultos, num_niños, fecha_entrada, fecha_salida, precio) VALUES (12, 'Manuel', 'Castro', 600890123, 2, 2, 0, '2025-07-05', '2025-07-09', 1040.00);
INSERT INTO reserva (habitacion_id, nombre_titular, apellidos_titular, telefono, num_clientes, num_adultos, num_niños, fecha_entrada, fecha_salida, precio) VALUES (17, 'Isabel', 'Navarro', 600901234, 1, 1, 0, '2025-07-02', '2025-07-04', 110.00);

