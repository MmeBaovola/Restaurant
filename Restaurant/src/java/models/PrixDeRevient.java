/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dbTable.DbTablePostgres;

public class PrixDeRevient extends DbTablePostgres {

    private int id;
    private int id_type;
    private String nom;
    private double prix;
    private double prix_de_revient;

    public PrixDeRevient() {
    }

    public PrixDeRevient[] getListePrixDeRevient(String conditions) {
        Object[] pr = this.select(conditions);
        PrixDeRevient[] retour = new PrixDeRevient[pr.length];
        for (int i = 0; i < pr.length; i++) {
            retour[i] = (PrixDeRevient) pr[i];
        }
        return retour;
    }

    public double getPrixDeRevientSuggere() {
        double pr = this.prix - this.prix_de_revient;
        double retour = 0;
        Marge m = new Marge();
        Marge[] marges = m.getListeMarge("");
        for (Marge marge : marges) {
            if (pr >= marge.getMin() && pr < marge.getMax()) {
                retour = pr + (pr * (marge.getPourcentage() / 100));
                break;
            }
        }
        return retour;
    }

    public PrixDeRevient(int id, int id_type, String nom, double prix, double prix_de_revient) {
        this.id = id;
        this.id_type = id_type;
        this.nom = nom;
        this.prix = prix;
        this.prix_de_revient = prix_de_revient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_type() {
        return id_type;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getPrix_de_revient() {
        return prix_de_revient;
    }

    public void setPrix_de_revient(double prix_de_revient) {
        this.prix_de_revient = prix_de_revient;
    }

}
