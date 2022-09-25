package pages;

import core.WebDriverInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import java.time.Duration;
import java.util.List;


public class BasePage {

    protected WebDriver driver;
    public Actions actions;


    public BasePage() {
        this.driver = WebDriverInstance.getDriver();
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }


    public String getCurrentPageLink() {
        return driver.getCurrentUrl();
    }


    protected WebElement waitForVisible(WebElement element, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return  wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitForClickable(WebElement element, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return  wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected Boolean waitForSelected(WebElement element, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return  wait.until(ExpectedConditions.elementSelectionStateToBe(element, true));
    }

    @AfterMethod(alwaysRun = true)
    public void Close() {
        driver.close();
    }

}
