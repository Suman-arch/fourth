package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Main.Base;
import pageObjects.RediffHomePage;

public class RediffPageTest extends Base{
	
      WebDriver driver;
      
      public static Logger log=LogManager.getLogger(RediffPageTest.class.getName());
      
      @BeforeTest
      public void startup() throws IOException
      {
   	driver=Capabilities();
   	log.info("driver is initialized");
  		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
  		log.info("waiting for 20 seconds in each operation");
  		
      }
      
	
    @Test   
	public void start() throws IOException
	{
    	driver.get(props.getProperty("url1"));
     	log.info("getting the url of redifftest");
    	 RediffHomePage p=new RediffHomePage(driver);
		p.gettext().sendKeys("bollywood songs 2021 ");
		p.gettext().sendKeys(Keys.ENTER);
		
	}
    
    @AfterTest
    public void teardown()
    {
    	driver.close();
    	    }

}
