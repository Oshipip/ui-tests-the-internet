package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By input =
            By.cssSelector("input[type='number']");

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

        wait.until(
                ExpectedConditions
                        .presenceOfElementLocated(input)
        );
    }

    public WebElement getInput() {

        return wait.until(
                ExpectedConditions
                        .elementToBeClickable(input)
        );
    }
}