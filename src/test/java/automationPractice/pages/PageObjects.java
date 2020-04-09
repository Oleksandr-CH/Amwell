package automationPractice.pages;

import org.junit.Assert;

public class PageObjects {

    private PageObjects(){}

    public static BasePage getPageObject(String page){
        page = page.toLowerCase();
        switch (page){
            case "login":
                return new LoginPage();
            case "account":
                return new AccountPage();
            case "search":
                return new SearchPage();
            case "item description":
                return new ItemDescriptionPage();
            case "cart":
                return new CartPage();
            default:
                Assert.fail("Error: Invalid Page name: " + page);
        }

        return new BasePage();
    }

}
