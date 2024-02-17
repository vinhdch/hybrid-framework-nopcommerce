package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserDataMapper;

import commons.BaseTest;
import commons.PageGeneraterManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.nop.user.UserHomePageObject;
import pageObjects.nop.user.UserRegisterPageObject;

public class Level_22_Grid extends BaseTest {

	private WebDriver driverTestClass;

	private String email;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	UserDataMapper userDataMapper;

	@Parameters({ "envName", "url", "browserName", "osName", "osVersion", "ipAddress", "port" })
	@BeforeClass
	protected void beforeClass(@Optional("grid") String envName, @Optional("dev") String url, @Optional("chrome") String browserName, @Optional("Windows") String osName, @Optional("10") String osVersion,
			@Optional("localhost") String ipAddress, @Optional("4444") String port) {

		driverTestClass = getBrowserDriver(envName, url, browserName, osName, osVersion, ipAddress, port);

		homePage = PageGeneraterManager.getUserHomePageObject(driverTestClass);

		userDataMapper = UserDataMapper.getUserData();

		email = userDataMapper.getEmailAddress() + generateRandomNumber() + "@fakeemail.com";

	}

	@Description("Register account")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void User_01_Register() {

		registerPage = homePage.clickToRegisterLink();

		// registerPage.inputToFirstnameTextbox(firstName);
		// call test data directly from other class
		registerPage.inputToTextboxById(driverTestClass, "FirstName", userDataMapper.getFirstName());

		Assert.assertEquals(registerPage.getTextboxValueById(driverTestClass, "FirstName"), userDataMapper.getFirstName());

		// registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToTextboxById(driverTestClass, "LastName", userDataMapper.getLastName());

		Assert.assertEquals(registerPage.getTextboxValueById(driverTestClass, "LastName"), userDataMapper.getLastName());

		// registerPage.inputToEmailTextbox(email);
		registerPage.inputToTextboxById(driverTestClass, "Email", email);

		// registerPage.inputToPasswordTextbox(password);
		registerPage.inputToTextboxById(driverTestClass, "Password", userDataMapper.getPassword());

		// registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.inputToTextboxById(driverTestClass, "ConfirmPassword", userDataMapper.getPassword());

		// registerPage.clickToRegisterButton();
		registerPage.clickToButtonByText(driverTestClass, "Register");

		Assert.assertEquals(registerPage.getRegisterSuccessfulMessage(), "Your registration completed");
	}

	protected int generateRandomEmail() {
		Random rand = new Random();

		return rand.nextInt(99999);
	}

	@AfterClass
	protected void afterClass() {
		closeBrowserDriver();
	}

}
