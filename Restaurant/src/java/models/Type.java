/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dbTable.DbTablePostgres;

public class Type extends DbTablePostgres {

    int id;
    String nom;

    public static void main(String args[]) throws Exception {
        Type t = new Type(0, "laoka");
        Type[] types = t.getListeType("");
        for (Type type : types) {
            System.out.println(type.getId() + type.getNom());
        }
    }

    public Type() {
    }

    public Type[] getListeType(String conditions) {
        Object[] types = this.select(conditions);
        Type[] retour = new Type[types.length];
        for (int i = 0; i < types.length; i++) {
            retour[i] = (Type) types[i];
        }
        return retour;
    }

    public Type(int id, String nom) {
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
