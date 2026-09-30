package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pages.InputsPage;

public class InputsTest extends TestBase {

    @Test
    public void inputAcceptsNumber() {

        InputsPage page =
                new InputsPage(driver, wait);

        page.open();

        WebElement input =
                page.getInput();

        input.clear();
        input.sendKeys("123");

        Assert.assertEquals(
                input.getAttribute("value"),
                "123",
                "Input должен принять число 123."
        );
    }

    @Test
    public void inputWorksWithArrowKeys() {

        InputsPage page =
                new InputsPage(driver, wait);

        page.open();

        WebElement input =
                page.getInput();

        input.clear();
        input.sendKeys("1");

        input.sendKeys(Keys.ARROW_UP);

        Assert.assertEquals(
                input.getAttribute("value"),
                "2",
                "ARROW_UP должен увеличить значение."
        );

        input.sendKeys(Keys.ARROW_DOWN);

        Assert.assertEquals(
                input.getAttribute("value"),
                "1",
                "ARROW_DOWN должен уменьшить значение."
        );
    }
}