package test.java;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pom.LoginSvpPage;

import java.net.URL;

public class SimulateCreditTest {

    public RemoteWebDriver driver;
    public LoginSvpPage loginSvpPage;
    public String gridURL = "http://standalone-chrome:4444/";

    @BeforeTest
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.LINUX);
        try {
            driver = new RemoteWebDriver(new URL(gridURL), capabilities);
        } catch (Exception exception) {
            System.out.println("Exception message " + exception.getMessage());
        }
    }

    @Test
    public void firstTestCase() {
        try {
            driver.get("https://pwpwebqaohs.cajalosandes.cl/mi-sucursal/SimuladorDeCreditoUnico");
            loginSvpPage = new LoginSvpPage(driver);
            loginSvpPage.loginUser("55589143", "QA2022");
        } catch (Exception exception) {
            System.out.println("Exception message " + exception.getMessage());
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        System.out.println("The driver has been closed.");
    }
}
