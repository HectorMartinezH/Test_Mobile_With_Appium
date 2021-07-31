package basicTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class BasicAppium {

    private AppiumDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // para el emulador
        capabilities.setCapability("devicename", "Android SDK built for x86_64");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("appPackage", "com.vrproductiveapps.whendo");
        capabilities.setCapability("appActivity", ".ui.HomeActivity");
        capabilities.setCapability( "platformName", "Android");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @After
    public void cleanUp() throws InterruptedException {
        Thread.sleep(15);
        driver.quit();
    }

    @Test
    public void verificar_adicionar_tarea() {
        // Click +
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
        // Set Title
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys("REMOVE");
        // Set Notas
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys("esta es una descripcion");
        // Click Save
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/saveItem")).click();
        // Verificacion
        String expectedResult="REMOVE";
        String actualResult=driver.findElement(By.id("com.vrproductiveapps.whendo:id/home_list_item_text")).getText();
        Assert.assertEquals("ERROR tarea no fue creado!",expectedResult,actualResult);
    }

}
