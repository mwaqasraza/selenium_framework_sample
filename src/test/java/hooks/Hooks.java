package hooks;
import config.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
public class Hooks {
    public static WebDriver driver;
    @Before public void setUp() { driver = DriverFactory.getDriver(); driver.manage().window().maximize(); driver.get(ConfigReader.get("base.url")); }
    @After public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed_Screenshot");
        }
        DriverFactory.quitDriver();
    }
}
