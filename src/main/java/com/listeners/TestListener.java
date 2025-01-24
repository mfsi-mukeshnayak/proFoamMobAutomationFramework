package com.listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.reports.ExtentReport;
import com.utills.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import org.apache.commons.codec.binary.Base64;
import java.io.InputStream;


public class TestListener implements ITestListener {

    BaseClass base = new BaseClass();
    
    @Override
    public void onTestStart(ITestResult result) {
        String className = result.getTestClass().getRealClass().getSimpleName();
        String testName = result.getName();
        String description = result.getMethod().getDescription();
        String[] groups = result.getMethod().getGroups();

        // Start the ExtentTest instance
        ExtentTest extentTest = ExtentReport.startTest(className, testName, description)
                                            .assignAuthor(base.getPropertyValue("Author_Name"));

        for (String group : groups) {
            extentTest.assignCategory(group);
        }

        ExtentReport.getTest().log(Status.INFO, "Logged in Successfully and Test started: " + testName);
    //    ExtentReport.getTest().log(Status.INFO, "Group(s): " + (groups.length > 0 ? String.join(", ", groups) : "Uncategorized"));

        base.startScreenRecording();
    }



    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReport.getTest().log(Status.PASS, "Test passed: " + result.getName());
 //       base.stopScreenRecording(result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {


    	String videoPath= base.stopScreenRecording(result.getName());
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

//            ExtentReport.getTest().fail("Test Failed",
//                    MediaEntityBuilder.createScreenCaptureFromPath(completeImagePath).build());
            ExtentReport.getTest().fail("Test Failed",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(new String(encoded, StandardCharsets.US_ASCII)).build());
            ExtentReport.getTest().fail(result.getThrowable());
            
            // Attach video to Extent Report if available
            if (videoPath != null) {
               // String relativeVideoPath = videoPath.replace(System.getProperty("user.dir"), ".");
                String videoHtml = "<video width='400' controls>" +
                        "<source src='" + videoPath + "' type='video/mp4'>" +
                        "Your browser does not support the video tag." +
                        "</video>";
                ExtentReport.getTest().fail("Test Failed. See the recorded video below:").fail(videoHtml);
            
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReport.getTest().log(Status.SKIP, "Test skipped: " + result.getName());
        base.stopScreenRecording(result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReport.getReporter().flush();
    }
}
