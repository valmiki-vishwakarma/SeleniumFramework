package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import utilities.ExtentManager;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExtentManager;
import utilities.Reader;

public class TestBase {

	public static WebDriver driver;
	public static String browser = Reader.readerValue("browser");
	
	//Extent Report
	public static ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;

	@BeforeSuite
	public void setUp() {
		if (driver == null) {

			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();

			} else if (browser.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new ChromeDriver();

			}

			else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			}

		}
		driver.manage().window().maximize();
		driver.get(Reader.readerValue("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(Reader.readerValue("implicit.wait"))));
		System.out.println("Browser configuration completed");

	}

	@AfterSuite
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}

	}
}
