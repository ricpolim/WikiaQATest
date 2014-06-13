package wikiaqatest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage{
	
	@FindBy(linkText = "Log in")
	private WebElement ajaxLogin;
	
	@FindBy(id = "UserLoginDropdown")
	private WebElement userLoginDropDown;
	
	@FindBy(name = "username")
	private WebElement loginUserNameField;
	
	@FindBy(name = "password")
	private WebElement loginPasswordField;
	
	@FindBy(className = "login-button")
	private WebElement loginButton;
	
	private Actions actions;
	
	public LoginPage(WebDriver driver){
		actions = new Actions(driver);
	}
	
	public boolean isLoggedIn(){
		return (ajaxLogin == null);
	}
	
	public boolean isUserLoginDropDownVisible(){
		return (userLoginDropDown != null && userLoginDropDown.getAttribute("class").contains("show"));
	}
	
	public LoginPage typeUsername(String username) {
		
		if(loginUserNameField != null){
			loginUserNameField.sendKeys(username);
		}

		return this;    
    }

    public LoginPage typePassword(String password) {
    	
    	if(loginPasswordField != null){
			loginPasswordField.sendKeys(password);
		}
        
    	return this;    
    }

    public LoginPage submitLogin() {
    	
    	if(loginButton != null){
			loginButton.submit();
		}
    	
        return this;  
    }
    
    public HomePage loginAs(String username, String password, HomePage nextPage) {
    	if(!isLoggedIn()){
    		typeUsername(username);
    		typePassword(password);
    		submitLogin();
    		return nextPage;
    	}else{
    		throw new IllegalStateException("A user is already logged in");
    	}
    }

    public LoginPage hoverLoginLabel(){
    	if(!isLoggedIn()){
    		actions.moveToElement(ajaxLogin).click().perform();
    		return this;
    	}else{
    		throw new IllegalStateException("A user is already logged in");
    	}
    }
}
