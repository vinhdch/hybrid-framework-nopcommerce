package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.wordpress.admin.AdminDashboardPageUI;

public class AdminDashboardPO extends BasePage {

	WebDriver driver;

	public AdminDashboardPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostSearchPO clickToPostMenuLink() {
		waitForElementsClickable(driver, AdminDashboardPageUI.POST_MENU_LINK);
		clickToElement(driver, AdminDashboardPageUI.POST_MENU_LINK);
		return PageGeneraterManager.getAdminPostSearchPage(driver);
	}
}
