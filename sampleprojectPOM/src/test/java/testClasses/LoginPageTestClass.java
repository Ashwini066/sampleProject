package testClasses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import retryAnalyzer.RetryAnalyzer;



public class LoginPageTestClass extends BaseClass{
	LoginPageClass lpc;
	HomePageClass hpc;
	
	
	
  @Test(groups = {"Login"},retryAnalyzer = RetryAnalyzer.class)
  public void verifySuccessfulLogin() throws IOException {
	  lpc=new LoginPageClass(driver);
	  lpc.loginPage(lpc.readStringData(1, 0),lpc.readStringData(1, 1));
	  hpc=new HomePageClass(driver);
	  String actualUserName=hpc.getLoggedInUser();
	  Assert.assertEquals(actualUserName, lpc.readStringData(2, 0));
	  
	  
 
  }
  
  @Test(dataProviderClass = DataProviderClass.class, dataProvider = "UnsucessfulLogin",groups = {"Login"},retryAnalyzer = RetryAnalyzer.class)
  public void verifyUnSuccessfulLogin(String uname, String pwd) throws IOException {
	  lpc=new LoginPageClass(driver);
	  //lpc.loginPage(lpc.readStringData(4, 0),lpc.readStringData(4, 1));
	  //hpc=new HomePageClass(driver);
	  //String expected_text="Invalid username/password. Please try again.";
	  lpc.loginPage(uname, pwd);
	  String actual_text=lpc.InvalidCredentailsMessage();
	  Assert.assertEquals(actual_text, lpc.readStringData(5, 0));
	  
	  
 
  }
  
  @Test(groups = { "launch" },retryAnalyzer = RetryAnalyzer.class)
  public void verifyLogoIsDiaplayed()
  {
	  lpc=new LoginPageClass(driver);
	  Assert.assertTrue(lpc.isLogoDisplayed());
	  
  }
  
	
  @Test
  public void verifyTheExpectedPageisOpensWhileHittingTheUrl() throws IOException{
	  lpc=new LoginPageClass(driver);
	  //String expected_title="Login";
	  String actual_title=lpc.getTitleOfPage();
	  Assert.assertEquals(actual_title, lpc.readStringData(10, 0));
	  
	  
	  
  }
  
  
  @Test(groups = {"CheckDisplay" },retryAnalyzer = RetryAnalyzer.class)
  public void verifyAllLocationSessionsAreDisplayedOrNotInLoginPage()
  {
	  lpc=new LoginPageClass(driver);
	  Boolean result=lpc.AllLocationSessionsIsDisplayed();
	  Assert.assertTrue(result);
	  
  }
  
  
  
  
  
}
