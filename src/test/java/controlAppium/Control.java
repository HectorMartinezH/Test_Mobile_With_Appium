package controlAppium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import session.Session;

import java.net.MalformedURLException;

public class Control {
    protected WebElement control;
    protected By locator;

    public Control(By locator) {
        this.locator = locator;
    }


    protected void findControlWithWait() throws MalformedURLException {
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getDriver(),30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.locator));

        this.control = Session.getInstance().getDriver().findElement(this.locator);

    }

    protected void findControl() throws MalformedURLException {
        this.control = Session.getInstance().getDriver().findElement(this.locator);
    }

    public void click() throws MalformedURLException {
        this.findControlWithWait();
        this.control.click();
    }

    public String text() throws MalformedURLException {
        this.findControl();
        return this.control.getText();
    }

    public boolean isVisible() throws MalformedURLException {
        try {
            this.findControl();
            return this.control.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
