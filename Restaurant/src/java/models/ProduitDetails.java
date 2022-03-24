/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dbTable.DbTablePostgres;

public class ProduitDetails extends DbTablePostgres {

    int id_produit;
    int id_ingredient;
    int quantite;

    public ProduitDetails() {
    }

    public ProduitDetails(int idProduit, int idIngredient, int quantite) {
        this.id_produit = idProduit;
        this.id_ingredient = idIngredient;
        this.quantite = quantite;
    }

    public ProduitDetails[] getListeProduitDetails(String conditions) {
        Object[] produitDetails = this.select(conditions);
        ProduitDetails[] retour = new ProduitDetails[produitDetails.length];
        for (int i = 0; i < produitDetails.length; i++) {
            retour[i] = (ProduitDetails) produitDetails[i];
        }
        return retour;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public int getId_ingredient() {
        return id_ingredient;
    }

    public void setId_ingredient(int id_ingredient) {
        this.id_ingredient = id_ingredient;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

}
