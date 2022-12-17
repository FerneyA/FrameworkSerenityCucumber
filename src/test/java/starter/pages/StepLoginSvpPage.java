package starter.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

public class StepLoginSvpPage extends PageObject {

    @FindBy(name = "username")
    WebElementFacade txtRutUser;

    @FindBy(name = "password")
    WebElementFacade txtPassword;

    @FindBy(id = "botonLogin")
    WebElementFacade btnEnter;

    @Step("Enter username")
    public void inputUserName(String username) {
        txtRutUser.sendKeys(username);
    }

    @Step("Enter password")
    public void inputPassword(String password) {
        txtPassword.sendKeys(password);
    }

    @Step("Click Submit Button")
    public void clickButtonLogin() {
        btnEnter.click();
    }
}
