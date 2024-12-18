package com.utills;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;

//import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
//import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
//import org.testng.log4testng.Logger;

//import com.actions.ChromeDriver;
import com.aventstack.extentreports.Status;
import com.logger.Log;
import com.pageObjects.LoginPage;
import com.reports.ExtentReport;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileOutputStream;
import java.util.Base64;



/**
 * contains all the methods to create/initialize a new session and stop the 
 * session after the test(s) execution is over. Each test extends
 *  this class.
 */

public class BaseClass {

	//	protected static ThreadLocal <AppiumDriver> driver = new ThreadLocal<AppiumDriver>();
	//	public LoginPage loginpage;
	public AppiumDriverLocalService appiumService;
	public static AppiumServiceBuilder builder;
	public static WebDriver wdriver;
	public static LoginPage loginPage = new LoginPage();
	
	
//	protected static AppiumDriver driver;
	public static AndroidDriver driver;
	

	InputStream inputStream = null;
	InputStream stringsis = null;
	Properties props = new Properties();
	private ExtentReport test;
	// common timeout for all tests can be set here
	public static WebDriverWait wait;
	public final int timeOut = 40;

	
	String ProFoamRelease =System.getProperty("user.dir")+ File.separator + "resources"+ File.separator +"App"+ File.separator +"ProFoamApp-release.apk";
	//	static Logger logger = LogManager.getLogger(BaseClass.class.getName());
	//	String packageName = driver.getCurrentPackage();
	public static Log logger = new Log();
	
	/** 
	 *  this method returns AppiumDriver driver
	 * @param os your machine OS (windows/mac)
	 **/
	public AppiumDriver getDriver() {
		return driver;
	}
	

	/**
	 * This method starts the Appium server depending on your OS.
	 * @param os your machine OS (windows/mac)
	 **/
	public void startAppiumServer(String os) {
	    try {
	        if (os.contains("windows")) {
	            builder = new AppiumServiceBuilder();
	            // Set the Appium server's capabilities
	            builder.withIPAddress("192.168.29.23");
	            builder.usingPort(4723);
	            builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
	            builder.withArgument(GeneralServerFlag.LOG_LEVEL, "info");
	            builder.withArgument(GeneralServerFlag.LOCAL_TIMEZONE);

	            // Start the Appium server
	            appiumService = AppiumDriverLocalService.buildService(builder);
	            appiumService.start();
	            logger.info("Appium Server started successfully on Windows.");
	        } else if (os.contains("mac")) {
	            builder = new AppiumServiceBuilder()
	                    .usingAnyFreePort()
	                    .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
	                    .withArgument(GeneralServerFlag.LOG_LEVEL, "error");
	            logger.info("Appium Server configuration is under development for macOS.");
	        } else {
	            logger.info(os + " is not supported yet.");
	        }
	    } catch (Exception e) {
	        logger.info("An unexpected error occurred while starting the Appium server: " + e.getMessage());
	    } finally {
	        if (appiumService != null && appiumService.isRunning()) {
	            logger.info("Appium Server is running.");
	        } else {
	            logger.info("Appium Server did not start as expected.");
	        }
	    }
	}	



	/** 
	 *  this method stops the appium  server.
	 * @param os your machine OS (windows/mac).

	 */
	@AfterMethod
	public void stopAppiumServer() {
		if (appiumService != null) {
			tearDown();
			appiumService.stop();

			logger.info("Appium server stopped");
			//			logger.error("Appium server stopped");
			//			logger.debug("Appium server stopped");
		} else {
			//Log.logError(getClass().getName(), getClass().getEnclosingMethod().getName(),"Appium server fail to stopped");
			logger.info("Appium server fail to stopped");

		}

	}

	public void tearDown() {
		if(driver != null){
			driver.quit();
		}
	}

	/** 
	 *  this method creates the android driver
	 *  @param buildPath - path to pick the location of the app 
	 *  @throws IOException 
	 * @throws InterruptedException 
	 */
	
	public void initAndroidDriverAndApp() throws IOException {
	
		try {
		//props = new Properties();
		String propFileName = "config.properties";

		inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		props.load(inputStream);
		//		  setProps(props);
		String automationName = props.getProperty("androidAutomationName");
		if (automationName == null) {
		    
		} else {
			logger.info("Automation name got found in properties file!");
		}
		startAppiumServer("windows");
		File app = new File(ProFoamRelease);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "MFSEmulator");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
		capabilities.setCapability("automationName", props.getProperty("androidAutomationName"));
		capabilities.setCapability("appPackage", props.getProperty("profoamAppPackage"));
		capabilities.setCapability("appActivity", props.getProperty("proFoamAppActivity"));
		capabilities.setCapability("newCommandTimeout", 3000); 
		URL url = new URL(props.getProperty("appiumURL"));
		driver = new AndroidDriver(url, capabilities);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		logger.info("Driver initiated");
//		ExtentReport.getTest().log(Status.INFO,"Driver initiated" );}
		} catch (IOException e) {
	        logger.info("IOException occurred while loading properties or initializing the driver: " + e.getMessage());
		}finally {
	        try {
	            if (inputStream != null) {
	                inputStream.close();
	            }
	        } catch (IOException e) {
	            logger.info("Failed to close the property file input stream: " + e.getMessage());
	        }
	      }
		//LoginToProFoamApplication();

	}
	
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		
	    initAndroidDriverAndApp();  
	    LoginToApplication(); 
	}
	
