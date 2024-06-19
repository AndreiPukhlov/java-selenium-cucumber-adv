package pages.ups;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import support.TestContext;

public class UpsShipmentPage extends UpsPageHeader {

    public UpsShipmentPage() {
        setUrl("https://www.ups.com/ship/basic/shipment-info");
    }

    @FindBy(xpath = "//*[contains(text(),'our Simplified')]/parent::div//span[@class='icon ups-icon-close']")
    private WebElement closeModalWindow;

    @FindBy(xpath = "//*[@class='close_btn_thick']")
    private WebElement closeCookiesWindow;

    @FindBy(xpath = "//*[@id='ShippingSummaryOriginAdd-Name']")
    private WebElement senderFullName;

    @FindBy(xpath = "//*[@id='ShippingSummaryOriginAdd-ContactName']")
    private WebElement senderContactName;

    @FindBy(xpath = "//*[@id='ShippingSummaryOriginAdd-Email']")
    private WebElement senderEmail;

    @FindBy(xpath = "//*[@id='ShippingSummaryOriginAdd-Phone']")
    private WebElement senderPhone;

    @FindBy(xpath = "//*[@id='ShippingSummaryOriginAdd-Address']")
    private WebElement senderStreetAddress;

    @FindBy(xpath = "//*[@id='ShippingSummaryOriginAdd-City']")
    private WebElement senderCityName;

    @FindBy(xpath = "//*[@id='ShippingSummaryOriginAdd-BtnState']")
    private WebElement senderStateDropDown;

    @FindBy(xpath = "//*[@id='ShippingSummaryOriginAdd-Postal']")
    private WebElement senderZipCode;

    // Recipient

    @FindBy(xpath = "//button[@id='btn_ShippingSummaryDestinationAdd-country']")
    private WebElement recipientCountry;

    @FindBy(xpath = "//*[@id='ShippingSummaryDestinationAdd-Name']")
    private WebElement recipientFullName;

    @FindBy(xpath = "//input[@id='ShippingSummaryDestinationAdd-ContactName']")
    private WebElement recipientContactName;

    @FindBy(xpath = "//*[@id='ShippingSummaryDestinationAdd-Address']")
    private WebElement recipientStreetAddress;

    @FindBy(xpath = "//*[@id='ShippingSummaryDestinationAdd-City']")
    private WebElement recipientCityName;

    @FindBy(xpath = "//*[@id='ShippingSummaryDestinationAdd-Email']")
    private WebElement recipientEmail;

    @FindBy(xpath = "//*[@id='ShippingSummaryDestinationAdd-Phone']")
    private WebElement recipientPhone;

    @FindBy(xpath = "//*[@id='ShippingSummaryDestinationAdd-Postal']")
    private WebElement recipientPostalCode;

    // Packaging
    @FindBy(xpath = "//input[@id='action2']")
    private WebElement upsPackaging;

    @FindBy(xpath = "//*[@id='UPS Letter_0']")
    private WebElement upsLetter;

    @FindBy(xpath = "//*[@id='next-btn']")
    private WebElement selectServiceButton;


    public void clickCloseModalWindow() {
        click(closeModalWindow);
    }

    public void clickCloseCookiesWindow() {
        click(closeCookiesWindow);
    }

    public void fillSenderFullName() {
        sendKeys(senderFullName, TestContext.getData("senderFullName"));
    }

    public void fillSenderContactName() {
        sendKeys(senderContactName, TestContext.getData("senderFullName"));
    }

    public void fillSenderEmail() {
        sendKeys(senderEmail, TestContext.getData("senderEmail"));
    }

    public void fillSenderPhone() {
        sendKeys(senderPhone, TestContext.getData("senderPhone"));
    }

    public void fillSenderStreetAddress() {
        sendKeys(senderStreetAddress, TestContext.getData("senderStreetAddress"));
    }

    public void fillSenderCityName() {
        sendKeys(senderCityName, TestContext.getData("senderCityName"));
    }

    public void clickSenderStateDropdown() {
        click(senderStateDropDown);
    }

    public void selectSenderStateName() {
        click(getByXpath("//*[@value='" + TestContext.getData("senderState") + "']"));
    }

    public void fillSenderZip() {
        sendKeys(senderZipCode, TestContext.getData("senderZip"));

    }

    // Recipient ==============================================
    public void clickRecipientCountryDropdown() {
        click(recipientCountry);
    }

    public void selectRecipientCountry() {
        String country = TestContext.getData("recipientCountry");
        click(getByXpath("(//button[text()='" + country + "'])[2]"));
    }

    public void fillRecipientFullName() {
        sendKeys(recipientFullName, TestContext.getData("recipientFullName"));
    }

    public void fillRecipientContactName() {
        sendKeys(recipientContactName, TestContext.getData("recipientFullName"));
    }

    public void fillRecipientEmail() {
        sendKeys(recipientEmail, TestContext.getData("recipientEmail"));
    }

    public void fillRecipientPhone() {
        sendKeys(recipientPhone, TestContext.getData("recipientPhone"));
    }

    public void fillRecipientAddress() {
        sendKeys(recipientStreetAddress, TestContext.getData("recipientStreetAddress"));
    }

    public void fillRecipientCityName() {
        sendKeys(recipientCityName, TestContext.getData("recipientCityName"));
    }

    public void fillRecipientPostalCode() {
        sendKeys(recipientPostalCode, TestContext.getData("recipientPostalCode"));
    }

    // Packaging =====================================================
    public void clickUpsPackaging() {
        clickWithJS(upsPackaging);
    }

    public void clickUpsLetter() {
        click(upsLetter);
    }

    public void clickSelectServiceButton() {
        click(selectServiceButton);
    }
}
