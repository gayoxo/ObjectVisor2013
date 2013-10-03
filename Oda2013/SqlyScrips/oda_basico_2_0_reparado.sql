/*
SQLyog Enterprise v9.02 
MySQL - 5.0.77 : Database - odabbdd
*********************************************************************
*/use chasquioda;

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`odabbdd` /*!40100 DEFAULT CHARACTER SET latin1 */;

/*Table structure for table `contenidos_pagina` */

DROP TABLE IF EXISTS `contenidos_pagina`;

CREATE TABLE `contenidos_pagina` (
  `id` int(11) NOT NULL auto_increment,
  `idpagina` int(11) default NULL,
  `tipo` varchar(255) default NULL,
  `imagen` varchar(255) default NULL,
  `contenido` text,
  `orden` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `contenidos_pagina` */


/*Table structure for table `controlled_data` */

DROP TABLE IF EXISTS `controlled_data`;

CREATE TABLE `controlled_data` (
  `id` int(11) NOT NULL auto_increment,
  `idov` int(11) default NULL,
  `idseccion` int(11) default NULL,
  `value` varchar(255) default NULL,
  `idrecurso` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `idseccion` (`idseccion`),
  KEY `idov` (`idov`)
) ENGINE=MyISAM AUTO_INCREMENT=24150 DEFAULT CHARSET=utf8;

/*Data for the table `controlled_data` */


/*Table structure for table `date_data` */

DROP TABLE IF EXISTS `date_data`;

CREATE TABLE `date_data` (
  `id` int(11) NOT NULL auto_increment,
  `idov` int(11) default NULL,
  `idseccion` int(11) default NULL,
  `value` int(8) default NULL,
  `idrecurso` int(11) default NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1527 DEFAULT CHARSET=latin1;

/*Data for the table `date_data` */


/*Table structure for table `log_modificaciones` */

DROP TABLE IF EXISTS `log_modificaciones`;

CREATE TABLE `log_modificaciones` (
  `id` int(11) NOT NULL auto_increment,
  `idusuario` int(11) default NULL,
  `fechaModificacion` varchar(14) default NULL,
  `tipo` varchar(2) default NULL,
  `idov` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1614 DEFAULT CHARSET=utf8;

/*Data for the table `log_modificaciones` */


/*Table structure for table `mensajes` */

DROP TABLE IF EXISTS `mensajes`;

CREATE TABLE `mensajes` (
  `id` int(11) NOT NULL auto_increment,
  `lang` varchar(255) default NULL,
  `atributo` varchar(255) default NULL,
  `valor` text,
  `grupo` varchar(255) default NULL,
  `formato` varchar(255) default NULL,
  `tipo` varchar(255) default NULL,
  `etiqueta` varchar(255) default NULL,
  `orden` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=129 DEFAULT CHARSET=utf8;

/*Data for the table `mensajes` */

insert  into `mensajes`(`id`,`lang`,`atributo`,`valor`,`grupo`,`formato`,`tipo`,`etiqueta`,`orden`) values (121,'es','datos_titulo','Contenedor de Objetos Digitales de Aprendizaje','Datos del contenedor','largo','cabecera','Título del contenedor',1),(122,'es','datos_descripcion','Contenedor de objetos digitales','Datos del sitio web','texto','cabecera','Descripción',2),(123,'es','datos_palabras',' museo virtual, contenedor de objetos virtuales de aprendizaje, repositorio de objetos de aprendizaje','Datos del sitio web','texto','cabecera','Palabras clave',3),(124,'es','datos_imagen','../../download/bancorecursos/cabecera.png','Datos del contenedor','imagen','cabecera','Imagen cabecera',4),(128,'en','datos_imagen',NULL,'Datos del contenedor','imagen','cabecera','Imagen Cabecera',4);


/*Table structure for table `navegacion` */

DROP TABLE IF EXISTS `navegacion`;

CREATE TABLE `navegacion` (
  `id` int(11) NOT NULL auto_increment,
  `nombre` varchar(255) default NULL,
  `tooltip` varchar(255) default NULL,
  `idpadre` int(11) default NULL,
  `visible` char(1) default NULL,
  `orden` int(11) default NULL,
  `tipo_contenido` varchar(255) default NULL,
  `idpagina` int(11) default NULL,
  `tipo` varchar(255) default NULL,
  `nombreseo` varchar(255) default NULL,
  `imagen` varchar(255) default NULL,
  `contenido` text,
  `url` varchar(255) default NULL,
  `tiene_contenido` varchar(255) default NULL,
  `protocolo` varchar(255) default NULL,
  `ventanaexterna` char(1) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `navegacion` */
insert into `navegacion` (`id`, `nombre`, `tooltip`, `idpadre`, `visible`, `orden`, `tipo_contenido`, `idpagina`, `tipo`, `nombreseo`, `imagen`, `contenido`, `url`, `tiene_contenido`, `protocolo`, `ventanaexterna`) values('1','MANTENIMIENTO','Mantenimiento','0','N','7','M',NULL,'I','mantenimiento',NULL,NULL,NULL,'S',NULL,'N');


/*Table structure for table `numeric_data` */

DROP TABLE IF EXISTS `numeric_data`;

CREATE TABLE `numeric_data` (
  `id` int(11) NOT NULL auto_increment,
  `idov` int(11) default NULL,
  `idseccion` int(11) default NULL,
  `value` decimal(30,15) default NULL,
  `idrecurso` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=948 DEFAULT CHARSET=utf8;

/*Data for the table `numeric_data` */


/*Table structure for table `paginas` */

DROP TABLE IF EXISTS `paginas`;

CREATE TABLE `paginas` (
  `id` int(11) NOT NULL auto_increment,
  `titulo` varchar(255) default NULL,
  `contenido` text,
  `visible` char(1) default NULL,
  `documento` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `paginas` */

insert  into `paginas`(`id`,`titulo`,`contenido`,`visible`,`documento`) values (1,'Presentación del sitio web',NULL,'S',NULL);

/*Table structure for table `permisos` */

DROP TABLE IF EXISTS `permisos`;

CREATE TABLE `permisos` (
  `id` int(11) NOT NULL auto_increment,
  `idusuario` int(11) default NULL,
  `idov` int(11) default NULL,
  `tipoPermiso` char(1) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=199 DEFAULT CHARSET=utf8;

/*Data for the table `permisos` */


/*Table structure for table `preferencias_presentacion` */

DROP TABLE IF EXISTS `preferencias_presentacion`;

CREATE TABLE `preferencias_presentacion` (
  `id` int(11) NOT NULL auto_increment,
  `atributo` varchar(255) default NULL,
  `valor` text,
  `tipo` varchar(255) default NULL,
  `etiqueta` varchar(255) default NULL,
  `orden` int(11) default NULL,
  `formato` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `preferencias_presentacion` */

insert  into `preferencias_presentacion`(`id`,`atributo`,`valor`,`tipo`,`etiqueta`,`orden`,`formato`) values (1,'portada_contenido','I','P',NULL,NULL,NULL),(2,'imagen_fondo_global',NULL,'F','Imagen de fondo global',1,'imagen'),(3,'color_fondo',NULL,'F','Color de fondo',2,'color'),(4,'seguridad_web','N',NULL,NULL,NULL,NULL),(5,'extension_archivos','jpg;doc;pdf;docx;mp3',NULL,NULL,NULL,NULL),(6,'numeric_decimal','4',NULL,NULL,NULL,NULL);

/*Table structure for table `resources` */

DROP TABLE IF EXISTS `resources`;

CREATE TABLE `resources` (
  `id` int(11) NOT NULL auto_increment,
  `idov` int(11) default NULL,
  `ordinal` int(11) default NULL,
  `visible` char(1) default NULL,
  `iconoov` char(1) default NULL,
  `name` varchar(255) default NULL,
  `idov_refered` int(11) default NULL,
  `idresource_refered` int(11) default NULL,
  `type` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=469 DEFAULT CHARSET=utf8;

/*Data for the table `resources` */


/*Table structure for table `section_data` */

DROP TABLE IF EXISTS `section_data`;

CREATE TABLE `section_data` (
  `id` int(11) NOT NULL auto_increment,
  `idpadre` int(11) default NULL,
  `nombre` varchar(255) default NULL,
  `codigo` varchar(255) default NULL,
  `tooltip` varchar(255) default NULL,
  `visible` char(1) default NULL,
  `orden` int(11) default NULL,
  `browseable` char(1) default NULL,
  `tipo_valores` varchar(255) default NULL,
  `extensible` char(1) default NULL,
  `vocabulario` int(11) default NULL,
  `decimales` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=299 DEFAULT CHARSET=utf8;

/*Data for the table `section_data` */

insert  into `section_data`(`id`,`idpadre`,`nombre`,`codigo`,`tooltip`,`visible`,`orden`,`browseable`,`tipo_valores`,`extensible`,`vocabulario`) values (2,0,'Modelo de MetaDatos','lom','metadatos','S',2,NULL,NULL,'S',0),(3,0,'Modelo de Datos de los Recursos','recursos','recursos','S',3,NULL,NULL,'S',0),(111,1,'Descripción',NULL,'fijo_texto','S',1,NULL,'T',NULL,NULL),(112,1,'Tipo Registro',NULL,'fijo_controlado','S',5,'S','C',NULL,NULL),(1,0,'Modelo de Datos','datos','datos','S',1,NULL,NULL,'S',0);

/*Table structure for table `text_data` */

DROP TABLE IF EXISTS `text_data`;

CREATE TABLE `text_data` (
  `id` int(11) NOT NULL auto_increment,
  `idov` int(11) default NULL,
  `idseccion` int(11) default NULL,
  `value` text,
  `idrecurso` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=903 DEFAULT CHARSET=utf8;

/*Data for the table `text_data` */


/*Table structure for table `usuarios` */

DROP TABLE IF EXISTS `usuarios`;

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL auto_increment,
  `nombre` varchar(255) default NULL,
  `apellidos` varchar(255) default NULL,
  `correo` varchar(255) default NULL,
  `login` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `rol` varchar(255) default NULL,
  `ultimo_acceso` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=139 DEFAULT CHARSET=utf8;

/*Data for the table `usuarios` */
insert into `usuarios` (`id`, `nombre`, `apellidos`, `correo`, `login`, `password`, `rol`, `ultimo_acceso`) values('11','admin1','admin2','test@test.test','admin','admin','B','20121112035440');
insert into `usuarios` (`id`, `nombre`, `apellidos`, `correo`, `login`, `password`, `rol`, `ultimo_acceso`) values('111','user1','user2','test@test.test','user','user','C','20121113153706');
insert into `usuarios` (`id`, `nombre`, `apellidos`, `correo`, `login`, `password`, `rol`, `ultimo_acceso`) values('1','super1','super2','test@test.test','superadmin','superadmin','A','20121114025845');


/*Table structure for table `virtual_object` */

DROP TABLE IF EXISTS `virtual_object`;

CREATE TABLE `virtual_object` (
  `id` int(11) NOT NULL auto_increment,
  `ispublic` char(1) default NULL,
  `isprivate` char(1) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=274 DEFAULT CHARSET=utf8;

/*Data for the table `virtual_object` */


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
