CREATE DATABASE resto;

\c resto

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

select produit_detail.*, ingredient.*, produit_detail.quantite*ingredient.prix_unitaire as total_prix from produit_detail, ingredient where produit_detail.id_ingredient = ingredient.id and produit_detail.id_produit = 1;  

















DROP TABLE IF EXISTS serveur;
CREATE TABLE serveur(
	id SERIAL NOT NULL,
	nom VARCHAR(255),
	pourcentage DOUBLE PRECISION,
	PRIMARY KEY (id)
);

INSERT INTO serveur VALUES (default,'Jean Rakoto',10),(default,'Ravao Jeanne',10),(default,'Eric',10);

/*

DROP TABLE IF EXISTS ;
CREATE TABLE (
	id SERIAL NOT NULL,
	PRIMARY KEY (id)
);

ALTER TABLE  ADD CONSTRAINT FK_ FOREIGN KEY () REFERENCES  ();

*/

DROP TABLE IF EXISTS latable;
CREATE TABLE latable(
	id SERIAL NOT NULL,
	nom VARCHAR(255),
	PRIMARY KEY (id)
);

INSERT INTO latable VALUES (default,'t1'),(default,'t2'),(default,'t3'),(default,'t4');

DROP TABLE IF EXISTS commande;
CREATE TABLE commande(
	id SERIAL NOT NULL,
	date DATE, 
	id_table INTEGER NOT NULL,
	PRIMARY KEY (id)
);

ALTER TABLE commande ADD CONSTRAINT FK_commande_id_table FOREIGN KEY (id_table) REFERENCES latable (id);

ALTER TABLE commande ADD COLUMN is_valid BOOLEAN default false;


INSERT INTO commande VALUES (default,'2022-03-28',1),(default,'2022-03-28',2),(default,'2022-03-28',3),(default,'2022-03-28',4);

DROP TABLE IF EXISTS commande_detail;
CREATE TABLE commande_detail(
	id SERIAL NOT NULL,
	id_commande INTEGER NOT NULL,
	id_produit INTEGER NOT NULL,
	prix_unitaire DOUBLE PRECISION,
	PRIMARY KEY (id)
);

ALTER TABLE  commande_detail ADD CONSTRAINT FK_commande_detail_id_commande FOREIGN KEY (id_commande) REFERENCES commande (id);
ALTER TABLE  commande_detail ADD CONSTRAINT FK_commande_detail_id_produit FOREIGN KEY (id_produit) REFERENCES produit (id);

INSERT INTO commande_detail VALUES (default,1,1,5000);
INSERT INTO commande_detail VALUES (default,1,2,3500);

INSERT INTO commande_detail VALUES (default,2,3,4000);
INSERT INTO commande_detail VALUES (default,2,4,5000);

INSERT INTO commande_detail VALUES (default,3,5,6000);
INSERT INTO commande_detail VALUES (default,3,6,7000);

INSERT INTO commande_detail VALUES (default,4,1,5000);
INSERT INTO commande_detail VALUES (default,4,6,7000);

DROP TABLE IF EXISTS commande;
CREATE TABLE pourboire(
	id SERIAL NOT NULL,
	id_serveur INTEGER NOT NULL,
	id_commande INTEGER NOT NULL,
	valeur DOUBLE PRECISION,
	PRIMARY KEY (id)
);

ALTER TABLE pourboire ADD CONSTRAINT FK_pourboire_id_serveur FOREIGN KEY (id_serveur) REFERENCES serveur (id);
ALTER TABLE pourboire ADD CONSTRAINT FK_pourboire_id_commande FOREIGN KEY (id_commande) REFERENCES commande (id);

INSERT INTO pourboire VALUES (default,1,1,850),(default,1,2,900),(default,2,3,1300),(default,2,4,1200);

SELECT SUM(pourboire.valeur) as somme from pourboire,commande where pourboire.id_commande = commande.id and id_serveur = 1 and commande.date >= '2021-02-02' and commande.date <= '2022-03-28'; 


select ingredient.id,ingredient.nom,ingredient.prix_unitaire,sum(produit_detail.quantite) as sum_quantite from commande,commande_detail,produit_detail,ingredient where commande_detail.id_commande = commande.id and commande_detail.id_produit = produit_detail.id_produit and produit_detail.id_ingredient = ingredient.id and commande.date >='2022-03-28' and commande.date<='2022-03-28' group by ingredient.id;


DROP TABLE IF EXISTS inventaire;
CREATE TABLE inventaire(
	id SERIAL NOT NULL,
	date DATE,
	PRIMARY KEY (id)
);

DROP TABLE IF EXISTS detail_inventaire;
CREATE TABLE detail_inventaire(
	id_inventaire INT NOT NULL,
	id_ingredient INT NOT NULL,
	quantite INT
);

ALTER TABLE detail_inventaire ADD CONSTRAINT FK_detail_inventaire_id_inventaire FOREIGN KEY (id_inventaire) REFERENCES inventaire (id);
ALTER TABLE detail_inventaire ADD CONSTRAINT FK_detail_inventaire_id_ingredient FOREIGN KEY (id_ingredient) REFERENCES ingredient (id);

INSERT INTO inventaire values (default,'2021-12-10');

INSERT INTO detail_inventaire values (1,1,4000),(1,2,8000),(1,3,16000),(1,4,8000),(1,5,5000),(1,6,6000); 


DROP TABLE IF EXISTS mouvement_stock;
CREATE TABLE mouvement_stock(
	id SERIAL NOT NULL,
	id_ingredient INT NOT NULL,
	date DATE,
	quantite INT,
	type INT,
	PRIMARY KEY (id)
);

ALTER TABLE mouvement_stock ADD CONSTRAINT FK_mouvement_stock_id_ingredient FOREIGN KEY (id_ingredient) REFERENCES ingredient (id);

/*INSERT INTO mouvement_stock values (default,1,'2022-01-01',4000,0),(default,2,'2022-02-01',8000,0),(default,3,'2022-02-01',16000,0),(default,4,'2022-02-01',8000,0),(default,5,'2022-02-01',5000,0),(default,6,'2022-02-01',6000,0);*/