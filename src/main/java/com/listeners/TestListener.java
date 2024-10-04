package com.listeners;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.reports.ExtentReport;
import com.utills.BaseClass;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class TestListener implements ITestListener  {
//	public static String imagePath;
	public static String completeImagePath;


	public void onTestFailure(ITestResult result) {
		
		if(result.getThrowable() != null) {
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
			// TODO Auto-generated catch block
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
			
			Reporter.log("Failure ScreenShot : "+result.getName());
			Reporter.log("<a href='"+ completeImagePath + "'> <img src='"+ completeImagePath + "' height='400' width='400'/> </a>");
			
			
			ExtentReport.getTest().fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(completeImagePath).build());
			ExtentReport.getTest().fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromBase64String(new String(encoded, StandardCharsets.US_ASCII)).build());
			ExtentReport.getTest().fail(result.getThrowable());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		//ExtentReport.getTest().log(Status.FAIL, "Test Failed");
		

				
	}
	
//	@Override
//	public void onTestStart(ITestResult result) {
//		try {
//		Properties props = new Properties();
//		String propFileName = "config.properties";
//
//		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
//		props.load(inputStream);
//	//	BaseTest base = new BaseTest();
//		ExtentReport.startTest(result.getName(), result.getMethod().getDescription())
//		.assignCategory(props.getProperty("platformName")  + "_" + props.getProperty("deviceName"))
//		.assignAuthor("MukeshKumarNayak");		
//		}catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//			
//	}
	

	@Override
	public void onTestStart(ITestResult result) {
		
		ExtentReport.startTest(result.getName(), result.getMethod().getDescription())
		.assignCategory("Android" + "_" + "MFSEmulator")
		.assignAuthor("MukesKumarNayak");		
	}


	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentReport.getTest().log(Status.PASS, "Test Passed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentReport.getTest().log(Status.SKIP, "Test Skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentReport.getReporter().flush();		
	}

}
