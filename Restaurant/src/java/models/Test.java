/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dbTable.DbTablePostgres;
import java.math.BigInteger;
import java.sql.Date;

public class Test extends DbTablePostgres {

    Date date;
    int sum;

    public Test() {
    }

    public Test(Date date, int sum) {
        this.date = date;
        this.sum = sum;
    }

    public Test[] getListe(String conditions) {
        Object[] ingredients = this.select(conditions);
        Test[] retour = new Test[ingredients.length];
        for (int i = 0; i < ingredients.length; i++) {
            retour[i] = (Test) ingredients[i];
        }
        return retour;
    }
}
