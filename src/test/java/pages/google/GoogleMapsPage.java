package pages.google;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class GoogleMapsPage extends Page {

    @FindBy(xpath = "//input[@id='searchboxinput']")
    private WebElement searchGoogleMaps;

    @FindBy(xpath = "//button[@id='searchbox-searchbutton']")
    private WebElement searchButton;


    public void inputSearchText(String searchText) {
        sendKeysWithoutWait(searchGoogleMaps, searchText);
    }

    public void clickSearchButton() {
        clickOn(searchButton);
    }

}
