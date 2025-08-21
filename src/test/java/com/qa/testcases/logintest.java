package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.base.TestBase;
import com.qa.test.login;
import com.qa.utils.CsvUtil;

public class logintest extends TestBase {

	login Login;

	public logintest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		Login = new login();
	}

	@DataProvider(name = "LoginData")
	public Object[][] getLoginData() {
		String path = "src/test/resource/TestData.csv";
		return CsvUtil.getTestData(path);
	}

	@Test(dataProvider = "LoginData", priority = 1)
	public void LogintestWithMultipleCredentials(String username, String password) {
		System.out.println("Tested with: " + username + " | " + password);
		Login.logininto(username, password);
		boolean flag = Login.verifyLoginsucess();
		Assert.assertTrue(flag);
		System.out.println("Login is sucessful with given cradentials");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}