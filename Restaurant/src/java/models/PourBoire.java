/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dbTable.DbTablePostgres;

public class PourBoire extends DbTablePostgres {

    int id;
    int id_serveur;
    int id_commande;
    double valeur;

    public PourBoire[] getListePourBoire(String conditions) {
        Object[] liste = this.select(conditions);
        PourBoire[] retour = new PourBoire[liste.length];
        for (int i = 0; i < liste.length; i++) {
            retour[i] = (PourBoire) liste[i];
        }
        return retour;
    }

    public PourBoire(int id, int id_serveur, int id_commande, double valeur) {
        this.id = id;
        this.id_serveur = id_serveur;
        this.id_commande = id_commande;
        this.valeur = valeur;
    }

    public PourBoire() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_serveur() {
        return id_serveur;
    }

    public void setId_serveur(int id_serveur) {
        this.id_serveur = id_serveur;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

}
