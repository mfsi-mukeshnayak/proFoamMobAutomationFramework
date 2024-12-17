package com.listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.reports.ExtentReport;
import com.utills.BaseClass;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class TestListener implements ITestListener {
	
	BaseClass base = new BaseClass();

    @Override
    public void onTestStart(ITestResult result) {
        String category = result.getMethod().getGroups().length > 0
                ? result.getMethod().getGroups()[0] // Use TestNG groups for categorization
                : "Uncategorized";

        String className = result.getTestClass().getRealClass().getSimpleName();

        // Start the test with dynamic categorization
        ExtentReport.startTest(result.getName(), result.getMethod().getDescription(), category)
                .assignCategory(className)  // Assign test class name as category
                .assignAuthor("MukesKumarNayak");

        // Start screen recording
        base.startScreenRecording();
        ExtentReport.getTest().log(Status.INFO, "Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	base.stopScreenRecording(result.getName());
        ExtentReport.getTest().log(Status.PASS, "Test passed: " + result.getName());

    }

    @Override
    public void onTestFailure(ITestResult result) {
    	base.stopScreenRecording(result.getName());
        if (result.getThrowable() != null) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            result.getThrowable().printStackTrace(pw);
            System.out.println(sw.toString());
        }

        BaseClass base = new BaseClass();
        File file = base.getDriver().getScreenshotAs(OutputType.FILE);

        byte[] encoded = null;
        try {
            encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try {
            Properties props = new Properties();
            String propFileName = "config.properties";

            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            props.load(inputStream);

            String imagePath = "Screenshots" + File.separator + props.getProperty("platformName")
                    + "_" + props.getProperty("deviceName") + File.separator + base.getdateTime() + File.separator
                    + result.getTestClass().getRealClass().getSimpleName() + File.separator + result.getName() + ".png";

            String completeImagePath = System.getProperty("user.dir") + File.separator + imagePath;

            FileUtils.copyFile(file, new File(imagePath));

            Reporter.log("Failure ScreenShot : " + result.getName());
            Reporter.log("<a href='" + completeImagePath + "'> <img src='" + completeImagePath + "' height='400' width='400'/> </a>");

            ExtentReport.getTest().fail("Test Failed",
                    MediaEntityBuilder.createScreenCaptureFromPath(completeImagePath).build());
            ExtentReport.getTest().fail("Test Failed",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(new String(encoded, StandardCharsets.US_ASCII)).build());
            ExtentReport.getTest().fail(result.getThrowable());
            

            
        } catch (Exception e) {
            e.printStackTrace();
        }
        

    }

    @Override
    public void onTestSkipped(ITestResult result) {
    	base.stopScreenRecording(result.getName());
        ExtentReport.getTest().log(Status.SKIP, "Test skipped: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Starting execution: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReport.getReporter().flush();
    }
}
