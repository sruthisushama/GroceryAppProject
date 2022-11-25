package testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.ScreenShotCapture;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {

	WebDriver driver;
	ScreenShotCapture scr;
	public static Properties ps;
	
	public static void testBasic() throws IOException {
		ps=new Properties();
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\Properties\\Config.properties");
		ps.load(file);
	}
	@BeforeMethod(alwaysRun = true)
	@Parameters("Browser")
	public void beforeMethod(@Optional("Chrome") String browserName) throws IOException {
		testBasic();
		if (browserName.equals("Chrome")) {
			System.setProperty(ps.getProperty("ChromeDriver"),
					System.getProperty("user.dir") + ps.getProperty("ChromeDriverPath"));
			driver = new ChromeDriver();
		}

		else if (browserName.equals("Firefox")) {
			System.setProperty(ps.getProperty("FirefoxDriver"),
					System.getProperty("user.dir") + ps.getProperty("FirefoxDriverPath"));
			driver = new FirefoxDriver();
		}

		driver.get(ps.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod (alwaysRun = true)
	public void afterMethod(ITestResult itestResult) throws IOException {

		if (itestResult.getStatus() == ITestResult.FAILURE) {
			scr = new ScreenShotCapture();
			scr.captureScreenShot(driver, itestResult.getName());
		}

		driver.close();
	}

}
