package wikiaqatest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class VideoPage {
	
	@FindBy(xpath = "//header[@id = 'WikiaPageHeader']/h1")
	private WebElement fileName;

	public boolean fileNameEquals(String fileName){
		return this.fileName.getText().equals(fileName);
	}
	
	public String getFileName(){
		return fileName.getText();
	}
}
