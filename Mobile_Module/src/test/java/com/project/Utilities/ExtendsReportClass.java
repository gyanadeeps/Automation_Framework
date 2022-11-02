//package com.project.Utilities;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.project.Base.BaseClass;
//
//public class ExtendsReportClass extends BaseClass {
//
//    static ExtentReports exReports;
//
//    public static ExtentReports extendReportGenerator()
//    {
//        String reportPath = System.getProperty("user.dir")+"Mobile_Module\\Reports\\TestReport.html";
//        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
//
//        reporter.config().setReportName("Environment : Development Server");
//        reporter.config().setDocumentTitle("Development Server-Loop Test Results");
//        reporter.config().setTheme(Theme.STANDARD);
//
//        exReports = new ExtentReports();
//        exReports.attachReporter(reporter);
//        exReports.setSystemInfo("Environment", "Development Server");
//        exReports.setSystemInfo("Test By", "Automation Team");
//        return exReports;
//    }
//}
