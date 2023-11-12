package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

import exception.BrowserNotSupport;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private WebDriver driverBaseTest;

	public WebDriver getDriver() {
		return driverBaseTest;
	}

	protected WebDriver getBrowserDriver(String browserName) {
		System.out.println("Run on " + browserName);
		if (browserName.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driverBaseTest = new FirefoxDriver();

		} else if (browserName.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driverBaseTest = new ChromeDriver();

		} else if (browserName.equals("edge")) {

			WebDriverManager.edgedriver().setup();
			driverBaseTest = new EdgeDriver();

		} else if (browserName.equals("headChrome")) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();

			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");

			driverBaseTest = new ChromeDriver(options);

		} else if (browserName.equals("edge")) {

			WebDriverManager.edgedriver().setup();
			driverBaseTest = new EdgeDriver();

		} else {
			throw new BrowserNotSupport(browserName);
		}
		driverBaseTest.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driverBaseTest.manage().window().maximize();
		driverBaseTest.get(GlobalConstants.PORTAL_PAGE_URL);
		return driverBaseTest;
	}

	protected WebDriver getBrowserDriverDataTable(String browserName, String url) {

		System.out.println("Run on " + browserName);

		if (browserName.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driverBaseTest = new FirefoxDriver();

		} else if (browserName.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driverBaseTest = new ChromeDriver();

		} else if (browserName.equals("edge")) {

			WebDriverManager.edgedriver().setup();
			driverBaseTest = new EdgeDriver();

		} else if (browserName.equals("headChrome")) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();

			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");

			driverBaseTest = new ChromeDriver(options);

		} else if (browserName.equals("edge")) {

			WebDriverManager.edgedriver().setup();
			driverBaseTest = new EdgeDriver();

		} else {
			throw new BrowserNotSupport(browserName);
		}

		driverBaseTest.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);

		driverBaseTest.manage().window().maximize();

		driverBaseTest.get(url);

		return driverBaseTest;
	}

	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {

			Assert.assertTrue(condition);
		} catch (Throwable e) {

			pass = false;

			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {

			Assert.assertFalse(condition);
		} catch (Throwable e) {

			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);

		} catch (Throwable e) {

			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

}
