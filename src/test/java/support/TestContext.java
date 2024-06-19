package support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.yaml.snakeyaml.Yaml;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TestContext {

    private static WebDriver driver;
    private static HashMap<String, String> testdata;


    public static void addData(String key, String value) {
        testdata.put(key, value);
    }

    public static String getData(String key) {
        return testdata.get(key);
    }

    public static Collection<String> getDataValues() {
        return testdata.values();
    }

    public static HashMap<String, String> loadFromFile() throws FileNotFoundException {
        File file = new File(System.getProperty("user.dir") + "/src/test/resources/downloads/testdata.yaml");
        FileInputStream stream = new FileInputStream(file);
        return new Yaml().load(stream);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static JavascriptExecutor getExecutor() {
        return (JavascriptExecutor) driver;
    }

    public static void initialize() throws FileNotFoundException {
        testdata = loadFromFile();
        initialize(false);
    }

    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void initialize(boolean isHeadless) {
        Dimension size = new Dimension(1920, 1080);
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.setExperimentalOption("prefs", getChromePreferences());

        if (isHeadless) {
            chromeOptions.addArguments("--headless=new");
            chromeOptions.addArguments("--window-size=" + size.getWidth() + "," + size.getWidth());
            chromeOptions.addArguments("--disable-gpu");
        }

        ChromeDriverService service = new ChromeDriverService.Builder()
                .withLogOutput(System.out)
                .build();
        driver = new ChromeDriver(service, chromeOptions);
    }

    private static Map<String, Object> getChromePreferences() {
        Map<String, Object> chromePreferences = new HashMap<>();
        chromePreferences.put("profile.default_content_settings.geolocation", 2);
        chromePreferences.put("profile.default_content_settings.popups", 0);
        chromePreferences.put("download.prompt_for_download", false);
        chromePreferences.put("download.directory_upgrade", true);
        chromePreferences.put("download.default_directory", System.getProperty("user.dir") + "/src/test/resources/downloads");
        chromePreferences.put("safebrowsing.enabled", false);
        chromePreferences.put("plugins.always_open_pdf_externally", true);
        chromePreferences.put("plugins.plugins_disabled", new ArrayList<String>() {{
            add("Chrome PDF Viewer");
        }});
        chromePreferences.put("credentials_enable_service", false);
        chromePreferences.put("password_manager_enabled", false);
        return chromePreferences;
    }


}
