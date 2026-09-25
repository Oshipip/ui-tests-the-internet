package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.InventoryPage;
import pages.LoginPage;
import utils.BaseTest;

public class CartTest extends BaseTest {

    @Test
    public void addProductToCartTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        InventoryPage inventoryPage =
                new InventoryPage(driver);

        inventoryPage.addBackpackToCart();

        Assert.assertEquals(
                inventoryPage.getCartBadgeText(),
                "1",
                "Счётчик корзины должен быть равен 1"
        );

        inventoryPage.openCart();

        Assert.assertTrue(
                driver.getPageSource()
                        .contains("Sauce Labs Backpack"),
                "В корзине должен находиться Sauce Labs Backpack"
        );
    }
}