package starter.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.By;

import static org.hamcrest.MatcherAssert.assertThat;

public class StepDigitalSimulationPage extends BasePage {

    @FindBy(css = "input[class='ant-input sml-input']")
    WebElementFacade inputRequestedAmount;

    //By inputRequestedAmount = By.cssSelector("input[class='ant-input sml-input']");
    By inputDues = By.cssSelector("input[class='ant-input-number-input']");
    By chkInsurance = By.cssSelector("input[class='ant-checkbox-input']");
    By btnContinueWithoutInsurance = By.cssSelector("button[class='ant-btn ant-btn modal-button-acuerdo']");
    By downMonthOfGrace = By.xpath("//div[@class='sml-select ant-select ant-select-enabled']/div/span");
    By btnSimulate = By.xpath("//div[@class='ant-spin-container']//button[@type='button']");
    By lblSimulationResults = By.cssSelector("span[class='sml-subtitle-amount']");
    By lblSimulationResultsPf1 = By.xpath(".//h4[@class='sml-subtitle']");
    By btnRequestCredit = By.xpath("//*[@id='root']/section/main/div[4]/button");

    @WhenPageOpens
    public void searchInputIsVisibleNow() {
        fluentWait(By.cssSelector("input[class='ant-input sml-input']"));
        assertThat("Element not displayed...", inputRequestedAmount.isVisible());
    }

    @Step
    public void simulateCredit(String requestAmount, String dues, String monthOfGrace, String insurance) throws InterruptedException {
        waitInvisibilityOfSpin();
        fluentWait(By.cssSelector("input[class='ant-input sml-input']"));
        typeWithTab(requestAmount, By.cssSelector("input[class='ant-input sml-input']"));
        //typeInto(inputRequestedAmountSerenity, requestAmount);
        typeWithTab(dues, inputDues);
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

    @Step
    public void simulateCreditPF1(String requestAmount, String dues) throws InterruptedException {
        waitInvisibilityOfSpin();
        fluentWait(By.cssSelector("input[class='ant-input sml-input']"));
        typeWithTab(requestAmount, By.cssSelector("input[class='ant-input sml-input']"));
        typeWithTab(dues, inputDues);
        explicitWaitElementToBeClickable(btnSimulate).click();
    }

    @Step
    public Boolean validateTextInLabel(String text) {
        waitInvisibilityOfSpin();
        return explicitWaitTextToBePresentInElement(lblSimulationResults, text);
    }

    @Step
    public Boolean validateTextInLabelPf1(String text) {
        waitInvisibilityOfSpin();
        return explicitWaitTextToBePresentInElement(lblSimulationResultsPf1, text);
    }

    @Step
    public void requestCredit() throws InterruptedException {
        Thread.sleep(1000);
        performScrollDownBottomPage();
        Thread.sleep(1000);
        click(btnRequestCredit);
    }
}
