create schema if not exists pruebarest;

use pruebarest;

drop schema pruebarest;

INSERT INTO `cliente` (`apellido`,`baja`,`dni`,`fecha_nacimiento`,`nombre`) VALUES ('ramirez',false,12345388,NULL,'sebastian');
INSERT INTO `cliente` (`apellido`,`baja`,`dni`,`fecha_nacimiento`,`nombre`)VALUES ('garcia',false,12345458,NULL,'maia');
INSERT INTO `cliente` (`apellido`,`baja`,`dni`,`fecha_nacimiento`,`nombre`) VALUES ('perez',false,12215458,NULL,'lucas');
INSERT INTO `cliente` (`apellido`,`baja`,`dni`,`fecha_nacimiento`,`nombre`) VALUES ('lopez',false,12215789,'1998-12-05','daniela');
INSERT INTO `cliente` (`apellido`,`baja`,`dni`,`fecha_nacimiento`,`nombre`)VALUES ('gomez',false,12975789,'1978-12-05','ludmila');
INSERT INTO `cliente` (`apellido`,`baja`,`dni`,`fecha_nacimiento`,`nombre`) VALUES ('hernandez',false,13672789,'1978-02-05','manuel');

INSERT INTO `prestamo` (`cant_cuotas`,`fecha`,`interes`,`monto`,`fk_cliente`) VALUES (9,'2020-07-04',35,35000,1);
INSERT INTO `prestamo` (`cant_cuotas`,`fecha`,`interes`,`monto`,`fk_cliente`) VALUES (9,'2020-07-04',35,35000,2);
INSERT INTO `prestamo` (`cant_cuotas`,`fecha`,`interes`,`monto`,`fk_cliente`) VALUES (10,'2020-07-04',50,100000,1);
INSERT INTO `prestamo` (`cant_cuotas`,`fecha`,`interes`,`monto`,`fk_cliente`) VALUES (10,'2020-02-14',25,20000,3);

INSERT INTO `prestamo` (`cant_cuotas`,`fecha`,`interes`,`monto`,`fk_cliente`) VALUES (8,'2020-07-04',12.5,45000,4);
INSERT INTO `prestamo` (`cant_cuotas`,`fecha`,`interes`,`monto`,`fk_cliente`) VALUES (8,'2020-07-04',15,40000,5);
INSERT INTO `prestamo` (`cant_cuotas`,`fecha`,`interes`,`monto`,`fk_cliente`) VALUES (9,'2020-07-04',35,35000,6);

