package pages.google;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchResultPage extends GooglePage {

    @FindBy(xpath = "(//*[text()='https://cucumber.io'])[1]")
    private WebElement cucumberIo;

    @FindBy(xpath = "//textarea")
    private WebElement randomSearchField;

    public void clickCucumberLink() {
        cucumberIo.click();
    }

    public String getSearchKeyWords() {
        return randomSearchField.getText();
    }
}
