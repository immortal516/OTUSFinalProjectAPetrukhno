package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UsersPage extends BasePage {
    private static final String PATH = "/users";

    private final By header = By.xpath("//h2[normalize-space(.)='Пользователи']");
    private final By userCards = By.cssSelector("div.card");

    public UsersPage(WebDriver driver) {
        super(driver);
    }

    public UsersPage open() {
        driver.get(baseUrl() + PATH);
        wait.until(ExpectedConditions.visibilityOfElementLocated(header));
        return this;
    }

    public int userCardsCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(header));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(userCards, 0));
        return driver.findElements(userCards).size();
    }
}