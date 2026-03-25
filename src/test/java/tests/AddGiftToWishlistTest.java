package tests;

import config.TestConfig;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.NavBar;
import pages.WishlistDetailsPage;
import pages.WishlistsPage;
import pages.components.AddGiftModal;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddGiftToWishlistTest extends WebDriverBaseTest {

    @Test
    void shouldAddGiftToWishlist() {
        new LoginPage(driver).open().login(TestConfig.loginRequired(), TestConfig.passwordRequired());
        new NavBar(driver).openWishlists();

        String listTitle = "autotest_gifts_" + System.currentTimeMillis();

        new WishlistsPage(driver).createWishlist(listTitle, "list for gifts");
        new WishlistsPage(driver).openWishlistByTitle(listTitle);

        WishlistDetailsPage details = new WishlistDetailsPage(driver).waitUntilOpened();

        String giftTitle = "gift_" + System.currentTimeMillis();

        AddGiftModal modal = details.openAddGiftModal();
        modal.setName(giftTitle)
                .setDescription("created by selenium")
                .setShopUrl("https://example.com/product")
                .setPrice(123)
                .setImageUrl("https://example.com/image.jpg")
                .submit();

        details.waitGiftPresentByTitle(giftTitle);
        assertTrue(details.isGiftPresentByTitle(giftTitle), "Gift should be present by title: " + giftTitle);
    }
}