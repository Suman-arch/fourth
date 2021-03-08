package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Main.Base;
import Main.TestData;
import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePageTest extends Base {
	public WebDriver driver;

	public static Logger log = LogManager.getLogger(HomePageTest.class.getName());

	@BeforeTest
	public void initialize() throws IOException {

		driver = Capabilities();
		log.info("driver is initialized");

	}

	@Test(dataProvider = "Inputdata", dataProviderClass = TestData.class)

	public void basePageNavigation(String Username, String Password) throws IOException {

		// one is inheritance

		// creating object to that class and invoke methods of it
		driver.get(props.getProperty("url"));
		log.info("getting the home page of homepagetest");
		LandingPage l = new LandingPage(driver);
		LoginPage lp = l.getLogin(); // driver.findElement(By.css()
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);

		

		lp.getLogin().click();
		ForgotPassword fp = lp.forgotPassword();
		fp.getEmail().sendKeys("xxx");
		fp.sendMeInstructions().click();

	}

	@AfterTest
	public void teardown() {

		driver.close();
		log.info("closing the driver");

	}

}