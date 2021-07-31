package activities.whenDo;

import controlAppium.Button;
import controlAppium.ElementFromList;
import controlAppium.Label;
import org.openqa.selenium.By;

public class MainScreen {
    public Button addTaskButton = new Button(By.id("com.vrproductiveapps.whendo:id/fab"));
    public Label nameTaskLabel = new Label(By.id("com.vrproductiveapps.whendo:id/home_list_item_text"));
    public ElementFromList elementFromList;

    public MainScreen(){}

    public ElementFromList selectElementFromList(String element) {
        return this.elementFromList = ElementFromList.getElementFromList(element);
    }

}
