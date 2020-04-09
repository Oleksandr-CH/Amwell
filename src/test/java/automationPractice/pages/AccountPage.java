package automationPractice.pages;

import automationPractice.utilities.ConfigurationReader;
import automationPractice.utilities.Utilities;
import automationPractice.utilities.WaitClass;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class AccountPage extends BasePage{


    @FindBy(id = "search_query_top")
    public WebElement txt_search;

    @FindBy(name = "submit_search")
    public WebElement btn_submit_search;

    @FindBy(id = "customer_firstname")
    public WebElement txt_firstName;

    @FindBy(id = "customer_lastname")
    public WebElement txt_lastName;

    @FindBy(xpath = "//input[@id='passwd']")
    public WebElement txt_password;

    @FindBy(id="address1")
    public WebElement txt_street;

    @FindBy(id = "city")
    public WebElement txt_city;

    @FindBy(id = "id_state")
    public WebElement lst_state;

    @FindBy(id = "postcode")
    public WebElement txt_postcode;

    @FindBy(id = "phone_mobile")
    public WebElement txt_mobile;

    @FindBy(id = "submitAccount")
    public WebElement btn_register;

    @Override
    public  void validate (String field, String expected){
        field = field.toLowerCase();
        switch (field){
            case "title":
                Assert.assertEquals(expected, driver.getTitle());
                break;
            default:
                Assert.fail("Field not configured.");
        }
    }


    @Override
    public void enterValue(String field , String value){
        field = field.toLowerCase();
        switch (field){
            case "search key":
                WaitClass.waitAndSendKeys(txt_search, value);
                break;
            default:
                Assert.fail("Field not configured.");
        }
    }

    @Override
    public void clickButton(String button){
        button = button.toLowerCase();
        switch (button){
            case "search":
                WaitClass.waitAndClick(btn_submit_search);
                break;
            case "register":
                WaitClass.waitAndClick(btn_register);
                break;
            default:
                Assert.fail("No button name found");
        }
    }

    @Override
    public void enterFields(Map<String, String> data){
        for (String key:
                data.keySet()) {
            if (key.equalsIgnoreCase("firstName")) {
                WaitClass.waitAndSendKeys(txt_firstName, data.get(key));
            } else if (key.equalsIgnoreCase("lastName")) {
                WaitClass.waitAndSendKeys(txt_lastName, data.get(key));
            }else if (key.equalsIgnoreCase("password")) {
                Utilities.waitTime(1);
                WaitClass.waitAndSendKeys(txt_password, data.get(key));
            }else if (key.equalsIgnoreCase("Street")) {
                WaitClass.waitAndSendKeys(txt_street, data.get(key));
            }else if (key.equalsIgnoreCase("City")) {
                WaitClass.waitAndSendKeys(txt_city, data.get(key));
            }else if (key.equalsIgnoreCase("PostalCode")) {
                WaitClass.waitAndSendKeys(txt_postcode, data.get(key));
            }else if (key.equalsIgnoreCase("Phone")) {
                WaitClass.waitAndSendKeys(txt_mobile, data.get(key));
            }else if (key.equalsIgnoreCase("State")) {
                WaitClass.selectByTextFromDropDown(lst_state, data.get(key));
            }
        }
    }
}
