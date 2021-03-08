package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffHomePage {

	public WebDriver driver;
	
	public RediffHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By text=By.xpath("//input[@name='q']");
	

    public WebElement gettext()
    {
    	return driver.findElement(text);
    }
        













}
