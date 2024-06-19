package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.google.CucumberPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CucumberPageSteps {

    @Then("the right page is opened")
    public void theRightPageIsOpened() {
        assertThat(new CucumberPage().cucumberPageIsDisplayed()).isTrue();
    }

    @And("they accepted cookies")
    public void theyAcceptedCookies() {
        new CucumberPage().clickAcceptCookies();
    }

    @And("the information about WebDriver printed to the console")
    public void theyPrintOutTestAboutWebDriver() {
        System.out.println(new CucumberPage().getAboutWebDriverText());
    }
}
