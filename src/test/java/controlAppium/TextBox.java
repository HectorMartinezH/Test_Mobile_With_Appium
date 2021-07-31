package controlAppium;

import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class TextBox extends Control{

    public TextBox(By locator) {
        super(locator);
    }

    public void setValue(String texValue) throws MalformedURLException {
        this.findControl();
        this.control.sendKeys(texValue);
    }
}
