package pages.google;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class GooglePage extends Page {

    public GooglePage() {
        setUrl("https://www.google.com/");

    }

    @FindBy(xpath = "//textarea[@id='APjFqb']")
    private WebElement searchField;

    @FindBy(xpath = "//div[@class='nDcEnd']")
    private WebElement searchByImage;

    @FindBy(xpath = "//button[@aria-label='Stay signed out']")
    private WebElement staySignOut;

    @FindBy(xpath = "//iframe[@name='callout']")
    private WebElement iframeSign;

    @FindBy(xpath = "//iframe[@name='app']")
    private WebElement iframeApp;

    @FindBy(xpath = "//*[@aria-label='Google apps']")
    private WebElement googleAppsIcon;

    @FindBy(xpath = "//*[text()='Maps']")
    private WebElement googleMapsIcon;


    public void enterSearchWord(String text) {
        sendKeys(searchField, text);
    }

    public void clickStaySignOut() {
        click(staySignOut);
    }

    public void iFrameSign() {
        getIframe(iframeSign);
    }

    public void leaveIframe() {
        outOfIframe();
    }

    public void clickGoogleApps() {
        click(googleAppsIcon);
    }

    public void clickGoogleMaps() {
        click(googleMapsIcon);
    }

    public void iFrameApp() {
        getIframe(iframeApp);
    }
}
