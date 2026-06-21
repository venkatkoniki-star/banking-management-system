package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String url = "jdbc:mysql://localhost:3306/banking_system";
    private static final String USER = "root";
    private static final String PASSWORD = "vksaaho123";
    public static Connection getConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url,USER,PASSWORD);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }


}
