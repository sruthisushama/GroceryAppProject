package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;

public class LoginTestCases extends BaseClass { //inherit base class
	
	LoginPage lp;
  @Test (groups= {"medium"})
  public void testCase01VerifySignInButtonText() {
	  
	  lp=new LoginPage(driver);
	  String expected = Constant.expectedSignInButtonName;
	  String actual =lp.getSignInButtonText();
	  
	  Assert.assertEquals(actual, expected, " : Sign-In button text not expected : ");
	  
  }
  
  @Test(enabled=false)
  public void testCase02VerifyBrandIconDisplayed() {
	  
	  lp=new LoginPage(driver);
	  boolean expected=true;
	  boolean actual=lp.isBrandIconDisplayed();
	  
	  Assert.assertEquals(actual, expected, " : Brand Icon not Displayed : ");
  }
  
  
}
