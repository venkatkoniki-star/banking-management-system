package main;

import dao.UserDAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        UserDAO user = new UserDAO();
        System.out.println(user.validateLogin("admin","admin123"));
    }
}