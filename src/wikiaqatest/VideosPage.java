package wikiaqatest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class VideosPage {
	
	@FindBy(xpath = "//div[contains(concat(' ', @class, ' '), ' global-notification confirm ')]")
	private WebElement flashMessageArea;
	
	@FindBy(xpath = "//div[contains(concat(' ', @class, ' '), ' msg ')]/a")
	private WebElement newVideoLink;

	public boolean videoAdded(String message){
		return flashMessageArea.getText().equals(message);
	}
	
	public VideoPage  gotoNewlyAddedVideo(VideoPage nextPage){
		newVideoLink.click();
		return nextPage;
	}
}
