package testCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.DashBoardPage;
import elementRepository.LoginPage;
import elementRepository.ManageCategoryPage;
import utilities.ExcelRead;

public class ManageCategoryPageTestCases extends BaseClass {

	LoginPage lp;
	DashBoardPage dp;
	ManageCategoryPage mcp;
	ExcelRead read;

	@Test(enabled = false)
	public void testCase01VerifyAddNewCategoryFunctionality() throws IOException, AWTException, InterruptedException {

		lp = new LoginPage(driver);
		read = new ExcelRead();
		lp.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageCategoryLabel();

		mcp = new ManageCategoryPage(driver);
		mcp.clickOnNewButton();
		mcp.inputDataOnCategoryTextBox(Constant.productCategory);
		mcp.selectGroup1();

		
		mcp.uploadProductImage(System.getProperty("user.dir") + ps.getProperty("GheeImagePath"));
		mcp.clickOnTopMenuNoRadioButton();
		mcp.clickOnLeftMenuNoRadioButton();
		mcp.clickOnSaveButton();
		String expected = Constant.productCategory;
		String actual = mcp.getNewAddedCategoryText();

		Assert.assertEquals(actual, expected, Constant.saveCategoryButtonWorkingAssertion);

	}

	@Test(enabled = true)
	public void testCase02VerifyCancelButtonOnAddCategoryPage() {

		lp = new LoginPage(driver);
		read = new ExcelRead();
		lp.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageCategoryLabel();

		mcp = new ManageCategoryPage(driver);
		mcp.clickOnNewButton();
		mcp.clickOnCancelButton();

		String actual = mcp.getPageHeadingText();
		String expected = "List Categories";

		Assert.assertEquals(actual, expected, Constant.cancelButtonWorkingAssertion);


	}

	@Test(enabled = false)
	public void testCase03VerifySearchButtonWorking() throws InterruptedException {

		lp = new LoginPage(driver);
		read = new ExcelRead();
		lp.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageCategoryLabel();

		mcp = new ManageCategoryPage(driver);
		mcp.clickOnTopSearchButton();
		mcp.enterCategoryTextBox("Care");
		mcp.clickOnSearchButton();
		
		List<String> list=mcp.getTextStringOfCategoryColumn();
		
		boolean actual=mcp.checkListCategoriesConatainsText(list,"Care");
		
		Assert.assertTrue(actual, Constant.searchButtonWorkingAssertion);

	}

	@Test(enabled = false)
	public void testCase04VerifyResetButtonOnSearchPage() {

		lp = new LoginPage(driver);
		read = new ExcelRead();
		lp.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageCategoryLabel();

		mcp = new ManageCategoryPage(driver);
		mcp.clickOnTopSearchButton();
		mcp.clickOnResetButton();

		String actual = mcp.getPageSubHeadingText();
		String expected = "List Categories";

		Assert.assertEquals(actual, expected, Constant.resetButtonWorkingAssertion);

	}

	@Test(enabled = false)
	public void testCase05VerifySelectingGroupsOnAddCategoryPage() {

		lp = new LoginPage(driver);
		read = new ExcelRead();
		lp.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageCategoryLabel();

		mcp = new ManageCategoryPage(driver);
		mcp.clickOnNewButton();
		mcp.selectGroup1();
		mcp.selectGroup2();
		
		List<String> list = mcp.getListOfStringsOfSelectedGropus();
		//System.out.println(list);
		
		boolean actual = mcp.compareSelectedGroupItems(list, "Wayanadan Spices", "Merchants");

		Assert.assertTrue(actual, " : Selected group not expected : ");

	}

	@Test(enabled = false)
	public void testCase06VerifyWorkingOfStatusActiveOrInactiveButton() {

		lp = new LoginPage(driver);
		read = new ExcelRead();
		lp.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageCategoryLabel();

		mcp = new ManageCategoryPage(driver);
		
		String text=mcp.getTextOfStatusActiveOrInactiveButton();
		mcp.clickOnStatusActiveOrInactiveButton();
		
		boolean actual=mcp.checkStatusButtonWorking(text,"Active","Inactive");
		
		Assert.assertTrue(actual, " : Working Of Status Active/Inactive Button not expected : ");
	}
	

	@Test(enabled = false)
	public void testCase07VerifyCancelButtonOnEditCategoryPage() {

		lp = new LoginPage(driver);
		read = new ExcelRead();
		lp.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageCategoryLabel();

		mcp = new ManageCategoryPage(driver);
		mcp.clickOnButtonEditCategory();
		mcp.clickOnCancelButtonEditCategory();

		String actual = mcp.getPageHeadingText();
		String expected = "List Categories";

		Assert.assertEquals(actual, expected, Constant.cancelButtonWorkingAssertion);

	}
	
	@Test(enabled = false) // (groups = {"medium"})
	public void testCase08VerifyEditButtonBackgroundColor() {

		lp = new LoginPage(driver);
		read = new ExcelRead();
		lp.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageCategoryLabel();

		mcp = new ManageCategoryPage(driver);
		String expected="rgba(0, 123, 255, 1)";
		String actual=mcp.verifyBackgroundColorOfEditButton(Constant.backgroundColor);
		Assert.assertEquals(actual, expected, Constant.backgroundColorAssertion);

	}	

	@Test(enabled = false) // (groups = {"medium"})
	public void testCase09VerifyFontSizeOfPAgeHeading() {

		lp = new LoginPage(driver);
		read = new ExcelRead();
		lp.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageCategoryLabel();

		mcp = new ManageCategoryPage(driver);
		String expected="28.8px";
		String actual=mcp.verifyFontSizeOfPageHeading(Constant.fontSize);
		Assert.assertEquals(actual, expected, Constant.fontSizeAssertion);

	}	
	
	@Test(enabled = false) // (groups = {"medium"})
	public void testCase10VerifyFooterLabelText() {

		lp = new LoginPage(driver);
		read = new ExcelRead();
		lp.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageCategoryLabel();

		mcp = new ManageCategoryPage(driver);
		String expected=Constant.footerText;
		String actual=mcp.getFooterLabelText();
		Assert.assertEquals(actual, expected, " : Not Expected : ");

	}	
}
