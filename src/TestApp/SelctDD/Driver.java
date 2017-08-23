package TestApp.SelctDD;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class Driver {

	private static AppiumDriver<MobileElement> driver;

	DesiredCapabilities capabilities = new DesiredCapabilities();
/*
	public Driver(String driverType) throws MalformedURLException {
		createDriver(driverType);
	}
*/
	@SuppressWarnings("rawtypes")
	AppiumDriver createDriver(String driverType) throws MalformedURLException {
		if (driverType.equalsIgnoreCase("Android")) {
			capabilities.setCapability("BROWSER_NAME", "Android");
			capabilities.setCapability("platformVersion", "4.4.2");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("appPackage", "");
			capabilities.setCapability("appActivity", "");
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);	
		} else {
			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("platformVersion", "9");
			capabilities.setCapability("deviceName", "iPhone 7");
			capabilities.setCapability("appPackage", "");
			capabilities.setCapability("appActivity", "");
			driver = new IOSDriver(new URL("https://us1.appium.testobject.com/wd/hub"), capabilities);
			setDriver(driver);
		}
		return driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(AppiumDriver driver) {
		Driver.driver = driver;
	}

}
