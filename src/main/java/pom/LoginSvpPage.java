package main.java.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSvpPage extends BasePage {

    By txtRutUser = By.name("username");
    By txtPassword = By.name("password");
    By btnEnter = By.id("botonLogin");

    public LoginSvpPage(WebDriver driver) {
        super(driver);
    }

    public void loginUser(String user, String password) throws InterruptedException {
        /*fluentWait(txtRutUser);
        performScrollDown(btnEnter);
        Thread.sleep(2000);
        type(user, txtRutUser);
        type(password, txtPassword);
        click(btnEnter);*/
        System.out.println("Hello Wordl!!");
    }
}
