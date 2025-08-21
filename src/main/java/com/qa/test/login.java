package com.qa.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class login extends TestBase {

	@FindBy(xpath = "//input[@id='user-name']")
	WebElement un;

	@FindBy(xpath = "//input[@id='password']")
	WebElement pwd;

	@FindBy(xpath = "//input[@id='login-button']")
	WebElement loginBtn;

	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	WebElement cartlogo;

	public login() {
		PageFactory.initElements(driver, this);
	}

	public void logininto(String username, String password) {
		un.sendKeys(username);
		pwd.sendKeys(password);
		loginBtn.click();
	}

	public boolean verifyLoginsucess() {
		return cartlogo.isDisplayed();
	}
	
	

}
