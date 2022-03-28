/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dbTable.DbTablePostgres;

public class LaTable extends DbTablePostgres {

    int id;
    String nom;

    public LaTable[] getListeTable(String conditions) {
        Object[] liste = this.select(conditions);
        LaTable[] retour = new LaTable[liste.length];
        for (int i = 0; i < liste.length; i++) {
            retour[i] = (LaTable) liste[i];
        }
        return retour;
    }

    public LaTable() {
    }

    public LaTable(int id, String nom) {
        this.id = id;
        this.nom = nom;
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

}
