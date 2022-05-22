package config;

import org.aeonbits.owner.ConfigFactory;

public class Validation {

    public static BrowserStackConfig configStack = ConfigFactory.create(BrowserStackConfig.class, System.getProperties());
    public static LocalConfig configEmulator = ConfigFactory.create(LocalConfig.class, System.getProperties());
}

