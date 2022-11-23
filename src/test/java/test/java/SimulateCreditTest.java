package test.java;

import main.java.utils.BaseTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main.java.pom.DigitalSimulationPage;
import main.java.pom.HomeBranchPage;
import main.java.pom.LoginSvpPage;
import main.java.utils.ExcelDataProvider;

import java.io.IOException;
import java.util.ArrayList;

import static org.testng.AssertJUnit.assertTrue;

public class SimulateCreditTest  extends BaseTests {

    WebDriver driver;
    LoginSvpPage loginSvpPage;
    HomeBranchPage homeBranchPage;
    DigitalSimulationPage digitalSimulationPage;
    ExcelDataProvider excelDataProvider;

    @Test(dataProvider = "credit_simulation_data", testName = "Simular crédito usuario")
    public void test(String args[]) throws InterruptedException {
        this.driver = BaseTests.driver;
        loginSvpPage = new LoginSvpPage(driver);
        //homeBranchPage = new HomeBranchPage(driver);
        digitalSimulationPage = new DigitalSimulationPage(driver);
        loginSvpPage.loginUser(args[0], args[1]);
        //assertTrue("Object on screen was not loaded!!", homeBranchPage.selectDirectAccess("SIMULA TU CRÉDITO"));
        //ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        //driver.switchTo().window(tabs2.get(1));
        digitalSimulationPage.simulateCredit(args[2], args[3]);
        assertTrue("Message was not found", digitalSimulationPage.validateSimulationResults("Resultados Simulaci"));
        digitalSimulationPage.requestCredit();
    }

    @DataProvider(name = "credit_simulation_data")
    public Object[][] getDataCreditSimulation() throws IOException {
        excelDataProvider = new ExcelDataProvider();
        return excelDataProvider.getTestData("credit_simulation_data.xlsx", "Sheet1");
    }
}
