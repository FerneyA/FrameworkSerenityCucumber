package test.java;

import main.java.pom.*;
import main.java.utils.ExcelDataProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class SimulateCreditPF1Test extends BaseTests {

    WebDriver driver;
    LoginSvpPage loginSvpPage;
    DigitalSimulationPage digitalSimulationPage;
    PersonalInformationPage personalInformationPage;
    DocumentsPage documentsPage;
    SummaryPage summaryPage;
    ExcelDataProvider excelDataProvider;

    @Test(testName = "Simular crédito usuario PF1.0")
    public void test(String args[]) throws InterruptedException, AWTException {
        this.driver = BaseTests.driver;
        loginSvpPage = new LoginSvpPage(driver);
        digitalSimulationPage = new DigitalSimulationPage(driver);
        personalInformationPage = new PersonalInformationPage(driver);
        documentsPage = new DocumentsPage(driver);
        summaryPage = new SummaryPage(driver);
        loginSvpPage.loginUser("54597274", "Qa2022");
       /* digitalSimulationPage.simulateCreditPF1(args[2], args[3]);
        digitalSimulationPage.validateTextInLabelPf1(args[6]);
        digitalSimulationPage.requestCredit();
        personalInformationPage.updatePersonalInformationPf1(args[7], args[8], args[9], args[10], args[4], args[16], args[17]);
        personalInformationPage.updateBankDataPf1(args[11], args[12], args[13]);
        documentsPage.uploadDocumentIdPf1();
        assertEquals(summaryPage.getRequestAmountPf1(), args[14]);
        assertEquals(summaryPage.getDues(), args[3]);
        summaryPage.sendRequestPf1();
        assertEquals(summaryPage.getMessageRequestSent(), "TU SOLICITUD FUE ENVIADA EXITOSAMENTE");*/
    }

    @DataProvider(name = "credit_simulation_data")
    public Object[][] getDataCreditSimulation() throws IOException {
        excelDataProvider = new ExcelDataProvider();
        return excelDataProvider.getTestData("credit_simulation_data.xlsx", "PF1.0");
    }
}
