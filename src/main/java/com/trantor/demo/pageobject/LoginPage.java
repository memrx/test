package com.trantor.demo.pageobject;

import org.openqa.selenium.By;
import com.trantor.demo.base.Base;


public class LoginPage extends Base{
	
	By usernameInputboxLocator = By.name("username");
	By passwordInputboxLocator = By.name("password");
	By loginButtonLocator = By.xpath("//button[@type='submit']");
	
	

	public void typeUsername(String username) {
		sleepForMiliSecs(5000);
		_log.info("Typing username: " + username);
		driver.findElement(usernameInputboxLocator).sendKeys(username);
	}
	

	public void typePassword(String password) {
		_log.info("Typing password: " + password);
		driver.findElement(passwordInputboxLocator).sendKeys(password);
	}

	public void clickLoginButton() {
		_log.info("Clicking login button");
		driver.findElement(loginButtonLocator).click();
	
	}

	
	public void loginIntoHrmPortal() {
		driver.findElement(usernameInputboxLocator).sendKeys("Admin");
		driver.findElement(passwordInputboxLocator).sendKeys("admin123");
		driver.findElement(loginButtonLocator).click();
	}

}
