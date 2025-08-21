package com.qa.test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class Homepage extends TestBase {

	@FindBy(xpath = "//select[@class='product_sort_container']")
	WebElement filterDropdown;

	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	WebElement cartlogo;

	@FindBy(xpath = "//div[@class='cart_item_label']//div[@class='inventory_item_name']")
	List<WebElement> cartProducts;

	@FindBy(id = "checkout")
	WebElement checkout;

	@FindBy(id = "first-name")
	WebElement firstNameInput;

	@FindBy(id = "last-name")
	WebElement lastNameInput;

	@FindBy(id = "postal-code")
	WebElement postalCodeInput;

	@FindBy(id = "continue")
	WebElement continueBtn;

	@FindBy(id = "finish")
	WebElement finishBtn;

	@FindBy(xpath = "//h2[normalize-space()='Thank you for your order!']")
	WebElement orderSuccessMessage;

	@FindBy(xpath = "//img[@alt='Pony Express']")
	WebElement checkoutimg;

	public Homepage() {
		PageFactory.initElements(driver, this);
	}

	public void applyFilterLowToHigh() {
		Select select = new Select(filterDropdown);
		select.selectByVisibleText("Price (low to high)");
	}

	public List<String> getProductNames() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'inventory_item_name')]")));
		List<WebElement> products = driver.findElements(By.xpath("//div[contains(@class,'inventory_item_name')]"));
		List<String> names = new ArrayList<>();
		for (WebElement e : products) {
			names.add(e.getText());
		}
		return names;
	}

	public List<String> getProductPrices() {
		List<WebElement> pricesList = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		List<String> prices = new ArrayList<>();
		for (WebElement e : pricesList) {
			prices.add(e.getText());
		}
		return prices;
	}

	public void addProductToCart(String product) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'inventory_item_name')]")));

		List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item']"));
		for (WebElement p : products) {
			String name = p.findElement(By.xpath(".//div[contains(@class,'inventory_item_name')]")).getText().trim();
			if (name.equalsIgnoreCase(product)) {
				WebElement addBtn = p.findElement(By.xpath(".//button[contains(@id,'add-to-cart')]"));
				wait.until(ExpectedConditions.elementToBeClickable(addBtn));
				addBtn.click();
				System.out.println("Added product: " + name);
				return;
			}
		}
	}

	public void gotocartpage() {
		cartlogo.click();
	}

	public boolean ProductInCart(String productName) {
		for (WebElement product : cartProducts) {
			if (product.getText().trim().equalsIgnoreCase(productName)) {
				return true;
			}
		}
		return false;
	}

	public void filltheDetails(String firstName, String lastName, String zip) {
		checkout.click();
		firstNameInput.sendKeys(firstName);
		lastNameInput.sendKeys(lastName);
		postalCodeInput.sendKeys(zip);
		continueBtn.click();
	}

	public void completePurchase() {
		finishBtn.click();
	}

	public String getConfirmationMessage() {
		return orderSuccessMessage.getText();
	}

	public void checkimg() {
		checkoutimg.click();
	}

}
