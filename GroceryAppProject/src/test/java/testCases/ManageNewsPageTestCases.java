package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.DashBoardPage;
import elementRepository.LoginPage;
import elementRepository.ManageNewsPage;
import utilities.ExcelRead;

public class ManageNewsPageTestCases extends BaseClass {
	
	LoginPage lp;
	DashBoardPage dp;
	ManageNewsPage mnp;
	ExcelRead read;
	
  @Test (enabled = false)
  public void testCase01VerifyWorkingOfSaveButtonInNewsAdd(){
	  
	  lp=new LoginPage(driver);
	  read=new ExcelRead();
	  lp.performLogin(read.readData(1, 0), read.readData(1, 1));
	  
	  dp=new DashBoardPage(driver);
	  dp.clickManageContentLink();
	  dp.clickManageNewsLink();
	  
	  mnp=new ManageNewsPage(driver);
	  mnp.clickOnNewButton();
	  mnp.enterTextToNewsTextArea("New product created");
	  mnp.clickOnSaveButton();

	  List<String> list=mnp.getTextOfNewsColumn();
	  boolean actual=mnp.checkListIncludesText(list, "New product created");
	  
	  Assert.assertTrue(actual, Constant.saveButtonWorkingAssertion);
	  
  }
  
  @Test (enabled = false)
  public void testCase02VerifyWorkingOfCancelButtonInNewsAdd(){
	  
	  lp=new LoginPage(driver);
	  read=new ExcelRead();
	  lp.performLogin(read.readData(1, 0), read.readData(1, 1));
	  
	  dp=new DashBoardPage(driver);
	  dp.clickManageContentLink();
	  dp.clickManageNewsLink();
	  
	  mnp=new ManageNewsPage(driver);
	  mnp.clickOnNewButton();
	  mnp.clickOnCancelButton();

	  String actual=mnp.getPageHeadingText();
	  String expected="Manage News";
	  
	  Assert.assertEquals(actual, expected, Constant.cancelButtonWorkingAssertion ); //BUG DETECTED
	  
  }
  
  @Test (enabled = false)
  public void testCase03VerifyWorkingOfDeleteButton(){
	  
	  lp=new LoginPage(driver);
	  read=new ExcelRead();
	  lp.performLogin(read.readData(1, 0), read.readData(1, 1));
	  
	  dp=new DashBoardPage(driver);
	  dp.clickManageContentLink();
	  dp.clickManageNewsLink();
	  
	  mnp=new ManageNewsPage(driver);
	  mnp.clickOnDeleteButton();
	  mnp.acceptDeleteAlert();
	  
	  String actual=mnp.getDeleteConfirmAlertText();
	  String expected="×\n"
	  		+ "Alert!\n"
	  		+ "News Deleted Successfully";
	  
	  Assert.assertEquals(actual, expected," : Delete Button working not expected : ");
	  
	  
  }
  
  @Test (enabled = false)
  public void testCase04VerifyWorkingOfSearchButton(){
	  
	  lp=new LoginPage(driver);
	  read=new ExcelRead();
	  lp.performLogin(read.readData(1, 0), read.readData(1, 1));
	  
	  dp=new DashBoardPage(driver);
	  dp.clickManageContentLink();
	  dp.clickManageNewsLink();
	  
	  mnp=new ManageNewsPage(driver);
	  mnp.cilckOnTopSearchButton();
	  mnp.inputTextToSearchTextField("New product created");
	  mnp.cilckOnSearchButton();
	  
	  List<String> list=mnp.getTextOfNewsColumn();
	  boolean actual=mnp.checkListConatainsText(list, "New product");
	  
	  Assert.assertTrue(actual, Constant.searchButtonWorkingAssertion);
	  
  }
  
  @Test (enabled = true)
  public void testCase05VerifyWorkingOfUpdateButton(){
	  
	  lp=new LoginPage(driver);
	  read=new ExcelRead();
	  lp.performLogin(read.readData(1, 0), read.readData(1, 1));
	  
	  dp=new DashBoardPage(driver);
	  dp.clickManageContentLink();
	  dp.clickManageNewsLink();
	  
	  mnp=new ManageNewsPage(driver);
	  mnp.cilckOnUpdateButton();
	  mnp.clearUpdateTextArea();
	  mnp.inputTextToUpdateTextField("New");
	  mnp.cilckOnUpdateButtonOnPage();
	  
	  String actual=mnp.getTextOfUpdatedCell();
	  String expected="New";
	  
	  System.out.println(actual);
	  
	  Assert.assertEquals(actual, expected," : Update Button working not expected : " );
  }
  
}
