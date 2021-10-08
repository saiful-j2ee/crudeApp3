
package com.example.service;

import com.example.model.Customer;
import com.example.model.ValidateModel;
import com.example.repository.CustomerRepository;
import com.example.util.Utility;
import com.example.util.ValidateConstant;
import com.example.util.Validator;
import com.example.util.ValidatorService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Instructor
 */
public class CustomerServiceImpl implements CustomerService{
    private CustomerRepository customerRepository;
    private ValidatorService validatorService;
    
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        validatorService = new Validator();
    }
    
    @Override
    public Map<String, Object> save(Customer customer) {
        Map<String, Object> map = new HashMap<>();
        ValidateModel model = new ValidateModel(customer.getName(), customer.getEmail(), customer.getMobile());
        List<String> errors = validatorService.validate(model, ValidateConstant.Field.EMPTY, ValidateConstant.Field.EMAIL, ValidateConstant.Field.MOBILE);
        Customer OldCustomer = customerRepository.getCustomerByEmail(customer.getEmail());
        Customer OldCustomer2 = customerRepository.getCustomerByMobile(customer.getMobile());
        
        if(OldCustomer != null){
            errors.add("Custoemr email address exist");
        }
        if(OldCustomer2 != null){
           errors.add("Custoemr mobile address exist");
        }
        if(errors.isEmpty()){
            customerRepository.save(customer);
            map.put("message", "Save Successful!");
            map.put("status", Utility.status.SUCCESS);
        }else{
            map.put("message", "Save Failed!");
            map.put("errors", errors);
            map.put("status", Utility.status.FAILED);
        }
        return map;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.getAllCustomer();
    }
    
}
