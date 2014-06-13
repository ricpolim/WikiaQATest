package wikiaqatest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddVideoPage {

	@FindBy(id = "wpWikiaVideoAddUrl")
	private WebElement addVideoURL;
	
	@FindBy(xpath = "//div[contains(concat(' ', @class, ' '), ' submits ')]/input")
	private WebElement addButton;
	
	public AddVideoPage addVideo(String url){
		addVideoURL.sendKeys(url);
		return this;
	}
	
	public VideosPage submitVideo(VideosPage nextPage){
		addButton.submit();
		return nextPage;
	}
}
