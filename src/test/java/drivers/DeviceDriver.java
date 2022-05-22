package drivers;

public class DeviceDriver {
    public static String getDeviceDriver(String deviceHost) {

        switch (deviceHost) {
            case "browserstack":
                return BrowserStackDriver.class.getName();
            case "local":
                return LocalDriver.class.getName();
            default:
                throw new RuntimeException("Select device: browserstack / local");
        }
    }
}