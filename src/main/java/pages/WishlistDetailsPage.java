package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.components.AddGiftModal;

public class WishlistDetailsPage extends BasePage {

    private final By addGiftButton = By.xpath("//button[contains(@class,'btn-primary') and normalize-space(.)='Добавить подарок']");
    private final By deleteListButton = By.xpath("//button[contains(@class,'btn-danger') and normalize-space(.)='Удалить список']");
    private final By titleH2 = By.cssSelector("div.mt-5.container h2");

    public WishlistDetailsPage(WebDriver driver) {
        super(driver);
    }

    public WishlistDetailsPage waitUntilOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addGiftButton));
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteListButton));
        return this;
    }

    public String title() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(titleH2)).getText();
    }

    public AddGiftModal openAddGiftModal() {
        wait.until(ExpectedConditions.elementToBeClickable(addGiftButton)).click();
        return new AddGiftModal(driver, wait);
    }

    public void waitGiftPresentByTitle(String giftTitle) {
        By giftCardTitle = By.xpath("//div[contains(@class,'card-title') and normalize-space(.)='" + giftTitle + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(giftCardTitle));
    }

    public boolean isGiftPresentByTitle(String giftTitle) {
        By giftCardTitle = By.xpath("//div[contains(@class,'card-title') and normalize-space(.)='" + giftTitle + "']");
        return !driver.findElements(giftCardTitle).isEmpty();
    }

    public void deleteList() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteListButton)).click();
    }
}