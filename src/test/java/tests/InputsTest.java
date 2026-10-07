package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InputsPage;

public class InputsTest extends BaseTest {

    @Test
    public void enterNumbers() {

        InputsPage page =
                new InputsPage(driver, wait);

        page.open();

        WebElement input =
                page.getInput();

        input.sendKeys("123");

        Assert.assertEquals(
                input.getAttribute("value"),
                "123"
        );
    }

    @Test
    public void arrowKeysChangeNumber() {

        InputsPage page =
                new InputsPage(driver, wait);

        page.open();

        WebElement input =
                page.getInput();

        input.sendKeys("5");

        input.sendKeys(Keys.ARROW_UP);

        input.sendKeys(Keys.ARROW_DOWN);

        Assert.assertTrue(
                input.isDisplayed(),
                "Поле ввода должно отображаться"
        );
    }
}