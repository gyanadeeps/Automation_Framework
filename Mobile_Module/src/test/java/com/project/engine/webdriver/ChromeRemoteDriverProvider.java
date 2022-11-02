package com.project.engine.webdriver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChromeRemoteDriverProvider implements RemoteDriver {

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(ChromeOptions.CAPABILITY, getChromeOptions());

        capabilities.setCapability("name", "Remote File Upload using Selenium 2's FileDetectors");
        WebDriver web=instantiateDriver(capabilities);
        String ss=web.manage().getCookies().toString();

        return web;
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
       // Cookie cookie1 = new Cookie.Builder("key", "value").sameSite("Lax").build();
        HashMap<String, Object> chromeLocalStatePrefs = new HashMap<String, Object>();
//        HashMap<String, Object> deviceMetrics = new HashMap<>();
//
//        deviceMetrics.put("width", 360);
//
//        deviceMetrics.put("height", 640);
//
//        deviceMetrics.put("pixelRatio", 3.0);
//
//        HashMap<String, Object> mobileEmulation = new HashMap<>();
//
//        mobileEmulation.put("deviceMetrics", deviceMetrics);
//
//        mobileEmulation.put("userAgent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.82 Safari/537.36");
       List<String> experimentalFlags = new ArrayList<String>();
        experimentalFlags.add("same-site-by-default-cookies@2");
        experimentalFlags.add("cookies-without-same-site-must-be-secure@2");
        chromeLocalStatePrefs.put("browser.enabled_labs_experiments", experimentalFlags);
        options.setExperimentalOption("localState", chromeLocalStatePrefs);
        options.addArguments("disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        System.err.println("Chrome driver Provider Remote");
        options.addArguments("--window-size=1920,1080");//1920,1080
      //  options.addArguments("--headless");
        options.addArguments("--incognito");
     //   options.setExperimentalOption("mobileEmulation", mobileEmulation);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.setAcceptInsecureCerts(true);
        return options;
    }
}
