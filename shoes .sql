-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 30, 2021 at 03:26 AM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shoes`
--

-- --------------------------------------------------------

--
-- Table structure for table `database_bid`
--

CREATE TABLE `database_bid` (
  `id_bid` varchar(10) NOT NULL,
  `id_product` varchar(10) DEFAULT NULL,
  `total_bid` bigint(20) DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `database_bid`
--

INSERT INTO `database_bid` (`id_bid`, `id_product`, `total_bid`, `username`) VALUES
('B0001', 'PR0001', 500000, 'LizaX'),
('B0002', 'PR0004', 150000, 'mita'),
('B0003', 'PR0002', 500000, 'mada'),
('B0004', 'PR0003', 4000000, 'dhimas');

-- --------------------------------------------------------

--
-- Table structure for table `database_pengguna`
--

CREATE TABLE `database_pengguna` (
  `email` varchar(30) DEFAULT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) DEFAULT NULL,
  `type` varchar(1) NOT NULL DEFAULT 'U'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `database_pengguna`
--

INSERT INTO `database_pengguna` (`email`, `username`, `password`, `type`) VALUES
('admin@gmail.com', 'admin', 'admin', 'A'),
('dhimas@gmail.com', 'dhimas', 'dhimas', 'U'),
('mada@gmail.com', 'mada', 'mada', 'U'),
('mita@gmail.com', 'mita', 'mita', 'U');

-- --------------------------------------------------------

--
-- Table structure for table `database_product`
--

CREATE TABLE `database_product` (
  `id_product` varchar(10) NOT NULL,
  `nama_product` varchar(30) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `start_bid` bigint(20) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `database_product`
--

INSERT INTO `database_product` (`id_product`, `nama_product`, `stock`, `start_bid`, `start_date`, `end_date`) VALUES
('PR0001', 'Servare Vitas', 1, 300000, '2021-04-30', '2021-05-02'),
('PR0002', 'Converse', 1, 250000, '2021-04-30', '2021-05-02'),
('PR0003', 'Adidas', 3, 200000, '2021-04-30', '2021-05-02'),
('PR0004', 'Nike', 3, 100000, '2021-04-30', '2021-05-03'),
('PR0005', 'nb', 2, 100000, '2021-04-30', '2021-05-01');

-- --------------------------------------------------------

--
-- Table structure for table `database_transaksi`
--

CREATE TABLE `database_transaksi` (
  `id_transaksi` varchar(10) NOT NULL,
  `id_bid` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `id_product` varchar(10) DEFAULT NULL,
  `username` varchar(10) DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `end_bid` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `database_transaksi`
--

INSERT INTO `database_transaksi` (`id_transaksi`, `id_bid`, `id_product`, `username`, `jumlah`, `end_bid`) VALUES
('TR0001', 'B0001', 'PR0001', 'lizaX', 1, 500000),
('TR0002', 'B0002', 'PR0004', 'mita', 1, 150000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `database_bid`
--
ALTER TABLE `database_bid`
  ADD PRIMARY KEY (`id_bid`) USING BTREE,
  ADD UNIQUE KEY `fk_product` (`id_product`) USING BTREE,
  ADD UNIQUE KEY `fk_username` (`username`) USING BTREE,
  ADD KEY `id_product` (`id_product`),
  ADD KEY `username` (`username`),
  ADD KEY `id_product_2` (`id_product`),
  ADD KEY `id_product_3` (`id_product`),
  ADD KEY `username_2` (`username`);

--
-- Indexes for table `database_pengguna`
--
ALTER TABLE `database_pengguna`
  ADD PRIMARY KEY (`username`) USING BTREE;

--
-- Indexes for table `database_product`
--
ALTER TABLE `database_product`
  ADD PRIMARY KEY (`id_product`) USING BTREE;

--
-- Indexes for table `database_transaksi`
--
ALTER TABLE `database_transaksi`
  ADD PRIMARY KEY (`id_transaksi`) USING BTREE,
  ADD UNIQUE KEY `fk_bid` (`id_bid`) USING BTREE,
  ADD UNIQUE KEY `fk_product2` (`id_product`) USING BTREE,
  ADD UNIQUE KEY `fk_username2` (`username`) USING BTREE,
  ADD KEY `id_bid` (`id_bid`),
  ADD KEY `id_product` (`id_product`),
  ADD KEY `username` (`username`),
  ADD KEY `id_bid_2` (`id_bid`),
  ADD KEY `id_product_2` (`id_product`),
  ADD KEY `username_2` (`username`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `database_transaksi`
--
ALTER TABLE `database_transaksi`
  ADD CONSTRAINT `database_transaksi_ibfk_1` FOREIGN KEY (`id_product`) REFERENCES `database_product` (`id_product`) ON DELETE CASCADE ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
