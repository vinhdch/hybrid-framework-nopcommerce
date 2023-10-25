package pageObjects.nop.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUIs.nop.user.LoginPageUI;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserHomePageObject clickToLoginButton() {
		waitForElementsClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return new PageGeneraterManager().getUserHomePageObject(driver);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public void inputToEmailTextbox(String validEmail) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, validEmail);

	}

	public String getErrorMessageUnsuccessful() {
		waitForElementVisible(driver, LoginPageUI.UNSUCCESSFUL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.UNSUCCESSFUL_ERROR_MESSAGE);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public UserHomePageObject loginAsUser(String validEmail, String password) {
		inputToEmailTextbox(validEmail);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
	}

}
