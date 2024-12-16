package basicFramework;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class RunnerScript1 extends BasePage
{
	@Test
	public void Test11()
	
	{
		System.out.println("Testcase From different class");
		Assert.fail();
	}
	
}
