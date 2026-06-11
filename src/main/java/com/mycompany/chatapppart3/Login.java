/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapppart3;

/**
 *
 * @author Student
 */

public class Login {

    // Variables
    private String username;
    private String password;
    private String phoneNumber;

    // Check username
    public boolean checkUserName(String username) {

        return username.contains("_")
                && username.length() <= 5;
    }

    // Check password complexity
    public boolean checkPasswordComplexity(String password) {

        boolean hasUppercase = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        char[] passwordChars = password.toCharArray();

        for (char c : passwordChars) {

            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            }

            if (Character.isDigit(c)) {
                hasNumber = true;
            }

            if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }

        return password.length() >= 8
                && hasUppercase
                && hasNumber
                && hasSpecial;
    }

    // Check phone number
    public boolean checkPhoneNumber(String phoneNumber) {

        return phoneNumber.startsWith("+27")
                && phoneNumber.length() <= 12;
    }

    // Register user
    public String registerUser(String username,
                               String password,
                               String phoneNumber) {

        if (!checkUserName(username)) {
            return "Username is incorrectly formatted.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password does not meet complexity requirements.";
        }

        if (!checkPhoneNumber(phoneNumber)) {
            return "Phone number incorrectly formatted.";
        }

        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;

        return "User successfully registered.";
    }

    // Login user
    public boolean loginUser(String username,
                             String password) {

        return this.username.equals(username)
                && this.password.equals(password);
    }

    // Return login status
    public String returnLoginStatus(boolean loginSuccess) {

        if (loginSuccess) {
            return "Welcome to QuickChat.";
        } else {
            return "Username or password incorrect.";
        }
    }
}