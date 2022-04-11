/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dbTable.DbTablePostgres;
import java.sql.Date;

public class Total_paiement_facture_view extends DbTablePostgres {

    Date date;
    double total_a_paye;
    double deja_paye;
    double reste_a_payer;
    String nom_type;

    public Total_paiement_facture_view() {
    }

    public Total_paiement_facture_view(Date date, double total_a_paye, double deja_paye, double reste_a_payer, String nom_type) {
        this.date = date;
        this.total_a_paye = total_a_paye;
        this.deja_paye = deja_paye;
        this.reste_a_payer = reste_a_payer;
        this.nom_type = nom_type;
    }

    public Total_paiement_facture_view[] getListePaiement(String conditions) {
        Object[] paiements = this.select(conditions);
        Total_paiement_facture_view[] retour = new Total_paiement_facture_view[paiements.length];
        for (int i = 0; i < paiements.length; i++) {
            retour[i] = (Total_paiement_facture_view) paiements[i];
        }
        return retour;
    }

    public double getTotal_a_paye() {
        return total_a_paye;
    }

    public void setTotal_a_paye(double total_a_paye) {
        this.total_a_paye = total_a_paye;
    }

    public double getReste_a_payer() {
        return reste_a_payer;
    }

    public void setReste_a_payer(double reste_a_payer) {
        this.reste_a_payer = reste_a_payer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
