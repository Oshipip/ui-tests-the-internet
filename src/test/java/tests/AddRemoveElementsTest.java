package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pages.AddRemovePage;

public class AddRemoveElementsTest extends TestBase {

    @Test
    public void addTwoElements() {

        AddRemovePage page =
                new AddRemovePage(driver, wait);

        page.open();

        page.clickAdd();
        page.clickAdd();

        Assert.assertEquals(
                page.getDeleteButtonsCount(),
                2,
                "После двух нажатий должны появиться две кнопки Delete."
        );
    }

    @Test
    public void deleteElement() {

        AddRemovePage page =
                new AddRemovePage(driver, wait);

        page.open();

        page.clickAdd();

        Assert.assertTrue(
                page.isDeleteButtonDisplayed(),
                "Кнопка Delete должна появиться."
        );

        page.clickDelete();

        Assert.assertFalse(
                page.isDeleteButtonDisplayed(),
                "Кнопка Delete должна исчезнуть."
        );
    }
}