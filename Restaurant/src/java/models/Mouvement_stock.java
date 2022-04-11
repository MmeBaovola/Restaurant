/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dbTable.DbTablePostgres;
import java.sql.Date;

public class Mouvement_stock extends DbTablePostgres {
    int id;
    int id_ingredient;
    Date date;
    int quantite;
    int type;

    public Mouvement_stock() {
    }
    public Mouvement_stock(int id, int id_ingredient, Date date, int quantite, int type) {
        this.id = id;
        this.id_ingredient = id_ingredient;
        this.date = date;
        this.quantite = quantite;
        this.type = type;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId_ingredient() {
        return id_ingredient;
    }

    public void setId_ingredient(int id_ingredient) {
        this.id_ingredient = id_ingredient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


}
