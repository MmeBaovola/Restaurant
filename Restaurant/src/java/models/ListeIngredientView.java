/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dbTable.DbTablePostgres;

public class ListeIngredientView extends DbTablePostgres {

    int id_produit;
    String nom_ingredient;
    int quantite;

    public ListeIngredientView() {
    }

    public ListeIngredientView[] getListeIngredientView(String conditions) {
        Object[] ingredients = this.select(conditions);
        ListeIngredientView[] retour = new ListeIngredientView[ingredients.length];
        for (int i = 0; i < ingredients.length; i++) {
            retour[i] = (ListeIngredientView) ingredients[i];
        }
        return retour;
    }

    public ListeIngredientView(int id_produit, String nom_ingredient, int quantite) {
        this.id_produit = id_produit;
        this.nom_ingredient = nom_ingredient;
        this.quantite = quantite;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public String getNom_ingredient() {
        return nom_ingredient;
    }

    public void setNom_ingredient(String nom_ingredient) {
        this.nom_ingredient = nom_ingredient;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

}
