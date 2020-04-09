package automationPractice.pages;

import automationPractice.utilities.WaitClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemDescriptionPage extends BasePage{

    @FindBy(id = "quantity_wanted")
    public WebElement txt_quantity;

    @FindBy(tagName = "select")
    public WebElement lst_size;

    @FindBy(xpath = "//a[@name='Orange']")
    public WebElement lnk_orange_color;

    @FindBy(name = "Submit")
    public WebElement btn_add_to_cart;

    @FindBy(xpath = "(//span[contains(text(),'Proceed to checkout')])[1]")
    public WebElement btn_checkout;


    @Override
    public  void select (String field, String value){
        field = field.toLowerCase();
        switch (field){
            case "quantity":
                WaitClass.waitAndSendKeys(txt_quantity, value);
                break;
            case "size":
                WaitClass.selectByTextFromDropDown(lst_size, value);
                break;
            case "color":
                WaitClass.waitAndClick(lnk_orange_color);
                break;
            default:
                Assert.fail("Field not configured.");
        }
    }

    @Override
    public void clickButton(String button){
        button = button.toLowerCase();
        switch (button){
            case "add to cart":
                WaitClass.waitAndClick(btn_add_to_cart);
                break;
            case "proceed to checkout":
                WaitClass.waitAndClick(btn_checkout);
                break;
            default:
                Assert.fail("No button name found");
        }
    }
}
