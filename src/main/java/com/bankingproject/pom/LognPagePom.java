package com.bankingproject.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bankingproject.base.BaseClass;

public class LognPagePom extends BaseClass {
	
	public LognPagePom() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='uid']")
	public WebElement userID;
	
	@FindBy(xpath = "//input[@name='password']")
	public WebElement password;
	
	@FindBy(xpath = "//input[@name='btnLogin']")
	public WebElement loginbutton;
	
	@FindBy(xpath = "//input[@name='btnReset']")
	public WebElement resetButton;
	
	@FindBy(xpath = "//a[text()='here']")
	WebElement getCredentialLink;
	
	public void clickOnLoginButton() {
		loginbutton.click();
	}
	
	public BankHomePagePom clickOnGetCredential() {
		getCredentialLink.click();
		return new BankHomePagePom();
	}
	
	

}
