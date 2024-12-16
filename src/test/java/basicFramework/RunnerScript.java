package basicFramework;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RunnerScript extends BasePage
{
	@Test
	public void Test1()
	{
		driver.findElement(By.id("email")).sendKeys("admin");

		driver.findElement(By.id("pass")).sendKeys("admin");
		driver.findElement(By.name("login")).click();
	
	}
	@Test
	public void Test2()
	{
		System.out.println(driver.getTitle());
//		Assert.fail();
	}
	@Test
	public void Test3()
	{
		System.out.println(driver.getCurrentUrl());
	}
	
}
