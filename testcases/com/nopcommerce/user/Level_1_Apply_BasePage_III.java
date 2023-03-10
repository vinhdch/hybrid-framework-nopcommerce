package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_1_Apply_BasePage_III extends BasePage {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("https://demo.nopcommerce.com/");

		emailAddress = "vinh" + generateRandomEmail() + "@gmail.com";

	}

	@Test
	public void TC_01_Register_with_empty_data() {

		waitForAllElementsClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		waitForAllElementsClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
	}

	@Test
	public void TC_02_Register_with_invalid_email() {
		waitForAllElementsClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		sendkeyToElement(driver, "//input[@id='FirstName']", "vinh1234");
		sendkeyToElement(driver, "//input[@id='LastName']", "dong");
		sendkeyToElement(driver, "//input[@id='Email']", "vinh123");
		sendkeyToElement(driver, "//input[@id='Password']", "vinh1234@!");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "vinh1234@!");

		waitForAllElementsClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
	}

	@Test
	public void TC_03_Register_success() {

		waitForAllElementsClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		sendkeyToElement(driver, "//input[@id='FirstName']", "vinh1234");
		sendkeyToElement(driver, "//input[@id='LastName']", "dong");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", "vinh1234@!");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "vinh1234@!");

		waitForAllElementsClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");

		// basePage.waitForAllElementsClickable(driver, "//a[@class='ico-logout']");
		// basePage.clickToElement(driver, "//a[@class='ico-logout']");

	}

	@Test
	public void TC_04_Register_with_exist_email() {

		waitForAllElementsClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		sendkeyToElement(driver, "//input[@id='FirstName']", "vinh1234");
		sendkeyToElement(driver, "//input[@id='LastName']", "dong");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", "vinh1234@!");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "vinh1234@!");

		waitForAllElementsClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//div[contains(@class,'message-error')]//li"), "The specified email already exists");

	}

	@Test
	public void TC_05_Register_with_pw_less_than_6chars() {
		waitForAllElementsClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		sendkeyToElement(driver, "//input[@id='FirstName']", "vinh1234");
		sendkeyToElement(driver, "//input[@id='LastName']", "dong");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", "vin");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "vin");

		waitForAllElementsClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void TC_06_Register_with_invalid_confirm_pw() {

		waitForAllElementsClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		sendkeyToElement(driver, "//input[@id='FirstName']", "vinh1234");
		sendkeyToElement(driver, "//input[@id='LastName']", "dong");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", "vin");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "vin567");

		waitForAllElementsClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

	public int generateRandomEmail() {
		Random rand = new Random();

		return rand.nextInt(99999);
	}
}
