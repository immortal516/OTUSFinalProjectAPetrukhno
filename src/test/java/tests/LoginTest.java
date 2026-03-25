package tests;

import config.TestConfig;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.NavBar;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends WebDriverBaseTest {

    @Test
    void shouldLogin() {
        new LoginPage(driver)
                .open()
                .login(TestConfig.loginRequired(), TestConfig.passwordRequired());

        NavBar nav = new NavBar(driver);
        nav.waitUntilLoggedIn();

        assertTrue(nav.isLogoutVisible(), "Logout link should be visible after login");
    }
}