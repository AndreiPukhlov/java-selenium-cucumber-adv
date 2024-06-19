package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ups.*;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;

public class UpsSteps {
    @Given("user is on the ups home page")
    public void userIsOnTheUpsHomePage() {
        new UpsHomePage().openPage();
    }

    @When("user is on the shipment page")
    public void theyNavigatesToCreateShipment() {
        UpsShipmentPage upsShipmentPage = new UpsShipmentPage();
        upsShipmentPage.openPage();
        upsShipmentPage.clickCloseModalWindow();
        upsShipmentPage.clickCloseCookiesWindow();
    }


    @And("they fills all the required fields for the sender")
    public void theyFillsAllTheRequiredFieldsForTheShipForm() {
        UpsShipmentPage upsShipmentPage = new UpsShipmentPage();
        upsShipmentPage.fillSenderFullName();
        upsShipmentPage.fillSenderContactName();
        upsShipmentPage.fillSenderEmail();
        upsShipmentPage.fillSenderPhone();
        upsShipmentPage.fillSenderStreetAddress();
        upsShipmentPage.fillSenderCityName();
        upsShipmentPage.clickSenderStateDropdown();
        upsShipmentPage.selectSenderStateName();
        upsShipmentPage.fillSenderZip();
    }

    @And("they fills all the required fields for the recipient")
    public void theyFillsAllTheRequiredFieldsForTheRecipient() {
        UpsShipmentPage upsShipmentPage = new UpsShipmentPage();
        upsShipmentPage.clickRecipientCountryDropdown();
        upsShipmentPage.selectRecipientCountry();
        upsShipmentPage.fillRecipientFullName();
        upsShipmentPage.fillRecipientContactName();
        upsShipmentPage.fillRecipientEmail();
        upsShipmentPage.fillRecipientPhone();
        upsShipmentPage.fillRecipientAddress();
        upsShipmentPage.fillRecipientCityName();
        upsShipmentPage.fillRecipientPostalCode();
    }

    @And("they chooses UPS letter")
    public void theyChoosesUPSLetter() {
        UpsShipmentPage upsShipmentPage = new UpsShipmentPage();
        upsShipmentPage.clickUpsPackaging();
        upsShipmentPage.clickSelectServiceButton();
    }

    @And("they confirms residential address")
    public void theyConfirmsResidentialAddress() {
        UpsResidentialAddressModalWindow resAddressModal = new UpsResidentialAddressModalWindow();
        resAddressModal.clickCheckBox();
        resAddressModal.clickContinueButton();
    }

    @Then("all provided information is saved correctly")
    public void allProvidedInformationIsSavedCorrectly() {
        UpsVerifications upsVerifications = new UpsVerifications();
        assertThat(upsVerifications.getSenderFullName()).isEqualTo(getData("senderFullName"));
        assertThat(upsVerifications.getSenderContactName()).isEqualTo(getData("senderFullName"));
        assertThat(upsVerifications.getSenderEmail()).isEqualTo(getData("senderEmail"));
        assertThat(upsVerifications.getSenderPhone()).isEqualTo(getData("senderPhone"));
        assertThat(upsVerifications.getSenderAddress()).isEqualTo(getData("senderStreetAddress"));
        String citySZip = (getData("senderCityName") + ", " + getData("senderState") +
                ", " + getData("senderZip"));
        assertThat(upsVerifications.getSenderCityStateZip()).isEqualTo(citySZip);

        assertThat(upsVerifications.getRecipientFullName()).isEqualTo(getData("recipientFullName"));
        assertThat(upsVerifications.getRecipientContactName()).isEqualTo(getData("recipientFullName"));
        assertThat(upsVerifications.getRecipientEmail()).isEqualTo(getData("recipientEmail"));
        assertThat(upsVerifications.getRecipientPhone()).isEqualTo(getData("recipientPhone"));
        assertThat(upsVerifications.getRecipientAddress()).isEqualTo(getData("recipientStreetAddress"));
        String cityZip = (getData("recipientCityName") + ", " + getData("recipientPostalCode"));
        assertThat(upsVerifications.getRecipientCityStateZip()).isEqualTo(cityZip);
        assertThat(upsVerifications.isPackagingTypeLetter()).isTrue();
        System.out.println(upsVerifications.getSummaryText());
    }
}
