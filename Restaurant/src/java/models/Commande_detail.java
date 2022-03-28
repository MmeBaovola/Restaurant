/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dbTable.DbTablePostgres;

public class Commande_detail extends DbTablePostgres {

    int id;
    int id_commande;
    int id_produit;
    double prix_unitaire;

    public Commande_detail(int id, int id_commande, int id_produit, double prix_unitaire) {
        this.id = id;
        this.id_commande = id_commande;
        this.id_produit = id_produit;
        this.prix_unitaire = prix_unitaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Commande_detail() {
    }

    public Commande_detail[] getListeCommandeDetails(String conditions) {
        Object[] liste = this.select(conditions);
        Commande_detail[] retour = new Commande_detail[liste.length];
        for (int i = 0; i < liste.length; i++) {
            retour[i] = (Commande_detail) liste[i];
        }
        return retour;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public double getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

}
