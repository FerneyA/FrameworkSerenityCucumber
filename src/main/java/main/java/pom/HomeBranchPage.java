package main.java.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeBranchPage extends BasePage {

    By lnkSimulateYourCredit = By.cssSelector("a[href='cotiza-tu-credito']");
    By imgSimulateCredit = By.xpath("//a[@href='cotiza-tu-credito']/img");

    public HomeBranchPage(WebDriver driver) {
        super(driver);
    }

    public Boolean selectDirectAccess(String nameDirectAccess) throws InterruptedException {
        if (nameDirectAccess.equalsIgnoreCase("SIMULA TU CRÉDITO")) {
            Thread.sleep(3000);
            performScrollDown(imgSimulateCredit);
            if(fluentWait(imgSimulateCredit).isDisplayed()) {
                explicitWaitVisibilityOfElement(lnkSimulateYourCredit).click();
                return true;
            }
        }
        return false;
    }
}
