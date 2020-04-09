package automationPractice.step_definitions;


import automationPractice.pages.BasePage;
import automationPractice.pages.PageObjects;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.Map;

public class InputSteps {

    @When("User enters \"([^\"]*)\" as \"([^\"]*)\" on \"([^\"]*)\" page")
    public void user_enters_as_on_page(String field, String value, String page) {
        BasePage basePage = PageObjects.getPageObject(page);
        basePage.enterValue(field, value);
    }

    @Given("User select \"([^\"]*)\" as \"([^\"]*)\" on \"([^\"]*)\" page")
    public void user_select_as_on_page(String field, String value, String page) {
        BasePage basePage = PageObjects.getPageObject(page);
        basePage.select(field, value);
    }

    @When("User fill up all information on \"([^\"]*)\" page")
    public void user_fill_up_all_information_on_page(String page, DataTable data) {
        BasePage basePage = PageObjects.getPageObject(page);
        Map<String, String> mapToPass = new HashMap();
        DataTableRow head = data.getGherkinRows().get(0);
        DataTableRow value = data.getGherkinRows().get(1);

        for (String key :
                head.getCells()) {
            String strValue = value.getCells().get(head.getCells().indexOf(key));
            if (key.equalsIgnoreCase("FirstName") && strValue.equalsIgnoreCase("random")) {
                mapToPass.put(key, BasePage.firstName);
            } else if (key.equalsIgnoreCase("LastName") && strValue.equalsIgnoreCase("random")) {
                mapToPass.put(key, BasePage.lastName);
            } else if (key.equalsIgnoreCase("password") && strValue.equalsIgnoreCase("random")) {
                mapToPass.put(key, BasePage.lastName + "*");
            } else {
                mapToPass.put(key, strValue);
            }
        }
        basePage.enterFields(mapToPass);
    }
}
