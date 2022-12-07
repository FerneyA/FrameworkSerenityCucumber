package main.java.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.AssertJUnit.fail;

public class BaseTests {

    public static WebDriver driver;
    public ExtentSparkReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;

    @BeforeTest
    public void beforeTestMethod() {
        String path = System.getProperty("user.dir") +
                File.separator + "reports" + File.separator + "index.html";
        htmlReporter = new ExtentSparkReporter(path);
        htmlReporter.config().setDocumentTitle("Test Results");
        htmlReporter.config().setReportName("Web Automation Results");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Tester", "Ferney Arroyave Quintero");
    }

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void beforeMethodMethod(String browser, Method method) {
        logger = extent.createTest(method.getAnnotation(Test.class).testName());
        //setUpDriver(browser);
        remoteHubTest(browser);
        driver.manage().window().maximize();
        driver.get("https://pwpwebqaohs.cajalosandes.cl/mi-sucursal/SimuladorDeCreditoUnico");
    }

    @AfterMethod
    public void afterMethodMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + methodName + " Passed";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            logger.log(Status.PASS, m);
        } else if (result.getStatus() == ITestResult.FAILURE) {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + methodName + " Failed";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
            String path = System.getProperty("user.dir") + File.separator +
                    "screenshots" + File.separator + "failed" + File.separator +
                    result.getMethod().getMethodName();
            logger.fail(result.getThrowable(),
                    MediaEntityBuilder.createScreenCaptureFromPath(path).build());
            logger.log(Status.FAIL, m);
        } else if (result.getStatus() == ITestResult.SKIP) {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + methodName + " Skipped";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.AMBER);
            logger.log(Status.SKIP, m);
        }
        driver.quit();
    }

    @AfterTest
    public void afterTestMethod() {
        extent.flush();
    }

    public void setUpDriver(String browser){
        if (browser.equalsIgnoreCase("remote-chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:/Users/USUARIO/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("remote-firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:/Users/USUARIO/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("remote-edge")) {
            System.setProperty("webdriver.edge.driver", "C:/Users/USUARIO/drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", "C:/Users/USUARIO/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
    }

    public WebDriver remoteHubTest(String browserName) {
        if (browserName.equalsIgnoreCase("remote-chrome")) {
            try {
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setBrowserName(Browser.CHROME.browserName());
                //desiredCapabilities.setPlatform(Platform.LINUX);
                URL hubURL = new URL("http://standalone-chrome:4444/");
                driver = new RemoteWebDriver(hubURL, desiredCapabilities);
                driver.manage().window().maximize();
                return driver;
            } catch (MalformedURLException e) {
                fail(e.getMessage());
                return driver;
            }
        } else if (browserName.equalsIgnoreCase("remote-firefox")) {
            try {
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setBrowserName(Browser.FIREFOX.browserName());
                //desiredCapabilities.setPlatform(Platform.LINUX);
                URL hubURL = new URL("http://standalone-chrome:4444/");
                driver = new RemoteWebDriver(hubURL, desiredCapabilities);
                driver.manage().window().maximize();
                return driver;
            } catch (MalformedURLException e) {
                fail(e.getMessage());
                return driver;
            }
        }
        return driver;
    }
}
