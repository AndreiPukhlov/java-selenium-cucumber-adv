package pages.apple;

public class AppleMacPage extends ApplePageHeader{

    public void goToProductPage(String productName){
        click(getByXpath("//span[text()='"+productName+"']"));
    }

    public boolean isProductPageTitle(String prodName){
        return getByXpath("//a[@data-analytics-title='product index'][contains(text(),'"+prodName+"')]").isDisplayed();

    }
}
