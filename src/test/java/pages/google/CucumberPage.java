package pages.google;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class CucumberPage extends Page {

    @FindBy(xpath = "//*[@id='selenium-webdriver']")
    private WebElement webDriverTitle;
    @FindBy(xpath = "//*[contains(@class,'ch2-btn-primary')]")
    private WebElement acceptCookies;
    @FindBy(xpath = "//p[contains(text(),'WebDriver is designed to')]")
    private WebElement paragraphText;


    public boolean cucumberPageIsDisplayed() {
        return webDriverTitle.isDisplayed();
    }

    public void clickAcceptCookies() {
        click(acceptCookies);
    }

    public String getAboutWebDriverText() {
        return paragraphText.getText();
    }
}
