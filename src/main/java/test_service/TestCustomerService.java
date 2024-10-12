/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test_service;

import com.werapan.databaseproject.model.Customer;
import com.werapan.databaseproject.service.CustomerService;

/**
 *
 * @author Aspire
 */
public class TestCustomerService {
    public static void main(String[] args) {
        CustomerService cs = new CustomerService();
        for (Customer customer : cs.getCustomers()) {
            System.out.println(customer);
        }
        System.out.println(cs.getByTel("0822800028"));
        Customer cus1 = new Customer("ping", "0987654321");
        cs.addNew(cus1);
        for (Customer customer : cs.getCustomers()) {
            System.out.println(customer);
        }
        Customer delCus = cs.getByTel("0987654321");
        cs.delete(delCus);
        
    }   
}
