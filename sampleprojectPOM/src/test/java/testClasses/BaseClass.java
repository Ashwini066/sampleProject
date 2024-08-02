package testClasses;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import utilities.Screenshot;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	WebDriver driver;
	Screenshot sh;
	public static Properties property;

	public static void readProperty() throws IOException { // to read the contents of config.properties file
		property = new Properties(); /* instantiating Properties class */
		FileInputStream f = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties"); // user.dir->project
																								// path//
		property.load(f);

	}
	
	@BeforeSuite(alwaysRun = true)
	  public void createReport(final ITestContext testContext) {
			extentReport.ExtentManager.createInstance().createTest(testContext.getName(), "message");
		}

	@Parameters({ "browser" })
	@BeforeMethod(groups = { "launch" })
	public void beforeMethod(String bValue) throws IOException {
		readProperty();
		if (bValue.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (bValue.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		sh = new Screenshot();
		driver.get(property.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
	}

	@AfterMethod(groups = { "close" })
	public void afterMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			sh.takeScreenshot(driver, result.getName());
		}

		driver.quit();
	}

}
