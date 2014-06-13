package wikiaqatest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(id = "AccountNavigation")
	private WebElement accountNavigation;
	
	@FindBy(xpath = "//nav[contains(concat(' ', @class, ' '), ' contribute ')]")
	private WebElement contributeButton;
	
	@FindBy(linkText = "Add a Video")
	private WebElement addAVideoButton;
	
	private Actions actions;
	
	public HomePage(WebDriver driver){
		actions = new Actions(driver);
	}
	
	public boolean isLoggedIn(){
		return (!accountNavigation.getText().contains("Log in"));
	}
	
	public boolean isUserNameDisplayedInAcctNav(String username){
		return accountNavigation.getText().toLowerCase().contains(username.toLowerCase());
	}
	
	public HomePage clickContributeButton(){
		actions.moveToElement(contributeButton).click().perform();
		return this;
	}
	
	public boolean isContributeDropDownExpanded(){
		return contributeButton.getAttribute("class").contains("active");
	}
	
	public AddVideoPage clickAddAVideo(AddVideoPage nextPage){
		actions.moveToElement(addAVideoButton).click().perform();
		return nextPage;
	}

}
