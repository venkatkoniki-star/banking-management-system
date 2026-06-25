package dao;

import db.DBConnection;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;

public class CustomerDAO {

    public boolean addCustomer(Customer customer) {

        String query =
                "INSERT INTO customers(full_name, phone, email, address) VALUES(?,?,?,?)";

        try {
            Connection conn = DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(query);

            ps.setString(1, customer.getFullName());
            ps.setString(2, customer.getPhone());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getAddress());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public List<Customer> getAllCustomers(){
        List<Customer> customers = new ArrayList<>();
        String query = "select * from customers";
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs =ps.executeQuery();
            while(rs.next()){
                Customer customer = new Customer();
                customer.setCustomerId(rs.getInt("customer_id"));
                customer.setFullName(rs.getString("full_name"));
                customer.setPhone(rs.getString("phone"));
                customer.setEmail(rs.getString("email"));
                customer.setAddress(rs.getString("address"));

                customers.add(customer);

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return customers;
    }
    public boolean updateCustomer(Customer customer){
        String query = "UPDATE customers SET full_name=?,phone=?,email=?,address=? where customer_id = ?";
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, customer.getFullName());
            ps.setString(2, customer.getPhone());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getAddress());
            ps.setInt(5, customer.getCustomerId());

            int rows = ps.executeUpdate();

            return rows > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;

    }
}



