package factoryBrowser;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriverManager implements BrowserFactory {

	@Override
	public WebDriver getBrowserDriver() {
		WebDriverManager.firefoxdriver().setup();

		// disable browser log
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, GlobalConstants.BROWSERLOG + "Firefox.Log");

		// add extension to firefox
		FirefoxProfile profile = new FirefoxProfile();
		File translateFile = new File(GlobalConstants.PROJECT_PATH + "\\browserExtension\\to_google_translate-4.2.0.xpi");
		profile.addExtension(translateFile);

		// ignore SSL crtificate (unstrust page)
		// profile.setAcceptUntrustedCertificates(true);
		// profile.setAssumeUntrustedCertificateIssuer(false);

		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(profile);

		options.addPreference("browser.download.folderList", 2);
		options.addPreference("browser.download.dir", GlobalConstants.DOWNLOAD_FILE);
		options.addPreference("browser.download.useDownloadDir", true);
		options.addPreference("browser.helperApps.neverAsk.saveToDisk",
				"multipart/x-zip,application/zip,application/x-zip-compressed,application/x-compressed,application/msword,application/csv,text/csv,image/jpeg,application/pdf,text/html,text/plain,application/excel,application/vnd.ms-excel,application/x-msexcel,application/octet-stream");
		options.addPreference("pdfjs.disabled", true);

		// run as igcognito
		// options.addArguments("-private");
		return new FirefoxDriver(options);
	}

}
