package definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.orange.OrangeSignInPage;
import pages.orange.OrangeVerifications;

import static org.assertj.core.api.Assertions.assertThat;

public class OrangeHRMSteps {

    @Given("user is on the OrangeHRM home page")
    public void userIsOnTheOrangeHRMHomePage() {
        new OrangeSignInPage().openPage();

    }

    @When("they with provided user name and password for admin account")
    public void theyWithProvidedUserNameAndPasswordForAdminAccount() {
        OrangeSignInPage orangeSignInPage = new OrangeSignInPage();
        String adminUserName = orangeSignInPage.getAdminUserName();
        int colonIndex = adminUserName.indexOf(':');
        String adminName = adminUserName.substring(colonIndex + 1).trim(); // Get substring after the colon and trim whitespace
        orangeSignInPage.fillUserName(adminName);

        String adminUserPwd = orangeSignInPage.getAdminUserPwd();
        int colonIndexP = adminUserPwd.indexOf(':');
        String adminPwd = adminUserPwd.substring(colonIndexP + 1).trim(); // Get substring after the colon and trim whitespace
        orangeSignInPage.fillUserPwd(adminPwd);

        orangeSignInPage.clickLoginButton();
    }

    @Then("they logged in to the account")
    public void theyLoggedInToTheAccount() {
        assertThat(new OrangeVerifications().getPageTitle()).isEqualTo("Dashboard");
    }
}
