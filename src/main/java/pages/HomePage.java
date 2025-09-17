package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;
public class HomePage {
    private WebDriver driver;
    private WaitUtils waitUtils;
    private By elementsTab = By.xpath("//h5[text()='Elements']/ancestor::div[contains(@class,'top-card')]");
    public HomePage(WebDriver driver) { this.driver = driver; this.waitUtils = new WaitUtils(driver); }
    public void clickElementsTab() { waitUtils.waitForElementClickable(elementsTab).click(); }
}
