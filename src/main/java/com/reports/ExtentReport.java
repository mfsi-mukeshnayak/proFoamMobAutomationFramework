package com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.HashMap;
import java.util.Map;

public class ExtentReport {
    private static ExtentReports extent;
    private static final String REPORT_FILE_PATH = "Reports//Extent.html";
    private static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(REPORT_FILE_PATH);
            sparkReporter.config().setDocumentTitle("Profoam Automation Report");
            sparkReporter.config().setReportName("Profoam Mobile Application");
            sparkReporter.config().setTheme(Theme.DARK);

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Platform", System.getProperty("os.name"));
            extent.setSystemInfo("User", System.getProperty("user.name"));
        }
        return extent;
    }

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

    public static synchronized ExtentTest startTest(String testName, String description, String category) {
        ExtentTest test = getReporter().createTest(testName, description).assignCategory(category);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }

    public static synchronized void endTest() {
        getReporter().flush();
    }
}
