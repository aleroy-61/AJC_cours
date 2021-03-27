-- phpMyAdmin SQL Dump
-- version 4.6.6deb4
-- https://www.phpmyadmin.net/
--
-- Client :  localhost:3306
-- Généré le :  Mer 03 Juin 2020 à 19:23
-- Version du serveur :  5.7.19
-- Version de PHP :  7.0.19-1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `SQLFormation`
--
CREATE DATABASE IF NOT EXISTS `SQLFormation` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `SQLFormation`;

-- --------------------------------------------------------

--
-- Structure de la table `arme`
--

CREATE TABLE `arme` (
  `id_arme` int(11) NOT NULL,
  `libelle_arme` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `arme`
--

INSERT INTO `arme` (`id_arme`, `libelle_arme`) VALUES
(1, 'Hache'),
(2, 'Fusil'),
(3, 'Marteau'),
(4, 'Gilet Jaune'),
(5, 'Poison'),
(6, 'Couteau'),
(7, 'Boule de Bowling'),
(8, 'Magie');

-- --------------------------------------------------------

--
-- Structure de la table `lien`
--

CREATE TABLE `lien` (
  `id_lien` int(11) NOT NULL,
  `id_suspect1` int(11) NOT NULL,
  `id_suspect2` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `lien`
--

INSERT INTO `lien` (`id_lien`, `id_suspect1`, `id_suspect2`) VALUES
(1, 8, 3),
(2, 8, 6),
(3, 8, 10),
(4, 2, 12),
(5, 2, 4),
(6, 2, 1),
(7, 2, 3),
(8, 2, 7),
(9, 12, 1),
(10, 12, 3),
(11, 12, 7),
(12, 4, 1),
(13, 4, 3),
(14, 1, 3),
(15, 6, 12),
(16, 2, 11),
(17, 7, 4),
(18, 7, 5),
(19, 8, 11),
(20, 5, 11),
(21, 4, 8),
(22, 11, 9),
(23, 8, 5),
(25, 10, 1),
(26, 10, 11);

-- --------------------------------------------------------

--
-- Structure de la table `suspect`
--

CREATE TABLE `suspect` (
  `id_suspect` int(11) NOT NULL,
  `nom_suspect` varchar(15) NOT NULL,
  `prenom_suspect` varchar(15) NOT NULL,
  `ville_suspect` varchar(40) NOT NULL,
  `naissance_suspect` date DEFAULT NULL,
  `election_suspect` date DEFAULT NULL,
  `id_arme` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `suspect`
--

INSERT INTO `suspect` (`id_suspect`, `nom_suspect`, `prenom_suspect`, `ville_suspect`, `naissance_suspect`, `election_suspect`, `id_arme`) VALUES
(1, 'Sarkozy', 'Nicolas', 'Lyon', '1955-01-28', '2007-05-16', 5),
(2, 'Macron', 'Emmanuel', 'Amiens', '1977-12-21', '2017-05-14', 2),
(3, 'Le Pen', 'Marine', 'Neuilly-sur-Seine', '1968-08-05', '2011-01-16', 7),
(4, 'Melenchon', 'Jean-Luc', 'Tanger', '1951-08-19', '2017-06-27', 4),
(5, 'Hollande', 'François', 'Rouen', '1954-08-12', '2012-05-15', 8),
(6, 'Balkany', 'Patrick', 'Paris', '1948-08-16', '2001-03-18', 7),
(7, 'Hulot', 'Nicolas', 'Lille', '1955-04-30', '2017-05-17', 1),
(8, 'Hidalgo', 'Anne', 'San Fernando', '1959-06-19', '2014-04-05', 5),
(9, 'Bayrou', 'François', 'Borderes', '1951-05-25', '1992-04-02', 4),
(10, 'Valls', 'Manuel', 'Barcelone', '1962-08-13', '2001-03-18', 7),
(11, 'Pecresse', 'Valerie', 'Paris', '1967-07-14', '2015-12-18', 6),
(12, 'Royal', 'Segolene', 'Paris', '1953-09-22', '2004-04-02', 7);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `arme`
--
ALTER TABLE `arme`
  ADD PRIMARY KEY (`id_arme`);

--
-- Index pour la table `lien`
--
ALTER TABLE `lien`
  ADD PRIMARY KEY (`id_lien`);

--
-- Index pour la table `suspect`
--
ALTER TABLE `suspect`
  ADD PRIMARY KEY (`id_suspect`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `arme`
--
ALTER TABLE `arme`
  MODIFY `id_arme` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `lien`
--
ALTER TABLE `lien`
  MODIFY `id_lien` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT pour la table `suspect`
--
ALTER TABLE `suspect`
  MODIFY `id_suspect` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
