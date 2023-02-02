package com.bankingproject.loginpage;

import java.io.IOException;
import java.time.Duration;

import com.bankingproject.utility.Utility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.bankingproject.base.BaseClass;
import com.bankingproject.pom.LognPagePom;

public class LoginPageTest extends BaseClass {
	
	LognPagePom lognPagePom ;
	ExtentSparkReporter extentSparkReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;
	//WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		launchWebsite();
		extentSparkReporter = new ExtentSparkReporter(projectpath+"//extentReport//extent.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		switch (result.getStatus()) {
		case 1:
			extentTest.log(Status.PASS, "test case pass with correct url");
			break;
		case 2:
			extentTest.log(Status.FAIL, "test case fail with incorrect url");
			break;
			
		case 3:
			extentTest.log(Status.SKIP, "test case skipped ...");
			break;

		default:
			break;
		}
		extentReports.flush();
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
	public void testUrl() throws IOException {
		extentTest = extentReports.createTest("testUrl");
		String pageTitle = driver.getCurrentUrl();
		Assert.fail();
		Utility utility = new Utility();
		extentTest.addScreenCaptureFromPath(utility.getScreenShot("testUrl"), pageTitle);
		Assert.assertEquals(pageTitle, "https://demo.guru99.com/V1/index.ph");
		
		
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
