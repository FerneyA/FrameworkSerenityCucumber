package main.java.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class DocumentsPage extends BasePage {

    By btnFrontDocumentID = By.xpath("//span[contains(text(),'Anverso o Frontal')]/following-sibling::div//button");
    By btnReverse = By.xpath("//span[contains(text(),'Reverso')]/following-sibling::div//button");
    By btnNext = By.xpath("//*[@id='root']/section/main/div[4]/button[@class='ant-btn next-btn buttonSimulation2']");
    By btnNextPf1 = By.xpath("//span[text()='Siguiente']/parent::button");

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
        uploadFile(btnFrontDocumentID, "reverse_document_id.png");
        Thread.sleep(2000);
        click(btnNext);
    }

    public void uploadDocumentIdPf1() throws InterruptedException, AWTException {
        waitInvisibilityOfSpin();
        explicitWaitVisibilityOfElement(btnFrontDocumentID);
        click(btnFrontDocumentID);
        Thread.sleep(2000);
        uploadFile(btnFrontDocumentID, "front_document_id.png");
        click(btnReverse);
        Thread.sleep(2000);
        uploadFile(btnFrontDocumentID, "reverse_document_id.png");
        Thread.sleep(2000);
        click(btnNextPf1);
    }
}
