package starter.pages;

import org.openqa.selenium.By;

public class StepSummaryPage extends BasePage {

    By lblRequestAmount = By.xpath("//span[text()='Monto solicitado']/parent::div/following-sibling::div/span");
    By lblDues = By.xpath("//span[contains(text(),'de cuotas')]/parent::div/following-sibling::div/span");
    By lblRut = By.xpath("//span[text()='Rut']/parent::div/following-sibling::div/span");
    By lblAccountNumber = By.xpath("//span[text()='Nro de cuenta']/parent::div/following-sibling::div/span");
    By lblBank = By.xpath("//span[text()='Banco']/parent::div/following-sibling::div/span");
    By btnReviewDocuments= By.xpath("//*[@id='root']/section/main/div[4]/button[@class='ant-btn next-btn buttonSimulation2']");
    By btnConfirm = By.xpath("//span[text()='Confirmar']/parent::button");
    By btnSendRequestPf1 = By.xpath("//span[contains(text(),'Enviar Solicitud De Cr')]/parent::button");
    By lblMessagePf1 = By.xpath("//div[@id='root']/section/main/div/h2");

    public String getRequestAmount() throws InterruptedException {
        Thread.sleep(20000);
        waitInvisibilityOfSpin();
        explicitWaitVisibilityOfElement(btnReviewDocuments);
        return getText(lblRequestAmount);
    }

    public String getRequestAmountPf1() {
        waitInvisibilityOfSpin();
        fluentWait(btnSendRequestPf1);
        return getText(lblRequestAmount);
    }

    public String getDues() {
        return getText(lblDues);
    }

    public String getMessageRequestSent() throws InterruptedException {
        Thread.sleep(3000);
        waitInvisibilityOfSpin();
        fluentWait(lblMessagePf1);
        return getText(lblMessagePf1);
    }

    public String getRut() {
        return getText(lblRut);
    }

    public String getAccountNumber() {
        return getText(lblAccountNumber);
    }

    public String getBank() {
        return getText(lblBank);
    }

    public void reviewDocuments() {
        click(btnReviewDocuments);
        explicitWaitVisibilityOfElement(btnConfirm);
        click(btnConfirm);
    }

    public void sendRequestPf1() {
        click(btnSendRequestPf1);
    }
}
