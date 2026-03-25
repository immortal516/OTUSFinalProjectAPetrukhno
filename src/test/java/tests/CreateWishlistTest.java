package tests;

import config.TestConfig;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.NavBar;
import pages.WishlistsPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateWishlistTest extends WebDriverBaseTest {

    @Test
    void shouldCreateNewWishlist() {
        new LoginPage(driver).open().login(TestConfig.loginRequired(), TestConfig.passwordRequired());
        new NavBar(driver).openWishlists();

        String listName = "autotest_list_" + System.currentTimeMillis();

        WishlistsPage page = new WishlistsPage(driver)
                .createWishlist(listName, "created by selenium");

        assertTrue(page.isWishlistCardPresentByTitle(listName),
                "Created wishlist card should be present: " + listName);
    }
}