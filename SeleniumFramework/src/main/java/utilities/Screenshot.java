package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.TestBase;

public class Screenshot extends TestBase{

	public static String getScreenshotAsBase64() throws IOException {
		
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir")+"/Screenshots/image.png";

		FileUtils.copyFile(srcFile, new File(path));
		
		byte[] imageBytes = IOUtils.toByteArray(new FileInputStream(path));
		Base64.getEncoder().encode(imageBytes);
		return Base64.getEncoder().encodeToString(imageBytes);
		
	}
	

	public static String getBase64() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}

	

}