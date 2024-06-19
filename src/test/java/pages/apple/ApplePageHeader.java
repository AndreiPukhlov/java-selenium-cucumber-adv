package pages.apple;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class ApplePageHeader extends Page {


    @FindBy(xpath = "//*[@aria-label='Mac']")
    private WebElement mac;

    @FindBy(xpath = "//*[@aria-label='Apple']")
    private WebElement appleLogo;

    public void goToMac(){
        hoverMouse(mac);
    }

    public void goToAppleLogo(){
        hoverMouse(appleLogo);
    }

}
