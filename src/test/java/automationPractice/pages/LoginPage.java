package automationPractice.pages;

import automationPractice.utilities.ConfigurationReader;
import automationPractice.utilities.WaitClass;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(linkText = "Sign in")
    public WebElement signIn;

    @FindBy(id = "email")
    public WebElement userName;

    @FindBy(id = "passwd")
    public WebElement password;

    @FindBy(id = "SubmitLogin")
    public WebElement submit;

    @FindBy(id = "email_create")
    public WebElement txt_email;

    @FindBy(id = "SubmitCreate")
    public WebElement btn_create;


    @Override
    public void clickButton(String button) {
        button = button.toLowerCase();
        switch (button) {
            case "sign in":
                WaitClass.waitAndClick(signIn);
                break;
            case "submit":
                WaitClass.waitAndClick(submit);
                break;
            case "create an account":
                WaitClass.waitAndClick(btn_create);
                break;
            default:
                Assert.fail("No button name found");
        }
    }

    @Override
    public void enterValue(String field, String value) {
        field = field.toLowerCase();
        value = (value.equalsIgnoreCase("configValue")) ? ConfigurationReader.get(field) : value;
        switch (field) {
            case "username":
                WaitClass.waitAndSendKeys(userName, value);
                break;
            case "password":
                WaitClass.waitAndSendKeys(password, value);
                break;
            case "email":
                if (value.equalsIgnoreCase("random"))
                    WaitClass.waitAndSendKeys(txt_email, BasePage.email);
                else
                    WaitClass.waitAndSendKeys(txt_email, value);
                break;
            default:
                Assert.fail("Field not configured.");
        }
    }
}
