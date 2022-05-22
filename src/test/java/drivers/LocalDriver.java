package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.Validation;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class LocalDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        File app = getApp();

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName(Validation.configEmulator.platformName());
        options.setDeviceName(Validation.configEmulator.deviceName());
        options.setPlatformVersion(Validation.configEmulator.platformVersion());
        options.setApp(app.getAbsolutePath());
        options.setLocale("en");
        options.setLanguage("en");
        options.setAppPackage("org.gnucash.android");
        options.setAppActivity(".ui.account.AccountsActivity");

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    public static URL getAppiumServerUrl() {
        try {
            return new URL(Validation.configEmulator.url());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private File getApp() {
        String appPath = "src/test/resources/apk/" + Validation.configEmulator.appFileName();
        String appUrl = Validation.configEmulator.appURL();

        File app = new File(appPath);
        if (!app.exists()) {
            try (InputStream in = new URL(appUrl).openStream()) {
                copyInputStreamToFile(in, app);
            }
            catch (IOException e) {
                throw new AssertionError("Failed to download apk", e);
            }
        }
        return app;
    }
}