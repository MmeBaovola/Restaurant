/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dbTable.DbTablePostgres;
import java.util.Date;

public class Commande extends DbTablePostgres {

    int id_commande;
    Date date;
    int id_table;
    boolean is_valid;

    public Commande[] getListeCommande(String conditions) {
        Object[] liste = this.select(conditions);
        Commande[] retour = new Commande[liste.length];
        for (int i = 0; i < liste.length; i++) {
            retour[i] = (Commande) liste[i];
        }
        return retour;
    }

    public Commande() {
    }

    public Commande(int id_commande, Date daty, int id_table, boolean is_valid) {
        this.id_commande = id_commande;
        this.date = daty;
        this.id_table = id_table;
        this.is_valid = is_valid;
    }

    public boolean isIs_valid() {
        return is_valid;
    }

    public void setIs_valid(boolean is_valid) {
        this.is_valid = is_valid;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId_table() {
        return id_table;
    }

    public void setId_table(int id_table) {
        this.id_table = id_table;
    }

}
