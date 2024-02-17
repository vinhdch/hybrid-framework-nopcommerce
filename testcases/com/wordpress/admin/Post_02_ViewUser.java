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
import pageObjects.wordpress.AdminDashboardPO;
import pageObjects.wordpress.AdminLoginPO;
import pageObjects.wordpress.AdminPostAddNewPO;
import pageObjects.wordpress.AdminPostCatagoriesPO;
import pageObjects.wordpress.AdminPostSearchPO;
import pageObjects.wordpress.AdminPostTagPO;
import pageObjects.wordpress.AdminUserPO;
import pageObjects.wordpress.PageGeneraterManager;
import pageObjects.wordpress.UserHomePO;
import pageObjects.wordpress.UserPostDetailsPO;

public class Post_02_ViewUser extends BaseTest {

	private WebDriver driverTestClass;
	AdminLoginPO adminLoginPO;
	AdminDashboardPO adminDashboardPO;
	AdminPostAddNewPO adminPostAddNewPO;
	AdminPostCatagoriesPO adminPostCatagoriesPO;
	AdminPostTagPO adminPostTagPO;
	AdminPostSearchPO adminPostSearchPO;
	UserHomePO userHomePO;
	UserPostDetailsPO userPostDetailsPO;
	AdminUserPO adminUserPO;

	String adminUrl, endUserUrl;
	String adminUsername = "automationfc";
	String adminPassword = "Hello121996@!";
	String searchPostUrl;
	int randomNumber = generateRandomNumber();
	String postTitle = "Live Coding Title " + randomNumber;
	String postBody = "Live Coding Body " + randomNumber;
	String editPostTitle = "Edit Live Coding Title " + randomNumber;
	String editPostBody = "Edit Live Coding Body " + randomNumber;
	String authorName = "automationfc";
	String currentDate = getToday();

	@Parameters({ "browser", "adminUrl", "endUserUrl" })
	@BeforeClass
	@Description("Create,read, update, delete Post")
	@Severity(SeverityLevel.NORMAL)
	public void beforeClass(String browserName, String adminUrl, String endUserUrl) {
		this.adminUrl = adminUrl;
		this.endUserUrl = endUserUrl;

		driverTestClass = getBrowserDriverUrl(browserName, this.adminUrl);

		adminLoginPO = PageGeneraterManager.getAdminLoginPage(driverTestClass);

		adminLoginPO.enterToUserNameTextbox(adminUsername);
		adminLoginPO.enterToPasswordTextbox(adminPassword);

		adminDashboardPO = adminLoginPO.clickToLoginButton();

	}

	@Test
	public void TC01_View_user() {
		adminUserPO = adminDashboardPO.clickUserMenuLink();

		int totalNumberUserOnGUI = adminUserPO.getUserNumber();

		int totalNumberUserOnDB = adminUserPO.getNumberUserDB();

		verifyEquals(totalNumberUserOnGUI, totalNumberUserOnDB);

		adminUserPO.checkTotalRecordMemorySizeFromDB("computer", "20", "roleAdmin");
	}

	@AfterClass(alwaysRun = true)
	protected void afterClass() {
		closeBrowserDriver();
	}

}
