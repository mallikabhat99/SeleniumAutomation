package com.mb.learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

//@Listeners(com.mb.learning.TestNGListener.class)
public class FirstTestScript {
    WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void startBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("chrome")) {
            // System.setProperty("webdriver.chrome.driver", "path////");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("IE")) {
            // System.setProperty("webdriver.ie.driver", "path////");
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        System.out.println("Browser started");

    }

    @Test(priority = 1, description = "Verify login", groups = {"smoke"})
    public void loginToApplication() {
        driver.get("https://www.pearson.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        String title = driver.getTitle();
        String pgSource = driver.getPageSource();
        String expectedTitle = "Pearson | The World's Leading Education Provider";
        System.out.println(title);
        Assert.assertEquals(title, expectedTitle, "Title does not match!");
        Assert.assertTrue(pgSource.contains(expectedTitle), "Page source does not contain expected!");
    }

    @Test(priority = 2, dependsOnMethods = "loginToApplication",
            description = "Adds test cases to basket", groups = {"sanity"})
    public void selectItems() {
        System.out.println("Selected items");
    }

    @Test(priority = 3, dependsOnMethods = {"loginToApplication", "selectItems"},
            description = "Verify checkout", groups = {"regression"})
    public void checkOut() {
        System.out.println("Check out");
    }

    @Test(priority = 4, dependsOnMethods = {"loginToApplication"},
            description = "Verify checkout", groups = {"smoke", "regression"})
    public void doneWithTest() {
        System.out.println("Done with test");
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
        System.out.println("Browser closed");


    }
}
