package dao;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAO {
    public boolean validateLogin(String username,String password){

        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try{
            Connection conn =  DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();

            return rs.next();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;

    }

}

