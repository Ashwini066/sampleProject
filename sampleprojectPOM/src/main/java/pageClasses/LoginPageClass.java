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

public class LoginPageClass {
	WebDriver driver;
	GeneralUtilities generalUtilityObj = new GeneralUtilities();
	ExplicitWaitClass ewait = new ExplicitWaitClass();
	

	public LoginPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	WebElement userNameText;
	@FindBy(id = "password")
	WebElement passwordText;
	@FindBy(id = "Registration Desk")
	WebElement registrationDesk;
	@FindBy(id = "loginButton")
	WebElement loginButton;
	@FindBy(xpath = "//div[@id='error-message']")
	WebElement InvalidCreds;
	@FindBy(xpath = "//img[@src='/openmrs/ms/uiframework/resource/referenceapplication/images/openMrsLogo.png']")
	WebElement pageLogo;

	@FindBy(xpath = "//ul[@id='sessionLocation']//child::li")
	List<WebElement> allLocationSessions;

	public void loginPage(String username, String password) {
		generalUtilityObj.typeOnElement(userNameText, username);
		generalUtilityObj.typeOnElement(passwordText, password);
		ewait.elementToBeClickableByWebElement(driver, registrationDesk);
		generalUtilityObj.clickOnElement(registrationDesk);
		ewait.elementToBeClickableByWebElement(driver, loginButton);
		generalUtilityObj.clickOnElement(loginButton);

	}

	public String InvalidCredentailsMessage() {
		return generalUtilityObj.getTextOfElement(InvalidCreds);
	}

	public boolean isLogoDisplayed() {
		return generalUtilityObj.isElementDisplayed(pageLogo);
	}

	public String getTitleOfPage() {
		return generalUtilityObj.getTitleOfPage(driver);
	}

	public boolean AllLocationSessionsIsDisplayed() // check
	{

		for (WebElement element : allLocationSessions) {
			generalUtilityObj.isElementDisplayed(element);
			return true;

		}
		return false;

	}

	public String readStringData(int row, int column) throws IOException {
		return ExcelReadClass.readStringData(row, column);
		
	}
	
	public String readIntegerData(int row,int column) throws IOException
	{
		return ExcelReadClass.readIntegerData(row,column);
	}
}
