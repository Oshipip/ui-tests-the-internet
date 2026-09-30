package tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CheckboxesPage;

public class CheckboxesTest extends TestBase {

    @Test
    public void firstCheckboxCanBeChecked() {

        CheckboxesPage page =
                new CheckboxesPage(driver, wait);

        page.open();

        List<WebElement> checkboxes =
                page.getCheckboxes();

        WebElement first =
                checkboxes.get(0);

        if (!first.isSelected()) {
            first.click();
        }

        Assert.assertTrue(
                first.isSelected(),
                "Первый checkbox должен быть выбран."
        );
    }

    @Test
    public void secondCheckboxCanBeUnchecked() {

        CheckboxesPage page =
                new CheckboxesPage(driver, wait);

        page.open();

        List<WebElement> checkboxes =
                page.getCheckboxes();

        WebElement second =
                checkboxes.get(1);

        if (second.isSelected()) {
            second.click();
        }

        Assert.assertFalse(
                second.isSelected(),
                "Второй checkbox должен быть снят."
        );
    }
}