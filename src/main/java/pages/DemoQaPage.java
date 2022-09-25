package pages;

import Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.modal.DemoQaPageModal;

import java.util.List;

public class DemoQaPage extends BasePage {

    @FindBy(xpath = "//div[@id='app']")
    private WebElement page;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstNameInput;
    @FindBy (xpath = "//input[@placeholder='Last Name']")
    private WebElement lastNameInput;
    @FindBy (xpath = "//input[@id='userEmail']")
    private WebElement emailInput;
    @FindBy (xpath = "//input[@id='dateOfBirthInput']")
    private WebElement dateOfBirthInput;
    @FindBy (xpath = "//input[@id='subjectsInput']")
    private WebElement subjectsInput;
    @FindBy (xpath = "//div[@id='hobbiesWrapper']//input[@type='checkbox']")
    private List<WebElement> hobbiesInput;
    @FindBy (xpath = "//input[@id='userNumber']")
    private WebElement mobilePhoneInput;
    @FindBy (xpath = "//input[@placeholder='Mobile Number']")
    private WebElement currentAddressInput;
    @FindBy (xpath = "//div[@id='stateCity-wrapper']//div[text()='Select State']")
    private WebElement stateMenu;
    @FindBy (xpath = "//div[@id='stateCity-wrapper']//div[text()='Select City']")
    private WebElement cityMenu;
    @FindBy(xpath = "//input[@id='uploadPicture']")
    private WebElement uploadButton;
    @FindBy (xpath = "//button[@id='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//div[@class='modal-content']")
    private WebElement modal;


    public DemoQaPage() {
        waitForVisible(page, 10);
    }

    public DemoQaPage fillFirstNameAndLastName(String firstName, String lastName) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public DemoQaPage fillEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public DemoQaPage selectGender(String gender) {
        WebElement requiredGender = driver.findElement(By.xpath(String.format("//input[@name='gender' and @value='%s']", gender)));
        actions.moveToElement(requiredGender).click().build().perform();
        waitForSelected(requiredGender, 10);
        return this;
    }

    public DemoQaPage selectAllHobbies() {
        hobbiesInput
                .stream()
                .forEach(hobbie -> {
                    actions.moveToElement(hobbie).click().build().perform();
                });
        return this;
    }

    public DemoQaPage fillDateOfBirth(int day) {
        dateOfBirthInput.click();
        WebElement yesterdayElem = dateOfBirthInput
                .findElement(By.xpath(String.format("//div[@role='listbox']//div[@role='option' and text()='%s']", day)));
        actions.moveToElement(yesterdayElem).click().build().perform();
        return this;
    }

    public DemoQaPage fillSubjectsContainerInput(String subject) {
        subjectsInput.sendKeys(subject);
        actions.sendKeys(Keys.ENTER).perform();
        return this;
    }

    public DemoQaPage fillMobilePhone(String phone) {
        mobilePhoneInput.sendKeys(phone);
        return this;
    }

    public DemoQaPage fillCurrentAddressInput(String address) {
        currentAddressInput.sendKeys(address);
        return this;
    }

    public DemoQaPage selectStateAndCity(String state, String city) {
        stateMenu.click();
        WebElement needState = stateMenu.findElement(By.xpath(String.format("//*[contains(text(), '%s')]", state)));
        actions.moveToElement(needState).click().build().perform();
        cityMenu.click();
        WebElement needCity = cityMenu.findElement(By.xpath(String.format("//*[contains(text(), '%s')]", city)));
        actions.moveToElement(needCity).click().build().perform();
        return this;
    }

    public DemoQaPage uploadPicture(String fileName) {
        uploadButton.sendKeys(Utils.getFileImage(fileName));
        return this;
    }

    public String getUrlErrorImaage(String fieldName) {
        return waitForVisible(driver.findElement(By.xpath(String.format("//input[@placeholder='%s']", fieldName))), 5)
                .getCssValue("background-image");
    }

    public List<WebElement> getHobbies() {
        return  hobbiesInput;
    }

    public DemoQaPage clickSubmitButtonForFailed() {
        submitButton.click();
        return this;
    }
    public DemoQaPageModal clickSubmitButton() {
        submitButton.click();
        return new DemoQaPageModal(waitForVisible(modal, 10));
    }

}
