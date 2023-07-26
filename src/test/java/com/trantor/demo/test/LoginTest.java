package com.trantor.demo.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.trantor.demo.base.Base;
import com.trantor.demo.pageobject.DashboardPage;
import com.trantor.demo.pageobject.LoginPage;
import com.trantor.demo.utils.PropertyFetcher;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest {
	
	Base _base = null;
	
	@Before
	public void setUp() {
		_base = new Base();
		_base.initializeWebDriver();
		_base.openUrl(PropertyFetcher.readKeyFromPropertyFile("url"));
	}
	
	
	@Test
	public void testLoginFunctionality() {
		LoginPage _loginPage = new LoginPage();
		_loginPage.typeUsername(PropertyFetcher.readKeyFromPropertyFile("username"));
		_loginPage.typePassword(PropertyFetcher.readKeyFromPropertyFile("password"));
		_loginPage.clickLoginButton();
		
		DashboardPage _dashboardPage =  new DashboardPage();
		_dashboardPage.verifyTimeAtWorkHeader();
		
		String test = _dashboardPage.verifyMyActionsHeader1();
		//assertEquals(test, "Punched Out");
		assertEquals("We need to verify 'Punched Out', however the UI is displaying: "+test, PropertyFetcher.readKeyFromPropertyFile("textToVerify"), test);
		
	}
	
	
	//@Test
	public void testLoginFunctionality2() {
		LoginPage _loginPage = new LoginPage();
		_loginPage.typeUsername(PropertyFetcher.readKeyFromPropertyFile("username"));
		_loginPage.typePassword(PropertyFetcher.readKeyFromPropertyFile("password"));
		_loginPage.clickLoginButton();
		
		DashboardPage _dashboardPage =  new DashboardPage();
		_dashboardPage.verifyTimeAtWorkHeader();
		
		String test = _dashboardPage.verifyMyActionsHeader1();
		assertEquals(test, PropertyFetcher.readKeyFromPropertyFile("textToVerify"));
		//assertEquals("We need to verify 'Punched Out', however the UI is displaying: "+test, PropertyFetcher.readKeyFromPropertyFile("textToVerify"), test);
		
	}
	
	@After
	public void tearDown() {
		_base.killDriver();
	}
	
}
