package starter.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.By;

import static org.hamcrest.MatcherAssert.assertThat;

public class StepPersonalInformationPage extends BasePage {

    @FindBy(css = "input[class='ant-input sml-input']")
    WebElementFacade inputCIDocument;

    @WhenPageOpens
    public void searchInputIsVisibleNow() throws InterruptedException {
        fluentWait(By.cssSelector("input[class='ant-input sml-input']"));
        assertThat("Element not found...", inputCIDocument.isVisible());
    }
}
