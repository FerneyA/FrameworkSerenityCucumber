package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.StepLoginSvpPage;

public class LoginPageDefinition {

    @Steps
    StepLoginSvpPage loginPage;

    @Given("User is on Home page SVP")
    public void openApplication() {
        loginPage.open();
    }

    @When("User enters username as {string} and password as {string}")
    public void enterUsernameAndPassword(String username, String password) {
        loginPage.inputUserName(username);
        loginPage.inputPassword(password);
    }

    @Then("User should be able to login successfully")
    public void clickOnLoginButton() {
        loginPage.clickButtonLogin();
    }
}
