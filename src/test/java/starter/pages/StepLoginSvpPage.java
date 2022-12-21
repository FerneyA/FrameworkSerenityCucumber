package starter.pages;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class StepLoginSvpPage extends BasePage {

    By inputRutUser = By.name("username");
    By inputPassword = By.name("password");
    By btnEnter = By.id("botonLogin");

    @Step
    public void loginUserSvp(String user, String password) throws InterruptedException {
        fluentWait(By.name("username"));
        performScrollDown(btnEnter);
        Thread.sleep(2000);
        type(user, inputRutUser);
        type(password, inputPassword);
        click(btnEnter);
    }
}
