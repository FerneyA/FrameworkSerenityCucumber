package main.java.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DigitalSimulationPage extends BasePage {

    By txtRequestedAmount = By.cssSelector("input[class='ant-input sml-input']");
    By txtDues = By.cssSelector("input[class='ant-input-number-input']");
    By selExpandedMonthOfGrace = By.xpath("//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']");
    By selMonthOfGrace = By.xpath("//div[@class='sml-select ant-select ant-select-enabled']/div/span");
    By btnSimulate = By.xpath("//div[@class='ant-spin-container']//button[@type='button']");
    By lblSimulationResults = By.xpath("//div[@class='ant-row sml-credit-result']/h3");
    By btnRequestCredit = By.xpath("//main[@class='ant-layout-content']//button[@class='ant-btn next-btn buttonSimulation2']");

    public DigitalSimulationPage(WebDriver driver) {
        super(driver);
    }

    public void simulateCredit(String requestAmount, String dues) throws InterruptedException {
        //Thread.sleep(20000);
        explicitWaitElementToBeClickable(txtRequestedAmount);
        clearTextField(txtRequestedAmount);
        typeWithTab(requestAmount, txtRequestedAmount);
        type(dues, txtDues);
        //selectDropDown(selMonthOfGrace);
        //selectDropDown(selExpandedMonthOfGrace);
        selectOptionDown(selMonthOfGrace, "1");
        performScrollDown();
        explicitWaitElementToBeClickable(btnSimulate).click();
    }

    public Boolean validateSimulationResults(String text) {
        return explicitWaitTextToBePresentInElement(lblSimulationResults, text);
    }

    public void requestCredit() {
        performScrollDown();
        explicitWaitElementToBeClickable(btnRequestCredit);
        click(btnRequestCredit);
    }
}
