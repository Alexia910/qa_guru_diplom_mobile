package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:local.properties"})
public interface LocalConfig extends Config {

    @Key("deviceName")
    String deviceName();

    @Key("platformName")
    String platformName();

    @Key("platformVersion")
    String platformVersion();

    @Key("url")
    String url();

    @Key("appFileName")
    String appFileName();

    @Key("appUrl")
    String appURL();

}
