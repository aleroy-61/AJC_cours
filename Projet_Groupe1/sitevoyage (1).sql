-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 09 mars 2021 à 17:44
-- Version du serveur :  8.0.21
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `sitevoyage`
--
CREATE DATABASE IF NOT EXISTS `sitevoyage` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `sitevoyage`;

-- --------------------------------------------------------

--
-- Structure de la table `activite`
--

DROP TABLE IF EXISTS `activite`;
CREATE TABLE IF NOT EXISTS `activite` (
  `id` int NOT NULL,
  `libelle` varchar(30) NOT NULL,
  `duree` int NOT NULL,
  `idpays` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pays` (`idpays`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `activite`
--

INSERT INTO `activite` (`id`, `libelle`, `duree`, `idpays`) VALUES
(1, 'Balade en Dromadaire', 2, 1),
(2, 'Atelier sushi', 2, 2),
(3, 'Kayak dans les Fjords', 5, 3),
(4, 'Visite d\'un élevage de saumon', 3, 3);

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

DROP TABLE IF EXISTS `compte`;
CREATE TABLE IF NOT EXISTS `compte` (
  `id` int NOT NULL,
  `nom` varchar(25) NOT NULL,
  `email` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `typeCompte` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`id`, `nom`, `email`, `password`, `typeCompte`) VALUES
(1234, 'admin', 'admin@gmail.fr', 'admin', 'Admin'),
(3456, 'dupont', 'dupont@gmail.fr', 'dup', 'Client');

-- --------------------------------------------------------

--
-- Structure de la table `pays`
--

DROP TABLE IF EXISTS `pays`;
CREATE TABLE IF NOT EXISTS `pays` (
  `id` int NOT NULL,
  `nom` varchar(50) NOT NULL,
  `restriction` tinyint(1) NOT NULL,
  `prixJours` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `pays`
--

INSERT INTO `pays` (`id`, `nom`, `restriction`, `prixJours`) VALUES
(1, 'Maroc', 0, 80),
(2, 'Japon', 0, 100),
(3, 'Norvège', 0, 70),
(4, 'Thaïlande', 0, 120),
(5, 'Russie', 0, 60),
(6, 'Martinique', 0, 90),
(7, 'Brésil', 0, 150),
(8, 'Colombie', 0, 180),
(9, 'Madagascar', 0, 200),
(10, 'Tahiti', 0, 250);

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `heure` date NOT NULL,
  `prix` double NOT NULL,
  `idVoyage` int DEFAULT NULL,
  `transport` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_voyage` (`idVoyage`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`id`, `date`, `heure`, `prix`, `idVoyage`, `transport`) VALUES
(3, '2021-03-09 11:21:39', '2021-03-10', 1000, 1, 'bus');

-- --------------------------------------------------------

--
-- Structure de la table `reservation_activite`
--

DROP TABLE IF EXISTS `reservation_activite`;
CREATE TABLE IF NOT EXISTS `reservation_activite` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idReservation` int NOT NULL,
  `idActivite` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_reservation` (`idReservation`),
  KEY `fk_activite` (`idActivite`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `reservation_activite`
--

INSERT INTO `reservation_activite` (`id`, `idReservation`, `idActivite`) VALUES
(1, 3, 3),
(2, 3, 4);

-- --------------------------------------------------------

--
-- Structure de la table `voyage`
--

DROP TABLE IF EXISTS `voyage`;
CREATE TABLE IF NOT EXISTS `voyage` (
  `id` int NOT NULL AUTO_INCREMENT,
  `debut` date NOT NULL,
  `fin` date NOT NULL,
  `destination` int NOT NULL,
  `depart` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_depart` (`depart`),
  KEY `fk_destination` (`destination`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `voyage`
--

INSERT INTO `voyage` (`id`, `debut`, `fin`, `destination`, `depart`) VALUES
(1, '2021-03-17', '2021-03-25', 3, 7);

-- --------------------------------------------------------

--
-- Structure de la table `voyageur`
--

DROP TABLE IF EXISTS `voyageur`;
CREATE TABLE IF NOT EXISTS `voyageur` (
  `id` int NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `idReservation` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_reservation_voyageur` (`idReservation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `voyageur`
--

INSERT INTO `voyageur` (`id`, `nom`, `prenom`, `idReservation`) VALUES
(0, 'ABID', 'JORDAN', 3);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `activite`
--
ALTER TABLE `activite`
  ADD CONSTRAINT `fk_pays` FOREIGN KEY (`idpays`) REFERENCES `pays` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `fk_voyage` FOREIGN KEY (`idVoyage`) REFERENCES `voyage` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Contraintes pour la table `reservation_activite`
--
ALTER TABLE `reservation_activite`
  ADD CONSTRAINT `fk_activite` FOREIGN KEY (`idActivite`) REFERENCES `activite` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_reservation` FOREIGN KEY (`idReservation`) REFERENCES `reservation` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `voyage`
--
ALTER TABLE `voyage`
  ADD CONSTRAINT `fk_depart` FOREIGN KEY (`depart`) REFERENCES `pays` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_destination` FOREIGN KEY (`destination`) REFERENCES `pays` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `voyageur`
--
ALTER TABLE `voyageur`
  ADD CONSTRAINT `fk_reservation_voyageur` FOREIGN KEY (`idReservation`) REFERENCES `reservation` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
