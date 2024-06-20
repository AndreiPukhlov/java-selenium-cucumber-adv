package pages.orange;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;
import support.TestContext;

public class OrangeVerifications extends Page {


    @FindBy(css = ".oxd-topbar-header-breadcrumb-module")
    private WebElement dashBoardTitle;





    public String getHomePageTitle(){
        return dashBoardTitle.getText();
    }

    public String getPageTitle(){
        return TestContext.getDriver().getTitle();
    }
}
