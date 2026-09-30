package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By dropdown =
            By.id("dropdown");

    public DropdownPage(
            WebDriver driver,
            WebDriverWait wait
    ) {
        this.driver = driver;
        this.wait = wait;
    }

    public void open() {

        driver.get(
                "https://the-internet.herokuapp.com/dropdown"
        );

        wait.until(
                ExpectedConditions
                        .presenceOfElementLocated(dropdown)
        );
    }

    public Select getDropdown() {

        return new Select(
                wait.until(
                        ExpectedConditions
                                .elementToBeClickable(dropdown)
                )
        );
    }
}