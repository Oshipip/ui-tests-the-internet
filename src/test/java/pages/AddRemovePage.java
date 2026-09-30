package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddRemovePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By addButton =
            By.cssSelector("button[onclick='addElement()']");

    private final By deleteButton =
            By.cssSelector("button[onclick='deleteElement()']");

    public AddRemovePage(
            WebDriver driver,
            WebDriverWait wait
    ) {
        this.driver = driver;
        this.wait = wait;
    }

    public void open() {

        driver.get(
                "https://the-internet.herokuapp.com/add_remove_elements/"
        );

        wait.until(
                ExpectedConditions
                        .presenceOfElementLocated(addButton)
        );
    }

    public void clickAdd() {

        wait.until(
                ExpectedConditions.elementToBeClickable(addButton)
        ).click();
    }

    public void clickDelete() {

        wait.until(
                ExpectedConditions.elementToBeClickable(deleteButton)
        ).click();
    }

    public boolean isDeleteButtonDisplayed() {

        return !driver.findElements(deleteButton).isEmpty();
    }

    public int getDeleteButtonsCount() {

        return driver.findElements(deleteButton).size();
    }
}