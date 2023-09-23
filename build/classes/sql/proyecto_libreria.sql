/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  damia
 * Created: 6 jun 2023
 */

DROP DATABASE IF EXISTS proyecto_libreria;
CREATE DATABASE proyecto_libreria;
USE proyecto_libreria;

CREATE TABLE Autor (
  autor_id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(35),
  apellido VARCHAR(35),
  PRIMARY KEY (autor_id)
);

CREATE TABLE Edicion (
  edicion_id INT NOT NULL AUTO_INCREMENT,
  anio INT(4) NOT NULL,
  PRIMARY KEY (edicion_id)
);

CREATE TABLE Genero (
  genero_id INT NOT NULL AUTO_INCREMENT,
  genero VARCHAR(40) NOT NULL,
  PRIMARY KEY (genero_id)
);

CREATE TABLE Editorial (
  editorial_id INT NOT NULL AUTO_INCREMENT,
  editorial VARCHAR(40) NOT NULL,
  PRIMARY KEY (editorial_id)
);

CREATE TABLE Idioma (
  idiomas_id INT NOT NULL AUTO_INCREMENT,
  idiomas VARCHAR(40) NOT NULL,
  PRIMARY KEY (idiomas_id)
);

CREATE TABLE Punto_Venta (  
  punto_id INT NOT NULL AUTO_INCREMENT,
  formato VARCHAR(30) NOT NULL,
  direccion VARCHAR(200) NOT NULL,
  telefono VARCHAR(50),
  email VARCHAR(150),
  PRIMARY KEY (punto_id)
);

CREATE TABLE Titulo (
  libros_id INT NOT NULL AUTO_INCREMENT,
  titulo VARCHAR(100) NOT NULL,
  Paginas INT(4),
  Stock INT(4),
  Precio FLOAT(10,2), 
  autor_id INT,
  genero_id INT,
  edicion_id INT,
  PRIMARY KEY (libros_id),
  FOREIGN KEY (autor_id) REFERENCES Autor(autor_id),
  FOREIGN KEY (genero_id) REFERENCES Genero(genero_id),
  FOREIGN KEY (edicion_id) REFERENCES Edicion(edicion_id)
);

CREATE TABLE Autor_has_Libros (
  autor_id INT NOT NULL,
  libros_id INT NOT NULL,
  PRIMARY KEY (autor_id, libros_id),
  FOREIGN KEY (autor_id) REFERENCES Autor(autor_id),
  FOREIGN KEY (libros_id) REFERENCES Titulo(libros_id)
);

CREATE TABLE Edicion_has_Libros (
  edicion_id INT NOT NULL,
  libros_id INT NOT NULL,
  PRIMARY KEY (edicion_id, libros_id),
  FOREIGN KEY (edicion_id) REFERENCES Edicion(edicion_id),
  FOREIGN KEY (libros_id) REFERENCES Titulo(libros_id)
);

CREATE TABLE Genero_has_Libros (
  genero_id INT NOT NULL,
  libros_id INT NOT NULL,
  PRIMARY KEY (genero_id, libros_id),
  FOREIGN KEY (genero_id) REFERENCES Genero(genero_id),
  FOREIGN KEY (libros_id) REFERENCES Titulo(libros_id)
);

CREATE TABLE Editorial_has_Libros (
  editorial_id INT NOT NULL,
  libros_id INT NOT NULL,
  PRIMARY KEY (editorial_id, libros_id),
  FOREIGN KEY (editorial_id) REFERENCES Editorial(editorial_id),
  FOREIGN KEY (libros_id) REFERENCES Titulo(libros_id)
);

CREATE TABLE Idiomas_has_Libros (
  idiomas_id INT NOT NULL,
  libros_id INT NOT NULL,
  PRIMARY KEY (idiomas_id, libros_id),
  FOREIGN KEY (idiomas_id) REFERENCES Idioma(idiomas_id),
  FOREIGN KEY (libros_id) REFERENCES Titulo(libros_id)
);

CREATE TABLE Punto_Venta_has_Libros (
  punto_id INT NOT NULL,
  libros_id INT NOT NULL,
  PRIMARY KEY (punto_id, libros_id),
  FOREIGN KEY (punto_id) REFERENCES Punto_Venta(punto_id),
  FOREIGN KEY (libros_id) REFERENCES Titulo(libros_id)
);

