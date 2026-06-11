/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */

package com.mycompany.chatapppart3;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class LoginTest {

    Login login = new Login();

    @Test
    public void testValidUsername() {
        assertTrue(login.checkUserName("ab_c"));
    }

    @Test
    public void testInvalidUsername() {
        assertFalse(login.checkUserName("abcd"));
    }

    @Test
    public void testValidPassword() {
        assertTrue(
                login.checkPasswordComplexity(
                        "Password1!"
                )
        );
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(
                login.checkPasswordComplexity(
                        "password"
                )
        );
    }

    @Test
    public void testValidPhoneNumber() {
        assertTrue(
                login.checkPhoneNumber(
                        "+27831234567"
                )
        );
    }

    @Test
    public void testInvalidPhoneNumber() {
        assertFalse(
                login.checkPhoneNumber(
                        "0831234567"
                )
        );
    }

    @Test
    public void testLoginSuccess() {

        login.registerUser(
                "ab_c",
                "Password1!",
                "+27831234567"
        );

        assertTrue(
                login.loginUser(
                        "ab_c",
                        "Password1!"
                )
        );
    }
}