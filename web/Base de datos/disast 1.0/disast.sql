-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-05-2013 a las 17:12:13
-- Versión del servidor: 5.5.27
-- Versión de PHP: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `disast`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ambiental`
--

CREATE TABLE IF NOT EXISTS `ambiental` (
  `id_numero` int(11) NOT NULL AUTO_INCREMENT,
  `cod_ambiente` int(11) NOT NULL,
  `id_usuarios` int(11) NOT NULL,
  `id_proceso` int(11) NOT NULL,
  `actividad` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecha_de_ingreso` date NOT NULL,
  `id_aspecto` int(11) NOT NULL,
  `descripcion_del_aspecto` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `id_impacto` int(11) NOT NULL,
  `descripcion_del_impacto` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `legislacion` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cumple_legislacion` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `naturaleza` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `idextencion` int(11) NOT NULL,
  `idpersistencia` int(11) NOT NULL,
  `idsinergia` int(11) NOT NULL,
  `idefecto` int(11) NOT NULL,
  `idrecuperabilidad` int(11) NOT NULL,
  `idintensidad` int(11) NOT NULL,
  `idmomento` int(11) NOT NULL,
  `idreversibilidad` int(11) NOT NULL,
  `idacumulacion` int(11) NOT NULL,
  `idperiodicidad` int(11) NOT NULL,
  `importancia` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `clasificacion` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `observacion` text COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_numero`),
  KEY `id_usuarios` (`id_usuarios`),
  KEY `id_proceso` (`id_proceso`),
  KEY `id_aspecto` (`id_aspecto`),
  KEY `id_impacto` (`id_impacto`),
  KEY `cod_ambiente` (`cod_ambiente`),
  KEY `idextencion` (`idextencion`),
  KEY `idpersistencia` (`idpersistencia`),
  KEY `idsinergia` (`idsinergia`),
  KEY `idefecto` (`idefecto`),
  KEY `idrecuperabilidad` (`idrecuperabilidad`),
  KEY `idintensidad` (`idintensidad`),
  KEY `idmomento` (`idmomento`),
  KEY `idreversibilidad` (`idreversibilidad`),
  KEY `idacumulacion` (`idacumulacion`),
  KEY `idperiodicidad` (`idperiodicidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `id_usuarios` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nickname` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `clave` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `celular` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tipo` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `foto_perfil` varchar(800) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_usuarios`),
  KEY `id_usuarios` (`id_usuarios`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuarios`, `nombres`, `nickname`, `clave`, `celular`, `email`, `tipo`, `foto_perfil`) VALUES
(1, 'Fabian Marin Monsalve', 'ambiental', '12345', '22222222', 'fmarin@hotmail.com', 'Ambientalito', 'Fondo de escritorio.jpg'),
(2, 'Luz ', 'segurita', '12345', '3113170640', '12345@hotmail.com', 'Segurita', 'IMG198-1.jpg');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
