package com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;



public class ExtentReport {
    private static ExtentReports extent;
    private static final String REPORT_FILE_PATH = "Reports/Extent.html";
    private static final String LOGO_PATH = System.getProperty("user.dir") + "/resources/mindfire-solutions-logo-5356AF9071-seeklogo.com.png";
    private static final Map<String, ExtentTest> classTestMap = new HashMap<>();
    private static final ThreadLocal<ExtentTest> testMap = new ThreadLocal<>();

    public static synchronized ExtentReports getReporter() {
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(REPORT_FILE_PATH);
            sparkReporter.config().setDocumentTitle("Profoam Automation Report");
            sparkReporter.config().setReportName("Profoam Mob App Automation Report");
            sparkReporter.config().setTheme(Theme.DARK);
            
//            String reportNameWithLogo = 
//                "<div style='text-align:center;'>" +
//                "    <img src='" + LOGO_PATH + "' alt='Company Logo' style='height:20px;'>" +
//                "    <br>Profoam Mob App Automation Report" +
//                "</div>";
//            
//
//            sparkReporter.config().setReportName(reportNameWithLogo);
            
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Platform", System.getProperty("os.name"));
            extent.setSystemInfo("User", System.getProperty("user.name"));
        }
        return extent;
    }

    public static synchronized ExtentTest getClassTest(String className) {
        return classTestMap.get(className);
    }

    public static synchronized ExtentTest getTest() {
        return testMap.get();
    }

    public static synchronized ExtentTest startClassTest(String className) {
        ExtentTest classTest = getReporter().createTest(className);
        classTestMap.put(className, classTest);
        return classTest;
    }

    public static synchronized ExtentTest startTest(String className, String testName, String description) {
        ExtentTest classTest = getClassTest(className);
        if (classTest == null) {
            classTest = startClassTest(className);
        }
        ExtentTest test = classTest.createNode(testName, description);
        testMap.set(test); // Store test in ThreadLocal
        return test;
    }

    public static synchronized void endTest() {
        getReporter().flush();
        
    }
 }
