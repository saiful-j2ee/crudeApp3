/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.model.Customer;
import com.example.service.CustomerService;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Instructor
 */
public class CustomerController {
    private CustomerService customerService;
    
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    
    public Map<String, Object> save(Customer customer) {       
       return customerService.save(customer);
    }
    
     public List<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }
}
