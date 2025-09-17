package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;
public class ElementsPage {
    private WebDriver driver;
    private WaitUtils waitUtils;
    private By textBoxLink = By.xpath("//span[text()='Text Box']");
    private By fullNameField = By.id("userName");
    public ElementsPage(WebDriver driver) { this.driver = driver; this.waitUtils = new WaitUtils(driver); }
    public void clickTextBoxLink() { waitUtils.waitForElementClickable(textBoxLink).click(); }
    public boolean isTextBoxDisplayed() { return waitUtils.waitForElementVisible(fullNameField).isDisplayed(); }
    public void enterFullName(String name) { waitUtils.waitForElementVisible(fullNameField).sendKeys(name); }
}
