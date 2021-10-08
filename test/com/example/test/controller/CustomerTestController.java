package com.example.test.controller;

import com.example.controller.CustomerController;
import com.example.model.Customer;
import com.example.repository.CustomerRepo;
import com.example.repository.CustomerRepository;
import com.example.service.CustomerService;
import com.example.service.CustomerServiceImpl;
import com.example.util.Utility;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.OrderWith;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.DEFAULT)
public class CustomerTestController {

    @Test
    public void testSave() {
        CustomerRepository customerRepository = new CustomerRepo();
        CustomerService customerService = new CustomerServiceImpl(customerRepository);

        CustomerController controller = new CustomerController(customerService);

        Map<String, Object> map = controller.save(new Customer(1, "Amina", "01724486878", "efdsfds@gmail.com", "Khulna"));
        Utility.status status = (Utility.status) map.get("status");

        if (map.containsKey("errors")) {
            List<String> errors = (List<String>) map.get("errors");
            for (String error : errors) {
                System.err.println(error);
            }
        }

        assertEquals(status, Utility.status.SUCCESS);

    }

    @Test
    public void testSave2() {
        CustomerRepository customerRepository = new CustomerRepo();
        CustomerService customerService = new CustomerServiceImpl(customerRepository);

        CustomerController controller = new CustomerController(customerService);

        Map<String, Object> map = controller.save(new Customer(1, "Rabeya", "01724486879", "nayeem@gmail.com", "Khulna"));
        Utility.status status = (Utility.status) map.get("status");

        if (map.containsKey("errors")) {
            List<String> errors = (List<String>) map.get("errors");
            for (String error : errors) {
                System.err.println(error);
            }
        }

        assertEquals(status, Utility.status.SUCCESS);

    }
    
    @Test
    public void testSave3() {
        CustomerRepository customerRepository = new CustomerRepo();
        CustomerService customerService = new CustomerServiceImpl(customerRepository);

        CustomerController controller = new CustomerController(customerService);

        Map<String, Object> map = controller.save(new Customer(1, "Sakib", "01724486889", "sakib@gmail.com", "Khulna"));
        Utility.status status = (Utility.status) map.get("status");

        if (map.containsKey("errors")) {
            List<String> errors = (List<String>) map.get("errors");
            for (String error : errors) {
                System.err.println(error);
            }
        }

        assertEquals(status, Utility.status.SUCCESS);

    }
    
    

    @Test    
    public void testGetAllCustoemr() {
        CustomerRepository customerRepository = new CustomerRepo();
        CustomerService customerService = new CustomerServiceImpl(customerRepository);
        CustomerController controller = new CustomerController(customerService);
        List<Customer> customers = controller.getAllCustomer();
        for (Customer customer : customers) {
            System.out.println("Customer Name: "+ customer.getName());
            System.out.println("Customer Eamil: "+ customer.getEmail());
            System.out.println("Customer Mobile: "+ customer.getMobile());
            System.out.println("Customer Address: "+ customer.getAddress());
            System.out.println("====================================");
        }
        assertEquals(customers.size(), 3);
    }
}
