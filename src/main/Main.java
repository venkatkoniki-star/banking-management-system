package main;

import dao.CustomerDAO;
import dao.UserDAO;
import model.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDAO user = new UserDAO();
        System.out.println(user.validateLogin("admin","admin123"));
        Customer customer1 = new Customer(2,"koniki Srinivasaro","9958899606","srinukoniki160578@gamil.com","penumaka");
        CustomerDAO dao = new CustomerDAO();
        System.out.println(dao.updateCustomer(customer1));


        List<Customer> customers = dao.getAllCustomers();

        for (Customer customer : customers) {
            System.out.println("customer id: "+ customer.getCustomerId());
            System.out.println("customer full name: "+ customer.getFullName());
            System.out.println("customer phone no: "+ customer.getPhone());
            System.out.println("customer email: "+ customer.getEmail());
            System.out.println("customer address: "+ customer.getAddress());
            System.out.println("-------------------------");
        }
    }
}