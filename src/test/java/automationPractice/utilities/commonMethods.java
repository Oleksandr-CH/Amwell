package automationPractice.utilities;

import java.util.Map;

public interface commonMethods {

    public default void clickButton(String button){}

    public default void enterValue (String field, String value){}

    public default void validate (String field, String expected){}

    public default void select (String field, String value){}

    public default void enterFields (Map<String, String> data){}

}