INSERT INTO Autor (nombre, apellido)
VALUES                      ('Daniel', 'Lopez Rosetti'),
		('Asano', 'Inio'),
		('Henry', 'james'),
		('Carlos', 'Ferreira'),
		('Garth', 'Enis'),
		('Jhon', 'Boyne'),
		('Amor', 'Towles'),
		('Mary', 'Shelley'),
		('Charles', 'Dickens'),
		('Eugenio Raul', 'Zaffaroni'),
		('Flavia', 'Costa'),
		('Michelle', 'Perrot'),
                                   ('Georges', 'Duby'),
		('Wolfram', 'Eilenberger'),
		('Sara', 'Aldabe'),
		('Nakai', 'Shinshi'),
		('Mamita', NULL),
		('Nagisa', 'Furuya'),
		('Uguisu', 'Sachiko'),
		('Oda', 'Eiichiro'),
		('Lucy', 'Adlington'),
		('Kawaguchi', 'Toshikazu'),
		('Andy', 'Lanning'),
                                   ('Ron', 'Marz'),
                                   ('Howard','Porter'),
                                   ('Marco','Santucci'),
		('Brian', 'Azzarello'),
                                   ('Lee', 'Bermejo');

INSERT INTO Edicion (anio)
VALUES                      (1999),
		(2004),
		(2007),
		(2013),
		(2015),
		(2016),
		(2018),
		(2019),
		(2021),
		(2022),
		(2023);
                       
insert into Genero (genero)
values                        ('Ciencia ficcion'),
		('Drama'),
		('Fantasia'),
		('Terror'),
		('Ciencia'),
		('Ficcion'),
		('Novela'),
		('Historia'),
                                   ('Sociologia'),
                                   ('Biografia'),
                                   ('Ciencias Naturales'),
                                   ('Romance'),
                                   ('Aventura'),
		('Thriller'),
                                   ('Poesia');

insert into Editorial (editorial)
values	                  ('Colihue'),
		('Ivrea'),
		('Penguin'),
		('Planeta'),
		('Taurus'),
                                   ('Planeta de Livros Portugal'),
		('Salamandra'),
                                   ('Ovni Press'),
                                   ('PLAZA & JANES EDITORES'),
                                   ('Dynamite');
                                
insert into Idioma (idiomas)
values                        ('Español'),
		('Frances'),
		('Ingles'),
		('Italiano'),
		('Portugues');                                                  

insert into Punto_Venta (formato, direccion, telefono, email)
values                        ('Digital','www.cuspide.com',null,'ventas@cuspide.com'),
		('Fisico','Av. Díaz Vélez 5125, Caballito, Argentina','4958-4442','ventas@colihue.com.ar'),                                         
		('Digital','www.colihue.com.ar','4958-4442','ventas@colihue.com.ar'),                                         
		('Digital','www.lacomiqueria.com.ar','1161825787','info@comiqueria.com.ar'),                                         
		('Digital','www.dynamite.com','856-312-1040','info@dynamite.com'),							
		('Fisico','113 Gaither Dr., Suite 205, Mt. Laurel, NJ 08054, USA','856-312-1040','info@dynamite.com'),                                         
		('Digital','www.sbs.com.ar','1126695353','sac@sbs.com.ar'),                                         
		('Fisico','Av. Coronel Díaz 1742','1126695353','sac@sbs.com.ar'),                                         
		('Digital','www.penguinlibros.com','5235-4400','recepcion@penguinrandomhouse.com'),							
		('Fisico','Humberto Primo 555, (1103) CABA','5235-4400','recepcion@penguinrandomhouse.com'),                                         
		('Digital','www.planetadelivros.pt','00351213408520','info@planeta.pt'),                                         
		('Fisico','Calçada Ribeiro Santos, nº 37 – 2º - 1200-789 Lisboa','00351213408520','info@planeta.pt'),                                         
		('Digital','www.amazon.com',null,null);							
									                                           
INSERT INTO Titulo (titulo, Paginas, Stock, Precio)
VALUES                      ('La Gioconda y Leonardo', 400, 280, 6000),
                                   ('Heroes', 100, 150, 4300),
                                   ('Fantasmas', 448, 200, 5699),
                                   ('A mi Juego', 128, 50, 1550),
                                   ('The Boys Collection cover signed by Garth Enis', 152, 50, 7000),
                                   ('El niño con el pijama de rayas', 224, 150, 3199), 
                                   ('Las huellas del silencio', 400, 280, 8399), 
                                   ('Un caballero en Moscú', 512, 70, 5054.99), 
                                   ('Frankenstein o el moderno Prometeo', 320, 50, 3699),
                                   ('Oliver Twist', 624, 300, 5699), 
                                   ('Colonialismo y Derechos Humanos', 240, 45, 5799),
                                   ('Algoritmos, biohackers y nuevas formas de vida', 192, 33, 4399),
                                   ('Historia de las mujeres', 3656, 10, 16979),
                                   ('Tiempo de magos', 384, 23, 5799),
                                   ('Química 1. Fundamentos', 488, 15, 7100),
                                   ('Química 2', 408, 15, 8000),
                                   ('Perro que ladra no muerde', 200, 100, 2300),
                                   ('Mi vecino metalero', 400, 5, 2300),
                                   ('You are in the blue summer', 200, 35, 2300),
                                   ('The blue summer and you', 200, 35, 2600),
                                   ('Beyond the bad dream', 200, 500, 2000),
                                   ('WANTED !', 200, 1000, 1800),
                                   ('As Costureiras de Auschwitz', 392, 15, 6500),
                                   ('Antes que se enfrie el cafe', 272, 500, 6199), 
                                   ('LIGA DE LA JUSTICIA : INVIERNO INTERMINABLE', 450, 17, 6000), 
                                   ('BATMAN : JOKER', 350, 17, 2500);

