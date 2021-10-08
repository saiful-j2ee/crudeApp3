
package com.example.util;

import com.example.model.ValidateModel;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator implements ValidatorService {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    
     public static final Pattern VALID_MOBILE_NUMBER_REGEX = 
    Pattern.compile("^(?:\\+88|01)?(?:\\d{11}|\\d{13})$", Pattern.CASE_INSENSITIVE);
    @Override
    public boolean isEmpty(String text) {
        if (text != null || !text.trim().equals("")) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isEmpty(int numberValue) {
        if (numberValue == 0 && numberValue < 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty(long numberValue) {
        if (numberValue == 0 && numberValue < 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty(double numberValue) {
         if (numberValue == 0 && numberValue < 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isValidEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    @Override
    public boolean isValidMobile(String mobile) {
         Matcher matcher = VALID_MOBILE_NUMBER_REGEX.matcher(mobile);
        return matcher.find();
    }
    
    @Override
    public List<String> validate(ValidateModel model, ValidateConstant.Field... field) {
        List<String> erros = new ArrayList<>();
        for (ValidateConstant.Field FIELD : field) {
            switch(FIELD){
                case EMPTY: 
                    if(isEmpty(model.getText())){
                        erros.add("Name is empty not allowed.");
                    }
                    break;
                case EMAIL: 
                    if(!isValidEmail(model.getEmail())){
                        erros.add("Email not valid");
                    }
                    break;
                case MOBILE: 
                    if(!isValidMobile(model.getMobile())){
                        erros.add("Mobile not valid");
                    }
                    break;
                default:
                    erros.add("UNKNOWN field");
            }
        }
        
        return erros;
    }

}
