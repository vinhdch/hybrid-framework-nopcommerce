package fractoryEnvironment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import commons.GlobalConstants;

public class LambdaFactory {

	private WebDriver webDriver;
	private String osName;
	private String browserName;

	public LambdaFactory(String browserName, String osName) {
		this.browserName = browserName;
		this.osName = osName;
	}

	public WebDriver createDriver() {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", browserName);
		caps.setCapability("browserVersion", "latest");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		caps.setCapability("visual", true);
		caps.setCapability("video", true);
		caps.setCapability("platformName", osName);
		caps.setCapability("resolution", "1920x1080");
		caps.setCapability("LT:Options", ltOptions);

		try {
			webDriver = new RemoteWebDriver(new URL(GlobalConstants.LAMBDA_URL), caps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return webDriver;
	}

}
