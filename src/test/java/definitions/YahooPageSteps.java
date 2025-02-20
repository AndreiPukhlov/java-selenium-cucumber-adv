package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Page;
import pages.yahoo.YahooHeaderPage;
import pages.yahoo.YahooPage;
import pages.yahoo.YahooPageVerification;
import pages.yahoo.YahooWeatherPage;

import static org.assertj.core.api.Assertions.assertThat;


public class YahooPageSteps extends Page {

    @Given("user is on the Yahoo page")
    public void userIsOnTheYahooPage() {
        new YahooPage().openPage();
    }

    @When("they navigates to the Yahoo services")
    public void theyNavigatesToTheYahooServices() {
        new YahooHeaderPage().clickOnMoreServices();
    }

    @And("they chooses Weather")
    public void theyChoosesWeather()  {
        new YahooHeaderPage().clickOnWeather();
    }

    @And("they chooses to find location by {string} and chooses {string} from the search result")
    public void theyChoosesToChangeLocation(String cityOrZip, String cityName) {
        YahooWeatherPage yahooWeatherPage = new YahooWeatherPage();
        yahooWeatherPage.clickChangeLocation();
        yahooWeatherPage.enterCityOrZipCode(cityOrZip);
        yahooWeatherPage.chooseLocationToShow(cityName);
    }

    @Then("they see weather forecast city name, country name, and the temperature")
    public void theySeeChosenCityNameCountryNameAndTheTemperature() {
        YahooPageVerification yahooPageVerification = new YahooPageVerification();
        assertThat(yahooPageVerification.isTemperatureForecastDisplayed()).isTrue();
        assertThat(yahooPageVerification.isForecastCityNameDisplayed()).isTrue();
        assertThat(yahooPageVerification.isForecastCountryNameDisplayed()).isTrue();
        System.out.println(yahooPageVerification.getTextFromModule());
    }
}
