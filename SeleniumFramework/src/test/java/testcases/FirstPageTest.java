package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;

public class FirstPageTest extends TestBase {

	@Test
	public void titleTest() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Swag Labs");
		System.out.println("titleTest Passed");

	}

}
