package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Automatically handles ChromeDriver installation
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void testLogin() {
        LoginPage page = new LoginPage(driver);
        page.enterUsername("student");
        page.enterPassword("Password123");
        page.clickLogin();

        assert driver.getPageSource().contains("Logged In Successfully");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}


