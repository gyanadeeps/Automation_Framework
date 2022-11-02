package com.project.engine.webdriver;

import com.codeborne.selenide.WebDriverProvider;
import com.project.engine.DriverDownloadDirManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChromeDriverProvider implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        HashMap<String, Object> chromePrefs = new HashMap<>();
        HashMap<String, Object> deviceMetrics = new HashMap<>();
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
//        chromePrefs.put("download.default_directory", DriverDownloadDirManager.clearSetGet());
        ChromeOptions options = new ChromeOptions();
        desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        desiredCapabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
        options.merge(desiredCapabilities);
        List<String> experimentalFlags = new ArrayList<String>();
        experimentalFlags.add("same-site-by-default-cookies@2");
        experimentalFlags.add("cookies-without-same-site-must-be-secure@2");
        chromePrefs.put("browser.enabled_labs_experiments", experimentalFlags);
        options.addArguments("disable-infobars");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        //System.err.println("Chrome driver Provider Local");
        options.addArguments("--window-size=1920,1080");
      //options.addArguments("--headless");
        options.setExperimentalOption("prefs", chromePrefs);
        options.setExperimentalOption("useAutomationExtension", false);
       // options.setExperimentalOption("mobileEmulation", mobileEmulation);
        return new ChromeDriver(options);
    }
}
