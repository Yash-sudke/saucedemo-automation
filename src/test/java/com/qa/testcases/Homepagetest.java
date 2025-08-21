package com.qa.testcases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.test.Homepage;
import com.qa.test.login;

public class Homepagetest extends TestBase{
	
	login Login;
    Homepage homePage;

    public Homepagetest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        Login = new login();
        homePage = new Homepage();
        Login.logininto(prop.getProperty("username"),prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyProductFilterLowToHigh() {
        homePage.applyFilterLowToHigh();
        System.out.println("Filter is applied : (Low → High):");
        System.out.println("Products list After Applying Low → High Filter");
        List<String> names = homePage.getProductNames();
        List<String> prices = homePage.getProductPrices();
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i) + " | " + prices.get(i));
        }
    }
    
    @Test(priority = 2)
    public void verifyProductaddedtocart() {
    	homePage.applyFilterLowToHigh();
    	homePage.addProductToCart(data.getProperty("product"));
    	homePage.gotocartpage();
    	boolean flag = homePage.ProductInCart(data.getProperty("product"));
        Assert.assertTrue(flag, "Product not found in cart!");
        System.out.println("Product : " + data.getProperty("product") + "' successfully found in cart.");
    }
    
    @Test(priority = 3)
    public void verifyCheckoutAndPurchase() {
    	homePage.applyFilterLowToHigh();
    	homePage.addProductToCart(data.getProperty("product"));
    	homePage.gotocartpage();
    	homePage.filltheDetails(data.getProperty("firstName"), data.getProperty("lastName"), data.getProperty("zip"));
    	homePage.completePurchase();
    	
    	String confirmation = homePage.getConfirmationMessage();
    	Assert.assertEquals(confirmation, "Thank you for your order!");
    	homePage.checkimg();
    	System.out.println("message: " + confirmation);
    }
    
    @AfterMethod
	public void tearDown() {
		driver.quit();
	}
    

}
