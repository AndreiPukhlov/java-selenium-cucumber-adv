package pages.yahoo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YahooWeatherPage extends YahooPage {

    @FindBy(xpath = "//*[text()='Change location']")
    private WebElement changeLocationButton;

    @FindBy(xpath = "//*[@id='weather-autocomplete']")
    private WebElement findLocationByCityOrZip;


    public void clickChangeLocation() {
        click(changeLocationButton);
    }

    public void enterCityOrZipCode(String cityOrZip) {
        sendKeys(findLocationByCityOrZip, cityOrZip);
    }

    public void chooseLocationToShow(String cityName) {
        WebElement element = getByXpath("//li[contains(text(),'" + cityName + "')]");
        click(element);
    }
}
