CREATE DATABASE resto;

\c resto

CREATE SCHEMA resto;

DROP TABLE IF EXISTS type;
CREATE TABLE type(
	id SERIAL NOT NULL,
	nom VARCHAR(255),
	PRIMARY KEY(id)
);

DROP TABLE IF EXISTS produit;
CREATE TABLE produit(
	id SERIAL NOT NULL,
	id_type INTEGER NOT NULL,
	nom VARCHAR(255),
	prix DOUBLE PRECISION,
	PRIMARY KEY (id)
);

ALTER TABLE produit ADD CONSTRAINT FK_produit_id_type FOREIGN KEY (id_type) REFERENCES type (id);

INSERT INTO type(nom) values ('vary');
INSERT INTO type(nom) values ('dessert');


INSERT INTO produit(id_type,nom,prix) values (1,'boulettes de viandes',5000);
INSERT INTO produit(id_type,nom,prix) values (1,'cheese burger',3500);
INSERT INTO produit(id_type,nom,prix) values (1,'chicken burger',4000);
INSERT INTO produit(id_type,nom,prix) values (2,'sandwich',5000);
INSERT INTO produit(id_type,nom,prix) values (2,'spaghetti bolognaise',6000);
INSERT INTO produit(id_type,nom,prix) values (2,'spaghetti carbonara',7000);

CREATE VIEW produit_with_type as select produit.id as id_produit,produit.id_type,produit.nom as nom_produit,produit.prix,type.nom as categorie from produit, type where produit.id_type = type.id;

DROP TABLE IF EXISTS ingredient;
CREATE TABLE ingredient(
	id SERIAL NOT NULL,
	nom VARCHAR(255),
	prix_unitaire DOUBLE PRECISION,
	PRIMARY KEY (id)
);

DROP TABLE IF EXISTS produit_detail;
CREATE TABLE produit_detail(
	id_produit INTEGER NOT NULL,
	id_ingredient INTEGER NOT NULL,
	quantite INTEGER
);

ALTER TABLE produit_detail ADD CONSTRAINT FK_produit_detail_id_produit FOREIGN KEY (id_produit) REFERENCES produit (id);
ALTER TABLE produit_detail ADD CONSTRAINT FK_produit_detail_id_ingredient FOREIGN KEY (id_ingredient) REFERENCES ingredient (id);
 
INSERT INTO ingredient(nom,prix_unitaire) values ('carotte',500);
INSERT INTO ingredient(nom,prix_unitaire) values ('oignon',400);
INSERT INTO ingredient(nom,prix_unitaire) values ('pomme de terre',1000);
INSERT INTO ingredient(nom,prix_unitaire) values ('farine',1500);
INSERT INTO ingredient(nom,prix_unitaire) values ('sucre',300);
INSERT INTO ingredient(nom,prix_unitaire) values ('sel',300);


INSERT INTO produit_detail(id_produit,id_ingredient,quantite) values (1,1,1);
INSERT INTO produit_detail(id_produit,id_ingredient,quantite) values (1,2,2);
INSERT INTO produit_detail(id_produit,id_ingredient,quantite) values (1,3,3);

INSERT INTO produit_detail(id_produit,id_ingredient,quantite) values (2,4,4);
INSERT INTO produit_detail(id_produit,id_ingredient,quantite) values (2,5,5);
INSERT INTO produit_detail(id_produit,id_ingredient,quantite) values (2,6,6);

CREATE OR REPLACE VIEW listeIngredient AS select ingredient.id AS id_ingredient, produit_detail.id_produit, produit_detail.quantite*ingredient.prix_unitaire as total_prix from produit_detail, ingredient where produit_detail.id_ingredient = ingredient.id;
SELECT SUM(produit_detail.quantite*ingredient.prix_unitaire) as total_prix FROM produit_detail, ingredient WHERE produit_detail.id_ingredient = ingredient.id GROUP BY id_produit;
CREATE OR REPLACE VIEW prixDeRevient AS SELECT produit.*, SUM (listeIngredient.total_prix) AS prix_de_revient from produit JOIN listeIngredient ON produit.id = listeIngredient.id_produit GROUP by produit.id;

UPDATE produit SET prix = 10000 WHERE id = 2;

CREATE TABLE marge(
	min DOUBLE PRECISION,
	max DOUBLE PRECISION,
	pourcentage DOUBLE PRECISION,
	isCurrent boolean DEFAULT true
);
INSERT into marge VALUES(0, 1000, 200, default);
INSERT into marge VALUES(1000, 2000, 100, default);
INSERT into marge VALUES(2000, 3000, 50, default);

