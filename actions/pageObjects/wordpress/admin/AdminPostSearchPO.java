package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.wordpress.admin.AdminPostSearchPageUI;

public class AdminPostSearchPO extends BasePage {
	WebDriver driver;

	public AdminPostSearchPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostAddNewPO clickToAddNewButton() {
		waitForElementsClickable(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		return PageGeneraterManager.getAdminPostAddNewPage(driver);

	}

}
