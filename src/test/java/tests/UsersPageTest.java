package tests;

import config.TestConfig;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.NavBar;
import pages.UsersPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UsersPageTest extends WebDriverBaseTest {

    @Test
    void shouldOpenUsersAndSeeCards() {
        new LoginPage(driver).open().login(TestConfig.loginRequired(), TestConfig.passwordRequired());

        new NavBar(driver).openUsers();

        UsersPage usersPage = new UsersPage(driver);
        assertTrue(usersPage.userCardsCount() > 0, "Users list should not be empty");
    }
}