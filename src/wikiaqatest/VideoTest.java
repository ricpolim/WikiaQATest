package wikiaqatest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class VideoTest extends WikiaTests{
	
	private WebDriver driver;
	private LoginPage wikiaLoginPage;
	private HomePage wikiaHomePage;
	private AddVideoPage wikiaAddVideoPage;
	private VideosPage videosPage;
	private VideoPage videoPage;
	
	@Test
	public void testAddVideo() {
		
		String videoURL = "http://www.youtube.com/watch?v=h9tRIZyTXTI";
		String successMsg = "Video page File:The Best Classical Music In The World was successfully added.";
		
		// Navigate to the test homepage
        driver.get(WIKIA_MAIN_URL);
		
		//check that a user is logged in
		Assert.assertTrue(wikiaHomePage.isLoggedIn());
		
		//click contribute button and check if drop down menu is expanded
		wikiaHomePage.clickContributeButton();
		Assert.assertTrue(wikiaHomePage.isContributeDropDownExpanded());
		
		//click add a video and check that we're redirected to the correct URL
		wikiaAddVideoPage = wikiaHomePage.clickAddAVideo(PageFactory.initElements(driver, AddVideoPage.class));
		Assert.assertEquals(driver.getCurrentUrl(), WIKIA_MAIN_URL + "wiki/Special:WikiaVideoAdd");
		
		//add a video and check that the correct message is produced in the successor page
		wikiaAddVideoPage.addVideo(videoURL);
		videosPage = wikiaAddVideoPage.submitVideo(PageFactory.initElements(driver, VideosPage.class));
		Assert.assertTrue(videosPage.videoAdded(successMsg));
		
		//click on the new video link and confirm that the filename in the url and video page match
		videoPage = videosPage.gotoNewlyAddedVideo(PageFactory.initElements(driver, VideoPage.class));
		String fileName = driver.getCurrentUrl().substring(driver.getCurrentUrl().lastIndexOf(":") + 1).replace("_"," ");
		Assert.assertTrue(videoPage.fileNameEquals(fileName));
	}
	
	@BeforeClass
	public void setUp(){
		// Create a new instance of a driver
        driver = new FirefoxDriver();

        // Navigate to the test homepage
        driver.get(WIKIA_MAIN_URL);

        // Login to website before running any tests
        wikiaLoginPage = PageFactory.initElements(driver, LoginPage.class);
        wikiaLoginPage.hoverLoginLabel();
		wikiaHomePage = wikiaLoginPage.loginAs(USERNAME, PASSWORD, PageFactory.initElements(driver, HomePage.class));
		
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
