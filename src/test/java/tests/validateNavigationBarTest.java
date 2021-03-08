package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Main.Base;
import pageObjects.LandingPage;


public class validateNavigationBarTest extends Base {
	public WebDriver driver;

	public static Logger log = LogManager.getLogger(validateNavigationBarTest.class.getName());

	@BeforeTest

	public void initialize() throws IOException {

		driver = Capabilities();

		driver.get(props.getProperty("url"));
	}

	@Test

	public void validateAppNavBar() throws IOException {

		// one is inheritance
		// creating object to that class and invoke methods of it
		LandingPage l = new LandingPage(driver);

		// compare the text from the browser with actual text.- Error..
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		log.info("Navigation Bar is displayed of navbartest");
		System.out.println("Test completed");
		// Assert.assertFalse(false);
		;

	}

	@AfterTest
	public void teardown() {

		driver.close();

	}

}
