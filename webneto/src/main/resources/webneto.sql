CREATE DATABASE WebNeto;

USE WebNeto;

CREATE TABLE adm(
	id SERIAL PRIMARY KEY, --SERIAL
	senha VARCHAR(100) NOT NULL,
	nome VARCHAR(80) NOT NULL
);

CREATE TABLE site(
	id SERIAL PRIMARY KEY, --SERIAL
	logo CHARACTER VARYING NOT NULL,
	nome CHARACTER VARYING NOT NULL,
	link CHARACTER VARYING NOT NULL,
	id_adm int,
	FOREIGN KEY (id_adm) REFERENCES adm(id) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE tutorial(
	id SERIAL PRIMARY KEY, --SERIAL
	titulo CHARACTER VARYING NOT NULL,
	passos CHARACTER VARYING NOT NULL,
	video CHARACTER VARYING NOT NULL,
	foto CHARACTER VARYING NOT NULL,
	id_site int,
	FOREIGN KEY (id_site) REFERENCES site(id) ON DELETE SET NULL ON UPDATE CASCADE
);