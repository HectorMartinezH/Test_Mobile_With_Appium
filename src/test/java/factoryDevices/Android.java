package factoryDevices;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Android implements IDevice {

    @Override
    public AppiumDriver create() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // para el emulador
        capabilities.setCapability("devicename", "Pixel XL API 30");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("appPackage", "com.vrproductiveapps.whendo");
        capabilities.setCapability("appActivity", ".ui.HomeActivity");
        capabilities.setCapability( "platformName", "Android");

        //Para celular
//        capabilities.setCapability("devicename", "Hmemphis");
//        capabilities.setCapability("platformVersion", "10");
//        capabilities.setCapability("appPackage", "com.huawei.calculator");
//        capabilities.setCapability("appActivity", ".Calculator");
//        capabilities.setCapability( "platformName", "Android");

        AppiumDriver driver = null;
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        return driver;
    }
}
