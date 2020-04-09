package automationPractice.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//ul[@class='product_list grid row']/li/div/div/h5/a")
    public List <WebElement> relultList;

    @Override
    public  void validate (String field, String expected){
        field = field.toLowerCase();
        switch (field){
            case "search results":
                for (WebElement each :
                        relultList) {
                    Assert.assertTrue(each.getText().toLowerCase().contains(expected.toLowerCase()));
                }
                break;
            default:
                Assert.fail("Field not configured.");
        }
    }


    @Override
    public  void select (String field, String value){
        field = field.toLowerCase();
        switch (field){
            case "item":
                driver.findElement(By.xpath("//ul[@class='product_list grid row']/li/div/div/h5/a[contains(text(),'"+value+"')]")).click();
                break;
            default:
                Assert.fail("Field not configured.");
        }
    }

}
