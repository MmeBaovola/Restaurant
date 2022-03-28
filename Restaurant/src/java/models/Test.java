/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dbTable.DbTablePostgres;
import java.util.Date;

public class Test extends DbTablePostgres {

    int id;
    Date daty;
    int id_table;

    public Test() {
    }

    public Test(int id, Date daty, int id_table) {
        this.id = id;
        this.daty = daty;
        this.id_table = id_table;
    }

    public static void main(String args[]) {
        Test test = new Test();
        System.out.println(test.getListe("").length);
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
