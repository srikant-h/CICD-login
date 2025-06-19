package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();

        // Set Chrome to headless mode (needed for Docker/Jenkins)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // Use new headless mode
        options.addArguments("--no-sandbox"); // Required for Linux containers
        options.addArguments("--disable-dev-shm-usage"); // Fix for low memory containers

        // Explicitly build ChromeDriverService (fixes constructor errors)
        ChromeDriverService service = new ChromeDriverService.Builder().build();
        driver = new ChromeDriver(service,options);

        // Navigate to the login test page
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


