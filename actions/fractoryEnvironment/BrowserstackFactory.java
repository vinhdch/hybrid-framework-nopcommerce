package fractoryEnvironment;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import commons.GlobalConstants;

public class BrowserstackFactory {

	private WebDriver webDriver;
	private String osName;
	private String osVersion;
	private String browserName;

	public BrowserstackFactory(String browserName, String osName, String osVersion) {
		this.browserName = browserName;
		this.osName = osName;
		this.osVersion = osVersion;
	}

	public WebDriver createDriver() {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browser", browserName);
		caps.setCapability("os", osName);
		caps.setCapability("os_version", osVersion);
		caps.setCapability("browser_version", "latest");
		caps.setCapability("browserstack.console", "info");
		caps.setCapability("project", "Nopcommerce");
		caps.setCapability("name", "win10Chomev121");
		caps.setCapability("browserstack.debug", "true");
		try {
			webDriver = new RemoteWebDriver(new URL(GlobalConstants.BROWSER_STACK_URL), caps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return webDriver;
	}
}
