package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:browserstack.properties"})
public interface BrowserStackConfig extends Config {

    @Key("username")
    String username();

    @Key("password")
    String password();

    @Key("identificateapp")
    String identificateapp();

    @Key("url")
    String url();


}
