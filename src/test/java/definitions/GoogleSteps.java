package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.google.GoogleMapsPage;
import pages.google.GooglePage;
import pages.google.GooglePageVerifications;
import pages.google.GoogleSearchResultPage;


import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class GoogleSteps {
    @Given("user is on the google page")
    public void userIsOnTheSamplePage() {
        new GooglePage().openPage();
        assertThat(new GooglePageVerifications().getUrlForCurrentPage()).contains("google");
    }

    @When("they search for {string}")
    public void theySearchFor(String textToSearch) {
        new GooglePage().enterSearchWord(textToSearch);
        new Actions(getDriver()).sendKeys(Keys.ENTER).perform();
    }

    @And("they proceed with the result")
    public void theProceedWithTheResult() {
        new GoogleSearchResultPage().clickCucumberLink();
    }

    @When("they chooses stay sign out")
    public void theyChoosesSearchByImage() {
        new GooglePage().iFrameSign();
        new GooglePage().clickStaySignOut();
        new GooglePage().leaveIframe();
    }

    @When("they navigates to the Google maps")
    public void theyNavigatesToTheGoogleMaps() {
        new GooglePage().clickGoogleApps();
        new GooglePage().iFrameApp();
        new GooglePage().clickGoogleMaps();
        new GooglePage().leaveIframe();
    }

    @And("they search maps for {string}")
    public void theySearchMapsFor(String searchText)  {
        new GoogleMapsPage().inputSearchText(searchText);
        new GoogleMapsPage().clickSearchButton();
    }

    @Then("search result for {string} is displayed")
    public void theSearchResultForIsDisplayed(String searchResultName) {
        assertThat(new GooglePageVerifications().getSearchResultText()).contains(searchResultName);
    }
}
