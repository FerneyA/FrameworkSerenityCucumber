package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.StepLoginFacebookPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class LoginPageDefinition {

    @Steps
    StepLoginFacebookPage loginPage;

    @Given("User enters Facebook page")
    public void openApplication() {
        loginPage.open();
    }

    @When("User types the username: {string} and password: {string}")
    public void typeUserAndPassword(String username, String password) {
        loginPage.LoginFacebook(username, password);
    }

    @Then("User should see the message: {string}")
    public void validateMessage(String message) {
        String foundMessage = loginPage.getElementText();
        assertThat("Found text: " + foundMessage + " Expected message: " + message, foundMessage.contains(message));
    }
}
