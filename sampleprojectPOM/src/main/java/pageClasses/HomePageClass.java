package pageClasses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class HomePageClass {

	WebDriver driver;
	GeneralUtilities generalUtilityObj=new GeneralUtilities();
	ExplicitWaitClass ewait=new ExplicitWaitClass();
	
	
	@FindBy(xpath= "//div[@id='content']//child::h4") WebElement loggedInUserName;
	@FindBy( xpath="//a[@type='button']")  List <WebElement> getAllTilesInHomePage;
	@FindBy (xpath="//a[@href='/openmrs/registrationapp/registerPatient.page?appId=referenceapplication.registrationapp.registerPatient']")
	WebElement registerAPatientTile;
	
	public HomePageClass(WebDriver driver)
	
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	
	public String getLoggedInUser()
	{
		return 	 generalUtilityObj.getTextOfElement(loggedInUserName);
	}
	
	public boolean verifyAllTileInHomePage()      //check
	{

		for (WebElement element: getAllTilesInHomePage)
		{
			generalUtilityObj.isElementDisplayed(element);
			return true;
		}
		return false;
		
	}
	
	public void clickOnRegisterAPagebutton()
	{
		ewait.elementToBeClickableByWebElement(driver, registerAPatientTile);
		generalUtilityObj.clickAnElementUsingSendKeys(driver, registerAPatientTile);
		
	}
	public String readStringData(int row, int column) throws IOException {
		return ExcelReadClass.readStringData(row, column);
		
	}
	
	public String readIntegerData(int row,int column) throws IOException
	{
		return ExcelReadClass.readIntegerData(row,column);
	}
	}
	

