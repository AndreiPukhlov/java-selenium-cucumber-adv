package pages.orange;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class OrangeSignInPage extends Page {
    public OrangeSignInPage() {
        setUrl("https://opensource-demo.orangehrmlive.com/");

    }
    @FindBy(xpath = "(//p[@class = 'oxd-text oxd-text--p'])[1]")
    private WebElement adminNameText;

    @FindBy(xpath = "(//p[@class = 'oxd-text oxd-text--p'])[2]")
    private WebElement adminPwdText;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement userPwdField;

    @FindBy(css = ".orangehrm-login-button")
    private WebElement loginButton;



    public String getAdminUserName(){
        return adminNameText.getText();
    }

    public String getAdminUserPwd(){
        return adminPwdText.getText();
    }

    public void fillUserName(String userName){
//
        sendKeysWithoutWait(userNameField, userName);
    }

    public void fillUserPwd(String userPwd){
        sendKeysWithoutWait(userPwdField, userPwd);
    }

    public void clickLoginButton(){
        click(loginButton);
    }
}
