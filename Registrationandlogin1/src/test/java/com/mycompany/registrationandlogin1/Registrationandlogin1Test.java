/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.registrationandlogin1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lab_services_student
 */
public class Registrationandlogin1Test {
    
    public Registrationandlogin1Test() {
    }

    Registrationandlogin1 system = new Registrationandlogin1();

    //I am creating the test to test the username if it is correct.
    @Test
    public void testUsernameCorrectlyFormatted() {
        boolean result = system.checkUserName("Kyl_1");
        assertTrue(result);
    }
  // I am creating to test the username if it is incorrect. OLD ONE
    @Test
    public void testUsernameIncorrectlyFormatted() {
        boolean result = system.checkUserName("Kyle!!!!");
        assertFalse(result);
    }

    
    @Test
    public void testPasswordMeetsComplexity() {
        boolean result = system.checkPasswordComplexity("Ch&&sec@ke99!");
        assertTrue(result);
    }

    @Test
    public void testPasswordDoesNotMeetComplexity() {
        boolean result = system.checkPasswordComplexity("Password");
        assertFalse(result);
    }

    
    @Test
    public void testCellPhoneCorrectlyFormatted() {
        boolean result = system.checkCellPhoneNumber("+27838968976");
        assertTrue(result);
    }

    @Test
    public void testCellPhoneIncorrectlyFormatted() {
        boolean result = system.checkCellPhoneNumber("0838968976");
        assertFalse(result);
    }

    
    @Test
    public void testRegisterUserWithWrongUsername() {
        String result = system.registerUser("kyle!", "Ch&&sec@ke99!", "+27838968976");
        assertEquals("Username incorrectly formatted", result);
    }

    @Test
    public void testRegisterUserWithWrongPassword() {
        String result = system.registerUser("Kyl_1", "Password", "+27838968976");
        assertEquals("Password incorrectly formatted", result);
    }

    @Test
    public void testRegisterUserWithWrongCellPhoneNumber() {
        String result = system.registerUser("Kyl_1", "Ch&&sec@ke99!", "0838968976");
        assertEquals("Cellphone incorrectly formatted", result);
    }

    
    @Test
    public void testLoginSuccessful() {
        system.registerUser("Kyl_1", "Ch&&sec@ke99!", "+27838968976");
        boolean result = system.loginUser("Kyl_1", "Ch&&sec@ke99!");
        assertTrue(result);
    }

    @Test
    public void testLoginFailed() {
        system.registerUser("Kyl_1", "Ch&&sec@ke99!", "+27838968976");
        boolean result = system.loginUser("wrongUser", "wrongPass");
        assertFalse(result);
    }

    
    @Test
    public void testReturnLoginSuccessfulStatus() {
        String message = system.returnLoginStatus(true, "Kyle", "Smith");
        assertEquals("Welcome back Kyle Smith!", message);
    }

    @Test
    public void testReturnLoginFailedStatus() {
        String message = system.returnLoginStatus(false, "Kyle", "Smith");
        assertEquals("Incorrect username or password", message);
    }
}


