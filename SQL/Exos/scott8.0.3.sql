-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : lun. 01 mars 2021 à 09:51
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `scott`
--
CREATE DATABASE IF NOT EXISTS `scott` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `scott`;

-- --------------------------------------------------------

--
-- Structure de la table `dept`
--

DROP TABLE IF EXISTS `dept`;
CREATE TABLE IF NOT EXISTS `dept` (
  `deptno` int(11) NOT NULL,
  `dname` varchar(25) NOT NULL,
  `loc` varchar(25) NOT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `dept`
--

INSERT INTO `dept` (`deptno`, `dname`, `loc`) VALUES
(10, 'ACCOUNTING', 'NEW YORK'),
(20, 'RESEARCH', 'DALLAS'),
(30, 'SALES', 'CHICAGO'),
(40, 'OPERATIONS', 'BOSTON');

-- --------------------------------------------------------

--
-- Structure de la table `emp`
--

DROP TABLE IF EXISTS `emp`;
CREATE TABLE IF NOT EXISTS `emp` (
  `empno` int(11) NOT NULL,
  `ename` varchar(50) NOT NULL,
  `job` varchar(50) NOT NULL,
  `mgr` int(11) DEFAULT NULL,
  `hiredate` date NOT NULL,
  `sal` int(11) NOT NULL,
  `comm` int(11) DEFAULT NULL,
  `deptno` int(11) DEFAULT NULL,
  PRIMARY KEY (`empno`),
  KEY `deptno_fk` (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `emp`
--

INSERT INTO `emp` (`empno`, `ename`, `job`, `mgr`, `hiredate`, `sal`, `comm`, `deptno`) VALUES
(7369, 'SMITH', 'CLERK', 7902, '2018-02-09', 800, NULL, 20),
(7499, 'ALLEN', 'SALESMAN', 7698, '2018-06-13', 1600, 300, 30),
(7521, 'WARD', 'SALESMAN', 7698, '2018-07-18', 1250, 500, 30),
(7566, 'JONES', 'MANAGER', 7839, '2017-09-07', 2975, NULL, 20),
(7654, 'MARTIN', 'SALESMAN', 7698, '2018-07-18', 1250, 1400, 30),
(7698, 'BLAKE', 'MANAGER', 7839, '2017-09-20', 2850, NULL, 30),
(7782, 'CLARK', 'MANAGER', 7839, '2017-10-30', 2450, NULL, 10),
(7788, 'SCOTT', 'ANALYST', 7566, '2018-06-05', 3000, NULL, 20),
(7839, 'KING', 'PRESIDENT', NULL, '2016-05-01', 5000, NULL, 10),
(7844, 'TURNER', 'SALESMAN', 7698, '2018-06-23', 1500, 0, 30),
(7876, 'ADAMS', 'CLERK', 7788, '2018-05-04', 1100, NULL, 20),
(7900, 'JAMES', 'CLERK', 7698, '2018-08-17', 950, NULL, 30),
(7902, 'FORD', 'ANALYST', 7566, '2018-06-05', 3000, NULL, 20),
(7934, 'MILLER', 'CLERK', 7782, '2018-04-20', 1300, NULL, 10),
(7935, 'WILKIN', 'CLERK', 7782, '2018-04-22', 1280, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `salgrade`
--

DROP TABLE IF EXISTS `salgrade`;
CREATE TABLE IF NOT EXISTS `salgrade` (
  `GRADE` int(11) NOT NULL,
  `LOSAL` int(11) NOT NULL,
  `HISAL` int(11) NOT NULL,
  PRIMARY KEY (`GRADE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `salgrade`
--

INSERT INTO `salgrade` (`GRADE`, `LOSAL`, `HISAL`) VALUES
(1, 700, 1200),
(2, 1201, 1400),
(3, 1401, 2000),
(4, 2001, 3000),
(5, 3001, 9999);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `emp`
--
ALTER TABLE `emp`
  ADD CONSTRAINT `deptno_fk` FOREIGN KEY (`deptno`) REFERENCES `dept` (`deptno`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
