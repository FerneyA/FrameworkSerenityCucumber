package starter.pages;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class StepLoginFacebookPage extends BasePage {

    By inputEmail = By.id("email");
    By inputPassword = By.id("pass");
    By buttonLogin = By.name("login");
    By labelMessage = By.cssSelector("div[class='_9ay7']");

    @Step
    public void loginFacebook(String username, String password) {
        fluentWait(inputEmail);
        type(username, inputEmail);
        type(password, inputPassword);
        click(buttonLogin);
    }

    @Step
    public String getElementText() {
        fluentWait(labelMessage);
        return getText(labelMessage);
    }
}