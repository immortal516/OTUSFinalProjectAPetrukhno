package tests;

import config.TestConfig;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.NavBar;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoutTest extends WebDriverBaseTest {

    @Test
    void shouldLogout() {
        new LoginPage(driver).open().login(TestConfig.loginRequired(), TestConfig.passwordRequired());
        new NavBar(driver).logout();

        By loginLink = By.cssSelector("a.nav-link[href='/login']");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(loginLink));

        assertTrue(driver.findElement(loginLink).isDisplayed(), "Login link should be visible after logout");
    }
}