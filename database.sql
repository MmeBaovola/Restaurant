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
	quantite INTEGER NOT NULL,
	prix_unitaire DOUBLE PRECISION,
	id_serveur INT,
	PRIMARY KEY (id)
);

ALTER TABLE  commande_detail ADD CONSTRAINT FK_commande_detail_id_commande FOREIGN KEY (id_commande) REFERENCES commande (id);
ALTER TABLE  commande_detail ADD CONSTRAINT FK_commande_detail_id_produit FOREIGN KEY (id_produit) REFERENCES produit (id);

INSERT INTO commande_detail VALUES (default,1,1,1,5000, 1);
INSERT INTO commande_detail VALUES (default,1,2,2,3500, 1);
INSERT INTO commande_detail VALUES (default,1,2,1,10000, 1);

INSERT INTO commande_detail VALUES (default,2,3,1,4000, 1);
INSERT INTO commande_detail VALUES (default,2,4,2,5000, 1);

INSERT INTO commande_detail VALUES (default,3,5,1,6000, 2);
INSERT INTO commande_detail VALUES (default,3,6,1,7000, 2);

INSERT INTO commande_detail VALUES (default,4,1,1,5000, 2);
INSERT INTO commande_detail VALUES (default,4,6,1,7000, 2);

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

SELECT serveur.nom, id_serveur, SUM(pourboire.valeur) as somme from serveur,pourboire,commande where pourboire.id_commande = commande.id and commande.date >= '2021-02-02' and commande.date <= '2022-03-28' GROUP by id_serveur, serveur.nom; 

SELECT serveur.nom, id_serveur, SUM(pourboire.valeur) as somme from serveur JOIN pourboire ON serveur.id = pourboire.id_serveur JOIN commande ON pourboire.id_commande = commande.id WHERE commande.date >= '2021-02-02' and commande.date <= '2022-03-28' GROUP by pourboire.id_serveur, serveur.nom;

CREATE OR REPLACE VIEW commandeView AS SELECT commande_detail.id_commande, produit.nom AS nomPlat, commande_detail.quantite, commande_detail.prix_unitaire*quantite AS prix FROM produit JOIN commande_detail
ON commande_detail.id_produit = produit.id;


-- 05 / 04 / 2022 

SELECT ingredient.id, ingredient.nom, ingredient.prix_unitaire, sum(produit_detail.quantite) as sum_quantite
FROM commande, commande_detail, produit_detail, ingredient
where commande_detail.id_commande = commande.id and commande_detail.id_produit = produit_detail.id_produit and produit_detail.id_ingredient = ingredient.id
and commande.date >= '2022-03-28' and commande.date <= '2022-03-28' group by ingredient.id;

DROP view IF EXISTS ingredientUtilise;
CREATE OR REPLACE VIEW ingredientUtilise AS SELECT commande.date, ingredient.id as id_ingredient, ingredient.nom AS nom_ingredient, 
ingredient.prix_unitaire, sum(produit_detail.quantite)::DOUBLE PRECISION as sum_quantite, 
ingredient.prix_unitaire * sum(produit_detail.quantite) AS prix_total
FROM commande, commande_detail, produit_detail, ingredient
where commande_detail.id_commande = commande.id and commande_detail.id_produit = produit_detail.id_produit and produit_detail.id_ingredient = ingredient.id group by ingredient.id, commande.date;
SELECT * from ingredientUtilise;

DROP VIEW IF EXISTS prix_total_ingredient;
CREATE OR REPLACE VIEW prix_total_ingredient AS SELECT date, sum(prix_total) AS prix_total FROM ingredientUtilise GROUP BY date;
SELECT * from prix_total_ingredient;

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

-- 07/04/2022

-- TSY FAFANA ITO (query insert into mouvement_stock)*********
-- insert into mouvement_stock(id_ingredient,date ,quantite,type)(select ingredient.id, NOW(),quantite,1 from listeingredientview JOIN ingredient ON ingredient.nom = listeingredientview.nom_ingredient where id_produit=1);
-- *************************
SELECT * from mouvement_stock;

ALTER TABLE commande_detail ADD COLUMN estMasake boolean default false;

ALTER TABLE commande_detail DROP COLUMN quantite CASCADE;

CREATE OR REPLACE VIEW commandeView AS SELECT commande_detail.id_commande, produit.nom AS nomPlat, commande_detail.prix_unitaire AS prix, commande_detail.estMasake AS estMasake
FROM produit JOIN commande_detail ON commande_detail.id_produit = produit.id;

-- Ajout de id_commande_detail dans commandeView

DROP VIEW commandeView CASCADE;
CREATE OR REPLACE VIEW commandeView AS SELECT commande_detail.id AS id_commande_detail, commande_detail.id_commande, produit.nom AS nomPlat, commande_detail.prix_unitaire AS prix, commande_detail.estMasake AS estMasake
FROM produit JOIN commande_detail ON commande_detail.id_produit = produit.id;

DROP TABLE if EXISTS Facture_Commande;
CREATE TABLE Facture_Commande(
	id SERIAL PRIMARY KEY NOT NULL,
	id_commande INT,
	est_Paye boolean,
	date DATE DEFAULT NOw()
);

DROP TABLE if EXISTS type_paiement;
CREATE TABLE type_paiement(
	id SERIAL PRIMARY KEY NOT NULL,
	nom_type VARCHAR(15)
);
INSERT INTO type_paiement VALUES (default, 'Cheque');
INSERT INTO type_paiement VALUES (default, 'Espece');

DROP TABLE if EXISTS paiement_facture_commande CASCADE;
CREATE TABLE paiement_facture_commande(
	id_facture_commande INT,
	montant DOUBLE PRECISION,
	id_type_paiement INT
);

CREATE OR REPLACE VIEW total_paiement_Cheque AS SELECT SUM(paiement_fac.montant)::DOUBLE PRECISION AS total, typee.nom_type, fac.date FROM paiement_facture_commande AS paiement_fac
JOIN type_paiement AS typee ON typee.id = paiement_fac.id_type_paiement JOIN facture_commande AS fac ON paiement_fac.id_facture_commande = fac.id GROUP BY typee.nom_type, fac.date;

insert into facture_commande values(default,1,false),(default,2,false),(default,3,false),(default,4,false),(default,5,false),(default,6,false);

insert into paiement_facture_commande values (1,1000, 1),(1,1000, 1),(1,1000, 1),(2,1000, 2),(2,1000, 2),(2,1000, 2),(3,1000, 2),(3,1000,1),(4,1000, 1 ),(4,1000, 2),(4,1000, 1);

select fc.id_commande,co.date,sum(cd.prix_unitaire),sum(pf.montant),tp.nom_type,case when sum(cd.prix_unitaire)=sum(pf.montant) then 'Payé' else 'non payé' end from facture_commande as fc 
    join paiement_facture_commande as pf on pf.id_facture_commande=fc.id 
    join commande as co on co.id=fc.id_commande 
    join type_paiement as tp on tp.id=pf.id_type_paiement 
    join commande_detail as cd on cd.id_commande=co.id
    where tp.nom_type='espece' group by fc.id_commande, co.date, tp.nom_type;

drop view if exists total_paiement_facture_view;
CREATE OR REPLACE VIEW total_paiement_facture_view AS
SELECT date, SUM(total_a_payer) AS total_a_paye, SUM(deja_paye) AS deja_paye, (SUM(total_a_payer) - SUM(deja_paye)) AS reste_a_payer, nom_type 
FROM Paiement_facture_view GROUP BY nom_type, date;
SELECT * from total_paiement_facture_view;