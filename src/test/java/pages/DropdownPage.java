package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By dropdown =
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
    }

    public Select getDropdown() {
        return new Select(
                driver.findElement(dropdown)
        );
    }
}