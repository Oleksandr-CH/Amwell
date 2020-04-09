package automationPractice.step_definitions;

import automationPractice.pages.BasePage;
import automationPractice.pages.PageObjects;
import cucumber.api.java.en.Then;

public class AssertionSteps {

    @Then("\"([^\"]*)\" should be \"([^\"]*)\" on \"([^\"]*)\" page")
    public void should_be_on_page(String field, String expected, String page) {
        BasePage basePage = PageObjects.getPageObject(page);
        basePage.validate(field, expected);
    }

}
