package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WishlistsPage extends BasePage {
    private static final String PATH = "/wishlists";

    private final By header = By.xpath("//h2[normalize-space(.)='Мои списки желаний']");
    private final By createNewListButton = By.xpath("//button[normalize-space(.)='Создать новый список']");

    private final By modalTitle = By.xpath("//div[contains(@class,'modal-title') and normalize-space(.)='Создать новый список желаний']");
    private final By modalNameInput = By.cssSelector("div.modal.show input.form-control");
    private final By modalDescriptionTextarea = By.cssSelector("div.modal.show textarea.form-control");
    private final By modalSubmitButton = By.cssSelector("div.modal.show button[type='submit'].btn.btn-primary");

    private final By cardsContainer = By.cssSelector("div.g-4.row");

    public WishlistsPage(WebDriver driver) {
        super(driver);
    }

    public WishlistsPage open() {
        driver.get(baseUrl() + PATH);
        wait.until(ExpectedConditions.visibilityOfElementLocated(header));
        return this;
    }

    public WishlistsPage createWishlist(String name, String description) {
        wait.until(ExpectedConditions.elementToBeClickable(createNewListButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(modalTitle));

        wait.until(ExpectedConditions.elementToBeClickable(modalNameInput)).sendKeys(name);
        if (description != null) {
            driver.findElement(modalDescriptionTextarea).sendKeys(description);
        }
        driver.findElement(modalSubmitButton).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(modalTitle));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardsContainer));
        return this;
    }

    public boolean isWishlistCardPresentByTitle(String title) {
        By cardTitle = By.xpath("//div[contains(@class,'card-title') and normalize-space(.)='" + title + "']");
        return !driver.findElements(cardTitle).isEmpty();
    }

    public void openWishlistByTitle(String title) {
        By viewButton = By.xpath(
                "//div[contains(@class,'card-body')]" +
                        "[.//div[contains(@class,'card-title') and normalize-space(.)='" + title + "']]" +
                        "//button[normalize-space(.)='Просмотр']"
        );

        wait.until(ExpectedConditions.elementToBeClickable(viewButton)).click();
        wait.until(d -> d.getCurrentUrl().matches(".*/wishlists/[0-9a-f\\-]{36}.*"));
    }

    public void deleteWishlistByTitle(String title) {
        By cardTitle = By.xpath("//div[contains(@class,'card-title') and normalize-space(.)='" + title + "']");
        By deleteButton = By.xpath(
                "//div[contains(@class,'card-body')]" +
                        "[.//div[contains(@class,'card-title') and normalize-space(.)='" + title + "']]" +
                        "//button[contains(@class,'btn-danger') and normalize-space(.)='Удалить']"
        );

        wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(cardTitle));
    }
}