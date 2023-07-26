package com.trantor.demo.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.trantor.demo.base.Base;

public class DashboardPage extends Base{
	
	By timeAtWorkLocator = By.xpath("//div[@class='orangehrm-dashboard-widget-header']//p[contains(.,'Time at Work')]");
	By myActionsHeader = By.xpath("//div[@class='orangehrm-dashboard-widget-header']//p[contains(.,'My Actions')]");
	By punchedOutText = By.xpath("//div[@class='orangehrm-attendance-card-profile-image']//following-sibling::div//p[@class='oxd-text oxd-text--p orangehrm-attendance-card-state']");
	//This method will check if 'Time at Work' text is present on screen or not
	public void verifyTimeAtWorkHeader() {
		sleepForMiliSecs(5000);
		boolean isDisplayed = driver.findElement(timeAtWorkLocator).isDisplayed();
		System.out.println("'Time at work' is displayed: "+isDisplayed);
	}
	
	public void verifyMyActionsHeader(String name) {
		driver.findElement(myActionsHeader).isDisplayed();
	}
	
	public String verifyMyActionsHeader1() {
		_log.info("Fetching 'My Action Header' text from UI");
		String getText = null;
		WebElement testFromXpath = driver.findElement(punchedOutText);
		getText = testFromXpath.getText();
		return getText;
	}
	
	public String verifyMyActionsHeader2() {
		String getText = null;
		getText = driver.findElement(punchedOutText).getText();
		return getText;
	}
	
	public String verifyMyActionsHeader3() {
		return driver.findElement(punchedOutText).getText();
	}
}
