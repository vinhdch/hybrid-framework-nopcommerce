package com.wordpress.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.wordpress.admin.AdminDashboardPO;
import pageObjects.wordpress.admin.AdminLoginPO;
import pageObjects.wordpress.admin.AdminPostAddNewPO;
import pageObjects.wordpress.admin.AdminPostCatagoriesPO;
import pageObjects.wordpress.admin.AdminPostSearchPO;
import pageObjects.wordpress.admin.AdminPostTagPO;
import pageObjects.wordpress.admin.PageGeneraterManager;

public class Post_01_Create_Read_Update_Search extends BaseTest {

	private WebDriver driverTestClass;
	AdminLoginPO adminLoginPO;
	AdminDashboardPO adminDashboardPO;
	AdminPostAddNewPO adminPostAddNewPO;
	AdminPostCatagoriesPO adminPostCatagoriesPO;
	AdminPostTagPO adminPostTagPO;
	AdminPostSearchPO adminPostSearchPO;
	String adminUsername = "automationfc";
	String adminPassword = "Hello121996@!";
	String searchPostUrl;
	int randomNumber = generateRandomNumber();
	String postTitle = "Live Coding Title " + randomNumber;
	String postBody = "Live Coding Body " + randomNumber;

	@Parameters({ "browser", "urlAdmin" })
	@BeforeClass
	@Description("Create,read, update, delete Post")
	@Severity(SeverityLevel.NORMAL)
	public void beforeClass(String browserName, String urlAdmin) {
		driverTestClass = getBrowserDriverUrl(browserName, urlAdmin);

		adminLoginPO = PageGeneraterManager.getAdminLoginPage(driverTestClass);

		adminLoginPO.enterToUserNameTextbox(adminUsername);
		adminLoginPO.enterToPasswordTextbox(adminPassword);

		adminDashboardPO = adminLoginPO.clickToLoginButton();

	}

	@Test
	public void TC01_Create_Post() {

		adminPostSearchPO = adminDashboardPO.clickToPostMenuLink();

		searchPostUrl = adminPostSearchPO.getPageUrl(driverTestClass);

		adminPostAddNewPO = adminPostSearchPO.clickToAddNewButton();

		adminPostAddNewPO.enterPostTitle(postTitle);
		adminPostAddNewPO.enterPostBody(postBody);

		adminPostAddNewPO.clickToPublishButton();
		adminPostAddNewPO.clickToPrePublishButton();

		verifyTrue(adminPostAddNewPO.isPostPublishMessageDisplayed("Post published."));
	}

	@Test
	public void TC01_Read_Post() {

		adminPostSearchPO = adminPostAddNewPO.openSearchPostPageUrl(searchPostUrl);
	}

	@Test
	public void TC01_Update_Post() {

	}

	@Test
	public void TC01_Delete_Post() {

	}

	@AfterClass(alwaysRun = true)
	protected void afterClass() {
		closeBrowserDriver();
	}

}
