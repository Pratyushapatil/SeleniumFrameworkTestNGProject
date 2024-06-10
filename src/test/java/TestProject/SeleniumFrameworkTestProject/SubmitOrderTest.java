package TestProject.SeleniumFrameworkTestProject;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumFrameworkTestProjectPageobeject.CartPage;
import SeleniumFrameworkTestProjectPageobeject.CheckOutPage;
import SeleniumFrameworkTestProjectPageobeject.ConfirmationPage;
import SeleniumFrameworkTestProjectPageobeject.LandingPage;
import SeleniumFrameworkTestProjectPageobeject.ProductCatalog;
import SeleniumFrameworkTestProjectTestComponents.BaseTest;

import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SubmitOrderTest extends BaseTest{

	
	@Test
	public void SubmitOrder() throws IOException, InterruptedException{
	
        String productname = "ADIDAS ORIGINAL";
		ProductCatalog productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckOutPage checkoutPage = cartPage.checkOut();
		checkoutPage.SelectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.SubmitOrder();
		String confirmMessage = confirmationPage.VerifyMsg();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		
		 
		
		
	}

}
