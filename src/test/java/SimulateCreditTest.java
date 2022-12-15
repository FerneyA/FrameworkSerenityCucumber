package test.java;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import main.java.utils.ExcelDataProvider;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class SimulateCreditTest {

    static ExtentReports extent;
    static ExtentSparkReporter CP001;
    public RemoteWebDriver driver;
    public main.java.utils.ExcelDataProvider excelDataProvider;
    public main.java.pom.LoginSvpPage loginSvpPage;
    public String gridURL = "http://standalone-chrome:4444/";

    @BeforeTest
    public void setUp() {
        extent = new ExtentReports();
        CP001 = new ExtentSparkReporter(System.getProperty("user.dir") + "/target/surefire-reports/CP001.html");
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
    public void CP001(String args[]) {
        try {
            String path = System.getProperty("user.dir") + "/target/surefire-reports/CP001_OK.png";
            System.out.println("Path...: " + path);
            extent.attachReporter(CP001);
            driver.get("https://pwpwebqaohs.cajalosandes.cl/mi-sucursal/SimuladorDeCreditoUnico");
            loginSvpPage = new main.java.pom.LoginSvpPage(driver);
            Reporter.log("Login SVP Pilar Financiero");
            extent.createTest("Login SVP Pilar Financiero")
                    .log(Status.PASS, "Se levanta correctamente el navegador");
            loginSvpPage.loginUser(args[0], args[1]);
            loginSvpPage.takeScreenshot();
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(path));
            extent.createTest("Login exitoso SVP")
                    .createNode("CP001")
                    .pass(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        } catch (Exception exception) {
            System.out.println("Exception message " + exception.getMessage());
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
        extent.flush();
        System.out.println("The driver has been closed.");
    }

    @DataProvider(name = "credit_simulation_data")
    public Object[][] getDataCreditSimulation() throws IOException {
        excelDataProvider = new ExcelDataProvider();
        return excelDataProvider.getTestData("credit_simulation_data.xlsx", "PF2.0");
    }
}
