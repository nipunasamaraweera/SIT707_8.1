package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginServiceTest {
    
    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testLoginSuccess() {
        System.setProperty(
                "webdriver.chrome.driver",
                "/Users/nipunathathasara/Downloads/chromedriver-mac-x64/chromedriver");

        WebDriver driver = new ChromeDriver();
        System.out.println("Driver info: " + driver);

        // Full path where login.html is located.
        driver.navigate().to(
                "file:///Users/nipunathathasara/Downloads/SIT707_8.1/8.1P-resources/pages/login.html");
        sleep(5);

        // Find username element
        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("nipuna");

        // Find password element
        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys("nipuna_pass");

        // Find date of birth element
        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("29-05-1999"); // Updated date of birth

        // Find Submit button and click on it
        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();

        sleep(5);

        // Check the title of the page after login
        String title = driver.getTitle();
        System.out.println("Title: " + title);

        Assert.assertEquals(title, "success");

        driver.close();
    }

    @Test
    public void testLoginFailure() {
        System.setProperty(
                "webdriver.chrome.driver",
                "/Users/nipunathathasara/Downloads/chromedriver-mac-x64/chromedriver");

        WebDriver driver = new ChromeDriver();
        System.out.println("Driver info: " + driver);

        // Full path where login.html is located.
        driver.navigate().to(
                "file:///Users/nipunathathasara/Downloads/SIT707_8.1/8.1P-resources/pages/login.html");
        sleep(5);

        // Find username element
        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("invalid_user");

        // Find password element
        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys("invalid_password");

        // Find date of birth element
        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("1999-05-29"); // Updated date of birth

        // Find Submit button and click on it
        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();

        sleep(5);

        // Check the title of the page after login
        String title = driver.getTitle();
        System.out.println("Title: " + title);

        Assert.assertEquals(title, "fail");

        driver.close();
    }

    @Test
    public void testInvalidDateFormat() {
        System.setProperty(
                "webdriver.chrome.driver",
                "/Users/nipunathathasara/Downloads/chromedriver-mac-x64/chromedriver");

        WebDriver driver = new ChromeDriver();
        System.out.println("Driver info: " + driver);

        // Full path where login.html is located.
        driver.navigate().to(
                "file:///Users/nipunathathasara/Downloads/SIT707_8.1/8.1P-resources/pages/login.html");
        sleep(5);

        // Find username element
        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("nipuna");

        // Find password element
        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys("nipuna_pass");

        // Find date of birth element
        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("05/29/1999"); // Invalid date format

        // Find Submit button and click on it
        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();

        sleep(5);

        // Check the title of the page after login
        String title = driver.getTitle();
        System.out.println("Title: " + title);

        Assert.assertEquals(title, "fail");

        driver.close();
    }
}

