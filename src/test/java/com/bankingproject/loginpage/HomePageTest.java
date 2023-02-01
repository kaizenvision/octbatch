package com.bankingproject.loginpage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.bankingproject.base.BaseClass;
import com.bankingproject.pom.BankHomePagePom;
import com.bankingproject.pom.CredentialPom;
import com.bankingproject.pom.LognPagePom;
import com.bankingproject.utility.Utility;

public class HomePageTest extends BaseClass {
	
	@BeforeClass
	public void setUp() {
		launchWebsite();
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	
	
	@Test
	public void testGetCredentials() throws InterruptedException, EncryptedDocumentException, IOException {
		LognPagePom lognPagePom = new LognPagePom();
		BankHomePagePom bankHomePagePom = lognPagePom.clickOnGetCredential();
		SoftAssert sassert = new SoftAssert();
		Thread.sleep(2000);
		Utility utility = new Utility();
		String email = (String) utility.getSingleCellDataFromExcel(0,0,"login credentials");
		sassert.assertTrue(!email.trim().isEmpty());
		//Assert.assertTrue(!email.trim().isEmpty());
		bankHomePagePom.setEmailId(email);
		Thread.sleep(2000);
		bankHomePagePom.clickOnSubmit();
		Thread.sleep(20000);
		CredentialPom credentialPom1 = bankHomePagePom.clickOnSubmit();
		credentialPom1.saveCredentials();
		sassert.assertAll();
	}

}
