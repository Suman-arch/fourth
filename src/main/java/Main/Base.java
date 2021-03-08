package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public  WebDriver driver;
	public  Properties props;
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\target\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;


	}
	public WebDriver Capabilities() throws IOException
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Global.properties");
		props=new Properties();
		props.load(fis);
		String browsername=props.getProperty("browser");
		//String browsername=System.getProperty("browser");
		if(browsername.equalsIgnoreCase("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		else
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		return driver;
		
	}
	
}
