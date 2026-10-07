package tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropdownPage;

public class DropdownTest extends BaseTest {

    @Test
    public void selectOption1() {

        DropdownPage page =
                new DropdownPage(driver, wait);

        page.open();

        Select dropdown =
                page.getDropdown();

        dropdown.selectByVisibleText("Option 1");

        Assert.assertEquals(
                dropdown.getFirstSelectedOption().getText(),
                "Option 1"
        );
    }

    @Test
    public void selectOption2() {

        DropdownPage page =
                new DropdownPage(driver, wait);

        page.open();

        Select dropdown =
                page.getDropdown();

        dropdown.selectByVisibleText("Option 2");

        Assert.assertEquals(
                dropdown.getFirstSelectedOption().getText(),
                "Option 2"
        );
    }
}