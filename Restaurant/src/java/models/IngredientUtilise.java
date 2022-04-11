/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dbTable.DbTablePostgres;
import java.sql.Date;

public class IngredientUtilise extends DbTablePostgres {

    Date date;
    int id_ingredient;
    String nom_ingredient;
    double prix_unitaire;
    double sum_quantite;
    double prix_total;

    public IngredientUtilise() {
    }

    public IngredientUtilise[] getListeIngredientUtilise(String conditions) {
        Object[] m = this.select(conditions);
        IngredientUtilise[] retour = new IngredientUtilise[m.length];
        for (int i = 0; i < m.length; i++) {
            retour[i] = (IngredientUtilise) m[i];
        }
        return retour;
    }

    public IngredientUtilise(Date date, int id_ingredient, String nom_ingredient, double prix_unitaire, double sum_quantite, double prix_total) {
        this.date = date;
        this.id_ingredient = id_ingredient;
        this.nom_ingredient = nom_ingredient;
        this.prix_unitaire = prix_unitaire;
        this.sum_quantite = sum_quantite;
        this.prix_total = prix_total;
    }

    public double getSum_quantite() {
        return sum_quantite;
    }

    public void setSum_quantite(double sum_quantite) {
        this.sum_quantite = sum_quantite;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId_ingredient() {
        return id_ingredient;
    }

    public void setId_ingredient(int id_ingredient) {
        this.id_ingredient = id_ingredient;
    }

    public String getNom_ingredient() {
        return nom_ingredient;
    }

    public void setNom_ingredient(String nom_ingredient) {
        this.nom_ingredient = nom_ingredient;
    }

    public double getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public double getPrix_total() {
        return prix_total;
    }

    public void setPrix_total(double prix_total) {
        this.prix_total = prix_total;
    }

}
