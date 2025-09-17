package utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class WaitUtils {
    private WebDriver driver;
    private WebDriverWait wait;
    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        int timeout = Integer.parseInt(config.ConfigReader.get("timeout"));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }
    public WebElement waitForElementVisible(By locator) { return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); }
    public WebElement waitForElementClickable(By locator) { return wait.until(ExpectedConditions.elementToBeClickable(locator)); }
    public boolean waitForUrl(String url) { return wait.until(ExpectedConditions.urlToBe(url)); }
}
