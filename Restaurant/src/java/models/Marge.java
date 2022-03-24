/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dbTable.DbTablePostgres;

public class Marge extends DbTablePostgres {

    double min;
    double max;
    double pourcentage;
    boolean isCurrent;

    public Marge() {
    }

    public Marge[] getListeMarge(String conditions) {
        Object[] m = this.select("isCurrent = true");
        Marge[] retour = new Marge[m.length];
        for (int i = 0; i < m.length; i++) {
            retour[i] = (Marge) m[i];
        }
        return retour;
    }

    public Marge(double min, double max, double pourcentage, boolean isCurrent) {
        this.min = min;
        this.max = max;
        this.pourcentage = pourcentage;
        this.isCurrent = isCurrent;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(double pourcentage) {
        this.pourcentage = pourcentage;
    }

    public boolean isIsCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(boolean isCurrent) {
        this.isCurrent = isCurrent;
    }

}
