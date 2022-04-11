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
public class Paiement_facture_view extends DbTablePostgres {

    int id_commande;
    Date date;
    double total_a_payer;
    double deja_paye;
    String nom_type;

    public Paiement_facture_view[] getListePaiement(String conditions) {
        Object[] paiements = this.select(conditions);
        Paiement_facture_view[] retour = new Paiement_facture_view[paiements.length];
        for (int i = 0; i < paiements.length; i++) {
            retour[i] = (Paiement_facture_view) paiements[i];
        }
        return retour;
    }

    public Paiement_facture_view() {
    }

    public Paiement_facture_view(int id_commande, Date date, double total_a_payer, double deja_paye, String nom_type) {
        this.id_commande = id_commande;
        this.date = date;
        this.total_a_payer = total_a_payer;
        this.deja_paye = deja_paye;
        this.nom_type = nom_type;
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

    public double getTotal_a_payer() {
        return total_a_payer;
    }

    public void setTotal_a_payer(double total_a_payer) {
        this.total_a_payer = total_a_payer;
    }

    public double getDeja_paye() {
        return deja_paye;
    }

    public void setDeja_paye(double deja_paye) {
        this.deja_paye = deja_paye;
    }

    public String getNom_type() {
        return nom_type;
    }

    public void setNom_type(String nom_type) {
        this.nom_type = nom_type;
    }

}
