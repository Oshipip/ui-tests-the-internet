package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/inventory.html"),
                "Ожидался переход на страницу inventory"
        );

        Assert.assertTrue(
                driver.getPageSource().contains("Products"),
                "На странице должен присутствовать заголовок Products"
        );
    }

    @Test
    public void lockedUserLoginTest() {

    LoginPage loginPage = new LoginPage(driver);

    loginPage.login(
            "locked_out_user",
            "secret_sauce"
    );

    String error = loginPage.getErrorMessage();

    Assert.assertTrue(
            error.contains("Epic sadface"),
            "Ожидалось сообщение об ошибке. Фактический текст: " + error
    );
}
}