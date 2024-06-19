package pages.ups;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpsShippingMenu extends UpsPageHeader {

    @FindBy(xpath = "//*[text()='Create a Shipment']")
    private WebElement createShipment;

    public void clickCreateShipment() {
        click(createShipment);
    }
}