insert into Autor_has_Libros (autor_id, libros_id)
values                        (1,1),
		(2,2),
		(3,3),
		(4,4),
		(5,5),
                                   (6,6),
		(6,7),
		(7,8),
		(8,9),
		(9,10),
		(10,11),
		(11,12),
		(12,13),
                                   (13,13),
		(14,14),
		(15,15),
		(15,16),
		(16,17),
		(17,18),
		(18,19),
		(18,20),
		(19,21),
                                   (20,22),
		(21,23),
                                   (22,24),
                                   (23,25),
                                   (24,25),
                                   (25,25),
                                   (26,25),
                                   (27,26), 
		(28,26);

insert into Edicion_has_Libros (edicion_id, libros_id)
values          	(11,1),
		(11,2),
		(7,3),
		(4,4),
		(3,5),
		(9,6),
		(3,7),
		(10,8),
		(5,9),
		(10,10),
		(10,11),
		(9,12),
		(8,12),
		(3,14),
		(1,15),
		(2,16),
		(11,17),
		(11,18),
		(11,19),
		(11,20),
		(11,21),
		(11,22),
		(10,23),
		(10,24),
                                   (11,25),
		(11,26);                         

insert into Genero_has_Libros (genero_id, libros_id)
values          	(5,1),
		(3,2),
		(6,3),
		(15,4),
		(2,5),
		(2,6),
		(6,7),
		(6,8),
		(1,9),
                                   (4,9),
                                   (6,9),
		(7,10),
		(8,11),
		(9,12),
		(8,13),
		(1,14),
		(5,15),
		(5,16),
		(12,17),
		(12,18),
		(12,19),
		(2,20),
                                   (7,20),
                                   (12,20),
		(4,21),
		(7,22),
                                   (13,22),
		(8,23),
		(6,24),
                                   (7,24),
                                   (12,24),
                                   (2,25),
		(2,26),
                                   (4,26);

insert into Editorial_has_libros (editorial_id, libros_id)
values          	(4,1),
		(2,2),
		(3,3),
		(1,4),
		(10,5),
		(7,6),
		(7,7),
		(7,8),
		(3,9),
		(3,10),
		(5,11),
		(5,12),
		(5,13),
		(5,14),
		(1,15),
		(1,16),
		(2,17),
		(2,18),
		(2,19),
		(2,20),
		(2,21),
		(2,22),
		(6,23),
		(9,24),
                                   (8,25),
		(8,26);                         

insert into Idiomas_has_libros (idiomas_id, libros_id)
values          	(1,1),
		(1,2),
		(1,3),
		(1,4),
		(3,5),
		(1,6),
		(1,7),
		(1,8),
		(1,9),
		(1,10),
		(1,11),
		(1,12),
		(1,13),
		(1,14),
		(1,15),
		(1,16),
		(1,17),
		(1,18),
		(1,19),
		(1,20),
		(1,21),
		(1,22),
		(5,23),
		(1,24),
                                   (1,25),
		(1,26);

insert into Punto_Venta_has_libros (punto_id, libros_id)
values                        (1,1),
		(4,2),
		(1,3),
		(2,4),
                                   (3,4),
		(5,5),  
                                   (6,5),
		(1,6),
                                   (7,6),
                                   (8,6),
		(1,7),
                                   (7,7),
                                   (8,7),
		(7,8),
                                   (8,8),
		(9,9),
                                   (10,9),
		(9,10),
                                   (10,10),
		(9,11), 
                                   (10,11),
		(9,12),
                                   (10,12),
		(9,13),
                                   (10,13),
		(9,14),
                                   (10,14),
		(2,15),
                                   (3,15),
		(2,16),
                                   (3,16),
		(4,17),
		(4,18),
		(4,19),
		(4,20),
		(1,21),
		(1,22),
                                   (4,22),
		(11,23), 
                                   (12,23),
		(13,24),
                                   (1,25),
		(1,26);