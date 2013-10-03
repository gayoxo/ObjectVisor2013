CREATE DATABASE  IF NOT EXISTS `chasquioda` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `chasquioda`;
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: chasquioda
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.10.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `controlled_data`
--

DROP TABLE IF EXISTS `controlled_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `controlled_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idov` int(11) DEFAULT NULL,
  `idseccion` int(11) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `idrecurso` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `controlled_data`
--

LOCK TABLES `controlled_data` WRITE;
/*!40000 ALTER TABLE `controlled_data` DISABLE KEYS */;
INSERT INTO `controlled_data` VALUES (4,1,112,NULL,NULL),(6,2,112,NULL,NULL),(8,3,112,NULL,NULL);
/*!40000 ALTER TABLE `controlled_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contenidos_pagina`
--

DROP TABLE IF EXISTS `contenidos_pagina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contenidos_pagina` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idpagina` int(11) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `contenido` text,
  `orden` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contenidos_pagina`
--

LOCK TABLES `contenidos_pagina` WRITE;
/*!40000 ALTER TABLE `contenidos_pagina` DISABLE KEYS */;
INSERT INTO `contenidos_pagina` VALUES (2,2,'2',NULL,'<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n    <tbody>\r\n        <tr>\r\n            <td width=\"100%\">\r\n            <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n                <tbody>\r\n                    <tr height=\"25\">\r\n                        <td colspan=\"3\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"25\" border=\"0\" alt=\"\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td width=\"15%\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                        <td>\r\n                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\">\r\n                            <tbody>\r\n                                <tr height=\"35\">\r\n                                    <td><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"35\" border=\"0\" alt=\"\" /></td>\r\n                                </tr>\r\n                                <tr>\r\n                                    <td><a name=\"presentacion\"><font class=\"titPagina\" style=\"font-family: Verdana, Arial; font-weight: bold; font-size: 10pt;\">Presentaci&oacute;n</font></a></td>\r\n                                </tr>\r\n                                <tr>\r\n                                    <td><img src=\"http://macgalatea.sip.ucm.es/web/images/Raya.jpg\" width=\"400\" height=\"5\" border=\"0\" alt=\"\" /></td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                        </td>\r\n                        <td width=\"15%\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                    </tr>\r\n                    <tr height=\"10\">\r\n                        <td width=\"15%\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                        <td><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"600\" height=\"10\" border=\"0\" alt=\"\" /></td>\r\n                        <td width=\"15%\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td width=\"15%\">&nbsp;</td>\r\n                        <td>\r\n                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"textoIntro\" style=\"font-family: Verdana, Arial; font-size: 11pt; text-align: justify;\">\r\n                            <tbody>\r\n                                <tr>\r\n                                    <td><font class=\"capital\" style=\"color: blue; font-family: verdana; font-size: 30px;\">E</font>l&nbsp;<a href=\"http://www.ucm.es/info/america2/\">Departamento de Historia de Am&eacute;rica II (Antropolog&iacute;a de Am&eacute;rica)</a>&nbsp;de la Facultad de Geograf&iacute;a e Historia de la UCM y el Grupo de Ingenier&iacute;a del Software e Inteligencia Artificial del&nbsp;<a href=\"http://www.ucm.es/info/dsip/\">Departamento de Sistemas Inform&aacute;ticos y Programaci&oacute;n</a>&nbsp;de la Facultad de Inform&aacute;tica de la UCM est&aacute;n colaborando en la ejecuci&oacute;n de diversos&nbsp;<b><a href=\"http://macgalatea.sip.ucm.es/web/infoProyecto/presentacion.php#proyectos\">proyectos de investigaci&oacute;n</a></b>&nbsp;cuya finalidad &uacute;ltima es convertir en recursos educativos digitales los&nbsp;<b><a href=\"http://macgalatea.sip.ucm.es/web/infoProyecto/presentacion.php#materiales\">materiales arqueol&oacute;gicos y etnogr&aacute;ficos</a></b>&nbsp;del primero de ellos, de tal manera que sirvan de apoyo a la docencia, al trabajo de los investigadores y a la creaci&oacute;n de puntos de informaci&oacute;n (sitios Web) de contenido cultural.</td>\r\n                                    <td width=\"15\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"15\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                                    <td>\r\n                                    <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                                        <tbody>\r\n                                            <tr>\r\n                                                <td><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/plus.gif\" width=\"11\" height=\"11\" border=\"0\" alt=\"\" /></td>\r\n                                                <td><a href=\"http://macgalatea.sip.ucm.es/web/publico/control.php?accion=&amp;Ficha=1&amp;id=1160\" target=\"blank\"><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/069_005_9.jpg\" width=\"135\" height=\"180\" border=\"0\" alt=\"Abrir en nueva ventana\" /></a></td>\r\n                                                <td><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/plus2.gif\" width=\"11\" height=\"11\" border=\"0\" alt=\"\" /></td>\r\n                                            </tr>\r\n                                        </tbody>\r\n                                    </table>\r\n                                    </td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                        </td>\r\n                        <td width=\"15%\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr height=\"45\">\r\n                        <td colspan=\"3\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"45\" border=\"0\" alt=\"\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td width=\"15%\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                        <td>\r\n                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\">\r\n                            <tbody>\r\n                                <tr>\r\n                                    <td><a name=\"Proyectos\"><font class=\"titPagina\" style=\"font-family: Verdana, Arial; font-weight: bold; font-size: 10pt;\">Proyectos</font></a></td>\r\n                                </tr>\r\n                                <tr>\r\n                                    <td><img src=\"http://macgalatea.sip.ucm.es/web/images/Raya.jpg\" width=\"400\" height=\"5\" border=\"0\" alt=\"\" /></td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\">\r\n                            <tbody>\r\n                                <tr>\r\n                                    <td><a href=\"http://macgalatea.sip.ucm.es/web/infoProyecto/presentacion.php#inicio\"><img name=\"BVolver\" src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/Arriba.gif\" width=\"55\" height=\"15\" border=\"0\" alt=\"Volver\" /></a></td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                        </td>\r\n                        <td width=\"15%\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                    </tr>\r\n                    <tr height=\"35\">\r\n                        <td width=\"100%\" colspan=\"3\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"35\" border=\"0\" alt=\"\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td width=\"15%\">&nbsp;</td>\r\n                        <td>\r\n                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                            <tbody>\r\n                                <tr>\r\n                                    <td>\r\n                                    <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"textoIntro\" style=\"font-family: Verdana, Arial; font-size: 11pt; text-align: justify;\">\r\n                                        <tbody>\r\n                                            <tr>\r\n                                                <td><i><font class=\"capital\" style=\"color: blue; font-family: verdana; font-size: 30px;\">P</font>royecto NUTIAH, Nuevas tecnolog&iacute;as de la Informaci&oacute;n en Antropolog&iacute;a e Historia: Un entorno virtual de trabajo</i>, est&aacute; orientado a introducir nuevos m&eacute;todos docentes que con la ayuda de las nuevas tecnolog&iacute;as de la informaci&oacute;n posibiliten la realizaci&oacute;n de clases pr&aacute;cticas y otras actividades docentes no presenciales. Con este fin se est&aacute; construyendo un prototipo de clases pr&aacute;cticas apoyadas en los materiales del Museo y del Laboratorio.&nbsp;<br />\r\n                                                <br />\r\n                                                <table border=\"0\" cellpadding=\"0\" cellspacing=\"15\" align=\"right\">\r\n                                                    <tbody>\r\n                                                        <tr>\r\n                                                            <td>\r\n                                                            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n                                                                <tbody>\r\n                                                                    <tr>\r\n                                                                        <td><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/plus.gif\" width=\"11\" height=\"11\" border=\"0\" alt=\"\" /></td>\r\n                                                                        <td><a href=\"http://macgalatea.sip.ucm.es/web/publico/control.php?accion=&amp;Ficha=1&amp;id=313\" target=\"blank\"><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/277_1.jpg\" width=\"200\" height=\"138\" border=\"0\" alt=\"Abrir en nueva ventana\" /></a></td>\r\n                                                                        <td><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/plus2.gif\" width=\"11\" height=\"11\" border=\"0\" alt=\"\" /></td>\r\n                                                                    </tr>\r\n                                                                </tbody>\r\n                                                            </table>\r\n                                                            </td>\r\n                                                        </tr>\r\n                                                    </tbody>\r\n                                                </table>\r\n                                                <i><font class=\"capital\" style=\"color: blue; font-family: verdana; font-size: 30px;\">P</font>royecto SIMBA, Sistemas de Informaci&oacute;n Multimedia Basado en lenguajes de marcado y Agentes</i>. Este proyecto tiene como objetivo principal la construcci&oacute;n, mediante tecnolog&iacute;a web, de un sistema distribuido de gesti&oacute;n de informaci&oacute;n multimedia. La arquitectura del sistema est&aacute; pensada para que sobre ella se puedan desarrollar sistemas hipermedia de ense&ntilde;anza y de formaci&oacute;n en el puesto de trabajo.</td>\r\n                                            </tr>\r\n                                            <tr height=\"20\">\r\n                                                <td width=\"100%\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"20\" border=\"0\" alt=\"\" /></td>\r\n                                            </tr>\r\n                                        </tbody>\r\n                                    </table>\r\n                                    </td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"textoIntro\" style=\"font-family: Verdana, Arial; font-size: 11pt; text-align: justify;\">\r\n                            <tbody>\r\n                                <tr>\r\n                                    <td><i><font class=\"capital\" style=\"color: blue; font-family: verdana; font-size: 30px;\">P</font>royecto CHASQUI, Informaci&oacute;n y Comunicaci&oacute;n Digital en Antropolog&iacute;a e Historia</i>, utilizando el prototipo contruido en NUTIAH y las t&eacute;cnicas desarrolladas en SIMBA abarcar&aacute; no solamente los aspectos pedag&oacute;gicos, sino tambi&eacute;n otros m&aacute;s puramente informativos, como la colaboraci&oacute;n entre investigadores y la difusi&oacute;n cultural.</td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                        </td>\r\n                        <td width=\"15%\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr height=\"45\">\r\n                        <td colspan=\"3\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"45\" border=\"0\" alt=\"\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td width=\"15%\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                        <td>\r\n                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\">\r\n                            <tbody>\r\n                                <tr>\r\n                                    <td><a name=\"materiales\"><font class=\"titPagina\" style=\"font-family: Verdana, Arial; font-weight: bold; font-size: 10pt;\">Materiales</font></a></td>\r\n                                </tr>\r\n                                <tr>\r\n                                    <td><img src=\"http://macgalatea.sip.ucm.es/web/images/Raya.jpg\" width=\"400\" height=\"5\" border=\"0\" alt=\"\" /></td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\">\r\n                            <tbody>\r\n                                <tr>\r\n                                    <td><a href=\"http://macgalatea.sip.ucm.es/web/infoProyecto/presentacion.php#inicio\"><img name=\"BVolver2\" src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/Arriba.gif\" width=\"55\" height=\"15\" border=\"0\" alt=\"Volver\" /></a></td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                        </td>\r\n                        <td width=\"15%\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                    </tr>\r\n                    <tr height=\"35\">\r\n                        <td width=\"100%\" colspan=\"3\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"35\" border=\"0\" alt=\"\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td width=\"15%\">&nbsp;</td>\r\n                        <td>\r\n                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"textoIntro\" style=\"font-family: Verdana, Arial; font-size: 11pt; text-align: justify;\">\r\n                            <tbody>\r\n                                <tr>\r\n                                    <td><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/plus.gif\" width=\"11\" height=\"11\" border=\"0\" alt=\"\" /></td>\r\n                                    <td><a href=\"http://macgalatea.sip.ucm.es/web/publico/control.php?accion=&amp;Ficha=1&amp;id=601\" target=\"blank\"><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/592_1.jpg\" width=\"135\" height=\"160\" border=\"0\" alt=\"Abrir en nueva ventana\" /></a></td>\r\n                                    <td><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/plus2.gif\" width=\"11\" height=\"11\" border=\"0\" alt=\"\" /></td>\r\n                                    <td width=\"15\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"15\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                                    <td><font class=\"capital\" style=\"color: blue; font-family: verdana; font-size: 30px;\">E</font>stos materiales proceden de donaciones, excavaciones arqueol&oacute;gicas y trabajos de campo realizados por miembros y colaboradores del Departamento de Historia de Am&eacute;rica II y la mayor parte de ellos se encuentran localizados en su&nbsp;<a href=\"http://macgalatea.sip.ucm.es/web/infoProyecto/museo.php\">Museo Docente Colecciones de Arqueolog&iacute;a y Etnologia de Am&eacute;rica</a>&nbsp;o en el&nbsp;<a href=\"http://macgalatea.sip.ucm.es/web/infoProyecto/laboratorio.php\">Laboratorio de Arqueolog&iacute;a Americana</a>.</td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"textoIntro\" style=\"font-family: Verdana, Arial; font-size: 11pt; text-align: justify;\">\r\n                            <tbody>\r\n                                <tr height=\"15\">\r\n                                    <td colspan=\"3\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"15\" border=\"0\" alt=\"\" /></td>\r\n                                </tr>\r\n                                <tr>\r\n                                    <td><font class=\"capital\" style=\"color: blue; font-family: verdana; font-size: 30px;\">L</font>a infraestructura inform&aacute;tica la aporta el Grupo de Ingeneria del Sofware e Inteligencia Artificial del Departamento de Sistemas Inform&aacute;ticos y Programaci&oacute;n y es patrimonio de la UCM. En su mayor parte se corresponde con el hardaware y software, utilizado y desarrollado para la realizaci&oacute;n de los proyectos&nbsp;<a href=\"http://www.simba.vsf.es/\">Galatea</a>&nbsp;y&nbsp;<a href=\"http://www.simba.vsf.es/\">SIMBA</a>. Desde el punto de vista t&eacute;cnico, la construcci&oacute;n de estos recursos digitales se basa en la utilizaci&oacute;n de&nbsp;<a href=\"http://www.xml.org/\">XML</a>&nbsp;(eXtensible Markup Language) para definir los lenguajes de modelado de las actividades educativas y de representaci&oacute;n de la informaci&oacute;n arqueol&oacute;gica.</td>\r\n                                    <td width=\"15\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"15\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                                    <td><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/plus.gif\" width=\"11\" height=\"11\" border=\"0\" alt=\"\" /></td>\r\n                                    <td><a href=\"http://macgalatea.sip.ucm.es/web/publico/control.php?accion=&amp;Ficha=1&amp;id=1161\" target=\"blank\"><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/071_C02.jpg\" width=\"175\" height=\"146\" border=\"0\" alt=\"Abrir en nueva ventana\" /></a></td>\r\n                                    <td><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/plus2.gif\" width=\"11\" height=\"11\" border=\"0\" alt=\"\" /></td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                        </td>\r\n                    </tr>\r\n                    <tr height=\"20\">\r\n                        <td colspan=\"3\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"20\" border=\"0\" alt=\"\" /></td>\r\n                    </tr>\r\n                </tbody>\r\n            </table>\r\n            </td>\r\n        </tr>\r\n    </tbody>\r\n</table>',100),(3,3,'2',NULL,NULL,100);
/*!40000 ALTER TABLE `contenidos_pagina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permisos`
--

DROP TABLE IF EXISTS `permisos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permisos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idusuario` int(11) DEFAULT NULL,
  `idov` int(11) DEFAULT NULL,
  `tipoPermiso` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permisos`
