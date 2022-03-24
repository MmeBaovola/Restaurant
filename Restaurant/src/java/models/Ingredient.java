/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dbTable.DbTablePostgres;

public class Ingredient extends DbTablePostgres {

    int id;
    String nom;
    double prix_unitaire;

    public Ingredient() {
    }

    public Ingredient[] getListeIngredient(String conditions) {
        Object[] ingredients = this.select(conditions);
        Ingredient[] retour = new Ingredient[ingredients.length];
        for (int i = 0; i < ingredients.length; i++) {
            retour[i] = (Ingredient) ingredients[i];
        }
        return retour;
    }

    public Ingredient(int id, String nom, double prixUnitaire) {
        this.id = id;
        this.nom = nom;
        this.prix_unitaire = prixUnitaire;
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

    public double getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

}
