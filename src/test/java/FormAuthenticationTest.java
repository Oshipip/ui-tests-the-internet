import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FormAuthenticationTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void positiveLogin() {

        driver.get(
                "https://the-internet.herokuapp.com/login"
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("username")
                )
        ).sendKeys("tomsmith");

        driver.findElement(
                By.id("password")
        ).sendKeys("SuperSecretPassword!");

        driver.findElement(
                By.cssSelector("button.radius")
        ).click();

        String flash =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.id("flash")
                        )
                ).getText();

        Assert.assertTrue(
                flash.contains(
                        "You logged into a secure area!"
                ),
                "Нет подтверждения успешного входа."
        );

        Assert.assertTrue(
                driver.findElement(
                        By.cssSelector("a.button.secondary.radius")
                ).isDisplayed(),
                "Кнопка Logout должна отображаться."
        );
    }

    @Test
    public void negativeLogin_InvalidPassword() {

        driver.get(
                "https://the-internet.herokuapp.com/login"
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("username")
                )
        ).sendKeys("tomsmith");

        driver.findElement(
                By.id("password")
        ).sendKeys("wrong_password");

        driver.findElement(
                By.cssSelector("button.radius")
        ).click();

        String flash =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.id("flash")
                        )
                ).getText();

        Assert.assertTrue(
                flash.contains(
                        "Your password is invalid!"
                ),
                "Ожидалось сообщение об ошибке аутентификации."
        );
    }
}