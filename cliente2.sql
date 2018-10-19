-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 19-Out-2018 às 20:17
-- Versão do servidor: 10.1.31-MariaDB
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `nexti`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente2`
--

CREATE TABLE `cliente2` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `saldo` decimal(10,0) NOT NULL,
  `d_data` text NOT NULL,
  `web` decimal(1,0) DEFAULT NULL,
  `app` decimal(1,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cliente2`
--

INSERT INTO `cliente2` (`id`, `nome`, `saldo`, `d_data`, `web`, `app`) VALUES
(1, 'NexTI', '1555', 'Fri Oct 19 14:56:29 BRT 2018', NULL, NULL),
(20, 'Franklin', '5', 'Thu Oct 18 16:03:22 BRT 2018', NULL, '1'),
(21, 'FRANKLIN RODRIGO', '888', 'Thu Oct 18 16:28:00 BRT 2018', NULL, '1'),
(22, 'raful silva', '-867', '05/48/4444', NULL, NULL),
(23, 'asmda123123', '123', '2018-10-18 22:20:49', '1', NULL),
(25, 'Novo Cliente sem Dedo', '99999', 'Fri Oct 19 15:16:31 BRT 2018', NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cliente2`
--
ALTER TABLE `cliente2`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cliente2`
--
ALTER TABLE `cliente2`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
