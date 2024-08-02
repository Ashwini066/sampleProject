package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.RegisterAPatientPageClass;
import retryAnalyzer.RetryAnalyzer;
import utilities.ExplicitWaitClass;

public class RegisterAPatientTestClass extends BaseClass{
	LoginPageClass lpc;
	HomePageClass hpc;
	RegisterAPatientPageClass  rpc;
	ExplicitWaitClass ewait= new ExplicitWaitClass();
	
	
	 @Test(retryAnalyzer = RetryAnalyzer.class)
	
	public void verifyToRegisterPatient() throws InterruptedException, IOException
	{
		lpc=new LoginPageClass(driver);
		hpc=new HomePageClass(driver);
		rpc= new RegisterAPatientPageClass(driver);
		lpc.loginPage(lpc.readStringData(1, 0),lpc.readStringData(1, 1));
		
		hpc.clickOnRegisterAPagebutton();
		rpc.patientDemographicDetails(lpc.readStringData(14, 0), lpc.readStringData(14, 1),lpc.readStringData(14, 2) ,
				lpc.readIntegerData(14, 3),lpc.readStringData(14, 4),lpc.readIntegerData(14, 5));
		rpc.patientContactInfo(lpc.readStringData(15, 0),lpc.readIntegerData(15, 1));
		rpc.relationshipWithPatient(lpc.readStringData(16, 0),lpc.readStringData(16, 1));
		
		String actual_registeredPatientName=rpc.registeredPatientName();
		//System.out.println(actual_registeredPatientName);
		//String expected_registeredPatientName="12PatientGName";
		//System.out.println(expected_registeredPatientName);
		Assert.assertEquals(actual_registeredPatientName, lpc.readStringData(17, 0),"Patient registration Failed");
		
		
		
	}
	

}
