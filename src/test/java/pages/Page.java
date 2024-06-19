package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.TestContext;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static support.TestContext.getDriver;
import static support.TestContext.getExecutor;

public class Page {

    public Page() {
        PageFactory.initElements(getDriver(), this); // Initializes @FindBy for all pages
    }

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void openPage() {
        getDriver().get(url);
    }

    public String getActualUrl() {
        return getDriver().getCurrentUrl();
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
    }

    public void alertAccept() {
        getDriver().switchTo().alert().accept();
    }

    public void alertDismiss() {
        getDriver().switchTo().alert().dismiss();
    }

    public WebElement getByXpath(String xpath) {
        return getDriver().findElement(By.xpath(xpath));
    }

    public WebElement getByCSS(String css) {
        return getDriver().findElement(By.cssSelector(css));
    }

    public void clickWithJS(WebElement element) {
        getExecutor().executeScript("arguments[0].click();", element);
    }

    public void click(WebElement element) {
        waitForClickable(element);
        try {
            element.click();
        } catch (WebDriverException e) {
            clickWithJS(element);
        }
    }

    public void clickOn(WebElement element) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                element.click();
                break;
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                System.out.println("Attempt " + (attempts + 1) + " to click element failed: ");
            }
            attempts++;
        }
    }

    public void scrollToElement(WebElement element) {
        getExecutor().executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void selectByVisibleText(WebElement element, String text) {
        new Select(element).selectByVisibleText(text);
    }

    public void selectByValue(WebElement element, String value) {
        new Select(element).selectByValue(value);
    }

    public void sendKeys(WebElement element, String text) {
        waitForElementVisible(element);
        element.sendKeys(text);
    }

    public void sendKeysWithoutWait(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void waitForClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementsVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public void hoverMouse(WebElement element) {
        waitForElementVisible(element);
        new Actions(getDriver()).moveToElement(element).perform();
    }

    public void getIframe(WebElement element) {
        hoverMouse(element);
        TestContext.getDriver().switchTo().frame(element);
    }

    public void outOfIframe() {
        TestContext.getDriver().switchTo().defaultContent();
    }

    /**
     * Method to get current date from the system
     *
     * @param dateFormat to specify the date output format
     */
    public String getCurrentDate(String dateFormat) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        return currentDate.format(formatter);
    }

    /**
     * Method to get current time from the system
     *
     * @param timeFormat to specify the time output format
     */
    public String getCurrentTime(String timeFormat) {
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(timeFormat);
        return currentTime.format(formatter);
    }
}
