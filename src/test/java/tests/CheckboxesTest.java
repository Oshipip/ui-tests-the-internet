package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckboxesPage;

import java.util.List;

public class CheckboxesTest extends BaseTest {

    @Test
    public void firstCheckboxCanBeChecked() {

        CheckboxesPage page =
                new CheckboxesPage(driver, wait);

        page.open();

        List<WebElement> checkboxes =
                page.getCheckboxes();

        Assert.assertFalse(
                checkboxes.get(0).isSelected(),
                "Первый checkbox должен быть unchecked"
        );

        checkboxes.get(0).click();

        Assert.assertTrue(
                checkboxes.get(0).isSelected(),
                "Первый checkbox должен быть checked"
        );
    }
}