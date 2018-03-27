/**
 * 
 */
package com.xpanxion.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import com.xpanxion.core.Configuration;

import java.util.HashMap;
import java.util.Map;


public class MobileEmulatorDriver extends WebDriverFactory{
	
	WebDriver driver;
	String deviceName;

	public WebDriver getDriver() {
		Configuration config= Configuration.getInstance();
		String chromePath = System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", config.getDevice());
		Map<String, Object> chromeOptions = new HashMap<String, Object>();
		chromeOptions.put("mobileEmulation", mobileEmulation);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		//driver = new ChromeDriver(capabilities);
        if (isRemote) {
            driver = launchGridDriver(capabilities, config.getHubUrl());
            Reporter.log("Running test on Grid, in browser 'MOBILE' ", true);
        } else {
            driver = new ChromeDriver(capabilities);
            Reporter.log("Running test in browser 'CHROME'", true);
        }

		return driver;
	}

	public void setDeviceName(String deviceName)
	{
		this.deviceName = deviceName;
	}
	
	public String getDeviceName()
	{
		return this.deviceName;
	}
}
