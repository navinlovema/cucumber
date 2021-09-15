package designpattern.creational.singleton;

import java.sql.*;

public class SingletonDatabase {

    private static volatile Connection conn = null;
    private SingletonDatabase() {
        try{
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        }catch (SQLException e){
            e.printStackTrace();
        }
        if(conn!= null) {
            System.out.println("use getConnection() method to create...");
        }
    }

    public static Connection getConnection() throws SQLException {
        if(conn == null){
            synchronized (SingletonDatabase.class){
                if(conn == null) {
                    String url = "jdbc:derby:directory:memory/jpaserver_derby_files;create=true";
//                    String url = "jdbc:derby:directory:target/jpaserver_derby_files;create=true";
                    conn = DriverManager.getConnection(url);
                }
            }
        }
        return conn;
    }
}

class CallerSingletonDatabase {


    public static void main(String[] args) throws SQLException {
        Connection databaseConnection = SingletonDatabase.getConnection();
        Statement stmt = databaseConnection.createStatement();
        String query = "CREATE TABLE Employees( "
                + "Id INT NOT NULL GENERATED ALWAYS AS IDENTITY, "
                + "Name VARCHAR(255), "
                + "Salary INT NOT NULL, "
                + "Location VARCHAR(255), "
                + "PRIMARY KEY (Id))";
        stmt.execute(query);
        query = "INSERT INTO Employees("
                + "Name, Salary, Location) VALUES "
                + "('Amit', 30000, 'Hyderabad'), "
                + "('Kalyan', 40000, 'Vishakhapatnam'), "
                + "('Renuka', 50000, 'Delhi'), "
                + "('Archana', 15000, 'Mumbai'), "
                + "('Trupthi', 45000, 'Kochin'), "
                + "('Suchatra', 33000, 'Pune'), "
                + "('Rahul', 39000, 'Lucknow'), "
                + "('Trupti', 45000, 'Kochin')";

        stmt.execute(query);

        query = "SELECT Id, Name, Salary FROM Employees";
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()) {
            System.out.println("Id: "+rs.getString("Id"));
            System.out.println("Name: "+rs.getString("Name"));
            System.out.println("Salary: "+rs.getString("Salary"));
            System.out.println(" ");
        }
        databaseConnection.close();
    }
}
