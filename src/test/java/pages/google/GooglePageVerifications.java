package pages.google;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePageVerifications extends GooglePage {


    @FindBy(xpath = "//div[@role='main']")
    private WebElement resultText;


    public String getSearchResultText() {
        return resultText.getText();
    }

    public String getUrlForCurrentPage(){
        return getActualUrl();
    }
}

