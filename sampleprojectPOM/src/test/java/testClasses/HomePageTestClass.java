package testClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.LoginPageClass;
import retryAnalyzer.RetryAnalyzer;
import pageClasses.HomePageClass;

public class HomePageTestClass extends BaseClass{
	LoginPageClass lpc;
	HomePageClass hpc;

	
	
 @Test(groups = {"CheckDisplay" },retryAnalyzer = RetryAnalyzer.class)

public void verifyAllTileIsDisplayedInHomePage()
{
	lpc=new LoginPageClass(driver);
	hpc= new HomePageClass(driver);
	lpc.loginPage("Admin", "Admin123");
	Boolean result= hpc.verifyAllTileInHomePage();
	Assert.assertTrue(result);
}
 
 
 @Test(retryAnalyzer = RetryAnalyzer.class)
	
public void clickOnRegisterATile()

{
		lpc=new LoginPageClass(driver);
		hpc= new HomePageClass(driver);
		lpc.loginPage("Admin", "Admin123"); 
		hpc.clickOnRegisterAPagebutton();
}

	
}

