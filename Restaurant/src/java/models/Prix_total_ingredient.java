/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dbTable.DbTablePostgres;
import java.sql.Date;

/**
 *
 * @author ASUSROG
 */
public class Prix_total_ingredient extends DbTablePostgres {

    Date date;
    Double prix_total;

    public Prix_total_ingredient() {
    }

    public Prix_total_ingredient(Date date, Double prix_total) {
        this.date = date;
        this.prix_total = prix_total;
    }

    public Prix_total_ingredient[] getListePrix_total_ingredient(String conditions) {
        Object[] m = this.select(conditions);
        Prix_total_ingredient[] retour = new Prix_total_ingredient[m.length];
        for (int i = 0; i < m.length; i++) {
            retour[i] = (Prix_total_ingredient) m[i];
        }
        return retour;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrix_total() {
        return prix_total;
    }

    public void setPrix_total(Double prix_total) {
        this.prix_total = prix_total;
    }

}
