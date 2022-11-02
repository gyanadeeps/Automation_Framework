package com.project.Base;



import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.project.Reporting.ExtentManager;
import com.project.Reporting.ExtentTestManager;
import com.project.Utilities.AllureListener;
import com.project.Utilities.TestListener;
import com.project.engine.DriverConfigurator;
import com.project.engine.DriverUtils;
import com.project.engine.webdriver.RemoteDriverImplementation;

import lombok.extern.java.Log;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;


import java.io.*;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static com.project.data.SystemProperties.URL;
import static com.project.data.SystemProperties.DRIVER_TYPE;

import static java.lang.System.getProperties;

@Log
@Listeners({TestListener.class, AllureListener.class})
public class BaseWebTest {
    private final static ConcurrentMap<String, Object> ENV_PROPERTIES = new ConcurrentHashMap<>();
    DesiredCapabilities cap=new DesiredCapabilities();
    RemoteDriverImplementation a=new RemoteDriverImplementation();
    public static final String configFile="src/test/resources/config.properties";
    File file = new File(configFile);


    @Parameters("device")
    @BeforeTest
    protected void beforeSuite(ITestContext context,String device)
    {
       new ExtentManager().createInstance();
       // DriverBinaryManager.setupWebDriverBinary();
        if(device.equalsIgnoreCase("ios")) {

            try
            {
                InputStream in = new FileInputStream(file);
                Properties prop = new Properties();
                prop.load(in);
                prop.setProperty("mobile_version","iOS(14.0)");
                OutputStream out = new FileOutputStream(file);
                prop.store(out, "Device_Version");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            WebDriverRunner.setWebDriver(a.instantiateDriver(cap));
            System.out.println("URL Name --> "+ URL);

        }
        else if(device.equalsIgnoreCase("android"))
        {

            try
            {
                InputStream in = new FileInputStream(file);
                Properties prop = new Properties();
                prop.load(in);
                prop.setProperty("mobile_version","android(9.0)");
                OutputStream out = new FileOutputStream(file);
                prop.store(out, "Device_Version");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            WebDriverRunner.setWebDriver(a.instantiateAndroidDriver(cap));
            System.out.println("URL Name --> "+ URL);

        }


        //System.out.println("Suite Name --> "+ SUITENAME);



    }


    @BeforeMethod(description = "Initialize web driver configuration")
    protected void beforeMethod(Method method) {
        //System.out.println("Driver Type --> "+ DRIVER_TYPE);
            DriverConfigurator.configure(DRIVER_TYPE);


    }

    @AfterMethod(alwaysRun = true, description = "Close driver")
    protected void tearDown(Method method, ITestResult testResult, ITestContext testContext)
    {
        String className = method.getDeclaringClass().getName();

        String[] s = className.split("[.]", 0);
        if(testResult.getStatus()==3) {
            ExtentTestManager.getTest().getExtent().removeTest(ExtentTestManager.getTest());
            testContext.getFailedTests().removeResult(testResult);


        }
        else {
            ExtentTestManager.endTest(ExtentTestManager.getTest());
            String status;
            if(testResult.getStatus() == ITestResult.SUCCESS)
                status = "PASSED";
            else if(testResult.getStatus() == ITestResult.SKIP)
                status = "error";
            else
                status = "FAILED";

            Selenide.executeJavaScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+status+"\"}}");
            Selenide.executeJavaScript("browserstack_executor: {\"action\": \"setSessionName\", \"arguments\": {\"name\":\""+s[4]+"\" }}");

        }
        if (ENV_PROPERTIES.isEmpty()) {
            ENV_PROPERTIES.put("java_version", getProperties().getProperty("java.vm.version"));
            ENV_PROPERTIES.put("os_name", getProperties().getProperty("os.name"));
            ENV_PROPERTIES.put("github_user_email", getProperties().getProperty("github_user_email", "Github User Email not found"));
            ENV_PROPERTIES.put("github_user_name", getProperties().getProperty("github_user_name", "Github User Name not found"));
            ENV_PROPERTIES.put("URL", URL);
            ENV_PROPERTIES.putAll(((RemoteWebDriver) WebDriverRunner.getWebDriver()).getCapabilities().asMap());
        }
        SessionId sessionid = ((RemoteWebDriver) WebDriverRunner.getWebDriver()).getSessionId();
        log.info("Session is -> " + sessionid);
        System.out.println(LocalDateTime.now());
        DriverUtils.stop();
        WebDriverRunner.closeWebDriver();


    }

//    @AfterClass
//    public void mobileTearDown() throws IOException
//    {
//        driver.quit();
//
//    }
    @AfterTest(alwaysRun = true)
    protected void afterSuite() {

        try {



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
