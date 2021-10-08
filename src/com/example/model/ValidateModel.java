/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

/**
 *
 * @author Instructor
 */
public class ValidateModel {

    private String text;
    private String email;
    private String mobile;

    public ValidateModel(String text, String email, String mobile) {
        this.text = text;
        this.email = email;
        this.mobile = mobile;
    }

    public ValidateModel(String email, String mobile) {
        this.email = email;
        this.mobile = mobile;
    }

    public ValidateModel(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}
