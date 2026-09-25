package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.BaseTest;

public class CheckoutTest extends BaseTest {

    @Test
    public void successfulCheckoutTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        InventoryPage inventoryPage =
                new InventoryPage(driver);

        inventoryPage.addBackpackToCart();
        inventoryPage.openCart();

        CartPage cartPage =
                new CartPage(driver);

        cartPage.clickCheckout();

        CheckoutPage checkoutPage =
                new CheckoutPage(driver);

        checkoutPage.fillCustomerData(
                "Ivan",
                "Ivanov",
                "12345"
        );

        checkoutPage.clickContinue();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("checkout-step-two"),
                "Ожидался переход на страницу проверки заказа"
        );

        checkoutPage.clickFinish();

        Assert.assertEquals(
                checkoutPage.getCompleteMessage(),
                "Thank you for your order!",
                "Заказ должен быть успешно завершён"
        );
    }
}