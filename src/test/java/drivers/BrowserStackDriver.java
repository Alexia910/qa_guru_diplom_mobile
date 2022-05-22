package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.Validation;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities caps) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(caps);

        mutableCapabilities.setCapability("browserstack.user", Validation.configStack.username());
        mutableCapabilities.setCapability("browserstack.key", Validation.configStack.password());

        // Set URL of the application under test
        mutableCapabilities.setCapability("app", Validation.configStack.identificateapp());

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", "Google Pixel 3");
        mutableCapabilities.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", "First Java Project");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "first_test");

        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(Validation.configStack.url());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
