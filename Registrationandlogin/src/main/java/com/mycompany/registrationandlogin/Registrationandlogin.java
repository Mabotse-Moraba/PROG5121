/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.Registrationandlogin;

import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
public class Registrationandlogin {
    //creating variables to save what the user has entered in the registration part.

    public String savedUserName;
    public String savedPassword;
    public String savedCellphone;
//method to check the username registered by the User if it met the requirements provided.

    public boolean checkUserName(String userName) {
        if (userName.contains("_") && userName.length() <= 5) {
            System.out.println("Username successfully captured");
            return true;
        } else {
            System.out.println("Username is incorrectly formatted");
            return false;
        }
    }
//a method to check the password if it met the requirements 

    public boolean checkPasswordComplexity(String password) {
        String upper = ".*[A-Z].*";
        String digit = ".*[0-9].*";
        String special = ".*[!@#$%^&*].*";

        if (password.matches(upper) && password.matches(digit)
                && password.matches(special) && password.length() >= 8) {

            System.out.println("The password is successfully captured");
            return true;
        } else {
            System.out.println("Password is not correctly formatted.");
            return false;
        }
    }
//Amethod to check the cellphone number complexity

    public boolean checkCellPhoneNumber(String cellphone) {
        String pattern = "^\\+27\\d{9}$";//[Baeldung, 2024]

        if (cellphone.matches(pattern)) {
            System.out.println("The cellphone is successfully added");
            return true;
        } else {
            System.out.println("Invalid cellphone format");
            return false;
        }
    }
//A method for register user to check the details registered

    public String registerUser(String userName, String password, String cellphone) {
        if (!checkUserName(userName)) {
            return "Username incorrectly formatted";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password incorrectly formatted";
        }
        if (!checkCellPhoneNumber(cellphone)) {
            return "Cellphone incorrectly formatted";
        }

        savedUserName = userName;
        savedPassword = password;
        savedCellphone = cellphone;

        return "User successfully registered";
    }
// method to check for the login user

    public boolean loginUser(String userName, String password) {
        return savedUserName.equals(userName) && savedPassword.equals(password);
    }
//Method to check the return login status.

    public String returnLoginStatus(boolean success, String firstName, String lastName) {
        if (success) {
            return "Welcome back " + firstName + " " + lastName + "!";
        } else {
            return "Incorrect username or password";
        }
    }
//Main method for the registration and log in
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Registrationandlogin system = new Registrationandlogin();

        System.out.println("===== REGISTRATION =====");
//tell user to enter their first name
        System.out.print("First name: ");
        String firstName = input.nextLine();
//tell user to enetr their last name
        System.out.print("Last name: ");
        String lastName = input.nextLine();
//tell the user to enter their username
        System.out.print("Username: ");
        String userName = input.nextLine();
//Tell the user to enter their password
        System.out.print("Password: ");
        String password = input.nextLine();
//tell the user to enter their cellphone number
        System.out.print("Cellphone (+27...): ");
        String cellphone = input.nextLine();
//method to print out user details
        System.out.println(system.registerUser(userName, password, cellphone));

        System.out.println("\n===== LOGIN =====");
//tell user to enter their login username
        System.out.print("Username: ");
        String loginUser = input.nextLine();
//tell the user to enter their password
        System.out.print("Password: ");
        String loginPass = input.nextLine();
//boolean method to check if they entered the correct details to log in
        boolean success = system.loginUser(loginUser, loginPass);
//method to print out what they entered
        System.out.println(system.returnLoginStatus(success, firstName, lastName));
//login message when the user has correctly logged in
        System.out.println("LOGIN SUCCESSFUL WELCOME BACK!");
    }
}
/*
Baeldung, 2024. Validate phone number with Java Regex. [online] available at: <https://www.baeldung.com/java-regex-validate-phone-numbers> {accessed on : 15 april 2026}
*/