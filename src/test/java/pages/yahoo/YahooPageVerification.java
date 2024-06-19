package pages.yahoo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YahooPageVerification extends YahooPage {

    @FindBy(xpath = "//div[@id='module-location-heading']")
    private WebElement moduleLocation;

    @FindBy(xpath = "//div[@id='module-location-heading']")
    private WebElement temperatureForecast;

    @FindBy(xpath = "//h1[text()='Sunnyvale']")
    private WebElement cityNameForecast;

    @FindBy(xpath = "//h2[text()='United States']")
    private WebElement countryNameForecast;


    public String getTextFromModule() {
        return moduleLocation.getText();
    }

    public boolean isTemperatureForecastDisplayed() {
        return temperatureForecast.isDisplayed();
    }

    public boolean isForecastCityNameDisplayed() {
        return cityNameForecast.isDisplayed();
    }

    public boolean isForecastCountryNameDisplayed() {
        return countryNameForecast.isDisplayed();
    }
}
