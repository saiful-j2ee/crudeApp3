/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.repository;

import com.example.model.Customer;
import java.util.List;

/**
 *
 * @author Instructor
 */
public interface CustomerRepository {
    public Customer save(Customer customer);
    public Customer getCustomerByEmail(String emailAddress);
    public Customer getCustomerByMobile(String mobile);
    public List<Customer> getAllCustomer();
}
