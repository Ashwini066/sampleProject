package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	
	public void takeScreenshot(WebDriver driver,String name) throws IOException
	{
		String folder_path="C:\\Users\\premc\\OneDrive\\Desktop\\Workspace\\sampleprojectPOM"+"\\Screenshot\\";
		File file= new File(folder_path);
		if(!file.exists())
		{
			file.mkdirs();
		}
		TakesScreenshot takescreenshot = (TakesScreenshot) driver;
		File screenshot_file= takescreenshot.getScreenshotAs(OutputType.FILE);
		
		
		String timestamp= new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		String destination_path= folder_path+name+timestamp+".png";
		File destinationFile=new File(destination_path);
		FileHandler.copy(screenshot_file, destinationFile);
	}
	

}
