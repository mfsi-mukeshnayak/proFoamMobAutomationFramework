package com.utills;

import java.time.Duration;
import java.util.HashMap;
import java.util.Random;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.logger.Log;
import com.reports.ExtentReport;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import java.math.BigInteger;
import java.security.SecureRandom;



public class GenericMethods extends BaseClass {

	public static Log logger = new Log();
	WebDriverWait wait;
		// Create a date object for the current USA date and time
	public static String getCurrentTimeInUS() {
        
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy-HH:mm a");
        dateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        return dateFormat.format(currentDate);
    }
	
	
	 public static String generateExpiryDateOfCard() {
	        LocalDate currentDate = LocalDate.now();

	        // Randomly select a number of years between 6 and 10
	        Random random = new Random();
	        int randomYearsToAdd = random.nextInt(5) + 6; // Generates a random number between 6 and 10

	        // Add the random number of years to the current date
	        LocalDate expiryDate = currentDate.plusYears(randomYearsToAdd);

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");

	        return expiryDate.format(formatter);
	    }

		
	// Array of some cities in Alaska
    private static final String[] CITIES_IN_ALASKA = {
        "Anchorage", "Fairbanks", "Juneau", "Sitka", "Ketchikan", "Kenai", "Kodiak", "Bethel", "Wasilla", "Palmer"
    };

    // Alaska ZIP code range is 99501 - 99950
    private static final int ALASKA_ZIP_MIN = 99501;
    private static final int ALASKA_ZIP_MAX = 99950;

    // Method to generate a random 10-digit mobile number
    public static String generateRandomMobileNumber() {
        Random random = new Random();
        StringBuilder mobileNumber = new StringBuilder("9"); // Start with 9 for a more realistic mobile number
        for (int i = 0; i < 9; i++) {
            mobileNumber.append(random.nextInt(10)); // Append random digits
        }
        return mobileNumber.toString();
    }

    // Method to generate a random address (house number and street name)
    public static String generateRandomAddress() {
        Random random = new Random();
        int houseNumber = random.nextInt(9999) + 1; // Generate a random house number
        String[] streetNames = {"Main St", "Elm St", "Pine St", "Maple St", "Oak St", "Cedar St"};
        String streetName = streetNames[random.nextInt(streetNames.length)];
        return houseNumber + " " + streetName;
    }

    // Method to get a random city in Alaska
    public static String getRandomCityInAlaska() {
        Random random = new Random();
        return CITIES_IN_ALASKA[random.nextInt(CITIES_IN_ALASKA.length)];
    }

    // Method to generate a random ZIP code in Alaska
    public static String generateRandomAlaskaZipCode() {
        Random random = new Random();
        int zipCode= random.nextInt(ALASKA_ZIP_MAX - ALASKA_ZIP_MIN + 1) + ALASKA_ZIP_MIN;
        return String.valueOf(zipCode);
    }
    
    public static String generateRandomNumber(int digitCount) {
        // Ensure the digitCount is between 1 and 20
        if (digitCount < 1 || digitCount > 20) {
            throw new IllegalArgumentException("Digit count must be between 1 and 20.");
        }

        // Use SecureRandom for better randomness
        SecureRandom random = new SecureRandom();

        // Generate the random number with the specified number of digits
        BigInteger randomNumber = new BigInteger(digitCount * 3, random);
        
        // Convert the BigInteger to string and take the first 'digitCount' characters
        String randomNumberStr = randomNumber.toString();
        
        // Ensure the generated number has exactly 'digitCount' digits
        return randomNumberStr.substring(0, digitCount);
    }
	

	/**
	 * method to enter text into text box
	 */
	public void enterText(By element, String text) {
		waitForVisibility(element);
		WebElement mobileElement = driver.findElement(element);
		mobileElement.clear();
		mobileElement.sendKeys(text);
		//	    log().info(text+" was entered");
		//   String msg = text +" is entered";
		logger.info("text: "+text +" is entered" );
		ExtentReport.getTest().log(Status.INFO, "text: "+text +" - is entered to the text box" );
	}	

	/**
	 * method to go back by Android Native back click
	 */
	public void back() {
		((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.BACK));
	}

	/**
	 * method to tap on the screen on provided coordinates
	 *
	 * @param xPosition x coordinate to be tapped
	 * @param yPosition y coordinate to be tapped
	 */
	public void tap(double xPosition, double yPosition) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, Double> tapObject = new HashMap<String, Double>();
		tapObject.put("startX", xPosition);
		tapObject.put("startY", yPosition);
		js.executeScript("mobile: tap", tapObject);
	}

	/**
	 * method to get message test of alert
	 *
	 * @return message text which is displayed
	 */
	public String getAlertText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			return alertText;
		} catch (NoAlertPresentException e) {
			throw e;
		}
	}

	/**
	 * method to verify if alert is present
	 *
	 * @return returns true if alert is present else false
	 */
	public boolean isAlertPresent() {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			throw e;
		}
	}

	/**
	 * method to Accept Alert if alert is present
	 */

	public void acceptAlert() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}

	/**
	 * method to Dismiss Alert if alert is present
	 */

	public void dismissAlert() {
		wait = new  WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().dismiss();
	}

	/**
	 * method to long press on specific element by passing locator
	 *
	 * @param locator element to be long pressed
	 */
	public void longPress(By locator) {
		try {
			WebElement element = driver.findElement(locator);

			TouchAction touch = new TouchAction((AndroidDriver) driver);
			LongPressOptions longPressOptions = new LongPressOptions();
			longPressOptions.withElement(ElementOption.element(element));
			touch.longPress(longPressOptions).release().perform();
			//            Log.info("Long press successful on element: " + element);
		} catch (NoSuchElementException e) {
			//            Log.logError(this.getClass().getName(), "findElement", "Element not found" + locator);
			throw e;
		}

	}

	/**
	 * method to long press on specific x,y coordinates
	 *
	 * @param x x offset
	 * @param y y offset
	 */
	public void longPress(int x, int y) {
		TouchAction touch = new TouchAction((AndroidDriver) driver);
		PointOption pointOption = new PointOption();
		pointOption.withCoordinates(x, y);
		touch.longPress(pointOption).release().perform();
		//      Log.info("Long press successful on coordinates: " + "( " + x + "," + y + " )");

	}
	/**
	 * method to swipe on the screen on provided coordinates
	 *
	 * @param startX   - start X coordinate to be tapped
	 * @param endX     - end X coordinate to be tapped
	 * @param startY   - start y coordinate to be tapped
	 * @param endY     - end Y coordinate to be tapped
	 * @param duration duration to be tapped
	 */

	public void swipe(double startX, double startY, double endX, double endY, double duration) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, Double> swipeObject = new HashMap<String, Double>();
		// swipeObject.put("touchCount", 1.0);
		swipeObject.put("startX", startX);
		swipeObject.put("startY", startY);
		swipeObject.put("endX", endX);
		swipeObject.put("endY", endY);
		swipeObject.put("duration", duration);
		js.executeScript("mobile: swipe", swipeObject);

	}

	/**
	 * method to open notifications on Android
	 */

	public void openNotifications() {
		((AndroidDriver) driver).openNotifications();
	}

	/**
	 * method to verify the element is present or not
	 */
	public boolean verifyElemnt(By ele) {
		try {
			waitForVisibility(ele);
			logger.info("Webelement : " +ele + " - is Displayed");
			ExtentReport.getTest().log(Status.INFO,"Webelement : " +ele + " - is Displayed" );
			return findElement(ele).isDisplayed();

		}catch(org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
			return false;

		}
	}



}
