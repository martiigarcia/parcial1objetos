-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-05-2021 a las 14:07:05
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_parcial_garcia`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registro_de_ventas`
--

CREATE TABLE `registro_de_ventas` (
  `id` int(11) NOT NULL,
  `fecha_de_carga` timestamp NOT NULL DEFAULT current_timestamp(),
  `litros_cargados` double NOT NULL,
  `monto_abonado` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `registro_de_ventas`
--

INSERT INTO `registro_de_ventas` (`id`, `fecha_de_carga`, `litros_cargados`, `monto_abonado`) VALUES
(1, '2021-05-08 04:08:14', 20, 1584),
(2, '2021-05-08 06:19:05', 20, 1800),
(3, '2021-05-08 06:20:02', 20, 1800),
(4, '2021-05-08 06:25:30', 20, 1400),
(5, '2021-05-08 06:26:15', 20, 1584),
(6, '2021-05-08 12:04:40', 20, 1330);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `registro_de_ventas`
--
ALTER TABLE `registro_de_ventas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `registro_de_ventas`
--
ALTER TABLE `registro_de_ventas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
