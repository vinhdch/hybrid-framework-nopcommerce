package fractoryEnvironment;

import org.openqa.selenium.WebDriver;

import exception.BrowserNotSupport;
import factoryBrowser.ChromeDriverManager;
import factoryBrowser.EdgeDriverManager;
import factoryBrowser.FirefoxDriverManager;
import factoryBrowser.HeadlessChromeDriverManager;
import factoryBrowser.HeadlessFirefoxDriverManager;

public class LocalFactory {

	private WebDriver webDriver;

	private String browserName;

	public LocalFactory(String browserName) {
		this.browserName = browserName;
	}

	public WebDriver createDriver() {

		if (browserName.equals("firefox")) {

			webDriver = new FirefoxDriverManager().getBrowserDriver();

		} else if (browserName.equals("chrome")) {

			webDriver = new ChromeDriverManager().getBrowserDriver();

		} else if (browserName.equals("edge")) {

			webDriver = new EdgeDriverManager().getBrowserDriver();

		} else if (browserName.equals("headChrome")) {

			webDriver = new HeadlessChromeDriverManager().getBrowserDriver();
		} else if (browserName.equals("headFirefox")) {

			webDriver = new HeadlessFirefoxDriverManager().getBrowserDriver();

		} else {
			throw new BrowserNotSupport(browserName);
		}
		return webDriver;
	}
}
