package com.project.data;

import com.project.Utilities.GetRandomDataGenerator;

import static java.lang.System.getProperty;

public interface SystemProperties {
    String USERDIR = System.getProperty("user.dir");
    String FILE_SEPERATOR = System.getProperty("file.separator");
   public static final String AUTOMATE_USERNAME = "gsahoo_H9WwOn";
 public static final String AUTOMATE_ACCESS_KEY = "kxcLz1kAScjLqRpxyPro";
   // public static final String AUTOMATE_USERNAME = "gyanadeepsahoo2";
   /// public static final String AUTOMATE_ACCESS_KEY = "yrg5n87bJ8XT3YzX5wST";


    String RESOURCES_FOLDER_PATH = USERDIR + FILE_SEPERATOR + "src"
            + FILE_SEPERATOR + "main" + FILE_SEPERATOR + "resources" + FILE_SEPERATOR +"sportsCategory"+FILE_SEPERATOR;

    String BUILD_NUMBER = System.getenv("BUILD_NUMBER");
    String BUILD_ID = System.getenv("BUILD_ID");
    String BUILD_URL = System.getenv("BUILD_URL");
    String ARTIFACTFOLDER = USERDIR + FILE_SEPERATOR + "Mobile_Module"+"Artifacts" + FILE_SEPERATOR ;
    String FAILEDSCREENSHOTFOLDER = ARTIFACTFOLDER + "failedScreenshots" + FILE_SEPERATOR;

    String CSV_FOLDER_PATH = System.getProperty("folder.path","");
    String SUITENAME = System.getProperty("SUITE", "MobileUI");
    String DRIVER_TYPE = System.getProperty("DRIVER", "CHROME");
    String MOBILE_BROWSER = System.getProperty("MOBILE",GetRandomDataGenerator.getMobile_Version());

    String USERNAME = System.getProperty("Username","");
    String PASSWORD = System.getProperty("Password","");
    String SUPERADMIN = System.getProperty("Username","");
    String ADMIN_PASSWORD = System.getProperty("Password","");
    String REMOTE_DRIVER_STATUS = System.getProperty("remote.driver.status", "ENABLED");
    String REMOTE_URL = System.getProperty("remote.url", "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub");
   // String AUTHENTICATION_REQUIRED=System.getProperty("Authentication_Required", "Yes");
    String URL = System.getProperty("URL", "");
    String APPLICATION_BUILD_VERSION=System.getProperty("APPLICATION_BUILD_VERSION", GetRandomDataGenerator.getBuildNumber());

    boolean SCREENSHOT_ON_EVERY_STEP = Boolean.parseBoolean(getProperty("screenshot_on_every_step"));
    int RETRY_COUNT = 2;


}