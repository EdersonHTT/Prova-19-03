CREATE DATABASE gerenciadorOrdem;
use gerenciadorordem;

CREATE TABLE usuario(
	id INT PRIMARY KEY AUTO_INCREMENT,
    cpf VARCHAR(11) NOT NULL,
    name_user VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password_user TEXT NOT NULL,
    profile_user ENUM("Ad", "At", "T") NOT NULL
);

DELETE FROM usuario WHERE id = 0;

ALTER TABLE usuario CHANGE cpf cpf VARCHAR(11) NOT NULL unique;
ALTER TABLE usuario CHANGE email email VARCHAR(255) NOT NULL unique;

UPDATE usuario SET cpf = "12345678910", name_user = "aaa", email = "baa@", password_user = "123", profile_user= "T" WHERE id = 5;

CREATE TABLE cliente(
	id INT PRIMARY KEY AUTO_INCREMENT,
    cpf VARCHAR(11) NOT NULL unique,
    name_user VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL unique
);

CREATE TABLE equipamento(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name_equi VARCHAR(255) not null,
    id_cliente INT NOT NULL,
    CONSTRAINT id_cliente(id_cliente)
    FOREIGN (id_cliente) 
		REFERENCES cliente(id)
        ON DELETE CASCADE
);

CREATE TABLE ordem(
	id INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT NOT NULL,
    id_equipamento INT NOT NULL,
    id_user_tec INT NOT NULL,
    description_ordem TEXT NOT NULL,
    status_ordem ENUM("Aberta", "Em andamento", "Finalizada", "Cancelada") DEFAULT "Aberta",
    CONSTRAINT id_cliente(id_cliente)
    FOREIGN (id_cliente) 
		REFERENCES cliente(id)
        ON DELETE CASCADE,
        
	CONSTRAINT id_equipamento(id_equipamento)
    FOREIGN (id_equipamento) 
		REFERENCES equipamento(id)
        ON DELETE CASCADE,
        
	CONSTRAINT id_user_tec(id_user_tec)
    FOREIGN (id_user_tec) 
		REFERENCES usuario(id)
        ON DELETE CASCADE,
);

CREATE TABLE Registros(
	id INT PRIMARY KEY AUTO_INCREMENT,
    description_regis TEXT not null,
    moment DATETIME DEFAULT CURRENT_TIMESTAMP
);