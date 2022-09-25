package pages.modal;

import org.openqa.selenium.WebElement;
import pages.BasePage;

public abstract class Modal extends BasePage {
    private final WebElement wrapElement;

    public Modal(WebElement wrapElement) {
        this.wrapElement = wrapElement;
    }
}
