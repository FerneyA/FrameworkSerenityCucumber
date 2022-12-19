package starter.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

public class StepLoginSvpPage extends BasePage {

    @FindBy(name = "username")
    WebElementFacade inputRutUser;

    @FindBy(name = "password")
    WebElementFacade inputPassword;

    @FindBy(id = "botonLogin")
    WebElementFacade btnEnter;

    @Step("Enter username")
    public void inputUserName(String username) {
        inputRutUser.waitUntilClickable().sendKeys(username);
    }

    @Step("Enter password")
    public void inputPassword(String password) {
        inputPassword.sendKeys(password);
    }

    @Step("Click Submit Button")
    public void clickButtonLogin() {
        btnEnter.click();
    }
}
