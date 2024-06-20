package pages.orange;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class OrangeVerifications extends Page {


    @FindBy(css = ".oxd-topbar-header-breadcrumb-module")
    private WebElement dashBoardTitle;





    public String getPageTitle(){
        return dashBoardTitle.getText();
    }
}
