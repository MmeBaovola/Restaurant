package dbTable;

import connection.Conn;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class DbTablePostgres {

    public static void main(String[] args) throws Exception {
    }

    public DbTablePostgres() {
    }

    public Field[] getFields() {
        Class clazz = this.getClass();
        Field[] fields = clazz.getDeclaredFields();
        return fields;
    }

    public Class<?>[] getTypes() {
        Vector fieldTypeVector = new Vector();
        Field[] fields = getFields();
        for (Field field : fields) {
            fieldTypeVector.add(field.getType());
        }
        Object[] typeArray = fieldTypeVector.toArray();
        Class<?>[] type = new Class<?>[typeArray.length];
        for (int i = 0; i < type.length; i++) {
            type[i] = (Class<?>) typeArray[i];
        }
        return type;
    }

    public String getTableName() {
        String tableName = this.getClass().getSimpleName();
        return tableName;
    }

    public Constructor<?> getConstructor() throws Exception {
        Class clazz = this.getClass();
        return clazz.getConstructor(this.getTypes());
    }

    public Object[] getConstructorArgumentsInsert() throws IllegalArgumentException, IllegalAccessException {
        Vector retourVector = new Vector();
        Field[] fields = this.getFields();
        for (Field f : fields) {
            f.setAccessible(true);
            retourVector.add(f.get(this));
        }
        return retourVector.toArray();
    }

    public Object[] getConstructorArgumentsSelect(ResultSet resultSet, int n) throws IllegalArgumentException, IllegalAccessException, SQLException {
        Vector retourVector = new Vector();
        for (int i = 1; i <= n; i++) {
            retourVector.add(resultSet.getObject(i));
        }
        return retourVector.toArray();
    }

    public Object getInstance(Object[] constructorArguments) throws Exception {
        return getConstructor().newInstance(constructorArguments);
    }

    public Object getInstanceInsert() throws Exception {
        return getConstructor().newInstance(this.getConstructorArgumentsInsert());
    }

    public String getSelectQuery(String conditions) {
        String query = "SELECT * FROM " + getTableName();
        if (conditions != null && conditions != "") {
            try {
                query += " WHERE " + conditions;
            } catch (Exception e) {
            }
        }
        return query;
    }

    public String getInsertFields() {
        String retour = "(";
        Field[] fields = this.getFields();
        int i = 0;
        for (Field field : fields) {
            String toAdd = "";
            String name = field.getName();
            if (name.equals("id")) {
            } else {
                toAdd += name;
            }
            if (i < fields.length - 1 && !toAdd.equals("")) {
                toAdd += ", ";
            }
            i++;
            retour += toAdd;
        }
        retour += ")";
        return retour;
    }

    public String getInsertQuery(Object[] arguments) {
        String query = "INSERT INTO " + this.getTableName() + this.getInsertFields() + " VALUES (";
        int i = 0;
        for (Object arg : arguments) {
            String toAdd = "";
            if (this.getFields()[i].getName().equals("id")) {
            } else {
                if (arg instanceof String || arg instanceof Date) {
                    toAdd += "'" + arg + "'";
                } else if ((arg instanceof Integer) || (arg instanceof Double)) {
                    toAdd += arg;
                }
                if (i < arguments.length - 1) {
                    if (!"".equals(toAdd)) {
                        toAdd += ", ";
                    }
                }
            }
            query += toAdd;
            i++;
        }
        query += ")";
        System.out.print(query);
        return query;
    }

    public Object[] select(String conditions) {
        Vector retourVector = new Vector();
        String query = getSelectQuery(conditions);
        try {
            Conn conn = new Conn();
            Connection con = conn.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int numOfColumns = resultSetMetaData.getColumnCount();
            while (resultSet.next()) {
                try {
                    Object[] constructorArguments = this.getConstructorArgumentsSelect(resultSet, numOfColumns);
                    Object newInstance = this.getInstance(constructorArguments);
                    retourVector.add(newInstance);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            resultSet.close();
            preparedStatement.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Object[] retour = retourVector.toArray();
        return retour;
    }

    public void insert() throws Exception {
        String query = this.getInsertQuery(this.getConstructorArgumentsInsert());
        try {
            Conn connection = new Conn();
            Connection con = connection.getConnection();
            PreparedStatement prepStat = con.prepareStatement(query);
            prepStat.executeUpdate();
            prepStat.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(String sets, String conditions) {
        String table = this.getTableName();
        Connection con = null;
        try {
            Conn connexion = new Conn();
            con = connexion.getConnection();
            String query = "UPDATE " + table + " SET " + sets + " WHERE " + conditions;
            System.out.print(query);
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null)
                try {
                con.close();
            } catch (SQLException e) {
            }
        }
    }

    public void delete(String conditions) {
        String table = this.getTableName();
        Connection con = null;
        try {
            Conn connexion = new Conn();
            con = connexion.getConnection();
            String query = "DELETE FROM " + table;
            if (conditions.equals("")) {
            } else {
                query += " WHERE " + conditions;
            }
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null)
                try {
                con.close();
            } catch (SQLException e) {
            }
        }

    }
}
