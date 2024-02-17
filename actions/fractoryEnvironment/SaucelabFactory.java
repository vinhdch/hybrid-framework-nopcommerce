package fractoryEnvironment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import commons.GlobalConstants;

public class SaucelabFactory {

	private WebDriver webDriver;
	private String osName;
	private String browserName;

	public SaucelabFactory(String browserName, String osName) {
		this.osName = osName;
		this.browserName = browserName;
	}

	public WebDriver createDriver() {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", browserName);
		caps.setCapability("platformName", osName);
		caps.setCapability("browserVersion", "latest");
		caps.setCapability("name", "Run on:" + osName + browserName);
		Map<String, Object> sauceOptions = new HashMap<>();
		caps.setCapability("sauce:options", sauceOptions);

		try {
			webDriver = new RemoteWebDriver(new URL(GlobalConstants.SAUCELAB_URL), caps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return webDriver;
	}
}
