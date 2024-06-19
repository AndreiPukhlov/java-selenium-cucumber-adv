package pages.apple;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplePageMacMenu extends ApplePageHeader{

    @FindBy(xpath = "//a[@data-analytics-title='explore all mac']")
    private WebElement exploreAll;


    public void clickExploreAll() {
        click(exploreAll);
    }
}
