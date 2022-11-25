package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.DashBoardPage;
import elementRepository.LoginPage;
import elementRepository.ManageOrdersPage;
import utilities.ExcelRead;


public class ManageOrdersPageTestCases extends BaseClass {

	LoginPage lp;
	DashBoardPage dp;
	ManageOrdersPage mop;
	ExcelRead read;

	@Test(enabled = false) // (groups = {"high"})
	public void testCase01VerifySerachButtonFunctionalityWithOrderId() {

		lp = new LoginPage(driver);
		read = new ExcelRead();
		lp.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageOrdersLabel();

		mop = new ManageOrdersPage(driver);
		mop.clickOnTopSearchButtonLabel();
		mop.enterOrderId("652");
		mop.clickOnSearchButton();

		String actual = mop.getTextFromOderIdCellOnTable();
		String expected = "652";

		Assert.assertEquals(actual, expected, Constant.searchButtonWorkingAssertion);
	}

	@Test(enabled = false)
	public void testCase02VerifyResetButtonFunctionality() {

		lp = new LoginPage(driver);
		read = new ExcelRead();
		lp.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageOrdersLabel();

		mop = new ManageOrdersPage(driver);
		mop.clickOnTopSearchButtonLabel();
		System.out.println(mop.getTextOfSerchListOrdersLabel());
		mop.clickOnResetButton();

		String actual = mop.getTextOfSerchListOrdersLabel();
		String expected = "";

		Assert.assertEquals(actual, expected, Constant.resetButtonWorkingAssertion);
	}

	@Test(enabled = false)
	public void testCase03VerifyBackButtonFunctionalityOnOrderDetailsPage() {

		lp = new LoginPage(driver);
		read = new ExcelRead();
		lp.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageOrdersLabel();

		mop = new ManageOrdersPage(driver);
		mop.clickOnViewButton();
		mop.clickBackButtonOnOderDetailsPage();

		String actual = mop.getPageHeadingLabelText();
		String expected = Constant.pageHeadingListOrders;// change assertion done

		Assert.assertEquals(actual, expected, Constant.backButtonWorkingAssertion);
	}

	@Test(enabled = false)
	public void testCase04VerifyChangeStatusButtonWorking() {

		lp = new LoginPage(driver);
		read = new ExcelRead();
		lp.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageOrdersLabel();

		mop = new ManageOrdersPage(driver);
		mop.clickOnChangeStatusButton();
		mop.selectStatusDropDown("Canceled");
		mop.clickOnStatusChangeUpdateButton();

		String actual = mop.getStatusLabelText();
		String expected = mop.getStatusDropDownSelectedText();

		Assert.assertEquals(actual, expected, Constant.changeStatusButtonWorkingAssertion); // detected bug on page
	}

	@Test(enabled = false) // (groups = {"medium"})
	public void testCase05VerifyDeleteButtonAlertText() {

		lp = new LoginPage(driver);
		read = new ExcelRead();
		lp.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageOrdersLabel();

		mop = new ManageOrdersPage(driver);
		mop.clickOnDeleteButton();

		String actual = mop.getTextOfDeleteButtonAlert();
		String expected = Constant.deleteOrderAlert;
		mop.dismissDeleteButtonAlert();

		Assert.assertEquals(actual, expected, Constant.alertAssertion);
	}

	@Test(enabled = false) // (groups = {"medium"})
	public void testCase06VerifySearchButtonWorkingWithPaymentMode() {

		lp = new LoginPage(driver);
		read = new ExcelRead();
		lp.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageOrdersLabel();

		mop = new ManageOrdersPage(driver);
		mop.clickOnTopSearchButtonLabel();
		mop.selectPaymentModeDropDown("COD");
		mop.clickOnSearchButton();
		List<String> list = mop.getPaymentModeColomnText();
		boolean actual =mop.verifyPaymentModeColumnText(list,"COD");

		Assert.assertTrue(actual, Constant.searchButtonWorkingAssertion);

	}

	@Test(enabled = false) // (groups = {"medium"})
	public void testCase07VerifyAssignDeliveryBoyButtonWorking() {

		lp = new LoginPage(driver);
		read = new ExcelRead();
		lp.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageOrdersLabel();

		mop = new ManageOrdersPage(driver);
		mop.clickOnAssignDeliveryBoyButton();
		mop.selectDeliveryBoyDropDown("testdeliveryboy");
		mop.clickOnDeliveryBoyUpdateButton();

		String actual = mop.getDeliveryBoyNameDisplayLabelText();
		String expected = "Test Delivery Boy";

		Assert.assertEquals(actual, expected, Constant.alertAssertion);
	}

	@Test(enabled = true) // (groups = {"medium"})
	public void testCase08VerifyChangeDeliveryDateButtonWorking() throws InterruptedException {

		lp = new LoginPage(driver);
		read = new ExcelRead();
		lp.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageOrdersLabel();

		mop = new ManageOrdersPage(driver);
		mop.callMediumDelay();
		mop.clickOnChangeDeliveryDateButton();
		//mop.callMediumDelay();
		//mop.callExplicitWait();
		System.out.println(mop.verifyDeliveryDateFieldIsPresent());
//		mop.enterNewDeliveryDate("15");
//		mop.enterNewDeliveryDate("08");
//		mop.enterNewDeliveryDate("2022");
//		mop.clickOnDeliveryDateUpdateButton();

	}

	@Test(enabled = false) // (groups = {"medium"})
	public void testCase09VerifyViewButtonWorking() {

		lp = new LoginPage(driver);
		read = new ExcelRead();
		lp.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageOrdersLabel();

		mop = new ManageOrdersPage(driver);
		String expected = mop.getTextFromOderIdCellOnTable();
		mop.clickOnViewButton();
		String details = mop.getOrderDetails();
		String actual = details.substring(11, 14);

		Assert.assertEquals(actual, expected, Constant.viewButtonWorkingAssertion);

	}
	
	@Test(enabled = false) // (groups = {"medium"})
	public void testCase10VerifyDeleteButtonBackgroundColor() {

		lp = new LoginPage(driver);
		read = new ExcelRead();
		lp.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageOrdersLabel();

		mop = new ManageOrdersPage(driver);
		String expected="rgba(220, 53, 69, 1)";
		String actual=mop.getBackgroundColorOfDeleteButton(Constant.backgroundColor);

		Assert.assertEquals(actual, expected, Constant.backgroundColorAssertion);

	}	


}
