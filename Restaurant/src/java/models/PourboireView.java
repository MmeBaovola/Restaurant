/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dbTable.DbTablePostgres;

public class PourboireView extends DbTablePostgres {

    String nom;
    int id_serveur;
    double somme;

    public PourboireView() {
    }

    public PourboireView[] getListePourboire(String date1, String date2) {
        Object[] ingredients = this.selectPersonnalise("SELECT serveur.nom, id_serveur, SUM(pourboire.valeur) as somme from serveur JOIN pourboire ON serveur.id = pourboire.id_serveur JOIN commande ON pourboire.id_commande = commande.id WHERE commande.date >= '" + date1 + "' and commande.date <= '" + date2 + "' GROUP by pourboire.id_serveur, serveur.nom;");
        System.out.println(ingredients.length);
        PourboireView[] retour = new PourboireView[ingredients.length];
        for (int i = 0; i < ingredients.length; i++) {
            retour[i] = (PourboireView) ingredients[i];
        }
        return retour;
    }

    public PourboireView(String nom, int id_serveur, double somme) {
        this.nom = nom;
        this.id_serveur = id_serveur;
        this.somme = somme;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId_serveur() {
        return id_serveur;
    }

    public void setId_serveur(int id_serveur) {
        this.id_serveur = id_serveur;
    }

    public double getSomme() {
        return somme;
    }

    public void setSomme(double somme) {
        this.somme = somme;
    }

}
