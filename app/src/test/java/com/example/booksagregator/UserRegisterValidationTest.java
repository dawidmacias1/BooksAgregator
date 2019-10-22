package com.example.booksagregator.validator;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserRegisterValidationTest {

    @Test
    public void isCorrectLength(){

        String password = "1Januszek!";
        String username = "janusz123";
        String email = "janusz@gmail.com";

        UserRegisterValidation userRegisterValidation = new UserRegisterValidation();

        boolean result = userRegisterValidation.validiate(password, username, email);

        assertTrue(result);
    }
}
