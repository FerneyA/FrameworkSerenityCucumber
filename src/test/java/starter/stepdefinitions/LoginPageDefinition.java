package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.StepLoginSvpPage;
import starter.pages.StepPersonalInformationPage;

public class LoginPageDefinition {

    @Steps
    StepLoginSvpPage loginPage;

    @Steps
    StepPersonalInformationPage stepPersonalInformationPage;

    @Given("User is on Home page SVP")
    public void openApplication() {
        loginPage.open();
    }

    @When("User enters username as {string} and password as {string}")
    public void enterUsernameAndPassword(String username, String password) {
        loginPage.inputUserName(username);
        loginPage.inputPassword(password);
        loginPage.clickButtonLogin();
    }

    @Then("User should be able to login successfully")
    public void clickOnLoginButton() throws InterruptedException {
        stepPersonalInformationPage.searchInputIsVisibleNow();
    }
}
