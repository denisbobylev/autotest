package ui;

import core.Configuration;
import core.WebDriverInstance;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import pages.DemoQaPage;


public class BaseUiTest {

    public WebDriver getWebDriver() {
        WebDriver driver = WebDriverInstance.getDriver();

        if (driver == null) {
            throw new NullPointerException("WebDriver is null");
        }
        return driver;
    }

    @AfterTest(alwaysRun = true)
    public void quit() {
        WebDriverInstance.quit();
    }

    protected DemoQaPage openDemoQaPage() {
        getWebDriver().get(Configuration.DEMO_QA_LOGIN_PAGE);
        return new DemoQaPage();
    }

    protected DemoQaPage openDemoQaPage1() {
        getWebDriver().get(Configuration.DEMO_QA_LOGIN_PAGE1);
        return new DemoQaPage();
    }


}
