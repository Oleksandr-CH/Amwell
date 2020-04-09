package automationPractice.step_definitions;

import automationPractice.pages.BasePage;
import automationPractice.pages.PageObjects;
import automationPractice.utilities.ConfigurationReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class NavigationSteps extends BasePage {


    @Given("User on \"([^\"]*)\" page for \"([^\"]*)\" application")
    public void user_on_page_for_application(String pageName, String application) {
        switch (application){
            case "automationpractice":
                driver.get(ConfigurationReader.get("url1"));
                break;
            default:
                Assert.fail("Application name " + application + " not defined.");
        }
    }

    @When("User clicks on \"([^\"]*)\" button on \"([^\"]*)\" page")
    public void user_clicks_on_button_on_page(String buttonName, String page) {
        BasePage basePage = PageObjects.getPageObject(page);
        basePage.clickButton(buttonName);
    }



}
