package com.project.engine.webdriver;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.project.data.SystemProperties.REMOTE_URL;

interface RemoteDriver extends WebDriverProvider {

    default WebDriver instantiateDriver(DesiredCapabilities caps) {
       // caps.setCapability("browserName", "Chrome");
        caps.setCapability("device", "iPhone 11");
        caps.setCapability("realMobile", "true");
        caps.setCapability("os_version", "14.0");
        caps.setCapability("name", "EcloudMs"); // test name
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability(" browserstack.video", "false");

        //Cookie cookie1 = new Cookie.Builder("key", "value").sameSite("Lax").build();
        if (REMOTE_URL == null) {
            throw new IllegalArgumentException("Remote URL can not be null");
        }
        try {
            RemoteWebDriver remoteWebDriver = new RemoteWebDriver(new URL(REMOTE_URL), caps);
            remoteWebDriver.setFileDetector(new LocalFileDetector());
            return remoteWebDriver;

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


    default WebDriver instantiateAndroidDriver(DesiredCapabilities caps) {
        caps.setCapability("browser", "chrome");
        caps.setCapability("device", "Samsung Galaxy S10");
        caps.setCapability("realMobile", "true");
        caps.setCapability("os_version", "9.0");
        caps.setCapability("name", "EcloudMs"); // test name
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability(" browserstack.video", "false");

        //Cookie cookie1 = new Cookie.Builder("key", "value").sameSite("Lax").build();
        if (REMOTE_URL == null) {
            throw new IllegalArgumentException("Remote URL can not be null");
        }
        try {
            RemoteWebDriver remoteWebDriver = new RemoteWebDriver(new URL(REMOTE_URL), caps);
            remoteWebDriver.setFileDetector(new LocalFileDetector());
            return remoteWebDriver;

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


}

