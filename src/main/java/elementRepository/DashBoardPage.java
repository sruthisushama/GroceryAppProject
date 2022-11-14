package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class DashBoardPage {
	
	WebDriver driver;

	GeneralUtilities gu = new GeneralUtilities();

	public DashBoardPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product'])[1]")
	WebElement manageProductLabel;
	
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-order'])[1]")
	WebElement manageOrdersLabel;
	
	@FindBy(xpath = "(//a[@class='small-box-footer']//i[@class='fas fa-arrow-circle-right'])[3]")
	WebElement manageCategoryLabel;
	
	@FindBy(xpath = "//a[@class='nav-link']//i[@class='nav-icon fas fa-edit']")
	WebElement manageContentLink;
	
	@FindBy(xpath = "//a[@class='nav-link']//p[text()='Manage News']")
	WebElement manageNewsLink;
	
	
	public void clickManageProductLink() {
		gu.clickOnElement(manageProductLabel);
	}
	
	public void clickManageOrdersLabel() {
		gu.clickOnElement(manageOrdersLabel);
	}
	
	public void clickManageCategoryLabel() {
		gu.clickOnElement(manageCategoryLabel);
	
	}
	
	public void clickManageContentLink() {
		gu.clickOnElement(manageContentLink);
	
	}
	
	public void clickManageNewsLink() {
		gu.clickOnElement(manageNewsLink);
	
	}
	
	
}
