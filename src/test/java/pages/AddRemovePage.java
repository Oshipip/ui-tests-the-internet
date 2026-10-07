package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddRemovePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By addElementButton =
            By.xpath("//button[text()='Add Element']");

    private By deleteButton =
            By.xpath("//button[text()='Delete']");

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
                ExpectedConditions.elementToBeClickable(
                        addElementButton
                )
        );
    }

    public void clickAddElement() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        addElementButton
                )
        ).click();
    }

    public void clickDelete() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        deleteButton
                )
        ).click();
    }

    public int getDeleteButtonsCount() {

        return driver.findElements(deleteButton).size();
    }

    public void waitForDeleteButtons(int expectedCount) {

        wait.until(
                ExpectedConditions.numberOfElementsToBe(
                        deleteButton,
                        expectedCount
                )
        );
    }
}