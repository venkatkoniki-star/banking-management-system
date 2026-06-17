package main;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb",
                    "root",
                    "vksaaho123"
            );
            System.out.println("Connected!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}