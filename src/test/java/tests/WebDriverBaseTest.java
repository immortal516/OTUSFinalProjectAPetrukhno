package tests;

import core.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public abstract class WebDriverBaseTest {
    protected WebDriver driver;
    protected final Logger log = LogManager.getLogger(getClass());

    @BeforeEach
    void startDriver() {
        driver = DriverFactory.create();
        driver.manage().window().setSize(new Dimension(1280, 900));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
    }

    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }
}