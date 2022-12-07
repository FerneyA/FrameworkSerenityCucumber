package test.java;

import main.java.pom.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main.java.utils.ExcelDataProvider;

import java.awt.*;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class SimulateCreditTest  extends BaseTests {

    WebDriver driver;
    LoginSvpPage loginSvpPage;
    DigitalSimulationPage digitalSimulationPage;
    PersonalInformationPage personalInformationPage;
    DocumentsPage documentsPage;
    SummaryPage summaryPage;
    ExcelDataProvider excelDataProvider;

    @Test(testName = "Simular crédito usuario PF2.0")
    public void test(String args[]) throws InterruptedException, AWTException {
        this.driver = BaseTests.driver;
        loginSvpPage = new LoginSvpPage(driver);
        digitalSimulationPage = new DigitalSimulationPage(driver);
        personalInformationPage = new PersonalInformationPage(driver);
        documentsPage = new DocumentsPage(driver);
        summaryPage = new SummaryPage(driver);
        loginSvpPage.loginUser("55589143", "QA2022");
        /*digitalSimulationPage.simulateCredit(args[2], args[3], args[4], args[5]);
        digitalSimulationPage.validateTextInLabel(args[6]);
        digitalSimulationPage.requestCredit();
        personalInformationPage.updatePersonalInformation(args[7], args[8], args[9], args[10]);
        personalInformationPage.updateBankData(args[11], args[12], args[13]);
        documentsPage.uploadDocumentId();
        assertEquals(summaryPage.getRequestAmount(), args[14]);
        assertEquals(summaryPage.getDues(), args[3]);
        assertEquals(summaryPage.getAccountNumber(), args[13]);
        assertEquals(summaryPage.getBank(), args[11]);
        assertEquals(summaryPage.getRut(), args[15]);
        summaryPage.reviewDocuments();*/
    }

    @DataProvider(name = "credit_simulation_data")
    public Object[][] getDataCreditSimulation() throws IOException {
        excelDataProvider = new ExcelDataProvider();
        return excelDataProvider.getTestData("credit_simulation_data.xlsx", "PF2.0");
    }
}
