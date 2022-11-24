package main.java.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DigitalSimulationPage extends BasePage {

    By txtRequestedAmount = By.cssSelector("input[class='ant-input sml-input']");
    By txtDues = By.cssSelector("input[class='ant-input-number-input']");
    By chkInsurance = By.cssSelector("input[class='ant-checkbox-input']");
    By btnContinueWithoutInsurance = By.cssSelector("button[class='ant-btn ant-btn modal-button-acuerdo']");
    By downMonthOfGrace = By.xpath("//div[@class='sml-select ant-select ant-select-enabled']/div/span");
    By btnSimulate = By.xpath("//div[@class='ant-spin-container']//button[@type='button']");
    By lblSimulationResults = By.cssSelector("span[class='sml-subtitle-amount']");
    By btnRequestCredit = By.xpath("//*[@id='root']/section/main/div[4]/button");

    public DigitalSimulationPage(WebDriver driver) {
        super(driver);
    }

    public void simulateCredit(String requestAmount, String dues, String monthOfGrace, String insurance) throws InterruptedException {
        Thread.sleep(10000);
        waitInvisibilityOfSpin();
        explicitWaitVisibilityOfElement(txtRequestedAmount);
        typeWithTab(requestAmount, txtRequestedAmount);
        typeWithTab(dues, txtDues);
        explicitWaitElementToBeClickable(downMonthOfGrace) ;
        selectOptionDropDown(downMonthOfGrace, monthOfGrace);
        if(insurance.equalsIgnoreCase("No")) {
            click(chkInsurance);
            explicitWaitElementToBeClickable(btnContinueWithoutInsurance);
            click(btnContinueWithoutInsurance);
        }
        performScrollDown(btnSimulate);
        explicitWaitElementToBeClickable(btnSimulate).click();
    }

    public Boolean validateTextInLabel(String text) {
        waitInvisibilityOfSpin();
        return explicitWaitTextToBePresentInElement(lblSimulationResults, text);
    }

    public void requestCredit() throws InterruptedException {
        Thread.sleep(2000);
        performScrollDownBottomPage();
        Thread.sleep(2000);
        click(btnRequestCredit);
    }
}
