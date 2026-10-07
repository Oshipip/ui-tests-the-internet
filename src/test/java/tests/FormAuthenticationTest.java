package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormAuthenticationTest extends BaseTest {

    @Test
    public void positiveLogin() {

        driver.get(
                "https://the-internet.herokuapp.com/login"
        );

        wait.until(
                org.openqa.selenium.support.ui.ExpectedConditions
                        .visibilityOfElementLocated(
                                By.id("username")
                        )
        ).sendKeys("tomsmith");

        driver.findElement(
                By.id("password")
        ).sendKeys("SuperSecretPassword!");

        driver.findElement(
                By.cssSelector("button.radius")
        ).click();

        String flash = wait.until(
                org.openqa.selenium.support.ui.ExpectedConditions
                        .visibilityOfElementLocated(
                                By.id("flash")
                        )
        ).getText();

        Assert.assertTrue(
                flash.contains(
                        "You logged into a secure area!"
                ),
                "Нет подтверждения успешного входа."
        );

        Assert.assertTrue(
                driver.findElement(
                        By.cssSelector("a.button.secondary.radius")
                ).isDisplayed(),
                "Кнопка Logout должна отображаться."
        );
    }
}