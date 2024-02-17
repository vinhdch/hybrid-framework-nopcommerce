package factoryBrowser;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager implements BrowserFactory {

	@Override
	public WebDriver getBrowserDriver() {
		WebDriverManager.chromedriver().setup();

		// disable consolve log
		System.setProperty("webdriver.chrome.args", "--disable-logging");
		System.setProperty("webdriver,chrome.slientOutput", "true");

		// add extension to chrome
		File file = new File(GlobalConstants.PROJECT_PATH + "\\browserExtension\\google_translate.crx");

		ChromeOptions options = new ChromeOptions();

		// skip secure option
		options.setAcceptInsecureCerts(true);

		// config language of browser
		// options.addArguments("--lang=vi");

		// config noti of browser
		options.addArguments("--disable-notifications");

		// config turn off auto line during running
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

		// choose folder to save downloaded files
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_settings,popups", 0);
		prefs.put("download.default_directory", GlobalConstants.PROJECT_PATH + "\\downloadFiles");
		options.setExperimentalOption("prefs", prefs);

		options.addExtensions(file);

		// run as igcognito
		// options.addArguments("--igcognito");

		return new ChromeDriver(options);
	}

}
