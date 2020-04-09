package automationPractice.pages;

import automationPractice.step_definitions.AutomationHooks;
import automationPractice.utilities.Driver;
import automationPractice.utilities.commonMethods;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class BasePage implements commonMethods {

    protected WebDriver driver = Driver.get();
    public static Random random = new Random();
    public static String firstName = "First";
    public static String lastName = "Last";
    public static String email = firstName+lastName+ random.nextInt(10000) + "@gmail.com";

    public static Logger log = Logger.getLogger(AutomationHooks.class.getName());

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }
}
