package com.bankingproject.loginpage;

import java.io.IOException;
import java.time.Duration;

import com.bankingproject.utility.Utility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bankingproject.base.BaseClass;
import com.bankingproject.pom.LognPagePom;

public class LoginPageTest extends BaseClass {
	
	LognPagePom lognPagePom ;
	//WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		launchWebsite();
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void testTitle() throws IOException {
		String pageTitle = driver.getTitle();
		Utility utility = new Utility();
		utility.getScreenShot("testTitle");
		Assert.assertEquals(pageTitle, "GTPL Bank Home Page1");
	}
	
	@Test
	public void testUrl() {
		String pageTitle = driver.getCurrentUrl();
		Assert.assertEquals(pageTitle, "https://demo.guru99.com/V1/index.php");
		
	}
	
	@Test
	public void clickOnLoginButton() throws InterruptedException {
		lognPagePom = new LognPagePom();
		lognPagePom.clickOnLoginButton();
	}
	
	@Test
	public void setLogincrentials() {
		lognPagePom = new LognPagePom();
		lognPagePom.userID.sendKeys("dfjd12321");
		lognPagePom.password.sendKeys("sadsadas");
		lognPagePom.loginbutton.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		lognPagePom.userID.sendKeys("dfjd12321");
		lognPagePom.password.sendKeys("sadsadas");
		lognPagePom.resetButton.click();
	}

}
