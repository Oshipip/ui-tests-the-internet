package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By firstName =
            By.id("first-name");

    private final By lastName =
            By.id("last-name");

    private final By postalCode =
            By.id("postal-code");

    private final By continueButton =
            By.id("continue");

    private final By finishButton =
            By.id("finish");

    private final By completeHeader =
            By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
    }

    public void fillCustomerData(
            String firstNameValue,
            String lastNameValue,
            String postalCodeValue) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstName)
        ).sendKeys(firstNameValue);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(lastName)
        ).sendKeys(lastNameValue);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(postalCode)
        ).sendKeys(postalCodeValue);
    }

    public void clickContinue() {
        wait.until(
                ExpectedConditions.elementToBeClickable(continueButton)
        ).click();
    }

    public void clickFinish() {
        wait.until(
                ExpectedConditions.elementToBeClickable(finishButton)
        ).click();
    }

    public String getCompleteMessage() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(completeHeader)
        ).getText();
    }
}