--

LOCK TABLES `permisos` WRITE;
/*!40000 ALTER TABLE `permisos` DISABLE KEYS */;
/*!40000 ALTER TABLE `permisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mensajes`
--

DROP TABLE IF EXISTS `mensajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mensajes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lang` varchar(255) DEFAULT NULL,
  `atributo` varchar(255) DEFAULT NULL,
  `valor` text,
  `grupo` varchar(255) DEFAULT NULL,
  `formato` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `etiqueta` varchar(255) DEFAULT NULL,
  `orden` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=129 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensajes`
--

LOCK TABLES `mensajes` WRITE;
/*!40000 ALTER TABLE `mensajes` DISABLE KEYS */;
INSERT INTO `mensajes` VALUES (121,'es','datos_titulo','Contenedor de Objetos Digitales de Aprendizaje','Datos del contenedor','largo','cabecera','Título del contenedor',1),(122,'es','datos_descripcion','DEPARTAMENTO DE HISTORIA DE AMÉRICA II\r\n(ANTROPOLOGÍA DE AMÉRICA) Facultad de Geografía e Historia','Datos del sitio web','texto','cabecera','Descripción',2),(123,'es','datos_palabras',' museo virtual, contenedor de objetos virtuales de aprendizaje, repositorio de objetos de aprendizaje,chasqui','Datos del sitio web','texto','cabecera','Palabras clave',3),(124,'es','datos_imagen','../../download/bancorecursos/Cabecera7.jpg','Datos del contenedor','imagen','cabecera','Imagen cabecera',4),(128,'en','datos_imagen',NULL,'Datos del contenedor','imagen','cabecera','Imagen Cabecera',4);
/*!40000 ALTER TABLE `mensajes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paginas`
--

DROP TABLE IF EXISTS `paginas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paginas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) DEFAULT NULL,
  `contenido` text,
  `visible` char(1) DEFAULT NULL,
  `documento` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paginas`
--

LOCK TABLES `paginas` WRITE;
/*!40000 ALTER TABLE `paginas` DISABLE KEYS */;
INSERT INTO `paginas` VALUES (1,'Chasqui',NULL,'S','../../download/bancorecursos/chasqui/portada.html'),(4,'Presentación',NULL,'S','../../download/bancorecursos/chasqui/ChasquiPresentacion.html'),(5,'Laboratorio',NULL,'S','../../download/bancorecursos/chasqui/Laboratorio.html'),(7,'Miembros',NULL,'S','../../download/bancorecursos/chasqui/Miembros.html'),(8,'Museo',NULL,'S','../../download/bancorecursos/chasqui/Museo.html'),(9,'MasMuseo',NULL,'S','../../download/bancorecursos/chasqui/MasMuseo.html'),(10,'Financiación',NULL,'S','../../download/bancorecursos/chasqui/Financiacion.html'),(11,'Proyecto Chinchero',NULL,'S','../../download/bancorecursos/chasqui/ProyectoChinchero.html'),(12,'Proyecto Esmeraldas',NULL,'S','../../download/bancorecursos/chasqui/ProyectoEsmeraldas.html'),(13,'Proyecto Incapirca',NULL,'S','../../download/bancorecursos/chasqui/ProyectoIncapirca.html'),(14,'Proyecto Manabí Central',NULL,'S','../../download/bancorecursos/chasqui/ProyectoManabi.html'),(15,'Proyecto Arqueológico Coclé',NULL,'S','../../download/bancorecursos/chasqui/ProyectoCocle.html');
/*!40000 ALTER TABLE `paginas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `numeric_data`
--

DROP TABLE IF EXISTS `numeric_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `numeric_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idov` int(11) DEFAULT NULL,
  `idseccion` int(11) DEFAULT NULL,
  `value` decimal(30,15) DEFAULT NULL,
  `idrecurso` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `numeric_data`
--

LOCK TABLES `numeric_data` WRITE;
/*!40000 ALTER TABLE `numeric_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `numeric_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `date_data`
--

DROP TABLE IF EXISTS `date_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `date_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idov` int(11) DEFAULT NULL,
  `idseccion` int(11) DEFAULT NULL,
  `value` int(8) DEFAULT NULL,
  `idrecurso` int(11) DEFAULT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `date_data`
--

LOCK TABLES `date_data` WRITE;
/*!40000 ALTER TABLE `date_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `date_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preferencias_presentacion`
--

DROP TABLE IF EXISTS `preferencias_presentacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `preferencias_presentacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `atributo` varchar(255) DEFAULT NULL,
  `valor` text,
  `tipo` varchar(255) DEFAULT NULL,
  `etiqueta` varchar(255) DEFAULT NULL,
  `orden` int(11) DEFAULT NULL,
  `formato` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preferencias_presentacion`
--

LOCK TABLES `preferencias_presentacion` WRITE;
/*!40000 ALTER TABLE `preferencias_presentacion` DISABLE KEYS */;
INSERT INTO `preferencias_presentacion` VALUES (1,'portada_contenido','I','P',NULL,NULL,NULL),(2,'imagen_fondo_global','../../download/bancorecursos/fondoWeb2.jpg','F','Imagen de fondo global',1,'imagen'),(3,'color_fondo',NULL,'F','Color de fondo',2,'color'),(4,'seguridad_web','N',NULL,NULL,NULL,NULL),(5,'extension_archivos','jpg;doc;pdf;docx;html;JPG;DOC;PDF;DOCX;doc;DOC;php',NULL,NULL,NULL,NULL),(6,'numeric_decimal','4',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `preferencias_presentacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log_modificaciones`
--

DROP TABLE IF EXISTS `log_modificaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log_modificaciones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idusuario` int(11) DEFAULT NULL,
  `fechaModificacion` varchar(14) DEFAULT NULL,
  `tipo` varchar(2) DEFAULT NULL,
  `idov` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_modificaciones`
--

LOCK TABLES `log_modificaciones` WRITE;
/*!40000 ALTER TABLE `log_modificaciones` DISABLE KEYS */;
INSERT INTO `log_modificaciones` VALUES (1,NULL,'20130226161502','C',1),(2,NULL,'20130226161511','M',1),(3,NULL,'20130226161819','M',1),(4,NULL,'20130226162102','M',1),(5,NULL,'20130226162854','C',2),(6,NULL,'20130226162901','M',2),(7,NULL,'20130226180917','C',3),(8,NULL,'20130226180923','M',3);
/*!40000 ALTER TABLE `log_modificaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `virtual_object`
--

DROP TABLE IF EXISTS `virtual_object`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `virtual_object` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ispublic` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `virtual_object`
--

LOCK TABLES `virtual_object` WRITE;
/*!40000 ALTER TABLE `virtual_object` DISABLE KEYS */;
/*!40000 ALTER TABLE `virtual_object` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `text_data`
--

DROP TABLE IF EXISTS `text_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `text_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idov` int(11) DEFAULT NULL,
  `idseccion` int(11) DEFAULT NULL,
  `value` text,
  `idrecurso` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `text_data`
--

LOCK TABLES `text_data` WRITE;
/*!40000 ALTER TABLE `text_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `text_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=112 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (11,'Nombre','Nombre','test@test.test','admin','admin','B'),(111,'Nombre','Apellidos','test@test.test','user','user','C'),(1,'Nombre','Apellidos','test@test.test','superadmin','superadmin','A');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `section_data`
--

DROP TABLE IF EXISTS `section_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `section_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idpadre` int(11) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `codigo` varchar(255) DEFAULT NULL,
  `tooltip` varchar(255) DEFAULT NULL,
  `visible` char(1) DEFAULT NULL,
  `orden` int(11) DEFAULT NULL,
  `browseable` char(1) DEFAULT NULL,
  `tipo_valores` varchar(255) DEFAULT NULL,
  `extensible` char(1) DEFAULT NULL,
  `vocabulario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=113 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `section_data`
--

LOCK TABLES `section_data` WRITE;
/*!40000 ALTER TABLE `section_data` DISABLE KEYS */;
INSERT INTO `section_data` VALUES (2,0,'Modelo de MetaDatos','lom','metadatos','S',2,NULL,NULL,'S',0),(3,0,'Modelo de Datos de los Recursos','recursos','recursos','S',3,NULL,NULL,'S',0),(111,1,'Descripción',NULL,'fijo_texto','S',1,NULL,'T',NULL,NULL),(112,1,'Tipo Registro',NULL,'fijo_controlado',NULL,5,NULL,'C',NULL,NULL),(1,0,'Modelo de Datos','datos','datos','S',1,NULL,NULL,'S',0);
/*!40000 ALTER TABLE `section_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `navegacion`
--

DROP TABLE IF EXISTS `navegacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `navegacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `tooltip` varchar(255) DEFAULT NULL,
  `idpadre` int(11) DEFAULT NULL,
  `visible` char(1) DEFAULT NULL,
  `orden` int(11) DEFAULT NULL,
  `tipo_contenido` varchar(255) DEFAULT NULL,
  `idpagina` int(11) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `nombreseo` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `contenido` text,
  `url` varchar(255) DEFAULT NULL,
  `tiene_contenido` varchar(255) DEFAULT NULL,
  `protocolo` varchar(255) DEFAULT NULL,
  `ventanaexterna` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `navegacion`
--

LOCK TABLES `navegacion` WRITE;
/*!40000 ALTER TABLE `navegacion` DISABLE KEYS */;
INSERT INTO `navegacion` VALUES (4,'Mantenimiento',NULL,0,'N',7,'M',NULL,'I','mantenimiento',NULL,NULL,NULL,'S',NULL,'N'),(2,'Acceso clasificado a la Base de Datos',NULL,8,'S',5,'C',NULL,'I','acceso_clasificado_a_la_base_de_datos',NULL,NULL,NULL,'S',NULL,'N'),(3,'Presentación',NULL,6,'S',2,'P',4,'I','presentación',NULL,'<p>&nbsp;dasdsad</p>',NULL,'S',NULL,'N'),(5,'Laboratorio','Laboratorio',9,'S',7,'P',5,'I','laboratorio',NULL,NULL,NULL,'S',NULL,'N'),(6,'Información del Proyecto',NULL,0,'S',2,'H',4,'I','información_del_proyecto',NULL,NULL,NULL,'S',NULL,'N'),(7,'Busqueda',NULL,8,'S',8,'B',NULL,'I','busqueda',NULL,NULL,NULL,'S',NULL,'N'),(8,'Acceso clasificado',NULL,0,'S',6,'H',NULL,'I','acceso_clasificado',NULL,NULL,NULL,'S',NULL,'N'),(9,'Recursos','Recursos',6,'S',4,'H',NULL,'I','recursos',NULL,NULL,NULL,'S',NULL,'N'),(10,'Miembros','Miembros',6,'S',3,'P',7,'I','miembros',NULL,NULL,NULL,'S',NULL,'N'),(11,'Museo','Museo',9,'S',1009,'P',8,'I','museo',NULL,NULL,NULL,'S',NULL,'N'),(12,'Financiación','Financiación',6,'S',1010,'P',10,'I','financiación',NULL,NULL,NULL,'S',NULL,'N'),(13,'Pr. Chinchero','Pr. Chinchero',9,'S',1011,'P',11,'I','pr._chinchero',NULL,NULL,NULL,'S',NULL,'N'),(14,'Pr. Esmeraldas','Pr. Esmeraldas',9,'S',1012,'P',12,'I','pr._esmeraldas',NULL,NULL,NULL,'S',NULL,'N'),(15,'Pr. Incapirca','Pr. Incapirca',9,'S',1013,'P',13,'I','pr._incapirca',NULL,NULL,NULL,'S',NULL,'N'),(16,'Pr. Manabí Central','Pr. Manabí Central',9,'S',1014,'P',14,'I','pr._manabí_central',NULL,NULL,NULL,'S',NULL,'N'),(17,'Pr. Coclé','Pr. Coclé',9,'S',1015,'P',15,'I','pr._coclé',NULL,NULL,NULL,'S',NULL,'N');
/*!40000 ALTER TABLE `navegacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resources`
--

DROP TABLE IF EXISTS `resources`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resources` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idov` int(11) DEFAULT NULL,
  `ordinal` int(11) DEFAULT NULL,
  `visible` char(1) DEFAULT NULL,
  `iconoov` char(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `idov_refered` int(11) DEFAULT NULL,
  `idresource_refered` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resources`
--

LOCK TABLES `resources` WRITE;
/*!40000 ALTER TABLE `resources` DISABLE KEYS */;
/*!40000 ALTER TABLE `resources` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'chasquioda'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-02-27 18:59:50
CREATE DATABASE  IF NOT EXISTS `chasquiodaV2` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `chasquiodaV2`;
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: chasquiodaV2
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.10.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `controlled_data`
--

DROP TABLE IF EXISTS `controlled_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `controlled_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idov` int(11) DEFAULT NULL,
  `idseccion` int(11) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `idrecurso` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `controlled_data`
--

LOCK TABLES `controlled_data` WRITE;
/*!40000 ALTER TABLE `controlled_data` DISABLE KEYS */;
INSERT INTO `controlled_data` VALUES (4,1,112,NULL,NULL),(6,2,112,NULL,NULL),(8,3,112,NULL,NULL);
/*!40000 ALTER TABLE `controlled_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contenidos_pagina`
--

DROP TABLE IF EXISTS `contenidos_pagina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contenidos_pagina` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idpagina` int(11) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `contenido` text,
  `orden` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contenidos_pagina`
--

LOCK TABLES `contenidos_pagina` WRITE;
/*!40000 ALTER TABLE `contenidos_pagina` DISABLE KEYS */;
INSERT INTO `contenidos_pagina` VALUES (2,2,'2',NULL,'<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n    <tbody>\r\n        <tr>\r\n            <td width=\"100%\">\r\n            <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n                <tbody>\r\n                    <tr height=\"25\">\r\n                        <td colspan=\"3\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"25\" border=\"0\" alt=\"\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td width=\"15%\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                        <td>\r\n                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\">\r\n                            <tbody>\r\n                                <tr height=\"35\">\r\n                                    <td><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"35\" border=\"0\" alt=\"\" /></td>\r\n                                </tr>\r\n                                <tr>\r\n                                    <td><a name=\"presentacion\"><font class=\"titPagina\" style=\"font-family: Verdana, Arial; font-weight: bold; font-size: 10pt;\">Presentaci&oacute;n</font></a></td>\r\n                                </tr>\r\n                                <tr>\r\n                                    <td><img src=\"http://macgalatea.sip.ucm.es/web/images/Raya.jpg\" width=\"400\" height=\"5\" border=\"0\" alt=\"\" /></td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                        </td>\r\n                        <td width=\"15%\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                    </tr>\r\n                    <tr height=\"10\">\r\n                        <td width=\"15%\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                        <td><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"600\" height=\"10\" border=\"0\" alt=\"\" /></td>\r\n                        <td width=\"15%\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td width=\"15%\">&nbsp;</td>\r\n                        <td>\r\n                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"textoIntro\" style=\"font-family: Verdana, Arial; font-size: 11pt; text-align: justify;\">\r\n                            <tbody>\r\n                                <tr>\r\n                                    <td><font class=\"capital\" style=\"color: blue; font-family: verdana; font-size: 30px;\">E</font>l&nbsp;<a href=\"http://www.ucm.es/info/america2/\">Departamento de Historia de Am&eacute;rica II (Antropolog&iacute;a de Am&eacute;rica)</a>&nbsp;de la Facultad de Geograf&iacute;a e Historia de la UCM y el Grupo de Ingenier&iacute;a del Software e Inteligencia Artificial del&nbsp;<a href=\"http://www.ucm.es/info/dsip/\">Departamento de Sistemas Inform&aacute;ticos y Programaci&oacute;n</a>&nbsp;de la Facultad de Inform&aacute;tica de la UCM est&aacute;n colaborando en la ejecuci&oacute;n de diversos&nbsp;<b><a href=\"http://macgalatea.sip.ucm.es/web/infoProyecto/presentacion.php#proyectos\">proyectos de investigaci&oacute;n</a></b>&nbsp;cuya finalidad &uacute;ltima es convertir en recursos educativos digitales los&nbsp;<b><a href=\"http://macgalatea.sip.ucm.es/web/infoProyecto/presentacion.php#materiales\">materiales arqueol&oacute;gicos y etnogr&aacute;ficos</a></b>&nbsp;del primero de ellos, de tal manera que sirvan de apoyo a la docencia, al trabajo de los investigadores y a la creaci&oacute;n de puntos de informaci&oacute;n (sitios Web) de contenido cultural.</td>\r\n                                    <td width=\"15\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"15\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                                    <td>\r\n                                    <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                                        <tbody>\r\n                                            <tr>\r\n                                                <td><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/plus.gif\" width=\"11\" height=\"11\" border=\"0\" alt=\"\" /></td>\r\n                                                <td><a href=\"http://macgalatea.sip.ucm.es/web/publico/control.php?accion=&amp;Ficha=1&amp;id=1160\" target=\"blank\"><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/069_005_9.jpg\" width=\"135\" height=\"180\" border=\"0\" alt=\"Abrir en nueva ventana\" /></a></td>\r\n                                                <td><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/plus2.gif\" width=\"11\" height=\"11\" border=\"0\" alt=\"\" /></td>\r\n                                            </tr>\r\n                                        </tbody>\r\n                                    </table>\r\n                                    </td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                        </td>\r\n                        <td width=\"15%\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr height=\"45\">\r\n                        <td colspan=\"3\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"45\" border=\"0\" alt=\"\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td width=\"15%\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                        <td>\r\n                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\">\r\n                            <tbody>\r\n                                <tr>\r\n                                    <td><a name=\"Proyectos\"><font class=\"titPagina\" style=\"font-family: Verdana, Arial; font-weight: bold; font-size: 10pt;\">Proyectos</font></a></td>\r\n                                </tr>\r\n                                <tr>\r\n                                    <td><img src=\"http://macgalatea.sip.ucm.es/web/images/Raya.jpg\" width=\"400\" height=\"5\" border=\"0\" alt=\"\" /></td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\">\r\n                            <tbody>\r\n                                <tr>\r\n                                    <td><a href=\"http://macgalatea.sip.ucm.es/web/infoProyecto/presentacion.php#inicio\"><img name=\"BVolver\" src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/Arriba.gif\" width=\"55\" height=\"15\" border=\"0\" alt=\"Volver\" /></a></td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                        </td>\r\n                        <td width=\"15%\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                    </tr>\r\n                    <tr height=\"35\">\r\n                        <td width=\"100%\" colspan=\"3\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"35\" border=\"0\" alt=\"\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td width=\"15%\">&nbsp;</td>\r\n                        <td>\r\n                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                            <tbody>\r\n                                <tr>\r\n                                    <td>\r\n                                    <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"textoIntro\" style=\"font-family: Verdana, Arial; font-size: 11pt; text-align: justify;\">\r\n                                        <tbody>\r\n                                            <tr>\r\n                                                <td><i><font class=\"capital\" style=\"color: blue; font-family: verdana; font-size: 30px;\">P</font>royecto NUTIAH, Nuevas tecnolog&iacute;as de la Informaci&oacute;n en Antropolog&iacute;a e Historia: Un entorno virtual de trabajo</i>, est&aacute; orientado a introducir nuevos m&eacute;todos docentes que con la ayuda de las nuevas tecnolog&iacute;as de la informaci&oacute;n posibiliten la realizaci&oacute;n de clases pr&aacute;cticas y otras actividades docentes no presenciales. Con este fin se est&aacute; construyendo un prototipo de clases pr&aacute;cticas apoyadas en los materiales del Museo y del Laboratorio.&nbsp;<br />\r\n                                                <br />\r\n                                                <table border=\"0\" cellpadding=\"0\" cellspacing=\"15\" align=\"right\">\r\n                                                    <tbody>\r\n                                                        <tr>\r\n                                                            <td>\r\n                                                            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n                                                                <tbody>\r\n                                                                    <tr>\r\n                                                                        <td><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/plus.gif\" width=\"11\" height=\"11\" border=\"0\" alt=\"\" /></td>\r\n                                                                        <td><a href=\"http://macgalatea.sip.ucm.es/web/publico/control.php?accion=&amp;Ficha=1&amp;id=313\" target=\"blank\"><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/277_1.jpg\" width=\"200\" height=\"138\" border=\"0\" alt=\"Abrir en nueva ventana\" /></a></td>\r\n                                                                        <td><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/plus2.gif\" width=\"11\" height=\"11\" border=\"0\" alt=\"\" /></td>\r\n                                                                    </tr>\r\n                                                                </tbody>\r\n                                                            </table>\r\n                                                            </td>\r\n                                                        </tr>\r\n                                                    </tbody>\r\n                                                </table>\r\n                                                <i><font class=\"capital\" style=\"color: blue; font-family: verdana; font-size: 30px;\">P</font>royecto SIMBA, Sistemas de Informaci&oacute;n Multimedia Basado en lenguajes de marcado y Agentes</i>. Este proyecto tiene como objetivo principal la construcci&oacute;n, mediante tecnolog&iacute;a web, de un sistema distribuido de gesti&oacute;n de informaci&oacute;n multimedia. La arquitectura del sistema est&aacute; pensada para que sobre ella se puedan desarrollar sistemas hipermedia de ense&ntilde;anza y de formaci&oacute;n en el puesto de trabajo.</td>\r\n                                            </tr>\r\n                                            <tr height=\"20\">\r\n                                                <td width=\"100%\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"20\" border=\"0\" alt=\"\" /></td>\r\n                                            </tr>\r\n                                        </tbody>\r\n                                    </table>\r\n                                    </td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"textoIntro\" style=\"font-family: Verdana, Arial; font-size: 11pt; text-align: justify;\">\r\n                            <tbody>\r\n                                <tr>\r\n                                    <td><i><font class=\"capital\" style=\"color: blue; font-family: verdana; font-size: 30px;\">P</font>royecto CHASQUI, Informaci&oacute;n y Comunicaci&oacute;n Digital en Antropolog&iacute;a e Historia</i>, utilizando el prototipo contruido en NUTIAH y las t&eacute;cnicas desarrolladas en SIMBA abarcar&aacute; no solamente los aspectos pedag&oacute;gicos, sino tambi&eacute;n otros m&aacute;s puramente informativos, como la colaboraci&oacute;n entre investigadores y la difusi&oacute;n cultural.</td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                        </td>\r\n                        <td width=\"15%\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr height=\"45\">\r\n                        <td colspan=\"3\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"45\" border=\"0\" alt=\"\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td width=\"15%\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                        <td>\r\n                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\">\r\n                            <tbody>\r\n                                <tr>\r\n                                    <td><a name=\"materiales\"><font class=\"titPagina\" style=\"font-family: Verdana, Arial; font-weight: bold; font-size: 10pt;\">Materiales</font></a></td>\r\n                                </tr>\r\n                                <tr>\r\n                                    <td><img src=\"http://macgalatea.sip.ucm.es/web/images/Raya.jpg\" width=\"400\" height=\"5\" border=\"0\" alt=\"\" /></td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\">\r\n                            <tbody>\r\n                                <tr>\r\n                                    <td><a href=\"http://macgalatea.sip.ucm.es/web/infoProyecto/presentacion.php#inicio\"><img name=\"BVolver2\" src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/Arriba.gif\" width=\"55\" height=\"15\" border=\"0\" alt=\"Volver\" /></a></td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                        </td>\r\n                        <td width=\"15%\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                    </tr>\r\n                    <tr height=\"35\">\r\n                        <td width=\"100%\" colspan=\"3\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"35\" border=\"0\" alt=\"\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td width=\"15%\">&nbsp;</td>\r\n                        <td>\r\n                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"textoIntro\" style=\"font-family: Verdana, Arial; font-size: 11pt; text-align: justify;\">\r\n                            <tbody>\r\n                                <tr>\r\n                                    <td><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/plus.gif\" width=\"11\" height=\"11\" border=\"0\" alt=\"\" /></td>\r\n                                    <td><a href=\"http://macgalatea.sip.ucm.es/web/publico/control.php?accion=&amp;Ficha=1&amp;id=601\" target=\"blank\"><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/592_1.jpg\" width=\"135\" height=\"160\" border=\"0\" alt=\"Abrir en nueva ventana\" /></a></td>\r\n                                    <td><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/plus2.gif\" width=\"11\" height=\"11\" border=\"0\" alt=\"\" /></td>\r\n                                    <td width=\"15\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"15\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                                    <td><font class=\"capital\" style=\"color: blue; font-family: verdana; font-size: 30px;\">E</font>stos materiales proceden de donaciones, excavaciones arqueol&oacute;gicas y trabajos de campo realizados por miembros y colaboradores del Departamento de Historia de Am&eacute;rica II y la mayor parte de ellos se encuentran localizados en su&nbsp;<a href=\"http://macgalatea.sip.ucm.es/web/infoProyecto/museo.php\">Museo Docente Colecciones de Arqueolog&iacute;a y Etnologia de Am&eacute;rica</a>&nbsp;o en el&nbsp;<a href=\"http://macgalatea.sip.ucm.es/web/infoProyecto/laboratorio.php\">Laboratorio de Arqueolog&iacute;a Americana</a>.</td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"textoIntro\" style=\"font-family: Verdana, Arial; font-size: 11pt; text-align: justify;\">\r\n                            <tbody>\r\n                                <tr height=\"15\">\r\n                                    <td colspan=\"3\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"15\" border=\"0\" alt=\"\" /></td>\r\n                                </tr>\r\n                                <tr>\r\n                                    <td><font class=\"capital\" style=\"color: blue; font-family: verdana; font-size: 30px;\">L</font>a infraestructura inform&aacute;tica la aporta el Grupo de Ingeneria del Sofware e Inteligencia Artificial del Departamento de Sistemas Inform&aacute;ticos y Programaci&oacute;n y es patrimonio de la UCM. En su mayor parte se corresponde con el hardaware y software, utilizado y desarrollado para la realizaci&oacute;n de los proyectos&nbsp;<a href=\"http://www.simba.vsf.es/\">Galatea</a>&nbsp;y&nbsp;<a href=\"http://www.simba.vsf.es/\">SIMBA</a>. Desde el punto de vista t&eacute;cnico, la construcci&oacute;n de estos recursos digitales se basa en la utilizaci&oacute;n de&nbsp;<a href=\"http://www.xml.org/\">XML</a>&nbsp;(eXtensible Markup Language) para definir los lenguajes de modelado de las actividades educativas y de representaci&oacute;n de la informaci&oacute;n arqueol&oacute;gica.</td>\r\n                                    <td width=\"15\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"15\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                                    <td><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/plus.gif\" width=\"11\" height=\"11\" border=\"0\" alt=\"\" /></td>\r\n                                    <td><a href=\"http://macgalatea.sip.ucm.es/web/publico/control.php?accion=&amp;Ficha=1&amp;id=1161\" target=\"blank\"><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/071_C02.jpg\" width=\"175\" height=\"146\" border=\"0\" alt=\"Abrir en nueva ventana\" /></a></td>\r\n                                    <td><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/plus2.gif\" width=\"11\" height=\"11\" border=\"0\" alt=\"\" /></td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                        </td>\r\n                    </tr>\r\n                    <tr height=\"20\">\r\n                        <td colspan=\"3\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"20\" border=\"0\" alt=\"\" /></td>\r\n                    </tr>\r\n                </tbody>\r\n            </table>\r\n            </td>\r\n        </tr>\r\n    </tbody>\r\n</table>',100),(3,3,'2',NULL,NULL,100);
/*!40000 ALTER TABLE `contenidos_pagina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permisos`
--

DROP TABLE IF EXISTS `permisos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permisos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idusuario` int(11) DEFAULT NULL,
  `idov` int(11) DEFAULT NULL,
  `tipoPermiso` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permisos`
--

LOCK TABLES `permisos` WRITE;
/*!40000 ALTER TABLE `permisos` DISABLE KEYS */;
/*!40000 ALTER TABLE `permisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mensajes`
--

DROP TABLE IF EXISTS `mensajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mensajes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lang` varchar(255) DEFAULT NULL,
  `atributo` varchar(255) DEFAULT NULL,
  `valor` text,
  `grupo` varchar(255) DEFAULT NULL,
  `formato` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `etiqueta` varchar(255) DEFAULT NULL,
  `orden` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=129 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensajes`
--

LOCK TABLES `mensajes` WRITE;
/*!40000 ALTER TABLE `mensajes` DISABLE KEYS */;
INSERT INTO `mensajes` VALUES (121,'es','datos_titulo','Contenedor de Objetos Digitales de Aprendizaje','Datos del contenedor','largo','cabecera','Título del contenedor',1),(122,'es','datos_descripcion','DEPARTAMENTO DE HISTORIA DE AMÉRICA II\r\n(ANTROPOLOGÍA DE AMÉRICA) Facultad de Geografía e Historia','Datos del sitio web','texto','cabecera','Descripción',2),(123,'es','datos_palabras',' museo virtual, contenedor de objetos virtuales de aprendizaje, repositorio de objetos de aprendizaje,chasqui','Datos del sitio web','texto','cabecera','Palabras clave',3),(124,'es','datos_imagen','../../download/bancorecursos/Cabecera7.jpg','Datos del contenedor','imagen','cabecera','Imagen cabecera',4),(128,'en','datos_imagen',NULL,'Datos del contenedor','imagen','cabecera','Imagen Cabecera',4);
/*!40000 ALTER TABLE `mensajes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paginas`
--

DROP TABLE IF EXISTS `paginas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paginas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) DEFAULT NULL,
  `contenido` text,
  `visible` char(1) DEFAULT NULL,
  `documento` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paginas`
--

LOCK TABLES `paginas` WRITE;
/*!40000 ALTER TABLE `paginas` DISABLE KEYS */;
INSERT INTO `paginas` VALUES (1,'Chasqui',NULL,'S','../../download/bancorecursos/chasqui/portada.html'),(4,'Presentación',NULL,'S','../../download/bancorecursos/chasqui/ChasquiPresentacion.html'),(5,'Laboratorio',NULL,'S','../../download/bancorecursos/chasqui/Laboratorio.html'),(7,'Miembros',NULL,'S','../../download/bancorecursos/chasqui/Miembros.html'),(8,'Museo',NULL,'S','../../download/bancorecursos/chasqui/Museo.html'),(9,'MasMuseo',NULL,'S','../../download/bancorecursos/chasqui/MasMuseo.html'),(10,'Financiación',NULL,'S','../../download/bancorecursos/chasqui/Financiacion.html'),(11,'Proyecto Chinchero',NULL,'S','../../download/bancorecursos/chasqui/ProyectoChinchero.html'),(12,'Proyecto Esmeraldas',NULL,'S','../../download/bancorecursos/chasqui/ProyectoEsmeraldas.html'),(13,'Proyecto Incapirca',NULL,'S','../../download/bancorecursos/chasqui/ProyectoIncapirca.html'),(14,'Proyecto Manabí Central',NULL,'S','../../download/bancorecursos/chasqui/ProyectoManabi.html'),(15,'Proyecto Arqueológico Coclé',NULL,'S','../../download/bancorecursos/chasqui/ProyectoCocle.html');
/*!40000 ALTER TABLE `paginas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `numeric_data`
--

DROP TABLE IF EXISTS `numeric_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `numeric_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idov` int(11) DEFAULT NULL,
  `idseccion` int(11) DEFAULT NULL,
  `value` decimal(30,15) DEFAULT NULL,
  `idrecurso` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `numeric_data`
--

LOCK TABLES `numeric_data` WRITE;
/*!40000 ALTER TABLE `numeric_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `numeric_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `date_data`
--

DROP TABLE IF EXISTS `date_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `date_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idov` int(11) DEFAULT NULL,
  `idseccion` int(11) DEFAULT NULL,
  `value` int(8) DEFAULT NULL,
  `idrecurso` int(11) DEFAULT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `date_data`
--

LOCK TABLES `date_data` WRITE;
/*!40000 ALTER TABLE `date_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `date_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preferencias_presentacion`
--

DROP TABLE IF EXISTS `preferencias_presentacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `preferencias_presentacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `atributo` varchar(255) DEFAULT NULL,
  `valor` text,
  `tipo` varchar(255) DEFAULT NULL,
  `etiqueta` varchar(255) DEFAULT NULL,
  `orden` int(11) DEFAULT NULL,
  `formato` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preferencias_presentacion`
--

LOCK TABLES `preferencias_presentacion` WRITE;
/*!40000 ALTER TABLE `preferencias_presentacion` DISABLE KEYS */;
INSERT INTO `preferencias_presentacion` VALUES (1,'portada_contenido','I','P',NULL,NULL,NULL),(2,'imagen_fondo_global','../../download/bancorecursos/fondoWeb2.jpg','F','Imagen de fondo global',1,'imagen'),(3,'color_fondo',NULL,'F','Color de fondo',2,'color'),(4,'seguridad_web','N',NULL,NULL,NULL,NULL),(5,'extension_archivos','jpg;doc;pdf;docx;html;JPG;DOC;PDF;DOCX;doc;DOC;php',NULL,NULL,NULL,NULL),(6,'numeric_decimal','4',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `preferencias_presentacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log_modificaciones`
--

DROP TABLE IF EXISTS `log_modificaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log_modificaciones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idusuario` int(11) DEFAULT NULL,
  `fechaModificacion` varchar(14) DEFAULT NULL,
  `tipo` varchar(2) DEFAULT NULL,
  `idov` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_modificaciones`
--

LOCK TABLES `log_modificaciones` WRITE;
/*!40000 ALTER TABLE `log_modificaciones` DISABLE KEYS */;
INSERT INTO `log_modificaciones` VALUES (1,NULL,'20130226161502','C',1),(2,NULL,'20130226161511','M',1),(3,NULL,'20130226161819','M',1),(4,NULL,'20130226162102','M',1),(5,NULL,'20130226162854','C',2),(6,NULL,'20130226162901','M',2),(7,NULL,'20130226180917','C',3),(8,NULL,'20130226180923','M',3);
/*!40000 ALTER TABLE `log_modificaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `virtual_object`
--

DROP TABLE IF EXISTS `virtual_object`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `virtual_object` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ispublic` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `virtual_object`
--

LOCK TABLES `virtual_object` WRITE;
/*!40000 ALTER TABLE `virtual_object` DISABLE KEYS */;
/*!40000 ALTER TABLE `virtual_object` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `text_data`
--

DROP TABLE IF EXISTS `text_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `text_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idov` int(11) DEFAULT NULL,
  `idseccion` int(11) DEFAULT NULL,
  `value` text,
  `idrecurso` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `text_data`
--

LOCK TABLES `text_data` WRITE;
/*!40000 ALTER TABLE `text_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `text_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=112 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (11,'Nombre','Nombre','test@test.test','admin','admin','B'),(111,'Nombre','Apellidos','test@test.test','user','user','C'),(1,'Nombre','Apellidos','test@test.test','superadmin','superadmin','A');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `section_data`
--

DROP TABLE IF EXISTS `section_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `section_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idpadre` int(11) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `codigo` varchar(255) DEFAULT NULL,
  `tooltip` varchar(255) DEFAULT NULL,
  `visible` char(1) DEFAULT NULL,
  `orden` int(11) DEFAULT NULL,
  `browseable` char(1) DEFAULT NULL,
  `tipo_valores` varchar(255) DEFAULT NULL,
  `extensible` char(1) DEFAULT NULL,
  `vocabulario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=113 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `section_data`
--

LOCK TABLES `section_data` WRITE;
/*!40000 ALTER TABLE `section_data` DISABLE KEYS */;
INSERT INTO `section_data` VALUES (2,0,'Modelo de MetaDatos','lom','metadatos','S',2,NULL,NULL,'S',0),(3,0,'Modelo de Datos de los Recursos','recursos','recursos','S',3,NULL,NULL,'S',0),(111,1,'Descripción',NULL,'fijo_texto','S',1,NULL,'T',NULL,NULL),(112,1,'Tipo Registro',NULL,'fijo_controlado',NULL,5,NULL,'C',NULL,NULL),(1,0,'Modelo de Datos','datos','datos','S',1,NULL,NULL,'S',0);
/*!40000 ALTER TABLE `section_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `navegacion`
--

DROP TABLE IF EXISTS `navegacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `navegacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `tooltip` varchar(255) DEFAULT NULL,
  `idpadre` int(11) DEFAULT NULL,
  `visible` char(1) DEFAULT NULL,
  `orden` int(11) DEFAULT NULL,
  `tipo_contenido` varchar(255) DEFAULT NULL,
  `idpagina` int(11) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `nombreseo` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `contenido` text,
  `url` varchar(255) DEFAULT NULL,
  `tiene_contenido` varchar(255) DEFAULT NULL,
  `protocolo` varchar(255) DEFAULT NULL,
  `ventanaexterna` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `navegacion`
--

LOCK TABLES `navegacion` WRITE;
/*!40000 ALTER TABLE `navegacion` DISABLE KEYS */;
INSERT INTO `navegacion` VALUES (4,'Mantenimiento',NULL,0,'N',7,'M',NULL,'I','mantenimiento',NULL,NULL,NULL,'S',NULL,'N'),(2,'Acceso clasificado a la Base de Datos',NULL,8,'S',5,'C',NULL,'I','acceso_clasificado_a_la_base_de_datos',NULL,NULL,NULL,'S',NULL,'N'),(3,'Presentación',NULL,6,'S',2,'P',4,'I','presentación',NULL,'<p>&nbsp;dasdsad</p>',NULL,'S',NULL,'N'),(5,'Laboratorio','Laboratorio',9,'S',7,'P',5,'I','laboratorio',NULL,NULL,NULL,'S',NULL,'N'),(6,'Información del Proyecto',NULL,0,'S',2,'H',4,'I','información_del_proyecto',NULL,NULL,NULL,'S',NULL,'N'),(7,'Busqueda',NULL,8,'S',8,'B',NULL,'I','busqueda',NULL,NULL,NULL,'S',NULL,'N'),(8,'Acceso clasificado',NULL,0,'S',6,'H',NULL,'I','acceso_clasificado',NULL,NULL,NULL,'S',NULL,'N'),(9,'Recursos','Recursos',6,'S',4,'H',NULL,'I','recursos',NULL,NULL,NULL,'S',NULL,'N'),(10,'Miembros','Miembros',6,'S',3,'P',7,'I','miembros',NULL,NULL,NULL,'S',NULL,'N'),(11,'Museo','Museo',9,'S',1009,'P',8,'I','museo',NULL,NULL,NULL,'S',NULL,'N'),(12,'Financiación','Financiación',6,'S',1010,'P',10,'I','financiación',NULL,NULL,NULL,'S',NULL,'N'),(13,'Pr. Chinchero','Pr. Chinchero',9,'S',1011,'P',11,'I','pr._chinchero',NULL,NULL,NULL,'S',NULL,'N'),(14,'Pr. Esmeraldas','Pr. Esmeraldas',9,'S',1012,'P',12,'I','pr._esmeraldas',NULL,NULL,NULL,'S',NULL,'N'),(15,'Pr. Incapirca','Pr. Incapirca',9,'S',1013,'P',13,'I','pr._incapirca',NULL,NULL,NULL,'S',NULL,'N'),(16,'Pr. Manabí Central','Pr. Manabí Central',9,'S',1014,'P',14,'I','pr._manabí_central',NULL,NULL,NULL,'S',NULL,'N'),(17,'Pr. Coclé','Pr. Coclé',9,'S',1015,'P',15,'I','pr._coclé',NULL,NULL,NULL,'S',NULL,'N');
/*!40000 ALTER TABLE `navegacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resources`
--

DROP TABLE IF EXISTS `resources`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resources` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idov` int(11) DEFAULT NULL,
  `ordinal` int(11) DEFAULT NULL,
  `visible` char(1) DEFAULT NULL,
  `iconoov` char(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `idov_refered` int(11) DEFAULT NULL,
  `idresource_refered` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resources`
--

LOCK TABLES `resources` WRITE;
/*!40000 ALTER TABLE `resources` DISABLE KEYS */;
/*!40000 ALTER TABLE `resources` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'chasquiodaV2'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-02-27 18:59:50
CREATE DATABASE  IF NOT EXISTS `chasquiodaV3` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `chasquiodaV3`;
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: chasquiodaV3
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.10.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `controlled_data`
--

DROP TABLE IF EXISTS `controlled_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `controlled_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idov` int(11) DEFAULT NULL,
  `idseccion` int(11) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `idrecurso` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `controlled_data`
--

LOCK TABLES `controlled_data` WRITE;
/*!40000 ALTER TABLE `controlled_data` DISABLE KEYS */;
INSERT INTO `controlled_data` VALUES (4,1,112,NULL,NULL),(6,2,112,NULL,NULL),(8,3,112,NULL,NULL);
/*!40000 ALTER TABLE `controlled_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contenidos_pagina`
--

DROP TABLE IF EXISTS `contenidos_pagina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contenidos_pagina` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idpagina` int(11) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `contenido` text,
  `orden` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contenidos_pagina`
--

LOCK TABLES `contenidos_pagina` WRITE;
/*!40000 ALTER TABLE `contenidos_pagina` DISABLE KEYS */;
INSERT INTO `contenidos_pagina` VALUES (2,2,'2',NULL,'<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n    <tbody>\r\n        <tr>\r\n            <td width=\"100%\">\r\n            <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n                <tbody>\r\n                    <tr height=\"25\">\r\n                        <td colspan=\"3\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"25\" border=\"0\" alt=\"\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td width=\"15%\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                        <td>\r\n                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\">\r\n                            <tbody>\r\n                                <tr height=\"35\">\r\n                                    <td><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"35\" border=\"0\" alt=\"\" /></td>\r\n                                </tr>\r\n                                <tr>\r\n                                    <td><a name=\"presentacion\"><font class=\"titPagina\" style=\"font-family: Verdana, Arial; font-weight: bold; font-size: 10pt;\">Presentaci&oacute;n</font></a></td>\r\n                                </tr>\r\n                                <tr>\r\n                                    <td><img src=\"http://macgalatea.sip.ucm.es/web/images/Raya.jpg\" width=\"400\" height=\"5\" border=\"0\" alt=\"\" /></td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                        </td>\r\n                        <td width=\"15%\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                    </tr>\r\n                    <tr height=\"10\">\r\n                        <td width=\"15%\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                        <td><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"600\" height=\"10\" border=\"0\" alt=\"\" /></td>\r\n                        <td width=\"15%\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td width=\"15%\">&nbsp;</td>\r\n                        <td>\r\n                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"textoIntro\" style=\"font-family: Verdana, Arial; font-size: 11pt; text-align: justify;\">\r\n                            <tbody>\r\n                                <tr>\r\n                                    <td><font class=\"capital\" style=\"color: blue; font-family: verdana; font-size: 30px;\">E</font>l&nbsp;<a href=\"http://www.ucm.es/info/america2/\">Departamento de Historia de Am&eacute;rica II (Antropolog&iacute;a de Am&eacute;rica)</a>&nbsp;de la Facultad de Geograf&iacute;a e Historia de la UCM y el Grupo de Ingenier&iacute;a del Software e Inteligencia Artificial del&nbsp;<a href=\"http://www.ucm.es/info/dsip/\">Departamento de Sistemas Inform&aacute;ticos y Programaci&oacute;n</a>&nbsp;de la Facultad de Inform&aacute;tica de la UCM est&aacute;n colaborando en la ejecuci&oacute;n de diversos&nbsp;<b><a href=\"http://macgalatea.sip.ucm.es/web/infoProyecto/presentacion.php#proyectos\">proyectos de investigaci&oacute;n</a></b>&nbsp;cuya finalidad &uacute;ltima es convertir en recursos educativos digitales los&nbsp;<b><a href=\"http://macgalatea.sip.ucm.es/web/infoProyecto/presentacion.php#materiales\">materiales arqueol&oacute;gicos y etnogr&aacute;ficos</a></b>&nbsp;del primero de ellos, de tal manera que sirvan de apoyo a la docencia, al trabajo de los investigadores y a la creaci&oacute;n de puntos de informaci&oacute;n (sitios Web) de contenido cultural.</td>\r\n                                    <td width=\"15\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"15\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                                    <td>\r\n                                    <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                                        <tbody>\r\n                                            <tr>\r\n                                                <td><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/plus.gif\" width=\"11\" height=\"11\" border=\"0\" alt=\"\" /></td>\r\n                                                <td><a href=\"http://macgalatea.sip.ucm.es/web/publico/control.php?accion=&amp;Ficha=1&amp;id=1160\" target=\"blank\"><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/069_005_9.jpg\" width=\"135\" height=\"180\" border=\"0\" alt=\"Abrir en nueva ventana\" /></a></td>\r\n                                                <td><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/plus2.gif\" width=\"11\" height=\"11\" border=\"0\" alt=\"\" /></td>\r\n                                            </tr>\r\n                                        </tbody>\r\n                                    </table>\r\n                                    </td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                        </td>\r\n                        <td width=\"15%\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr height=\"45\">\r\n                        <td colspan=\"3\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"45\" border=\"0\" alt=\"\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td width=\"15%\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                        <td>\r\n                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\">\r\n                            <tbody>\r\n                                <tr>\r\n                                    <td><a name=\"Proyectos\"><font class=\"titPagina\" style=\"font-family: Verdana, Arial; font-weight: bold; font-size: 10pt;\">Proyectos</font></a></td>\r\n                                </tr>\r\n                                <tr>\r\n                                    <td><img src=\"http://macgalatea.sip.ucm.es/web/images/Raya.jpg\" width=\"400\" height=\"5\" border=\"0\" alt=\"\" /></td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\">\r\n                            <tbody>\r\n                                <tr>\r\n                                    <td><a href=\"http://macgalatea.sip.ucm.es/web/infoProyecto/presentacion.php#inicio\"><img name=\"BVolver\" src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/Arriba.gif\" width=\"55\" height=\"15\" border=\"0\" alt=\"Volver\" /></a></td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                        </td>\r\n                        <td width=\"15%\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                    </tr>\r\n                    <tr height=\"35\">\r\n                        <td width=\"100%\" colspan=\"3\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"35\" border=\"0\" alt=\"\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td width=\"15%\">&nbsp;</td>\r\n                        <td>\r\n                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                            <tbody>\r\n                                <tr>\r\n                                    <td>\r\n                                    <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"textoIntro\" style=\"font-family: Verdana, Arial; font-size: 11pt; text-align: justify;\">\r\n                                        <tbody>\r\n                                            <tr>\r\n                                                <td><i><font class=\"capital\" style=\"color: blue; font-family: verdana; font-size: 30px;\">P</font>royecto NUTIAH, Nuevas tecnolog&iacute;as de la Informaci&oacute;n en Antropolog&iacute;a e Historia: Un entorno virtual de trabajo</i>, est&aacute; orientado a introducir nuevos m&eacute;todos docentes que con la ayuda de las nuevas tecnolog&iacute;as de la informaci&oacute;n posibiliten la realizaci&oacute;n de clases pr&aacute;cticas y otras actividades docentes no presenciales. Con este fin se est&aacute; construyendo un prototipo de clases pr&aacute;cticas apoyadas en los materiales del Museo y del Laboratorio.&nbsp;<br />\r\n                                                <br />\r\n                                                <table border=\"0\" cellpadding=\"0\" cellspacing=\"15\" align=\"right\">\r\n                                                    <tbody>\r\n                                                        <tr>\r\n                                                            <td>\r\n                                                            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n                                                                <tbody>\r\n                                                                    <tr>\r\n                                                                        <td><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/plus.gif\" width=\"11\" height=\"11\" border=\"0\" alt=\"\" /></td>\r\n                                                                        <td><a href=\"http://macgalatea.sip.ucm.es/web/publico/control.php?accion=&amp;Ficha=1&amp;id=313\" target=\"blank\"><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/277_1.jpg\" width=\"200\" height=\"138\" border=\"0\" alt=\"Abrir en nueva ventana\" /></a></td>\r\n                                                                        <td><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/plus2.gif\" width=\"11\" height=\"11\" border=\"0\" alt=\"\" /></td>\r\n                                                                    </tr>\r\n                                                                </tbody>\r\n                                                            </table>\r\n                                                            </td>\r\n                                                        </tr>\r\n                                                    </tbody>\r\n                                                </table>\r\n                                                <i><font class=\"capital\" style=\"color: blue; font-family: verdana; font-size: 30px;\">P</font>royecto SIMBA, Sistemas de Informaci&oacute;n Multimedia Basado en lenguajes de marcado y Agentes</i>. Este proyecto tiene como objetivo principal la construcci&oacute;n, mediante tecnolog&iacute;a web, de un sistema distribuido de gesti&oacute;n de informaci&oacute;n multimedia. La arquitectura del sistema est&aacute; pensada para que sobre ella se puedan desarrollar sistemas hipermedia de ense&ntilde;anza y de formaci&oacute;n en el puesto de trabajo.</td>\r\n                                            </tr>\r\n                                            <tr height=\"20\">\r\n                                                <td width=\"100%\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"20\" border=\"0\" alt=\"\" /></td>\r\n                                            </tr>\r\n                                        </tbody>\r\n                                    </table>\r\n                                    </td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"textoIntro\" style=\"font-family: Verdana, Arial; font-size: 11pt; text-align: justify;\">\r\n                            <tbody>\r\n                                <tr>\r\n                                    <td><i><font class=\"capital\" style=\"color: blue; font-family: verdana; font-size: 30px;\">P</font>royecto CHASQUI, Informaci&oacute;n y Comunicaci&oacute;n Digital en Antropolog&iacute;a e Historia</i>, utilizando el prototipo contruido en NUTIAH y las t&eacute;cnicas desarrolladas en SIMBA abarcar&aacute; no solamente los aspectos pedag&oacute;gicos, sino tambi&eacute;n otros m&aacute;s puramente informativos, como la colaboraci&oacute;n entre investigadores y la difusi&oacute;n cultural.</td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                        </td>\r\n                        <td width=\"15%\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr height=\"45\">\r\n                        <td colspan=\"3\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"45\" border=\"0\" alt=\"\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td width=\"15%\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                        <td>\r\n                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\">\r\n                            <tbody>\r\n                                <tr>\r\n                                    <td><a name=\"materiales\"><font class=\"titPagina\" style=\"font-family: Verdana, Arial; font-weight: bold; font-size: 10pt;\">Materiales</font></a></td>\r\n                                </tr>\r\n                                <tr>\r\n                                    <td><img src=\"http://macgalatea.sip.ucm.es/web/images/Raya.jpg\" width=\"400\" height=\"5\" border=\"0\" alt=\"\" /></td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\">\r\n                            <tbody>\r\n                                <tr>\r\n                                    <td><a href=\"http://macgalatea.sip.ucm.es/web/infoProyecto/presentacion.php#inicio\"><img name=\"BVolver2\" src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/Arriba.gif\" width=\"55\" height=\"15\" border=\"0\" alt=\"Volver\" /></a></td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                        </td>\r\n                        <td width=\"15%\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                    </tr>\r\n                    <tr height=\"35\">\r\n                        <td width=\"100%\" colspan=\"3\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"35\" border=\"0\" alt=\"\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td width=\"15%\">&nbsp;</td>\r\n                        <td>\r\n                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"textoIntro\" style=\"font-family: Verdana, Arial; font-size: 11pt; text-align: justify;\">\r\n                            <tbody>\r\n                                <tr>\r\n                                    <td><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/plus.gif\" width=\"11\" height=\"11\" border=\"0\" alt=\"\" /></td>\r\n                                    <td><a href=\"http://macgalatea.sip.ucm.es/web/publico/control.php?accion=&amp;Ficha=1&amp;id=601\" target=\"blank\"><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/592_1.jpg\" width=\"135\" height=\"160\" border=\"0\" alt=\"Abrir en nueva ventana\" /></a></td>\r\n                                    <td><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/plus2.gif\" width=\"11\" height=\"11\" border=\"0\" alt=\"\" /></td>\r\n                                    <td width=\"15\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"15\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                                    <td><font class=\"capital\" style=\"color: blue; font-family: verdana; font-size: 30px;\">E</font>stos materiales proceden de donaciones, excavaciones arqueol&oacute;gicas y trabajos de campo realizados por miembros y colaboradores del Departamento de Historia de Am&eacute;rica II y la mayor parte de ellos se encuentran localizados en su&nbsp;<a href=\"http://macgalatea.sip.ucm.es/web/infoProyecto/museo.php\">Museo Docente Colecciones de Arqueolog&iacute;a y Etnologia de Am&eacute;rica</a>&nbsp;o en el&nbsp;<a href=\"http://macgalatea.sip.ucm.es/web/infoProyecto/laboratorio.php\">Laboratorio de Arqueolog&iacute;a Americana</a>.</td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"textoIntro\" style=\"font-family: Verdana, Arial; font-size: 11pt; text-align: justify;\">\r\n                            <tbody>\r\n                                <tr height=\"15\">\r\n                                    <td colspan=\"3\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"15\" border=\"0\" alt=\"\" /></td>\r\n                                </tr>\r\n                                <tr>\r\n                                    <td><font class=\"capital\" style=\"color: blue; font-family: verdana; font-size: 30px;\">L</font>a infraestructura inform&aacute;tica la aporta el Grupo de Ingeneria del Sofware e Inteligencia Artificial del Departamento de Sistemas Inform&aacute;ticos y Programaci&oacute;n y es patrimonio de la UCM. En su mayor parte se corresponde con el hardaware y software, utilizado y desarrollado para la realizaci&oacute;n de los proyectos&nbsp;<a href=\"http://www.simba.vsf.es/\">Galatea</a>&nbsp;y&nbsp;<a href=\"http://www.simba.vsf.es/\">SIMBA</a>. Desde el punto de vista t&eacute;cnico, la construcci&oacute;n de estos recursos digitales se basa en la utilizaci&oacute;n de&nbsp;<a href=\"http://www.xml.org/\">XML</a>&nbsp;(eXtensible Markup Language) para definir los lenguajes de modelado de las actividades educativas y de representaci&oacute;n de la informaci&oacute;n arqueol&oacute;gica.</td>\r\n                                    <td width=\"15\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"15\" height=\"1\" border=\"0\" alt=\"\" /></td>\r\n                                    <td><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/plus.gif\" width=\"11\" height=\"11\" border=\"0\" alt=\"\" /></td>\r\n                                    <td><a href=\"http://macgalatea.sip.ucm.es/web/publico/control.php?accion=&amp;Ficha=1&amp;id=1161\" target=\"blank\"><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/071_C02.jpg\" width=\"175\" height=\"146\" border=\"0\" alt=\"Abrir en nueva ventana\" /></a></td>\r\n                                    <td><img src=\"http://macgalatea.sip.ucm.es/web/infoProyecto/images/introduccion/plus2.gif\" width=\"11\" height=\"11\" border=\"0\" alt=\"\" /></td>\r\n                                </tr>\r\n                            </tbody>\r\n                        </table>\r\n                        </td>\r\n                    </tr>\r\n                    <tr height=\"20\">\r\n                        <td colspan=\"3\"><img src=\"http://macgalatea.sip.ucm.es/web/images/Blanco.gif\" width=\"1\" height=\"20\" border=\"0\" alt=\"\" /></td>\r\n                    </tr>\r\n                </tbody>\r\n            </table>\r\n            </td>\r\n        </tr>\r\n    </tbody>\r\n</table>',100),(3,3,'2',NULL,NULL,100);
/*!40000 ALTER TABLE `contenidos_pagina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permisos`
--

DROP TABLE IF EXISTS `permisos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permisos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idusuario` int(11) DEFAULT NULL,
  `idov` int(11) DEFAULT NULL,
  `tipoPermiso` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permisos`
--

LOCK TABLES `permisos` WRITE;
/*!40000 ALTER TABLE `permisos` DISABLE KEYS */;
/*!40000 ALTER TABLE `permisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mensajes`
--

DROP TABLE IF EXISTS `mensajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mensajes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lang` varchar(255) DEFAULT NULL,
  `atributo` varchar(255) DEFAULT NULL,
  `valor` text,
  `grupo` varchar(255) DEFAULT NULL,
  `formato` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `etiqueta` varchar(255) DEFAULT NULL,
  `orden` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=129 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensajes`
--

LOCK TABLES `mensajes` WRITE;
/*!40000 ALTER TABLE `mensajes` DISABLE KEYS */;
INSERT INTO `mensajes` VALUES (121,'es','datos_titulo','Contenedor de Objetos Digitales de Aprendizaje','Datos del contenedor','largo','cabecera','Título del contenedor',1),(122,'es','datos_descripcion','DEPARTAMENTO DE HISTORIA DE AMÉRICA II\r\n(ANTROPOLOGÍA DE AMÉRICA) Facultad de Geografía e Historia','Datos del sitio web','texto','cabecera','Descripción',2),(123,'es','datos_palabras',' museo virtual, contenedor de objetos virtuales de aprendizaje, repositorio de objetos de aprendizaje,chasqui','Datos del sitio web','texto','cabecera','Palabras clave',3),(124,'es','datos_imagen','../../download/bancorecursos/Cabecera7.jpg','Datos del contenedor','imagen','cabecera','Imagen cabecera',4),(128,'en','datos_imagen',NULL,'Datos del contenedor','imagen','cabecera','Imagen Cabecera',4);
/*!40000 ALTER TABLE `mensajes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paginas`
--

DROP TABLE IF EXISTS `paginas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paginas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) DEFAULT NULL,
  `contenido` text,
  `visible` char(1) DEFAULT NULL,
  `documento` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paginas`
--

LOCK TABLES `paginas` WRITE;
/*!40000 ALTER TABLE `paginas` DISABLE KEYS */;
INSERT INTO `paginas` VALUES (1,'Chasqui',NULL,'S','../../download/bancorecursos/chasqui/portada.html'),(4,'Presentación',NULL,'S','../../download/bancorecursos/chasqui/ChasquiPresentacion.html'),(5,'Laboratorio',NULL,'S','../../download/bancorecursos/chasqui/Laboratorio.html'),(7,'Miembros',NULL,'S','../../download/bancorecursos/chasqui/Miembros.html'),(8,'Museo',NULL,'S','../../download/bancorecursos/chasqui/Museo.html'),(9,'MasMuseo',NULL,'S','../../download/bancorecursos/chasqui/MasMuseo.html'),(10,'Financiación',NULL,'S','../../download/bancorecursos/chasqui/Financiacion.html'),(11,'Proyecto Chinchero',NULL,'S','../../download/bancorecursos/chasqui/ProyectoChinchero.html'),(12,'Proyecto Esmeraldas',NULL,'S','../../download/bancorecursos/chasqui/ProyectoEsmeraldas.html'),(13,'Proyecto Incapirca',NULL,'S','../../download/bancorecursos/chasqui/ProyectoIncapirca.html'),(14,'Proyecto Manabí Central',NULL,'S','../../download/bancorecursos/chasqui/ProyectoManabi.html'),(15,'Proyecto Arqueológico Coclé',NULL,'S','../../download/bancorecursos/chasqui/ProyectoCocle.html');
/*!40000 ALTER TABLE `paginas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `numeric_data`
--

DROP TABLE IF EXISTS `numeric_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `numeric_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idov` int(11) DEFAULT NULL,
  `idseccion` int(11) DEFAULT NULL,
  `value` decimal(30,15) DEFAULT NULL,
  `idrecurso` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `numeric_data`
--

LOCK TABLES `numeric_data` WRITE;
/*!40000 ALTER TABLE `numeric_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `numeric_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `date_data`
--

DROP TABLE IF EXISTS `date_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `date_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idov` int(11) DEFAULT NULL,
  `idseccion` int(11) DEFAULT NULL,
  `value` int(8) DEFAULT NULL,
  `idrecurso` int(11) DEFAULT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `date_data`
--

LOCK TABLES `date_data` WRITE;
/*!40000 ALTER TABLE `date_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `date_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preferencias_presentacion`
--

DROP TABLE IF EXISTS `preferencias_presentacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `preferencias_presentacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `atributo` varchar(255) DEFAULT NULL,
  `valor` text,
  `tipo` varchar(255) DEFAULT NULL,
  `etiqueta` varchar(255) DEFAULT NULL,
  `orden` int(11) DEFAULT NULL,
  `formato` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preferencias_presentacion`
--

LOCK TABLES `preferencias_presentacion` WRITE;
/*!40000 ALTER TABLE `preferencias_presentacion` DISABLE KEYS */;
INSERT INTO `preferencias_presentacion` VALUES (1,'portada_contenido','I','P',NULL,NULL,NULL),(2,'imagen_fondo_global','../../download/bancorecursos/fondoWeb2.jpg','F','Imagen de fondo global',1,'imagen'),(3,'color_fondo',NULL,'F','Color de fondo',2,'color'),(4,'seguridad_web','N',NULL,NULL,NULL,NULL),(5,'extension_archivos','jpg;doc;pdf;docx;html;JPG;DOC;PDF;DOCX;doc;DOC;php',NULL,NULL,NULL,NULL),(6,'numeric_decimal','4',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `preferencias_presentacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log_modificaciones`
--

DROP TABLE IF EXISTS `log_modificaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log_modificaciones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idusuario` int(11) DEFAULT NULL,
  `fechaModificacion` varchar(14) DEFAULT NULL,
  `tipo` varchar(2) DEFAULT NULL,
  `idov` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_modificaciones`
--

LOCK TABLES `log_modificaciones` WRITE;
/*!40000 ALTER TABLE `log_modificaciones` DISABLE KEYS */;
INSERT INTO `log_modificaciones` VALUES (1,NULL,'20130226161502','C',1),(2,NULL,'20130226161511','M',1),(3,NULL,'20130226161819','M',1),(4,NULL,'20130226162102','M',1),(5,NULL,'20130226162854','C',2),(6,NULL,'20130226162901','M',2),(7,NULL,'20130226180917','C',3),(8,NULL,'20130226180923','M',3);
/*!40000 ALTER TABLE `log_modificaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `virtual_object`
--

DROP TABLE IF EXISTS `virtual_object`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `virtual_object` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ispublic` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `virtual_object`
--

LOCK TABLES `virtual_object` WRITE;
/*!40000 ALTER TABLE `virtual_object` DISABLE KEYS */;
/*!40000 ALTER TABLE `virtual_object` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `text_data`
--

DROP TABLE IF EXISTS `text_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `text_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idov` int(11) DEFAULT NULL,
  `idseccion` int(11) DEFAULT NULL,
  `value` text,
  `idrecurso` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `text_data`
--

LOCK TABLES `text_data` WRITE;
/*!40000 ALTER TABLE `text_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `text_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=112 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (11,'Nombre','Nombre','test@test.test','admin','admin','B'),(111,'Nombre','Apellidos','test@test.test','user','user','C'),(1,'Nombre','Apellidos','test@test.test','superadmin','superadmin','A');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `section_data`
--

DROP TABLE IF EXISTS `section_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `section_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idpadre` int(11) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `codigo` varchar(255) DEFAULT NULL,
  `tooltip` varchar(255) DEFAULT NULL,
  `visible` char(1) DEFAULT NULL,
  `orden` int(11) DEFAULT NULL,
  `browseable` char(1) DEFAULT NULL,
  `tipo_valores` varchar(255) DEFAULT NULL,
  `extensible` char(1) DEFAULT NULL,
  `vocabulario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=113 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `section_data`
--

LOCK TABLES `section_data` WRITE;
/*!40000 ALTER TABLE `section_data` DISABLE KEYS */;
INSERT INTO `section_data` VALUES (2,0,'Modelo de MetaDatos','lom','metadatos','S',2,NULL,NULL,'S',0),(3,0,'Modelo de Datos de los Recursos','recursos','recursos','S',3,NULL,NULL,'S',0),(111,1,'Descripción',NULL,'fijo_texto','S',1,NULL,'T',NULL,NULL),(112,1,'Tipo Registro',NULL,'fijo_controlado',NULL,5,NULL,'C',NULL,NULL),(1,0,'Modelo de Datos','datos','datos','S',1,NULL,NULL,'S',0);
/*!40000 ALTER TABLE `section_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `navegacion`
--

DROP TABLE IF EXISTS `navegacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `navegacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `tooltip` varchar(255) DEFAULT NULL,
  `idpadre` int(11) DEFAULT NULL,
  `visible` char(1) DEFAULT NULL,
  `orden` int(11) DEFAULT NULL,
  `tipo_contenido` varchar(255) DEFAULT NULL,
  `idpagina` int(11) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `nombreseo` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `contenido` text,
  `url` varchar(255) DEFAULT NULL,
  `tiene_contenido` varchar(255) DEFAULT NULL,
  `protocolo` varchar(255) DEFAULT NULL,
  `ventanaexterna` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `navegacion`
--

LOCK TABLES `navegacion` WRITE;
/*!40000 ALTER TABLE `navegacion` DISABLE KEYS */;
INSERT INTO `navegacion` VALUES (4,'Mantenimiento',NULL,0,'N',7,'M',NULL,'I','mantenimiento',NULL,NULL,NULL,'S',NULL,'N'),(2,'Acceso clasificado a la Base de Datos',NULL,8,'S',5,'C',NULL,'I','acceso_clasificado_a_la_base_de_datos',NULL,NULL,NULL,'S',NULL,'N'),(3,'Presentación',NULL,6,'S',2,'P',4,'I','presentación',NULL,'<p>&nbsp;dasdsad</p>',NULL,'S',NULL,'N'),(5,'Laboratorio','Laboratorio',9,'S',7,'P',5,'I','laboratorio',NULL,NULL,NULL,'S',NULL,'N'),(6,'Información del Proyecto',NULL,0,'S',2,'H',4,'I','información_del_proyecto',NULL,NULL,NULL,'S',NULL,'N'),(7,'Busqueda',NULL,8,'S',8,'B',NULL,'I','busqueda',NULL,NULL,NULL,'S',NULL,'N'),(8,'Acceso clasificado',NULL,0,'S',6,'H',NULL,'I','acceso_clasificado',NULL,NULL,NULL,'S',NULL,'N'),(9,'Recursos','Recursos',6,'S',4,'H',NULL,'I','recursos',NULL,NULL,NULL,'S',NULL,'N'),(10,'Miembros','Miembros',6,'S',3,'P',7,'I','miembros',NULL,NULL,NULL,'S',NULL,'N'),(11,'Museo','Museo',9,'S',1009,'P',8,'I','museo',NULL,NULL,NULL,'S',NULL,'N'),(12,'Financiación','Financiación',6,'S',1010,'P',10,'I','financiación',NULL,NULL,NULL,'S',NULL,'N'),(13,'Pr. Chinchero','Pr. Chinchero',9,'S',1011,'P',11,'I','pr._chinchero',NULL,NULL,NULL,'S',NULL,'N'),(14,'Pr. Esmeraldas','Pr. Esmeraldas',9,'S',1012,'P',12,'I','pr._esmeraldas',NULL,NULL,NULL,'S',NULL,'N'),(15,'Pr. Incapirca','Pr. Incapirca',9,'S',1013,'P',13,'I','pr._incapirca',NULL,NULL,NULL,'S',NULL,'N'),(16,'Pr. Manabí Central','Pr. Manabí Central',9,'S',1014,'P',14,'I','pr._manabí_central',NULL,NULL,NULL,'S',NULL,'N'),(17,'Pr. Coclé','Pr. Coclé',9,'S',1015,'P',15,'I','pr._coclé',NULL,NULL,NULL,'S',NULL,'N');
/*!40000 ALTER TABLE `navegacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resources`
--

DROP TABLE IF EXISTS `resources`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resources` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idov` int(11) DEFAULT NULL,
  `ordinal` int(11) DEFAULT NULL,
  `visible` char(1) DEFAULT NULL,
  `iconoov` char(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `idov_refered` int(11) DEFAULT NULL,
  `idresource_refered` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resources`
--

LOCK TABLES `resources` WRITE;
/*!40000 ALTER TABLE `resources` DISABLE KEYS */;
/*!40000 ALTER TABLE `resources` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'chasquiodaV3'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-02-27 18:59:50
