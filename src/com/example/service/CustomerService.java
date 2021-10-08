/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.service;

import com.example.model.Customer;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Instructor
 */
public interface CustomerService {

    public Map<String, Object> save(Customer customer);

    public List<Customer> getAllCustomer();
}
