package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    private static final String PATH = "/login";

    private final By header = By.xpath("//h2[normalize-space(.)='Вход в систему']");
    private final By usernameInput = By.xpath("//h2[normalize-space(.)='Вход в систему']/following::label[normalize-space(.)='Имя пользователя']/following::input[1]");
    private final By passwordInput = By.xpath("//h2[normalize-space(.)='Вход в систему']/following::label[normalize-space(.)='Пароль']/following::input[@type='password'][1]");
    private final By submitButton = By.xpath("//h2[normalize-space(.)='Вход в систему']/following::button[@type='submit' and normalize-space(.)='Войти'][1]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        driver.get(baseUrl() + PATH);
        wait.until(ExpectedConditions.visibilityOfElementLocated(header));
        return this;
    }

    public void login(String username, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(usernameInput)).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(submitButton).click();
    }
}