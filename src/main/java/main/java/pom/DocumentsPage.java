package main.java.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class DocumentsPage extends BasePage {

    By btnFrontDocumentID = By.xpath("//span[contains(text(),'Anverso o Frontal')]/following-sibling::div//button");
    By btnReverse = By.xpath("//span[contains(text(),'Reverso')]/following-sibling::div//button");
    By btnNext = By.xpath("//*[@id='root']/section/main/div[4]/button[@class='ant-btn next-btn buttonSimulation2']");
    By btnNextPf1 = By.xpath("//span[text()='Siguiente']/parent::button");
    By chkSwornDeclaration = By.xpath("//span[contains(text(),'Jurada')]");
    By chkLaborValidityCertificate = By.xpath("//span[text()='Certificado de vigencia laboral']");
    By inputCompanyName = By.xpath("//div[text()='Nombre empresa*']/parent::div//span[@class='ant-select-arrow']");
    By inputCity = By.xpath("//div[text()='Ciudad']/parent::div//span[@class='ant-select-arrow']");
    By inputContractStartDate = By.xpath("//div[text()='Fecha inicio contrato']/parent::div/span/div/input");
    By btnTodayDate = By.xpath("//a[@class='ant-calendar-today-btn ']");
    By inputChooseDate = By.xpath("//input[@placeholder='Elegir fecha']");
    By btnUploadCertificateFile = By.xpath("//span[contains(text(),'2. Subir archivo')]/following-sibling::div//button");


    public DocumentsPage(WebDriver driver) {
        super(driver);
    }

    public void uploadDocumentId() throws InterruptedException, AWTException {
        Thread.sleep(20000);
        waitInvisibilityOfSpin();
        explicitWaitVisibilityOfElement(btnFrontDocumentID);
        click(btnFrontDocumentID);
        Thread.sleep(2000);
        uploadFile(btnFrontDocumentID, "front_document_id.png");
        click(btnReverse);
        Thread.sleep(2000);
        uploadFile(btnReverse, "reverse_document_id.png");
        Thread.sleep(2000);
        click(btnNext);
    }

    public void uploadDocumentIdPf1() throws InterruptedException, AWTException {
        waitInvisibilityOfSpin();
        fluentWait(btnFrontDocumentID);
        click(btnFrontDocumentID);
        Thread.sleep(1000);
        uploadFile(btnFrontDocumentID, "front_document_id.png");
        click(btnReverse);
        Thread.sleep(1000);
        uploadFile(btnReverse, "reverse_document_id.png");
        Thread.sleep(1000);
        performScrollDownBottomPage();
        click(btnNextPf1);
    }

    public void fillOutSwornDeclaration(String companyName, String city) throws InterruptedException {
        click(chkSwornDeclaration);
        //selectOptionDropDown(inputCompanyName, companyName);
        selectOptionDropDown(inputCity, city);
        click(inputContractStartDate);
        Thread.sleep(1000);
        click(btnTodayDate);
    }

    public void fillOutLaborValidityCertificate() throws InterruptedException, AWTException {
        click(chkLaborValidityCertificate);
        click(inputChooseDate);
        Thread.sleep(1000);
        click(btnTodayDate);
        click(btnUploadCertificateFile);
        Thread.sleep(1000);
        uploadFile(btnUploadCertificateFile, "front_document_id.png");
        Thread.sleep(3000);
        performScrollDownBottomPage();
        click(btnNextPf1);
    }
}
