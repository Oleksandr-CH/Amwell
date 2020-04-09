package automationPractice.utilities;

import automationPractice.pages.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitClass extends BasePage {

    public static WebDriverWait webDriverWait = new WebDriverWait((new WaitClass()).driver, 10);


    /**
     * @param element - Webelement to take an actions with
     * @Purpose: This method is responsible for clicking
     * @Return: void
     */
    public static void waitAndClick(WebElement element) {
        boolean notFound = true;
        int tTime =8;
        int wTime =7;

        for (int i = 0; i < tTime && notFound; i++) {
            try {
                webDriverWait.until(ExpectedConditions.visibilityOf(element));
                element.click();
                notFound = false;
            } catch (NoSuchElementException e) {
                if (i == wTime) {
                    throw e;
                }
                System.out.println("Caught and trying to recover from NoSuchElement exception");
                Utilities.waitTime(1);
            }  catch (StaleElementReferenceException e) {
                if (i == wTime) {
                    throw e;
                }
                System.out.println("Caught and trying to recover from StaleElement exception");
                Utilities.waitTime(1);
            } catch (InvalidElementStateException e) {
                if (i == wTime) {
                    throw e;
                }
                System.out.println("Caught and trying to recover from InvalidElementState exception");
                Utilities.waitTime(1);
            } catch (TimeoutException e) {
                if (i == wTime) {
                    throw e;
                }
                System.out.println("Caught and trying to recover from TimeoutException exception");
                Utilities.waitTime(1);
            } catch (WebDriverException e) {
                if (i == wTime) {
                    throw e;
                }
                System.out.println("Caught and trying to recover from WebDriverException exception");
                Utilities.waitTime(1);
            }
        }
    }







    public static void waitAndSendKeys(WebElement element, String keys) {
        boolean notFound = true;
        boolean wrongAttribute = true;
        for (int i = 0; i < 5 && notFound; i++) {
            try {
                do {
                    webDriverWait.until(ExpectedConditions.visibilityOf(element));
                    element.clear();
                    element.sendKeys(keys);
                    String attribute = element.getAttribute("value");
                    //Checking if the value in the box is the same as we entered
                    if (attribute.equalsIgnoreCase(keys)) {
                        wrongAttribute = false;
                    }
                } while (wrongAttribute);
                notFound = false;
            } catch (NoSuchElementException e) {
                if (i == 4) {
                    throw e;
                }
                System.out.println("Caught and trying to recover from NoSuchElement exception");
                Utilities.waitTime(1);
            }  catch (StaleElementReferenceException e) {
                if (i == 4) {
                    throw e;
                }
                System.out.println("Caught and trying to recover from StaleElement exception");
                Utilities.waitTime(1);
            } catch (InvalidElementStateException e) {
                if (i == 4) {
                    throw e;
                }
                System.out.println("Caught and trying to recover from InvalidElementState exception");
                Utilities.waitTime(1);
            } catch (TimeoutException e) {
                if (i == 4) {
                    throw e;
                }
                System.out.println("Caught and trying to recover from TimeoutException exception");
                Utilities.waitTime(1);
            } catch (WebDriverException e) {
                if (i == 4) {
                    throw e;
                }
                System.out.println("Caught and trying to recover from WebDriverException exception");
                Utilities.waitTime(1);
            }
        }
    }




    /**
     * @param element - Webelement to take an actions with
     * @Purpose: This method is responsible for getting the text from the element
     * @Return: String text
     */
    public static String waitAndGetText(WebElement element) {
        boolean notFound = true;
        String text = "";
        for (int i = 0; i < 15 && notFound; i++) {
            try {
                webDriverWait.until(ExpectedConditions.visibilityOf(element));
                text = element.getText();
                //We are checking if the text we got from the element is not empty
                if (!text.equalsIgnoreCase("")) {
                    notFound = false;
                }
            } catch (NoSuchElementException e) {
                if (i == 4) {
                    throw e;
                }
                System.out.println("Caught and trying to recover from NoSuchElement exception");
                Utilities.waitTime(1);
            } catch (StaleElementReferenceException e) {
                if (i == 4) {
                    throw e;
                }
                System.out.println("Caught and trying to recover from StaleElement exception");
                Utilities.waitTime(1);
            } catch (InvalidElementStateException e) {
                if (i == 4) {
                    throw e;
                }
                System.out.println("Caught and trying to recover from InvalidElementState exception");
                Utilities.waitTime(1);
            } catch (TimeoutException e) {
                if (i == 4) {
                    throw e;
                }
                System.out.println("Caught and trying to recover from TimeoutException exception");
                Utilities.waitTime(1);
            } catch (WebDriverException e) {
                if (i == 4) {
                    throw e;
                }
                System.out.println("Caught and trying to recover from WebDriverException exception");
                Utilities.waitTime(1);
            }
        }
        return text;
    }
    /**
     * @param element - Webelement to take an actions with
     * @param value   - text value of the dropdown option to be selected
     * @Purpose: This method is responsible for selecting the dropdown option by text
     * @Return void
     */
    public static void selectByTextFromDropDown(WebElement element, String value) {
        boolean notFound = true;
        int count = 0;
        boolean wrongAttribute = true;
        for (int i = 0; i < 4 && notFound; i++) {
            try {
                do {
                    Select select = new Select(element);
                    select.selectByVisibleText(value);
                    count++;
                    //Verifying that selected option is what we have chosen
                    if (select.getFirstSelectedOption().getText().equalsIgnoreCase(value)) {
                        wrongAttribute = false;

                    } else {
                        Utilities.waitTime(2);
                    }
                } while (wrongAttribute && count <5);
                notFound = false;
            } catch (NoSuchElementException e) {
                if (i == 3) {
                    throw e;
                }
                System.out.println("Caught and trying to recover from NoSuchElement exception");
                Utilities.waitTime(1);
            } catch (StaleElementReferenceException e) {
                if (i == 3) {
                    throw e;
                }
                System.out.println("Caught and trying to recover from StaleElement exception");
                Utilities.waitTime(1);
            } catch (InvalidElementStateException e) {
                if (i == 3) {
                    throw e;
                }
                System.out.println("Caught and trying to recover from InvalidElementState exception");
                Utilities.waitTime(1);
            } catch (TimeoutException e) {
                if (i == 3) {
                    throw e;
                }
                System.out.println("Caught and trying to recover from TimeoutException exception");
                Utilities.waitTime(1);
            } catch (WebDriverException e) {
                if (i == 3) {
                    throw e;
                }
                System.out.println("Caught and trying to recover from WebDriverException exception");
                Utilities.waitTime(1);
            }
        }
    }

}