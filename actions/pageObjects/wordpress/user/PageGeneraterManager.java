package pageObjects.wordpress.user;

import org.openqa.selenium.WebDriver;

public class PageGeneraterManager {

	public static UserLoginPO getUserLoginPage(WebDriver driver) {
		return new UserLoginPO(driver);
	}

	public static UserHomePO getUserHomePage(WebDriver driver) {
		return new UserHomePO(driver);
	}

	public static UserPostSearchPO getUserPostSearchPage(WebDriver driver) {
		return new UserPostSearchPO(driver);
	}

}
