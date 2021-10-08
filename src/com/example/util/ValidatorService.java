/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.util;

import com.example.model.ValidateModel;
import java.util.List;

/**
 *
 * @author Instructor
 */
public interface ValidatorService {

    public boolean isEmpty(String text);

    public boolean isEmpty(int numberValue);

    public boolean isEmpty(long numberValue);

    public boolean isEmpty(double numberValue);
    
    public boolean isValidEmail(String email);
    
    public boolean isValidMobile(String mobile);
    
    public List<String> validate(ValidateModel masterData, ValidateConstant.Field...field);
}
