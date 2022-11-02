package com.project.engine.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;


public class RemoteDriverImplementation implements RemoteDriver
{

    @Override
    public WebDriver instantiateDriver(DesiredCapabilities caps)
    {
        return RemoteDriver.super.instantiateDriver(caps);
    }

    @Override
    public WebDriver instantiateAndroidDriver(DesiredCapabilities caps)
    {
        return RemoteDriver.super.instantiateAndroidDriver(caps);
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        return null;
    }
}
