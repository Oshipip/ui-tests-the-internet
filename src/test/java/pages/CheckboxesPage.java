package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckboxesPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By checkboxes =
            By.cssSelector("[type=checkbox]");

    public CheckboxesPage(
            WebDriver driver,
            WebDriverWait wait
    ) {
        this.driver = driver;
        this.wait = wait;
    }

    public void open() {
        driver.get(
                "https://the-internet.herokuapp.com/checkboxes"
        );
    }

    public List<WebElement> getCheckboxes() {
        return driver.findElements(checkboxes);
    }
}