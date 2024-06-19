package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.apple.AppleMacPage;
import pages.apple.ApplePage;
import pages.apple.ApplePageHeader;
import pages.apple.ApplePageMacMenu;

import static org.assertj.core.api.Assertions.assertThat;

public class AppleSteps {
    @Given("user is on the apple page")
    public void userIsOnTheApplePage() {
        new ApplePage().openPage();
    }

    @When("they navigates to the Mac section")
    public void theyNavigatesToTheMacProductListPage() {
        new ApplePageHeader().goToAppleLogo();
        new ApplePageHeader().goToMac();
    }

    @And("they chooses to explore all macs")
    public void theyChoosesToExploreAllMacs(){
        new ApplePageMacMenu().clickExploreAll();
    }

    @And("they chooses {string}")
    public void theyChooses(String productName){
        new AppleMacPage().goToProductPage(productName);
    }

    @Then("the {string} product page is displayed")
    public void theProductPageIsDisplayed(String prodName) {
        assertThat(new AppleMacPage().isProductPageTitle(prodName)).isTrue();
    }
}
