package pages.ups;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class UpsPageHeader extends Page {

    @FindBy(xpath = "//a[@id='mainNavDropdown1']")
    private WebElement shippingMenu;


    public void clickShippingMenu(){
        click(shippingMenu);
    }



}