//	//public void setUp() throws InterruptedException, IOException {
//	        initAndroidDriverAndApp();
//	       // LoginToProFoamApplication();
//	    }

	
	/** 
	 *  this method Open or activate App without Resetting
	 */
	public void activateApp() {
		logger.info("Application is launching");
		String appPackage = driver.getCapabilities().getCapability("appPackage").toString();
		driver.activateApp(appPackage);
	}
	
	/** 
	 *  this method Close or Terminate App 
	 */
	public void terminateApp() {
		logger.info("Application is Terminating");
		String appPackage = driver.getCapabilities().getCapability("appPackage").toString();
		driver.terminateApp(appPackage);
	}
	
	/** 
	 *  this method Initiate Selenium Driver and Navigate to the URL 
	 */
	public void WebDriverget(String url) {
		logger.info("Web Chrome Browser is Initiating");
		WebDriverManager.chromedriver().setup();
		wdriver = new ChromeDriver();
		wdriver.get(url);
	}
	/** 
	 *  this method close Selenium Driver and Navigate to the URL 
	 */
	public void WebDriverTearDown() {
		logger.info("Web Chrome Browser is Closing");
		wdriver.close();
	}

	public void launchApp() throws IOException, InterruptedException {

		startAppiumServer("windows");
		initAndroidDriverAndApp();

	}
	
	/** 
	 *  Run the app in the background for 5 seconds 
	 */
	public void RunAppInBackground() {

		driver.runAppInBackground(Duration.ofSeconds(5));
	}
	
	public String getdateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	/**
	 * method to get Screenshot for the failure step
	 *
	 * @param Testcasename
	 * @return path in string format
	 * @throws IOException
	 */
	public String getScreenshot(String TestcaseName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + TestcaseName + ".png");

		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + TestcaseName + ".png";
		}

	
	/**
	 * Method to load the config.properties file and return the value for a given key
	 * @author mukeshnayak 
	 */
    public static String getPropertyValue(String key) {
        Properties props = new Properties();
        String value = null;
        String configPath = System.getProperty("user.dir")+ File.separator + "resources"+ File.separator +"config.properties";
        try (InputStream input = new FileInputStream(configPath)) {
            // Load the properties file
            props.load(input);
            
            // Retrieve the value for the given key
            value = props.getProperty(key);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return value;
    }


	/**
	 * method to wait for an element to be visible
	 *
	 * @param targetElement element to be visible
	 * @return true if element is visible else throws TimeoutException
	 */
	public boolean waitForVisibility(By targetElement) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.visibilityOfElementLocated(targetElement));
			logger.info("Webelement : " +targetElement + " - is Displayed");
			ExtentReport.getTest().log(Status.INFO,"Webelement : " +targetElement + " - is Displayed" );
			return true;
		} catch (TimeoutException e) {
			System.out.println("Element is not visible: " + targetElement);
			throw e;

		}
	}

	/**
	 * method to wait for an element until it is invisible
	 *
	 * @param targetElement element to be invisible
	 * @return true if element gets invisible else throws TimeoutException
	 */
	public boolean waitForInvisibility(By targetElement) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(targetElement));
			logger.info("Webelement : " +targetElement + " - is Displayed");
			ExtentReport.getTest().log(Status.INFO,"Webelement : " +targetElement + " - is Displayed" );
			return true;
		} catch (TimeoutException e) {
			System.out.println("Element is still visible: " + targetElement);
			System.out.println(e.getMessage());
			throw e;

		}
	}

	/**
	 * method to find an element
	 *
	 * @param locator element to be found
	 * @return WebElement if found else throws NoSuchElementException
	 */
	public WebElement findElement(By locator) {
		try {
			WebElement element = driver.findElement(locator);
			logger.info("Webelement is : " +locator );
			ExtentReport.getTest().log(Status.INFO,"Webelement is : " +locator  );
			return element;
		} catch (NoSuchElementException e) {

			//       log().info("element not found" + locator);
			throw e;
		}
	}

	/**
	 * method to find all the elements of specific locator
	 *
	 * @param locator element to be found
	 * @return return the list of elements if found else throws NoSuchElementException
	 */
	public List<WebElement> findElements(By locator) {
		try {
			List<WebElement> element = driver.findElements(locator);
			logger.info("Webelement is : " +locator );
			ExtentReport.getTest().log(Status.INFO,"Webelement is : " +locator );
			return element;
		} catch (NoSuchElementException e) {

			//       log().info("element not found" + locator);
			throw e;
		}
	}


	public void click(By element,String str) {
		waitForVisibility(element);
		driver.findElement(element).click();
		logger.info(str+" is clicked");
		ExtentReport.getTest().log(Status.INFO, str );

	}
//	//@BeforeMethod(dependsOnMethods = {"initAndroidDriverAndApp"})
	public void LoginToApplication() throws InterruptedException {
		loginPage.ClickOnSkipButtonInWelcomePage();
		loginPage.ClickOnLoginButtonInLoginButton();
		loginPage.LoginToProFoamApplication();
		
	}
	
	  /**
     * Method to start screen recording using the Appium driver.
     *
     * This method initiates screen recording, allowing the recording
     * of the test execution for debugging and reporting purposes.
     */
    public void startScreenRecording() {
        driver.startRecordingScreen();
    }
    
    /**
     * Stops the screen recording and saves the video in the specified location.
     *
     * @param testName Name of the test case to generate a unique video file name.
     * @return The path of the saved video file.
     */
    public String stopScreenRecording(String testName) {
        String videoPath = null;
        try {
            String media = driver.stopRecordingScreen();
            byte[] decode = Base64.getDecoder().decode(media);

            videoPath = System.getProperty("user.dir") + "/ScreenRecords/" + testName + ".mp4";
            File videoFile = new File(videoPath);
            videoFile.getParentFile().mkdirs();
            
            FileOutputStream stream = new FileOutputStream(videoFile);
            stream.write(decode);
            stream.close();

            logger.info("Screen recording saved: " + videoPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return videoPath;
    }

  

}
