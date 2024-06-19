package pages.ups;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpsResidentialAddressModalWindow extends UpsShipmentPage {

    @FindBy(xpath = "//label[contains(text(),'This is a residential')]")
    private WebElement residentialCheckBox;

    @FindBy(xpath = "//*[text()=' Continue ']")
    private WebElement continueButton;


    public void clickCheckBox() {
        click(residentialCheckBox);
    }

    public void clickContinueButton() {
        click(continueButton);
    }
}
