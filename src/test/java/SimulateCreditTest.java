package test.java;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import main.java.pom.LoginSvpPage;
import main.java.pom.PersonalInformationPage;
import main.java.utils.ExcelDataProvider;
import main.java.utils.TakeScreenshot;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.URL;

public class SimulateCreditTest {

    public ExtentReports extent = new ExtentReports();
    static ExtentSparkReporter spark = new ExtentSparkReporter("target/surefire-reports/reports/chrome/index.html");
    public static RemoteWebDriver driver;
    public ExcelDataProvider excelDataProvider;
    public LoginSvpPage loginSvpPage;
    public PersonalInformationPage personalInformationPage;
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
            System.out.println("Exception message Before Test:" + exception.getMessage());
        }
    }

    @Test(testName = "Simular crédito usuario PF2.0", dataProvider="credit_simulation_data")
    public void firstTest(String args[]) {
        try {
            spark.config().setDocumentTitle("Report SVP");
            extent.attachReporter(spark);
            driver.get("https://pwpwebqaohs.cajalosandes.cl/mi-sucursal/SimuladorDeCreditoUnico");
            loginSvpPage = new LoginSvpPage(driver);
            personalInformationPage = new PersonalInformationPage(driver);
            extent.createTest("Cargar navegador OK")
            .log(Status.PASS, "Se levantó correctamente el navegador");
            loginSvpPage.loginUser(args[0], args[1]);
            extent.createTest("Login SVP")
                        .createNode("CP001 - Login SVP")
                    .assignDevice("Linux").pass(MediaEntityBuilder.createScreenCaptureFromPath(TakeScreenshot.getScreenShot(driver)).build());
        } catch (Exception exception) {
            System.out.println("Exception message first Test::" + exception.getMessage());
        }
    }

    @AfterTest
    public void closeBrowser() {
        extent.flush();
        driver.quit();
        System.out.println("The driver has been closed.");
    }

    @DataProvider(name = "credit_simulation_data")
    public Object[][] getDataCreditSimulation() throws IOException {
        excelDataProvider = new ExcelDataProvider();
        return excelDataProvider.getTestData("credit_simulation_data.xlsx", "PF2.0");
    }
}
