package factoryDevices;

import static factoryDevices.FactoryDevice.DeviceType.ANDROID;

public class FactoryDevice {

    public enum DeviceType {
        ANDROID,IOS,WINDOWS_PHONE
    }

    public static IDevice make(DeviceType deviceType) {
        IDevice device;
        switch (deviceType) {
            case ANDROID:
                return device = new Android();
            case IOS:
                return device = new IOS();
            case WINDOWS_PHONE:
                return device = new WindowsPhone();
            default:
                return device = new Android();
        }
    }
}
