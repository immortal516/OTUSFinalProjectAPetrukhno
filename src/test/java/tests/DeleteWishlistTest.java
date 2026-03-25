package tests;

import config.TestConfig;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.NavBar;
import pages.WishlistsPage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeleteWishlistTest extends WebDriverBaseTest {

    @Test
    void shouldDeleteWishlist() {
        new LoginPage(driver).open().login(TestConfig.loginRequired(), TestConfig.passwordRequired());
        new NavBar(driver).openWishlists();

        String title = "autotest_delete_" + System.currentTimeMillis();

        WishlistsPage page = new WishlistsPage(driver).createWishlist(title, "to be deleted");
        assertTrue(page.isWishlistCardPresentByTitle(title), "Wishlist should be created");

        page.deleteWishlistByTitle(title);
        assertFalse(page.isWishlistCardPresentByTitle(title), "Wishlist should be deleted");
    }
}