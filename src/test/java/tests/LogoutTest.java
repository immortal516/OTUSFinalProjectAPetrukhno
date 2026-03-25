package tests;

import config.TestConfig;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.NavBar;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoutTest extends WebDriverBaseTest {

    @Test
    void shouldLogout() {
        new LoginPage(driver).open().login(TestConfig.loginRequired(), TestConfig.passwordRequired());
        new NavBar(driver).logout();

        boolean loginLinkVisible = !driver.findElements(org.openqa.selenium.By.cssSelector("a.nav-link[href='/login']")).isEmpty();
        assertTrue(loginLinkVisible, "Login link should be visible after logout");
    }
}