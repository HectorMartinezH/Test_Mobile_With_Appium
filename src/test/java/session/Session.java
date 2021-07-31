package session;

import factoryDevices.FactoryDevice;
import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;

public class Session {
    //Tener un atributo del mismo tipo
    private static Session instance = null;
    private AppiumDriver driver;

    //Tener un constructor privado
    private Session() throws MalformedURLException {
        driver = FactoryDevice.make(FactoryDevice.DeviceType.ANDROID).create();
    }

    //Tener un metodo statico publio que retorne la instancia unica
    public static Session getInstance() throws MalformedURLException {
        if (instance == null) {
            instance = new Session();
            return instance;
        }
        return instance;
    }

    public void closeSession() {
        driver.quit();
        instance = null;
    }

    public AppiumDriver getDriver() {
        return driver;
    }
}
