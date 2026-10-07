package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By input =
            By.tagName("input");

    public InputsPage(
            WebDriver driver,
            WebDriverWait wait
    ) {
        this.driver = driver;
        this.wait = wait;
    }

    public void open() {
        driver.get(
                "https://the-internet.herokuapp.com/inputs"
        );
    }

    public WebElement getInput() {
        return driver.findElement(input);
    }
}