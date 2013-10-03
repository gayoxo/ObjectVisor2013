USE `chasquioda`;

UPDATE mensajes SET `valor`='DEPARTAMENTO DE HISTORIA DE AMÉRICA II\\r\\n(ANTROPOLOGÍA DE AMÉRICA) Facultad de Geografía e Historia' WHERE `id`='122';
UPDATE mensajes SET `valor`='museo virtual, contenedor de objetos virtuales de aprendizaje, repositorio de objetos de aprendizaje,chasqui' WHERE `id`='123';
UPDATE mensajes SET `valor`='../../download/bancorecursos/Cabecera7.jpg' WHERE `id`='124';
UPDATE mensajes SET `valor`='Datos del contenedor' WHERE `id`='128';


INSERT INTO navegacion VALUES (2,'Acceso clasificado a la Base de Datos',NULL,8,'S',5,'C',NULL,'I','acceso_clasificado_a_la_base_de_datos',NULL,NULL,NULL,'S',NULL,'N');
INSERT INTO navegacion VALUES (3,'Presentación',NULL,6,'S',2,'P',4,'I','presentación',NULL,'<p>&nbsp;dasdsad</p>',NULL,'S',NULL,'N');
INSERT INTO navegacion VALUES (5,'Laboratorio','Laboratorio',9,'S',7,'P',5,'I','laboratorio',NULL,NULL,NULL,'S',NULL,'N');
INSERT INTO navegacion VALUES (6,'Información del Proyecto',NULL,0,'S',2,'H',4,'I','información_del_proyecto',NULL,NULL,NULL,'S',NULL,'N');
INSERT INTO navegacion VALUES (7,'Busqueda',NULL,8,'S',8,'B',NULL,'I','busqueda',NULL,NULL,NULL,'S',NULL,'N');
INSERT INTO navegacion VALUES (8,'Acceso clasificado',NULL,0,'S',6,'H',NULL,'I','acceso_clasificado',NULL,NULL,NULL,'S',NULL,'N');
INSERT INTO navegacion VALUES (9,'Recursos','Recursos',6,'S',4,'H',NULL,'I','recursos',NULL,NULL,NULL,'S',NULL,'N');
INSERT INTO navegacion VALUES (10,'Miembros','Miembros',6,'S',3,'P',7,'I','miembros',NULL,NULL,NULL,'S',NULL,'N');
INSERT INTO navegacion VALUES (11,'Museo','Museo',9,'S',1009,'P',8,'I','museo',NULL,NULL,NULL,'S',NULL,'N');
INSERT INTO navegacion VALUES (12,'Financiación','Financiación',6,'S',1010,'P',10,'I','financiación',NULL,NULL,NULL,'S',NULL,'N');
INSERT INTO navegacion VALUES (13,'Pr. Chinchero','Pr. Chinchero',9,'S',1011,'P',11,'I','pr._chinchero',NULL,NULL,NULL,'S',NULL,'N');
INSERT INTO navegacion VALUES (14,'Pr. Esmeraldas','Pr. Esmeraldas',9,'S',1012,'P',12,'I','pr._esmeraldas',NULL,NULL,NULL,'S',NULL,'N');
INSERT INTO navegacion VALUES (15,'Pr. Incapirca','Pr. Incapirca',9,'S',1013,'P',13,'I','pr._incapirca',NULL,NULL,NULL,'S',NULL,'N');
INSERT INTO navegacion VALUES (16,'Pr. Manabí Central','Pr. Manabí Central',9,'S',1014,'P',14,'I','pr._manabí_central',NULL,NULL,NULL,'S',NULL,'N');
INSERT INTO navegacion VALUES (17,'Pr. Coclé','Pr. Coclé',9,'S',1015,'P',15,'I','pr._coclé',NULL,NULL,NULL,'S',NULL,'N');


DELETE FROM `chasquioda`.`paginas` WHERE `id`='1';
INSERT INTO paginas VALUES (1,'Chasqui',NULL,'S','../../download/bancorecursos/chasqui/portada.html');
INSERT INTO paginas VALUES (4,'Presentación',NULL,'S','../../download/bancorecursos/chasqui/ChasquiPresentacion.html');
INSERT INTO paginas VALUES (5,'Laboratorio',NULL,'S','../../download/bancorecursos/chasqui/Laboratorio.html');
INSERT INTO paginas VALUES (7,'Miembros',NULL,'S','../../download/bancorecursos/chasqui/Miembros.html');
INSERT INTO paginas VALUES (8,'Museo',NULL,'S','../../download/bancorecursos/chasqui/Museo.html');
INSERT INTO paginas VALUES (9,'MasMuseo',NULL,'S','../../download/bancorecursos/chasqui/MasMuseo.html');
INSERT INTO paginas VALUES (10,'Financiación',NULL,'S','../../download/bancorecursos/chasqui/Financiacion.html');
INSERT INTO paginas VALUES (11,'Proyecto Chinchero',NULL,'S','../../download/bancorecursos/chasqui/ProyectoChinchero.html');
INSERT INTO paginas VALUES (12,'Proyecto Esmeraldas',NULL,'S','../../download/bancorecursos/chasqui/ProyectoEsmeraldas.html');
INSERT INTO paginas VALUES (13,'Proyecto Incapirca',NULL,'S','../../download/bancorecursos/chasqui/ProyectoIncapirca.html');
INSERT INTO paginas VALUES (14,'Proyecto Manabí Central',NULL,'S','../../download/bancorecursos/chasqui/ProyectoManabi.html');
INSERT INTO paginas VALUES (15,'Proyecto Arqueológico Coclé',NULL,'S','../../download/bancorecursos/chasqui/ProyectoCocle.html');

