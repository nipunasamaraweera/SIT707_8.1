package web.service;

import org.junit.Assert;
import org.junit.Test;

public class LoginServiceUnitTest {

    @Test
    public void testValidLogin() {
        // Arrange
        String username = "nipuna";
        String password = "nipuna_pass";
        String dob = "1999-05-29";

        // Act
        boolean result = LoginService.login(username, password, dob);

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void testInvalidUsername() {
        // Arrange
        String username = "invalid_user";
        String password = "nipuna_pass";
        String dob = "1999-05-29";

        // Act
        boolean result = LoginService.login(username, password, dob);

        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void testInvalidPassword() {
        // Arrange
        String username = "nipuna";
        String password = "invalid_password";
        String dob = "1999-05-29";

        // Act
        boolean result = LoginService.login(username, password, dob);

        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void testInvalidDOB() {
        // Arrange
        String username = "nipuna";
        String password = "nipuna_pass";
        String dob = "01/01/1990"; // Invalid date format

        // Act
        boolean result = LoginService.login(username, password, dob);

        // Assert
        Assert.assertFalse(result);
    }
}
