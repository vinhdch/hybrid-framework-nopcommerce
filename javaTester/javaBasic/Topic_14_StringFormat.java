package javaBasic;

public class Topic_14_StringFormat {

	public static String ADDRESS_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='Addresses']";
	public static String CUSTOMER_INFOR_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='Customer info']";

	public static String DYNAMIC_ADDRESS_LINK = "xpath=//div[contains(@class,'%s')]//a[text()='%s";

	public static void clickToSideBarLink(String dynamicLocator, String... params) {
		String locatorString = String.format(dynamicLocator, (Object[]) params);

	}

	public static void main(String[] args) {

		clickToSideBarLink(DYNAMIC_ADDRESS_LINK, "block-account-navigation", "Addresses");
	}
}
