/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dbTable.DbTablePostgres;

public class CommandeView extends DbTablePostgres {

    int id_commande;
    String nomPlat;
    int quantite;
    double prix;

    public CommandeView() {
    }

    public CommandeView[] getListeCommandeView(String conditions) {
        Object[] liste = this.select(conditions);
        CommandeView[] retour = new CommandeView[liste.length];
        for (int i = 0; i < liste.length; i++) {
            retour[i] = (CommandeView) liste[i];
        }
        return retour;
    }

    public CommandeView(int id_commande, String nomPlat, int quantite, double prix) {
        this.id_commande = id_commande;
        this.nomPlat = nomPlat;
        this.quantite = quantite;
        this.prix = prix;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public String getNomPlat() {
        return nomPlat;
    }

    public void setNomPlat(String nomPlat) {
        this.nomPlat = nomPlat;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

}
