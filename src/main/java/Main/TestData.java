package Main;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name="Inputdata")
	public Object[][] getData()
	{
		Object[][] obj=new Object[2][2];
				{
			obj[0][0]="fghf@gmail.com";
			obj[0][1]="dd45";
			
			obj[1][0]="fghf@gmail.com";
			obj[1][1]="dd45";
				}
				return obj;
	}
	

}
