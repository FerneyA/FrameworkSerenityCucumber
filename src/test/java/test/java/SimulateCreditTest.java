package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;

public class SimulateCreditTest {

    public static RemoteWebDriver driver = null;
    public String gridURL = "http://standalone-chrome:4444/";

    @BeforeTest
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "CHROME");
        capabilities.setCapability("platform", "LINUX"); // If this cap isn't specified, it will just get the any available one
        try {
            driver = new RemoteWebDriver(new URL(gridURL), capabilities);
        } catch (Exception e) {
            System.out.println("Excepción final: " + e.getMessage());
        }
    }

    @Test
    public void firstTestCase() {
        try {
            System.out.println("Logging into Lambda Test Sign Up Page");
            driver.get("https://pwpwebqaohs.cajalosandes.cl/mi-sucursal/SimuladorDeCreditoUnico");
            WebElement pageHeader= driver.findElement(By.name("username"));
            pageHeader.sendKeys("54597274");
            System.out.println("Clicked on the Sign In Button.");
        } catch (Exception e) {

        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        System.out.println("The driver has been closed.");
    }
}
