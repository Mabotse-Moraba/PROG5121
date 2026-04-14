/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registrationandlogin1;

import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
public class Registrationandlogin1 {

     public String savedUserName;
    public String savedPassword;
    public String savedCellphone;

    public boolean checkUserName(String userName) {
        if (userName.contains("_") && userName.length() <= 5) {
            System.out.println("Username successfully captured");
            return true;
        } else {
            System.out.println("Username is incorrectly formatted");
            return false;
        }
    }

    public boolean checkPasswordComplexity(String password) {
        String upper = ".*[A-Z].*";
        String digit = ".*[0-9].*";
        String special = ".*[!@#$%^&*].*";

        if (password.matches(upper) && password.matches(digit) &&
            password.matches(special) && password.length() >= 8) {

            System.out.println("The password is successfully captured");
            return true;
        } else {
            System.out.println("Password is not correctly formatted.");
            return false;
        }
    }

    public boolean checkCellPhoneNumber(String cellphone) {
        String pattern = "^\\+27\\d{9}$";

        if (cellphone.matches(pattern)) {
            System.out.println("The cellphone is successfully added");
            return true;
        } else {
            System.out.println("Invalid cellphone format");
            return false;
        }
    }

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

    public boolean loginUser(String userName, String password) {
        return savedUserName.equals(userName) && savedPassword.equals(password);
    }

    public String returnLoginStatus(boolean success, String firstName, String lastName) {
        if (success) {
            return "Welcome back " + firstName + " " + lastName + "!";
        } else {
            return "Incorrect username or password";
        }
    }


        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
          Registrationandlogin1 system = new Registrationandlogin1();

        System.out.println("===== REGISTRATION =====");

        System.out.print("First name: ");
        String firstName = input.nextLine();

        System.out.print("Last name: ");
        String lastName = input.nextLine();

        System.out.print("Username: ");
        String userName = input.nextLine();

        System.out.print("Password: ");
        String password = input.nextLine();

        System.out.print("Cellphone (+27...): ");
        String cellphone = input.nextLine();

        System.out.println(system.registerUser(userName, password, cellphone));

        System.out.println("\n===== LOGIN =====");

        System.out.print("Username: ");
        String loginUser = input.nextLine();

        System.out.print("Password: ");
        String loginPass = input.nextLine();

        boolean success = system.loginUser(loginUser, loginPass);

        System.out.println(system.returnLoginStatus(success, firstName, lastName));
    }
}
        
    