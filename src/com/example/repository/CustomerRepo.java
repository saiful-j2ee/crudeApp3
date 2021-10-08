












package com.example.repository;

import com.example.model.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepo implements CustomerRepository {

    private static List<Customer> customers = new ArrayList<Customer>();

    @Override
    public Customer save(Customer customer) {
        boolean isSaved = customers.add(customer);
        return isSaved ? customer : null;
    }

    @Override
    public Customer getCustomerByEmail(String emailAddress) {
        for (Customer customer : customers) {
            if (emailAddress.equalsIgnoreCase(customer.getEmail())) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public Customer getCustomerByMobile(String mobile) {
        for (Customer customer : customers) {
            if (mobile.equalsIgnoreCase(customer.getMobile())) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customers;
    }

}
