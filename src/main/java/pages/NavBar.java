package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavBar extends BasePage {
    private final By myWishlistsLink = By.cssSelector("a.nav-link[href='/wishlists']");
    private final By usersLink = By.cssSelector("a.nav-link[href='/users']");
    private final By logoutLink = By.xpath("//a[contains(@class,'nav-link') and @role='button' and normalize-space(.)='Выйти']");

    public NavBar(WebDriver driver) {
        super(driver);
    }

    public void waitUntilLoggedIn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink));
    }

    public boolean isLogoutVisible() {
        return !driver.findElements(logoutLink).isEmpty();
    }

    public void openWishlists() {
        wait.until(ExpectedConditions.elementToBeClickable(myWishlistsLink)).click();
    }

    public void openUsers() {
        wait.until(ExpectedConditions.elementToBeClickable(usersLink)).click();
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
    }
}