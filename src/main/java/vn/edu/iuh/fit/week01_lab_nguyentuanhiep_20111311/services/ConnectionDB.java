package vn.edu.iuh.fit.week01_lab_nguyentuanhiep_20111311.services;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
    private Connection connection;
    private static ConnectionDB instance;
    public ConnectionDB() {
       try {
           Class.forName("org.mariadb.jdbc.Driver");
           String url = "jdbc:mariadb://localhost:3306/mydb?createDatabaseIfNotExist=true";
           String user = "root";
           String password = "@Hiep180902";
           connection =  DriverManager.getConnection(url, user, password);

       }
       catch (Exception e) {
           e.printStackTrace();
       }
    }
    public static ConnectionDB getInstance() {
        if (instance == null) {
            instance = new ConnectionDB();
        }
        return instance;
    }
    public Connection getConnection() {
        return connection;
    }

}
