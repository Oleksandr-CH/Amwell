package automationPractice.pages;

import automationPractice.utilities.WaitClass;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    @FindBy(xpath = "//i/parent::h2")
    public WebElement confirm_msg;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    public WebElement success_msg;

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    public WebElement warning_msg;

    @FindBy(className = "icon-trash")
    public WebElement btn_delete;

    @FindBy(xpath = "(//span[contains(text(),'Proceed to checkout')])[2]")
    public WebElement btn_checkout;

    @FindBy(xpath = "//input[@id='cgv']")
    public WebElement btn_agree;

    @FindBy(xpath = "//a[contains(text(),'Pay by check')]")
    public WebElement btn_payCheck;

    @FindBy(xpath = "//span[contains(text(),'I confirm')]")
    public WebElement btn_confirm;

    @Override
    public  void validate (String field, String expected){
        field = field.toLowerCase();
        switch (field){
            case "confirmation":
                Assert.assertEquals(expected, WaitClass.waitAndGetText(confirm_msg));
                break;
            case "success":
                WaitClass.webDriverWait.until(ExpectedConditions.textToBePresentInElement(success_msg, expected));
                Assert.assertEquals(expected, success_msg.getText());
                break;
            case "warning":
                Assert.assertEquals(expected, WaitClass.waitAndGetText(warning_msg));
                break;
            default:
                Assert.fail("Field not configured.");
        }
    }

    @Override
    public void clickButton(String button){
        button = button.toLowerCase();
        switch (button){
            case "delete":
                WaitClass.waitAndClick(btn_delete);
                break;
            case "proceed to checkout":
                WaitClass.waitAndClick(btn_checkout);
                break;
            case "pay by check":
                WaitClass.waitAndClick(btn_payCheck);
                break;
            case "i confirm":
                WaitClass.waitAndClick(btn_confirm);
                break;
            case "agree":
                btn_agree.click();
                break;
            default:
                Assert.fail("No button name found");
        }
    }

}
