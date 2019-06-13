-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 11-Jun-2019 às 02:51
-- Versão do servidor: 10.1.38-MariaDB
-- versão do PHP: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `uaicoins`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `carteira`
--

CREATE TABLE `carteira` (
  `id` int(4) NOT NULL,
  `id_usuario` int(4) NOT NULL,
  `saldo_retirada` decimal(10,0) NOT NULL,
  `saldo_doacao` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `carteira`
--

INSERT INTO `carteira` (`id`, `id_usuario`, `saldo_retirada`, `saldo_doacao`) VALUES
(1, 1, '450', '1201'),
(2, 2, '200', '1251'),
(3, 3, '350', '1401');

-- --------------------------------------------------------

--
-- Estrutura da tabela `credito`
--

CREATE TABLE `credito` (
  `id` int(4) NOT NULL,
  `data_credito` datetime NOT NULL,
  `valor_credito` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `credito`
--

INSERT INTO `credito` (`id`, `data_credito`, `valor_credito`) VALUES
(1, '2019-06-10 02:23:35', '1000');

-- --------------------------------------------------------

--
-- Estrutura da tabela `debito`
--

CREATE TABLE `debito` (
  `id` int(4) NOT NULL,
  `id_usuario` int(4) NOT NULL,
  `data_debito` datetime NOT NULL,
  `valor_debito` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `debito`
--

INSERT INTO `debito` (`id`, `id_usuario`, `data_debito`, `valor_debito`) VALUES
(1, 1, '2019-06-02 00:00:00', '100'),
(2, 1, '2019-06-10 02:22:09', '50');

-- --------------------------------------------------------

--
-- Estrutura da tabela `transacao`
--

CREATE TABLE `transacao` (
  `id` int(4) NOT NULL,
  `id_usuario_origem` int(4) NOT NULL,
  `id_usuario_destino` int(4) NOT NULL,
  `motivo` varchar(400) NOT NULL,
  `data_transacao` datetime NOT NULL,
  `valor_transacao` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `transacao`
--

INSERT INTO `transacao` (`id`, `id_usuario_origem`, `id_usuario_destino`, `motivo`, `data_transacao`, `valor_transacao`) VALUES
(1, 1, 2, 'Ótimo curso de MySQL', '2019-06-01 00:00:00', '100'),
(2, 2, 1, 'Ótimo curso de Java', '2019-06-02 00:00:00', '100'),
(3, 1, 2, 'Ótimo curso de PostgreSQL', '2019-06-03 00:00:00', '100'),
(4, 2, 1, 'Ótimo curso de Spring', '2019-06-04 00:00:00', '100'),
(5, 1, 3, 'Ótimo curso de CSS', '2019-06-05 00:00:00', '100'),
(6, 2, 3, 'Ótimo curso de JavaScript', '2019-05-26 22:18:02', '50');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `id` int(4) NOT NULL,
  `nome` varchar(200) NOT NULL,
  `login` varchar(200) NOT NULL,
  `senha` varchar(200) NOT NULL,
  `admin` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `nome`, `login`, `senha`, `admin`) VALUES
(1, 'Ítallo Corrêa de Almeida', 'itallocec', '123456', 0),
(2, 'Breno Cirino Pedra', 'brenometal', '123456', 0),
(3, 'Guilherme Henrique Silva Alves', 'guilhermehsa', '123456', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `carteira`
--
ALTER TABLE `carteira`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_usuario_id` (`id_usuario`);

--
-- Indexes for table `credito`
--
ALTER TABLE `credito`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `debito`
--
ALTER TABLE `debito`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_debito_usuario` (`id_usuario`);

--
-- Indexes for table `transacao`
--
ALTER TABLE `transacao`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_usuario_origem` (`id_usuario_origem`),
  ADD KEY `id_usuario_destino` (`id_usuario_destino`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `credito`
--
ALTER TABLE `credito`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `debito`
--
ALTER TABLE `debito`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `transacao`
--
ALTER TABLE `transacao`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `carteira`
--
ALTER TABLE `carteira`
  ADD CONSTRAINT `fk_usuario_id` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`);

--
-- Limitadores para a tabela `debito`
--
ALTER TABLE `debito`
  ADD CONSTRAINT `fk_debito_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`);

--
-- Limitadores para a tabela `transacao`
--
ALTER TABLE `transacao`
  ADD CONSTRAINT `transacao_ibfk_1` FOREIGN KEY (`id_usuario_origem`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `transacao_ibfk_2` FOREIGN KEY (`id_usuario_destino`) REFERENCES `usuario` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
