package controlAppium;

import org.openqa.selenium.By;

public class ElementFromList extends Control{
    private static String selectTask = "//android.widget.TextView[@text = '%s']//parent::android.widget.LinearLayout";

    private ElementFromList(By locator) {
        super(locator);
    }

    public static ElementFromList getElementFromList(String element) {
        By elementFormList = By.xpath(String.format(selectTask,element));
        return new ElementFromList(elementFormList);
    }
}
