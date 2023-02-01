package com.bankingproject.loginpage;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNgDemo {
	
	@Test(priority = -1, groups = {"regression"})
	public void testOne() {
		SoftAssert assert1 = new SoftAssert();
		System.out.println("test started");
		System.out.println("open correct url");
		//Assert.assertTrue(1>5);
		System.out.println("do some action");
	//	Assert.assertEquals("test", "test1");
		System.out.println("test complete");
		//assert1.assertAll();
	}
	
	@Test(priority = 2, groups = {"reression","sanity"})
	public void testTwo() {
		
	}
	
	@Test(priority = -2, dependsOnGroups = {"sanity"})
	public void test() {
		
	}
	
	@Test(priority = 0, dependsOnMethods = {"testOne"})
	public void test1() {
		
	}

}
