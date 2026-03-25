package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddGiftModal {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By title = By.xpath("//div[contains(@class,'modal-title') and normalize-space(.)='Добавить подарок']");

    private final By nameInput = By.xpath("//div[contains(@class,'modal') and contains(@class,'show')]//label[normalize-space(.)='Название']/following::input[1]");
    private final By descriptionTextarea = By.xpath("//div[contains(@class,'modal') and contains(@class,'show')]//label[normalize-space(.)='Описание']/following::textarea[1]");
    private final By shopUrlInput = By.xpath("//div[contains(@class,'modal') and contains(@class,'show')]//label[contains(normalize-space(.),'Ссылка на магазин')]/following::input[1]");
    private final By priceInput = By.xpath("//div[contains(@class,'modal') and contains(@class,'show')]//label[starts-with(normalize-space(.),'Цена')]/following::input[@type='number'][1]");
    private final By imageUrlInput = By.xpath("//div[contains(@class,'modal') and contains(@class,'show')]//label[contains(normalize-space(.),'Ссылка на изображение')]/following::input[1]");

    private final By submitButton = By.cssSelector("div.modal.show button[type='submit'].btn.btn-primary");

    public AddGiftModal(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
    }

    public AddGiftModal setName(String value) {
        wait.until(ExpectedConditions.elementToBeClickable(nameInput)).sendKeys(value);
        return this;
    }

    public AddGiftModal setDescription(String value) {
        driver.findElement(descriptionTextarea).sendKeys(value);
        return this;
    }

    public AddGiftModal setShopUrl(String value) {
        if (value != null) driver.findElement(shopUrlInput).sendKeys(value);
        return this;
    }

    public AddGiftModal setPrice(int value) {
        driver.findElement(priceInput).clear();
        driver.findElement(priceInput).sendKeys(String.valueOf(value));
        return this;
    }

    public AddGiftModal setImageUrl(String value) {
        if (value != null) driver.findElement(imageUrlInput).sendKeys(value);
        return this;
    }

    public void submit() {
        driver.findElement(submitButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(title));
    }
}