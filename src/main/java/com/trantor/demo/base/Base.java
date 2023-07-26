package com.trantor.demo.base;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver = null;
	public Logger _log = Logger.getLogger(Base.class.getName());

	public void initializeWebDriver() {
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\harpreet2.singh\\Desktop\\chromedriver.exe");
		// driver = new ChromeDriver();

		writeLogs();
		
		ChromeOptions options = new ChromeOptions();
		// options.addArguments("--headless");
		options.addArguments("start-maximized");
		_log.info("Initializing driver ...");
		// System.out.println("Initializing driver ...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
	}

	public void openUrl(String url) {
		_log.info("The URL is: " + url);
		driver.get(url);
	}

	public void printCurrentTitle() {
		System.out.println("Current page title: " + driver.getTitle());
	}

	public void killDriver() {
		_log.info("Destroying the web driver");
		driver.quit();
	}

	public void sleepForMiliSecs(int sleepTime) {
		_log.severe("Waiting for : " + sleepTime + " ms");
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void writeLogs() {
		Handler _handler = null;
		Formatter _format = null;
		try {
			_handler = new FileHandler("./myLogs.log");
			_format = new SimpleFormatter();
			_handler.setFormatter(_format);
			_log.addHandler(_handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 

}
