package pages.ups;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpsVerifications extends UpsHomePage {

    @FindBy(xpath = "(//div[@class='card-body'])[4]")
    private WebElement infoSummary;

    // Sender ======================================================
    @FindBy(xpath = "(//*[@id='shippingSummaryOriginName'])[1]")
    private WebElement senderFullName;

    @FindBy(xpath = "(//*[@id='shippingSummaryOriginName'])[2]")
    private WebElement senderContactName;

    @FindBy(xpath = "//*[@id='shippingSummaryOriginEmail']")
    private WebElement senderEmail;

    @FindBy(xpath = "//*[@id='shippingSummaryOriginPhone']")
    private WebElement senderPhone;

    @FindBy(xpath = "//*[@id='shippingSummaryOriginAddressLine1']")
    private WebElement senderStreetAddress;

    @FindBy(xpath = "//*[@id='shippingSummaryOriginCityStatePostalCode']")
    private WebElement senderCityStateZip;

    // Recipient ========================================================
    @FindBy(xpath = "(//*[@id='shippingSummaryDestinationName'])[1]")
    private WebElement recipientFullName;

    @FindBy(xpath = "(//*[@id='shippingSummaryDestinationName'])[2]")
    private WebElement recipientContactName;

    @FindBy(xpath = "//*[@id='shippingSummaryDestinationEmail']")
    private WebElement recipientEmail;

    @FindBy(xpath = "//*[@id='shippingSummaryDestinationPhone']")
    private WebElement recipientPhone;

    @FindBy(xpath = "//*[@id='shippingSummaryDestinationAddressLine1']")
    private WebElement recipientStreetAddress;

    @FindBy(xpath = "//*[@id='shippingSummaryDestinationCityStatePostalCode']")
    private WebElement recipientCityStateZip;

    @FindBy(xpath = "//div[text()='UPS Letter']")
    private WebElement packagingTypeLetter;


    public String getSummaryText() {
        return infoSummary.getText();
    }

    // Sender ======================================================
    public String getSenderFullName() {
        return senderFullName.getText();
    }

    public String getSenderContactName() {
        return senderContactName.getText();
    }

    public String getSenderEmail() {
        return senderEmail.getText();
    }

    public String getSenderPhone() {
        return senderPhone.getText();
    }

    public String getSenderAddress() {
        return senderStreetAddress.getText();
    }

    public String getSenderCityStateZip() {
        return senderCityStateZip.getText();
    }

    // Recipient ========================================================
    public String getRecipientFullName() {
        return recipientFullName.getText();
    }

    public String getRecipientContactName() {
        return recipientContactName.getText();
    }

    public String getRecipientEmail() {
        return recipientEmail.getText();
    }

    public String getRecipientPhone() {
        return recipientPhone.getText();
    }

    public String getRecipientAddress() {
        return recipientStreetAddress.getText();
    }

    public String getRecipientCityStateZip() {
        return recipientCityStateZip.getText();
    }

    public boolean isPackagingTypeLetter() {
        return packagingTypeLetter.isDisplayed();
    }
}
