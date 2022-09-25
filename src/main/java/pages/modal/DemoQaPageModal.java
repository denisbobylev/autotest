package pages.modal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemoQaPageModal extends Modal {

    public DemoQaPageModal(WebElement wrapElement) {
        super(wrapElement);
    }

    @FindBy(xpath = "//div[@class='modal-content']//tbody/tr")
    private List<WebElement> rows;

    public Map<String, String> getLabelsAndValues() {
        Map map = new HashMap();
        rows
                .stream()
                .forEach(row -> {
                    map.put(getLabel(row), getValue(row));
                });

        return map;
    }

    private String getLabel(WebElement row) {
        return row.findElement(By.xpath("./td[1]")).getText();
    }

    private String getValue(WebElement row) {
        return row.findElement(By.xpath("./td[2]")).getText();
    }
}
