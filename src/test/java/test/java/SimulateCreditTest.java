package test.java;

import main.java.pom.PersonalInformationPage;
import main.java.utils.BaseTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main.java.pom.DigitalSimulationPage;
import main.java.pom.LoginSvpPage;
import main.java.utils.ExcelDataProvider;

import java.io.IOException;

public class SimulateCreditTest  extends BaseTests {

    WebDriver driver;
    LoginSvpPage loginSvpPage;
    DigitalSimulationPage digitalSimulationPage;
    PersonalInformationPage personalInformationPage;
    ExcelDataProvider excelDataProvider;

    @Test(dataProvider = "credit_simulation_data", testName = "Simular crédito usuario")
    public void test(String args[]) throws InterruptedException {
        this.driver = BaseTests.driver;
        loginSvpPage = new LoginSvpPage(driver);
        digitalSimulationPage = new DigitalSimulationPage(driver);
        personalInformationPage = new PersonalInformationPage(driver);
        loginSvpPage.loginUser(args[0], args[1]);
        digitalSimulationPage.simulateCredit(args[2], args[3], args[4], args[5]);
        digitalSimulationPage.validateTextInLabel(args[6]);
        digitalSimulationPage.requestCredit();
        personalInformationPage.updatePersonalInformation(args[7], args[8], args[9], args[10]);
        personalInformationPage.updateBankData(args[11], args[12], args[13]);
    }

    @DataProvider(name = "credit_simulation_data")
    public Object[][] getDataCreditSimulation() throws IOException {
        excelDataProvider = new ExcelDataProvider();
        return excelDataProvider.getTestData("credit_simulation_data.xlsx", "Sheet1");
    }
}
