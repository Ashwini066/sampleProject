package pageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;


public class RegisterAPatientPageClass{
	
	WebDriver driver;
	LoginPageClass lpc;
	HomePageClass hpc;
	GeneralUtilities generalUtilityObj=new GeneralUtilities();
	ExplicitWaitClass ewait= new ExplicitWaitClass();
	

	@FindBy (name="givenName") WebElement patientGivenName;
	@FindBy (name="familyName") WebElement patientFamilyName;
	@FindBy (name="gender") WebElement patientGender;
	//@FindBy (name="birthdateYears") WebElement patientDOBEstimatedYears;
	//@FindBy (name="birthdateMonths") WebElement patientDOBEstimatedMonths;
	@FindBy (name="birthdateDay") WebElement DayOfBirth;
	@FindBy (name="birthdateMonth") WebElement MonthOfBirth;
	@FindBy (name="birthdateYear") WebElement YearOfBirth;
	
	
	@FindBy (id="address1") WebElement patientAddress1;
	@FindBy (name="phoneNumber") WebElement patientPhoneNumber;
	@FindBy (id="relationship_type") WebElement relationshipDp;
	@FindBy (id="next-button") WebElement nextButton;
	//@FindBy (name="confirm right") WebElement enterButton;
	@FindBy (xpath="//input[@placeholder='Person Name']") WebElement relationPersonName;
	@FindBy (id="submit") WebElement confirmButton;
	@FindBy (id="cancelSubmission") WebElement CancelButton;
	@FindBy (className="PersonName-givenName") WebElement registeredPatientGivenName;
	@FindBy (name="PersonName-familyName") WebElement registeredPatientFamilyName;
	
	
	public RegisterAPatientPageClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void patientDemographicDetails(String gname,String fname,String gender,String date,String month, String year)
	{
		generalUtilityObj.typeOnElement(patientGivenName, gname );
		generalUtilityObj.typeOnElement(patientFamilyName, fname);
		ewait.visibitlityOfElementWait(driver, nextButton);
		generalUtilityObj.clickUsingJavaScriptExecutor(driver, nextButton);
		
		ewait.visibitlityOfElementWait(driver, patientGender);
		generalUtilityObj.selectFromDropDownByVisibleText(patientGender,gender);
		generalUtilityObj.clickUsingJavaScriptExecutor(driver, nextButton);
		
		
		ewait.visibitlityOfElementWait(driver, DayOfBirth);
		generalUtilityObj.typeOnElement(DayOfBirth, date);
		generalUtilityObj.selectFromDropDownByVisibleText(MonthOfBirth, month);
		ewait.visibitlityOfElementWait(driver, YearOfBirth);
		generalUtilityObj.typeOnElement(YearOfBirth, year);
		generalUtilityObj.clickUsingJavaScriptExecutor(driver, nextButton);
		
	}
	
	public void patientContactInfo(String address1,String phoneNumber) {
	    
	    generalUtilityObj.typeOnElement(patientAddress1, address1);
	    generalUtilityObj.clickUsingJavaScriptExecutor(driver, nextButton);
	    ewait.visibitlityOfElementWait(driver, patientPhoneNumber);
	    generalUtilityObj.typeOnElement(patientPhoneNumber, phoneNumber);
	    generalUtilityObj.clickUsingJavaScriptExecutor(driver, nextButton);

	}
	
	public void relationshipWithPatient(String relationship, String personName) {
	    
	    generalUtilityObj.selectFromDropDownByVisibleText(relationshipDp,relationship);
	    ewait.visibitlityOfElementWait(driver, relationPersonName);
	    generalUtilityObj.typeOnElement(relationPersonName, personName);
	    generalUtilityObj.clickUsingJavaScriptExecutor(driver, nextButton);
	    ewait.elementToBeClickableByWebElement(driver, confirmButton);
	    generalUtilityObj.clickAnElementUsingSendKeys(driver, confirmButton);

	}

	
	public String registeredPatientName()
	{
		ewait.visibitlityOfElementWait(driver, registeredPatientGivenName);
		return generalUtilityObj.getTextOfElement(registeredPatientGivenName);
		
	}
	public String readStringData(int row, int column) throws IOException {
		return ExcelReadClass.readStringData(row, column);
		
	}
	
	public String readIntegerData(int row,int column) throws IOException
	{
		return ExcelReadClass.readIntegerData(row,column);
	}

}
