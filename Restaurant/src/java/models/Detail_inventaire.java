/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dbTable.DbTablePostgres;

public class Detail_inventaire extends DbTablePostgres {
    int id_inventaire;
    int id_ingredient;
    int quantite;

    public Detail_inventaire() {
    }

    public Detail_inventaire(int id_inventaire, int id_ingredient, int quantite) {
        this.id_inventaire = id_inventaire;
        this.id_ingredient = id_ingredient;
        this.quantite = quantite;
    }

    public int getId_inventaire() {
        return id_inventaire;
    }

    public void setId_inventaire(int id_inventaire) {
        this.id_inventaire = id_inventaire;
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
