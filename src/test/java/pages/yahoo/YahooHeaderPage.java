package pages.yahoo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class YahooHeaderPage extends Page {


    @FindBy(xpath = "//span[text()='More']")
    private WebElement yahooServices;

    @FindBy(xpath = "//a[@href='https://www.yahoo.com/news/weather/']")
    private WebElement yahooWeather;

    public void clickOnMoreServices() {
        hoverMouse(yahooServices);
    }

    public void clickOnWeather() {
        click(yahooWeather);
    }
}
