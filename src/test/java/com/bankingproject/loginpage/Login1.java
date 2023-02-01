package com.bankingproject.loginpage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login1 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "G:\\selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/V1/index.php");
		
		driver.manage().window().maximize();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
//Reading the credentials from Excel Sheet
		
		/*
		 * FileInputStream fis=new
		 * FileInputStream("D:\\Automation\\ExcelSheet\\Banking Project\\TestCases1.xlsx"
		 * );
		 * 
		 * 
		 * Sheet sh=WorkbookFactory.create(fis).getSheet("Login");
		 * 
		 * String login=sh.getRow(1).getCell(0).getStringCellValue();
		 */
		
		/*
		 * System.out.println(login); String
		 * pwd=sh.getRow(1).getCell(1).getStringCellValue(); System.out.println(pwd);
		 */

		WebElement log=driver.findElement(By.xpath("//input[@name='uid']"));
		
		WebElement pwd1=driver.findElement(By.xpath("//input[@name='password']"));
		
//Incorrect credentials 
		
		
		
		log.sendKeys("abshshghsjjlshc");
		pwd1.sendKeys("jjkxkckxk");
		
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		
		
//Handling the alert
		
		Alert alert=driver.switchTo().alert();
		
		//System.out.println(alert.getText());
		
		alert.accept();
		
		//log.click();
		
		driver.navigate().refresh();
		
		new WebDriverWait(driver, Duration.ofSeconds(20))
        .ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofMillis(1000))
        .until((WebDriver d) -> {
            d.findElement(By.xpath("//input[@name='uid']")).sendKeys("ffgfhgh");
            d.findElement(By.xpath("//input[@name='password']")).sendKeys("dshfdhf");
            d.findElement(By.xpath("//input[@value='RESET']")).click();
            return true;
        });
		
		//wait.until(ExpectedConditions.elementToBeClickable(log));
		
		//log.sendKeys("ffgfhgh");
		
		//pwd1.sendKeys("awestrdtt");
		
		//driver.findElement(By.xpath("//input[@value='RESET']")).click();
		
		String val1=log.getAttribute("value");
		
		String val2=pwd1.getAttribute("value");
		
		
		if(val1.isEmpty() && val2.isEmpty()) {
				System.out.println("Reset Done");
		}
		
//Correct Login
		
	
		
		System.out.print("Login Sucessfully !");	
		
		driver.close();
		
	}

}