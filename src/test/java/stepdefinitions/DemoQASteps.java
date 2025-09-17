package stepdefinitions;
import hooks.Hooks;
import io.cucumber.java.en.*;
import pages.ElementsPage;
import pages.HomePage;
import utils.LogHelper;
import utils.WaitUtils;
import static org.testng.Assert.assertTrue;
public class DemoQASteps {
    private HomePage homePage;
    private ElementsPage elementsPage;
    @Given("I am on the Demo QA page {string}")
    public void i_am_on_the_demo_qa_page(String url) {
        LogHelper.info("Navigating to: " + url);
        Hooks.driver.get(url);
        homePage = new HomePage(Hooks.driver);
        elementsPage = new ElementsPage(Hooks.driver);
    }
    @When("I click on Elements tab") public void i_click_on_elements_tab() { LogHelper.info("Clicking on Elements tab"); homePage.clickElementsTab(); }
    @Then("I am navigated to page {string}") public void i_am_navigated_to_page(String expectedUrl) {
        LogHelper.info("Validating navigation to: " + expectedUrl);
        WaitUtils waitUtils = new WaitUtils(Hooks.driver);
        assertTrue(waitUtils.waitForUrl(expectedUrl), "Expected URL: " + expectedUrl + ", but got: " + Hooks.driver.getCurrentUrl());
    }
    @When("I click on Text Box link") public void i_click_on_text_box_link() { LogHelper.info("Clicking on Text Box link"); elementsPage.clickTextBoxLink(); }
    @Then("I can see Text Box fields") public void i_can_see_text_box_fields() { LogHelper.info("Verifying Text Box fields are visible"); assertTrue(elementsPage.isTextBoxDisplayed(), "Text Box fields are not visible!"); }
    @When("I enter {string} in the Full Name field") public void i_enter_in_the_full_name_field(String name) { LogHelper.info("Entering Full Name: " + name); elementsPage.enterFullName(name); }
}
