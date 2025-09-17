package utils;
import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class DriverFactory {
    private static WebDriver driver;
    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = ConfigReader.get("browser");
            switch (browser.toLowerCase()) {
                case "firefox": driver = new FirefoxDriver(); break;
                case "chrome":
                default: driver = new ChromeDriver(); break;
            }
        }
        return driver;
    }
    public static void quitDriver() {
        if (driver != null) { driver.quit(); driver = null; }
    }
}
