/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dbTable.DbTablePostgres;

public class Serveur extends DbTablePostgres {

    int id;
    String nom;
    double pourcentage;

    public Serveur[] getListeServeur(String conditions) {
        Object[] liste = this.select(conditions);
        Serveur[] retour = new Serveur[liste.length];
        for (int i = 0; i < liste.length; i++) {
            retour[i] = (Serveur) liste[i];
        }
        return retour;
    }

    public Serveur() {
    }

    public Serveur(int id, String nom, double pourcentage) {
        this.id = id;
        this.nom = nom;
        this.pourcentage = pourcentage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(double pourcentage) {
        this.pourcentage = pourcentage;
    }

}
