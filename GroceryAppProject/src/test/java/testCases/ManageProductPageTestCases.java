package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.DashBoardPage;
import elementRepository.LoginPage;
import elementRepository.ManageProductPage;
import utilities.ExcelRead;

public class ManageProductPageTestCases extends BaseClass {

	LoginPage lp;
	DashBoardPage dp;
	ManageProductPage mp;
	ExcelRead read;

	@Test(enabled = true)
	public void testCase01VerifyTextSelectedOnCategoryDropDown() {

		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.clickSignInButton();

		dp = new DashBoardPage(driver);
		dp.clickManageProductLink();

		mp = new ManageProductPage(driver);
		mp.clickOnNewButton();
		mp.selectCategoryDropDown("Grocery & Staples");
		String actual = mp.getCategoryDropDownSelectedText();
		String expected = "Grocery & Staples";

		Assert.assertEquals(actual, expected, " : Selected text not expected : ");
	}

	@Test(enabled = false)
	public void testCase02VerifyPriceTypeRadioButtonIsSelected() {

		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.clickSignInButton();

		dp = new DashBoardPage(driver);
		dp.clickManageProductLink();

		mp = new ManageProductPage(driver);
		mp.clickOnNewButton();
		mp.selectPriceTypeRadioButton();
		boolean expected = true;
		boolean actual = mp.isSelectedPriceTypeRadioButton();

		Assert.assertEquals(actual, expected, " : Selected radio button not expected : ");
	}

	@Test(enabled = false)
	public void testCase03VerifySubCategoryDropDownSelectedText() throws InterruptedException {

		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.clickSignInButton();

		dp = new DashBoardPage(driver);
		dp.clickManageProductLink();

		mp = new ManageProductPage(driver);
		mp.clickOnNewButton();

		mp.selectCategoryDropDown("Fruits & Vegetables");

		mp.selectSubCategoryDropDown("Fruits");

		String actual = mp.getSubCategoryDropDownText();
		String expected = "Fruits";

		Assert.assertEquals(actual, expected, " : Text not expected : ");

	}

	@Test(enabled = false)
	public void testCase04VerifyTextSelectedOnGroupDropDown() {

		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.clickSignInButton();

		dp = new DashBoardPage(driver);
		dp.clickManageProductLink();

		mp = new ManageProductPage(driver);
		mp.clickOnNewButton();
		mp.selectGroupDropDown("Wayanadan Spices");
		String actual = mp.getGroupDropDownText();
		String expected = "Wayanadan Spices";

		Assert.assertEquals(actual, expected, " : Selected text not expected : ");

	}

	@Test(enabled = false)
	public void testCase05VerifyUnlimitedStockCheckboxIsSelected() throws InterruptedException {

		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.clickSignInButton();

		dp = new DashBoardPage(driver);
		dp.clickManageProductLink();

		mp = new ManageProductPage(driver);
		mp.clickOnNewButton();

		//mp.selectCheckboxUnlimitedStock();
		boolean actual = mp.isSelectedCheckboxUnlimitedStock();
		//boolean expected = true;
		
		Assert.assertTrue(actual, " : Checkbox is not expected : ");

		//Assert.assertEquals(actual, expected, " : Checkbox is not expected : ");
	}

	@Test(enabled = false)
	public void testCase06VerifyPriceTextFieldNameAttribute() {
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.clickSignInButton();

		dp = new DashBoardPage(driver);
		dp.clickManageProductLink();

		mp = new ManageProductPage(driver);
		mp.clickOnNewButton();

		String actual = mp.getPriceTextFieldAttributeValue("name");
		String expected = "w_price";

		Assert.assertEquals(actual, expected, " : Not expected : ");
	}

	@Test(enabled = false)
	public void testCase07VerifyDescriptionPictureButtonToolTip() {
		lp = new LoginPage(driver);
		lp.enterUserName(Constant.userName);
		lp.enterPassword(Constant.password);
		lp.clickSignInButton();

		dp = new DashBoardPage(driver);
		dp.clickManageProductLink();

		mp = new ManageProductPage(driver);
		mp.clickOnNewButton();

		String actual = mp.getDescriptionPictureButtonToolTip("data-original-title");
		String expected = "Picture";

		Assert.assertEquals(actual, expected, Constant.toolTipAssertion);
	}
	
	@Test(enabled = false)
	public void testCase08VerifyAlertTextOfActionDeleteButton() {
		lp = new LoginPage(driver);
		//claa
		lp.enterUserName(Constant.userName);
		lp.enterPassword(Constant.password);
		lp.clickSignInButton();

		dp = new DashBoardPage(driver);
		dp.clickManageProductLink();

		mp = new ManageProductPage(driver);
		mp.clickOnActionDeleteButton();

		String actual = mp.getActionDeleteButtonAlertText();
		String expected = Constant.deleteAlert;
		
		mp.dismissActionDeleteButtonAlert();

		Assert.assertEquals(actual, expected, Constant.alertAssertion);
	}
	
	@Test(enabled = false)
	public void testCase09VerifyStatusInactiveButtonFondSize() {
		lp = new LoginPage(driver);
		lp.enterUserName(Constant.userName);
		lp.enterPassword(Constant.password);
		lp.clickSignInButton();

		dp = new DashBoardPage(driver);
		dp.clickManageProductLink();

		mp = new ManageProductPage(driver);

		String actual = mp.getStatusInactiveButtonFontSize(Constant.fontSize);
		String expected = "12px";
		
		Assert.assertEquals(actual, expected, Constant.fontSizeAssertion);
	}
	
	@Test(enabled = false)
	public void testCase10VerifyStatusInactiveButtonFondSize() {
		
		read=new ExcelRead();
		
		lp = new LoginPage(driver);
		lp.performLogin(read.readData(1, 0), read.readData(1, 1));
//		lp.enterUserName(read.readData(1, 0));
//		lp.enterPassword(read.readData(1, 1));
//		lp.clickSignInButton();

		dp = new DashBoardPage(driver);
		dp.clickManageProductLink();

		mp = new ManageProductPage(driver);

		String actual = mp.getSearchButtonBackgroundColor(Constant.backgroundColor);
		String expected = "rgba(0, 123, 255, 1)";
		
		Assert.assertEquals(actual, expected, Constant.backgroundColorAssertion);
	}

}
