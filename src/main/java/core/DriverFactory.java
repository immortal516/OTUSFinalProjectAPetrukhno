package core;

import config.TestConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;

public final class DriverFactory {
    private DriverFactory() {}

    public static WebDriver create() {
        String browser = TestConfig.browser().trim().toLowerCase();

        if (TestConfig.remote()) {
            return createRemote(browser);
        }
        return createLocal(browser);
    }

    private static WebDriver createLocal(String browser) {
        return switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                yield new ChromeDriver(new ChromeOptions());
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                yield new FirefoxDriver(new FirefoxOptions());
            }
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser + ". Use chrome|firefox");
        };
    }

    private static WebDriver createRemote(String browser) {
        try {
            return switch (browser) {
                case "chrome" -> new RemoteWebDriver(URI.create(TestConfig.gridUrl()).toURL(), new ChromeOptions());
                case "firefox" -> new RemoteWebDriver(URI.create(TestConfig.gridUrl()).toURL(), new FirefoxOptions());
                default -> throw new IllegalArgumentException("Unsupported browser: " + browser + ". Use chrome|firefox");
            };
        } catch (Exception e) {
            throw new RuntimeException("Failed to create RemoteWebDriver: " + e.getMessage(), e);
        }
    }
}