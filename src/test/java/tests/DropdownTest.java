package tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pages.DropdownPage;

public class DropdownTest extends TestBase {

    @Test
    public void dropdownContainsOptions() {

        DropdownPage page =
                new DropdownPage(driver, wait);

        page.open();

        Select dropdown =
                page.getDropdown();

        Assert.assertEquals(
                dropdown.getOptions().size(),
                3,
                "Dropdown должен содержать 3 пункта."
        );
    }

    @Test
    public void selectFirstAndSecondOption() {

        DropdownPage page =
                new DropdownPage(driver, wait);

        page.open();

        Select dropdown =
                page.getDropdown();

        dropdown.selectByVisibleText("Option 1");

        Assert.assertEquals(
                dropdown.getFirstSelectedOption()
                        .getText(),
                "Option 1"
        );

        dropdown.selectByVisibleText("Option 2");

        Assert.assertEquals(
                dropdown.getFirstSelectedOption()
                        .getText(),
                "Option 2"
        );
    }
}