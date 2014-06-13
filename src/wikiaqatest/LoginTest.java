package wikiaqatest;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class LoginTest extends WikiaTests{
	
	private WebDriver driver;
	private LoginPage wikiaLoginPage;
	private HomePage wikiaHomePage;

	@Test
	public void testLogin() {
		
		//check that we're at the correct address
		Assert.assertTrue(driver.getCurrentUrl().contains(WIKIA_MAIN_URL + "wiki/Test-homework_Wiki"));

		Assert.assertFalse(wikiaLoginPage.isLoggedIn(), "there should not be a logged in user when this test starts");
		
		//hover the login sign and verify the login drop down is displayed
		wikiaLoginPage.hoverLoginLabel();
		Assert.assertTrue(wikiaLoginPage.isUserLoginDropDownVisible());
		
		//login and verify that it's successful
		wikiaHomePage = wikiaLoginPage.loginAs(USERNAME, PASSWORD, PageFactory.initElements(driver, HomePage.class));
		Assert.assertTrue(wikiaHomePage.isUserNameDisplayedInAcctNav(USERNAME));		
	}
	
	@BeforeClass
	public void setUp(){
		
		// Create a new instance of a driver
        driver = new FirefoxDriver();
		
        // Navigate to the test homepage
        driver.get(WIKIA_MAIN_URL);

        // Create instance of login page
        wikiaLoginPage = PageFactory.initElements(driver, LoginPage.class);
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
}
