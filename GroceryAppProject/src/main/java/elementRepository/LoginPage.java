package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class LoginPage {

	WebDriver driver;

	GeneralUtilities gu = new GeneralUtilities();

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInButton;
	
	@FindBy(xpath="//b[text()='7rmart supermarket']")
	WebElement brandIconLabel;
	
	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;

	public String getSignInButtonText() {

		return gu.getElementText(signInButton);
	}

	
	
	public boolean isBrandIconDisplayed() {
		return gu.isElementDisplayed(brandIconLabel);
	}

	
	
	public void enterUserName(String name ) {
		gu.inputDataToTextField(userName, name);
	}
	
	
	
	public void enterPassword(String pwd ) {
		gu.inputDataToTextField(password, pwd);
	}
	
	public void clickSignInButton() {
		gu.clickOnElement(signInButton);
	}
	
	public void performLogin(String name,String pwd) {
		gu.inputDataToTextField(userName, name);
		gu.inputDataToTextField(password, pwd);
		gu.clickOnElement(signInButton);
		//call one by one methods
		
	}
	
}
