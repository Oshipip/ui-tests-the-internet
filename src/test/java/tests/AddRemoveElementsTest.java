package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddRemovePage;

public class AddRemoveElementsTest extends BaseTest {

    @Test
    public void addAndDeleteElements() {

        AddRemovePage page =
                new AddRemovePage(driver, wait);

        // Открываем страницу
        page.open();

        // Добавляем первый элемент
        page.clickAddElement();

        // Ждём появления первой кнопки Delete
        page.waitForDeleteButtons(1);

        // Добавляем второй элемент
        page.clickAddElement();

        // Ждём появления второй кнопки Delete
        page.waitForDeleteButtons(2);

        // Проверяем количество
        Assert.assertEquals(
                page.getDeleteButtonsCount(),
                2,
                "Должно быть 2 кнопки Delete"
        );

        // Удаляем один элемент
        page.clickDelete();

        // Ждём, пока останется одна кнопка
        page.waitForDeleteButtons(1);

        // Проверяем количество
        Assert.assertEquals(
                page.getDeleteButtonsCount(),
                1,
                "После удаления должна остаться 1 кнопка Delete"
        );
    }
}