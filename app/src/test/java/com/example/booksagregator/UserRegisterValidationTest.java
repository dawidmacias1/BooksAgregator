package com.example.booksagregator;


import com.example.booksagregator.validator.UserRegisterValidation;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserRegisterValidationTest {

    @Test
    public void isCorrectPLength(){

        String password = "rrr1!2rrrArr";
        String username = "lujoo66";
        String email = "janussz@gmail.com";

        UserRegisterValidation userRegisterValidation = new UserRegisterValidation();

        assertTrue(userRegisterValidation.validiate(password, username, email));
    }
}
