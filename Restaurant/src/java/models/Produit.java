package models;

import dbTable.DbTablePostgres;
import java.util.Vector;

public class Produit extends DbTablePostgres {

    private int idProduit;
    int id_type;
    private String nom;
    private double prix;

    public static void main(String args[]) throws Exception {
        Produit p = new Produit();
        Produit[] produits = p.getListeProduit("");
        for (Produit produit : produits) {
            System.out.println(produit.getIdProduit() + produit.getId_type() + produit.getId_type() + produit.getNom());
        }
    }

    public Produit() {
    }

    public Produit[] getListeProduit(String conditions) throws Exception {
        Object[] p = this.select(conditions);
        Produit[] retour = new Produit[p.length];
        for (int i = 0; i < p.length; i++) {
            retour[i] = (Produit) p[i];
        }
        return retour;
    }

    public Produit(int idProduit, int id_type, String nom, double prix) {
        this.idProduit = idProduit;
        this.id_type = id_type;
        this.nom = nom;
        this.prix = prix;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public int getId_type() {
        return id_type;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

}
