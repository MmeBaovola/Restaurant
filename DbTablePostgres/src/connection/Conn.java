package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {

    Connection connexion;
    String database = "restaurantBaovola";

    public String getDatabase() {
        return this.database;
    }

    public Connection getConnection() {
        return this.connexion;
    }

    public void setConnexion(Connection connection) {
        this.connexion = connection;
    }

    public Conn() throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1:5432/" + this.getDatabase();
            String user = "postgres";
            String pass = "1234";
            this.setConnexion(DriverManager.getConnection(url, user, pass));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
