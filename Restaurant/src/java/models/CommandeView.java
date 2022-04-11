/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dbTable.DbTablePostgres;

public class CommandeView extends DbTablePostgres {

    int id_commande_detail;
    int id_commande;
    String nomPlat;
    double prix;
    boolean estMasake;

    public CommandeView() {
    }

    public CommandeView(int id_commande_detail, int id_commande, String nomPlat, double prix, boolean estMasake) {
        this.id_commande_detail = id_commande_detail;
        this.id_commande = id_commande;
        this.nomPlat = nomPlat;
        this.prix = prix;
        this.estMasake = estMasake;
    }

    public int getId_commande_detail() {
        return id_commande_detail;
    }

    public void setId_commande_detail(int id_commande_detail) {
        this.id_commande_detail = id_commande_detail;
    }

    public CommandeView[] getListeCommandeView(String conditions) {
        Object[] liste = this.select(conditions);
        CommandeView[] retour = new CommandeView[liste.length];
        for (int i = 0; i < liste.length; i++) {
            retour[i] = (CommandeView) liste[i];
        }
        return retour;
    }

    public boolean isEstMasake() {
        return estMasake;
    }

    public void setEstMasake(boolean estMasake) {
        this.estMasake = estMasake;
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

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

}
