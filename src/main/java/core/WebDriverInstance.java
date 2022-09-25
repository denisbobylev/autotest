package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static core.Configuration.CHROMEDRIVER;

public class WebDriverInstance {

    public static final Logger LOGGER = LoggerFactory.getLogger(WebDriverInstance.class);
    private static WebDriver driver = createDriverInstance();


    private WebDriverInstance() {

    }


    public static WebDriver getDriver() {
        return driver;
    }

    public static void quit() {
        LOGGER.info(">>> Closing '{}' driver instance", CHROMEDRIVER);
        driver.quit();
    }

    public static WebDriver createDriverInstance() {
        LOGGER.info(">>> Creating '{}' driver instance", CHROMEDRIVER);
        return  initChrome();
    }

    private static WebDriver initChrome() {
        System.setProperty("webdriver.chrome.driver",Configuration.CHROMEDRIVER);
        return new ChromeDriver();
    }

}
