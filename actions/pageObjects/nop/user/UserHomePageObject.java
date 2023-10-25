package pageObjects.nop.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUIs.nop.user.HomePageUI;

public class UserHomePageObject extends BasePage {
	private WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserRegisterPageObject clickToRegisterLink() {
		waitForElementsClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return new PageGeneraterManager().getUserRegisterPageObject(driver);
	}

	public UserLoginPageObject clickTologinLink() {
		waitForElementsClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return new PageGeneraterManager().getUserLoginPageObject(driver);

	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	public UserCustomerInforPageObject clickToMyAccountLink() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return new PageGeneraterManager().getUserCustomerInforPageObject(driver);
	}

}