INSERT INTO `cuota` (`cancelada`,`deuda`,`fecha_de_pago`,`fecha_vencimiento`,`interes_cuota`,`monto`,`nro_cuota`,`fk_prestamo`) VALUES (false,150000,'2020-10-28','2020-08-04',7500,15000,1,3);
INSERT INTO `cuota` (`cancelada`,`deuda`,`fecha_de_pago`,`fecha_vencimiento`,`interes_cuota`,`monto`,`nro_cuota`,`fk_prestamo`) VALUES (false,135000,NULL,'2020-09-04',7500,15000,2,3);
INSERT INTO `cuota` (`cancelada`,`deuda`,`fecha_de_pago`,`fecha_vencimiento`,`interes_cuota`,`monto`,`nro_cuota`,`fk_prestamo`) VALUES (false,120000,NULL,'2020-10-04',7500,15000,3,3);
INSERT INTO `cuota` (`cancelada`,`deuda`,`fecha_de_pago`,`fecha_vencimiento`,`interes_cuota`,`monto`,`nro_cuota`,`fk_prestamo`) VALUES (false,105000,'2020-10-28','2020-11-04',7500,15000,4,3);
INSERT INTO `cuota` (`cancelada`,`deuda`,`fecha_de_pago`,`fecha_vencimiento`,`interes_cuota`,`monto`,`nro_cuota`,`fk_prestamo`) VALUES (false,90000,NULL,'2020-12-04',7500,15000,5,3);
INSERT INTO `cuota` (`cancelada`,`deuda`,`fecha_de_pago`,`fecha_vencimiento`,`interes_cuota`,`monto`,`nro_cuota`,`fk_prestamo`) VALUES (false,75000,NULL,'2021-01-04',7500,15000,6,3);
INSERT INTO `cuota` (`cancelada`,`deuda`,`fecha_de_pago`,`fecha_vencimiento`,`interes_cuota`,`monto`,`nro_cuota`,`fk_prestamo`) VALUES (false,60000,NULL,'2021-02-04',7500,15000,7,3);
INSERT INTO `cuota` (`cancelada`,`deuda`,`fecha_de_pago`,`fecha_vencimiento`,`interes_cuota`,`monto`,`nro_cuota`,`fk_prestamo`) VALUES (false,45000,NULL,'2021-03-04',7500,15000,8,3);
INSERT INTO `cuota` (`cancelada`,`deuda`,`fecha_de_pago`,`fecha_vencimiento`,`interes_cuota`,`monto`,`nro_cuota`,`fk_prestamo`) VALUES (false,30000,NULL,'2021-04-04',7500,15000,9,3);
INSERT INTO `cuota` (`cancelada`,`deuda`,`fecha_de_pago`,`fecha_vencimiento`,`interes_cuota`,`monto`,`nro_cuota`,`fk_prestamo`) VALUES (false,15000,NULL,'2021-05-04',7500,15000,10,3);
INSERT INTO `cuota` (`cancelada`,`deuda`,`fecha_de_pago`,`fecha_vencimiento`,`interes_cuota`,`monto`,`nro_cuota`,`fk_prestamo`) VALUES (false,25000,'2020-10-28','2020-03-14',625,2500,1,4);
INSERT INTO `cuota` (`cancelada`,`deuda`,`fecha_de_pago`,`fecha_vencimiento`,`interes_cuota`,`monto`,`nro_cuota`,`fk_prestamo`) VALUES (false,22500,NULL,'2020-04-14',625,2500,2,4);
INSERT INTO `cuota` (`cancelada`,`deuda`,`fecha_de_pago`,`fecha_vencimiento`,`interes_cuota`,`monto`,`nro_cuota`,`fk_prestamo`) VALUES (false,20000,NULL,'2020-05-14',625,2500,3,4);
INSERT INTO `cuota` (`cancelada`,`deuda`,`fecha_de_pago`,`fecha_vencimiento`,`interes_cuota`,`monto`,`nro_cuota`,`fk_prestamo`) VALUES (false,17500,NULL,'2020-06-14',625,2500,4,4);
INSERT INTO `cuota` (`cancelada`,`deuda`,`fecha_de_pago`,`fecha_vencimiento`,`interes_cuota`,`monto`,`nro_cuota`,`fk_prestamo`) VALUES (false,15000,NULL,'2020-07-14',625,2500,5,4);
INSERT INTO `cuota` (`cancelada`,`deuda`,`fecha_de_pago`,`fecha_vencimiento`,`interes_cuota`,`monto`,`nro_cuota`,`fk_prestamo`) VALUES (false,12500,NULL,'2020-08-14',625,2500,6,4);
INSERT INTO `cuota` (`cancelada`,`deuda`,`fecha_de_pago`,`fecha_vencimiento`,`interes_cuota`,`monto`,`nro_cuota`,`fk_prestamo`) VALUES (false,10000,NULL,'2020-09-14',625,2500,7,4);
INSERT INTO `cuota` (`cancelada`,`deuda`,`fecha_de_pago`,`fecha_vencimiento`,`interes_cuota`,`monto`,`nro_cuota`,`fk_prestamo`) VALUES (false,7500,NULL,'2020-10-14',625,2500,8,4);
INSERT INTO `cuota` (`cancelada`,`deuda`,`fecha_de_pago`,`fecha_vencimiento`,`interes_cuota`,`monto`,`nro_cuota`,`fk_prestamo`) VALUES (false,5000,NULL,'2020-11-14',625,2500,9,4);
INSERT INTO `cuota` (`cancelada`,`deuda`,`fecha_de_pago`,`fecha_vencimiento`,`interes_cuota`,`monto`,`nro_cuota`,`fk_prestamo`) VALUES (false,2500,NULL,'2020-12-14',625,2500,10,4);

