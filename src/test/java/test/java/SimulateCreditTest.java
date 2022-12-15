package test.java;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pom.LoginSvpPage;
import utils.ExcelDataProvider;

import java.io.IOException;
import java.net.URL;

public class SimulateCreditTest {

    public RemoteWebDriver driver;
    public ExcelDataProvider excelDataProvider;
    public LoginSvpPage loginSvpPage;
    public String gridURL = "http://standalone-chrome:4444/";

    @BeforeTest
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.LINUX);
        try {
            driver = new RemoteWebDriver(new URL(gridURL), capabilities);
            driver.manage().window().maximize();
        } catch (Exception exception) {
            System.out.println("Exception message " + exception.getMessage());
        }
    }

    @Test(testName = "Simular crédito usuario PF2.0", dataProvider="credit_simulation_data")
    public void firstTestCase(String args[]) {
        try {
            driver.get("https://pwpwebqaohs.cajalosandes.cl/mi-sucursal/SimuladorDeCreditoUnico");
            loginSvpPage = new LoginSvpPage(driver);
            Reporter.log("Login SVP Pilar Financiero");
            loginSvpPage.loginUser(args[0], args[1]);
        } catch (Exception exception) {
            System.out.println("Exception message " + exception.getMessage());
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
        System.out.println("The driver has been closed.");
    }

    @DataProvider(name = "credit_simulation_data")
    public Object[][] getDataCreditSimulation() throws IOException {
        excelDataProvider = new ExcelDataProvider();
        return excelDataProvider.getTestData("credit_simulation_data.xlsx", "PF2.0");
    }
}
