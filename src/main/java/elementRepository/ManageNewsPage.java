package elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageNewsPage {

	WebDriver driver;

	GeneralUtilities gu = new GeneralUtilities();

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	
	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	WebElement pageHeading;
	
	@FindBy(id="news")
	WebElement newsTextArea;
	
	@FindBy(name = "create")
	WebElement saveButton;
	
	@FindBy(xpath = "//a[@class='btn btn-default btn-fix']")
	WebElement cancelButton;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//td[1]")
	List<WebElement> newsTableColumn;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement deleteButton;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement updateButton;
	
	@FindBy(name = "update")
	WebElement updateButtonOnPage;
	
	@FindBy(xpath = "//div[@class='col-sm-12']//div[@class='alert alert-success alert-dismissible']")
	WebElement deleteConfirmAlert;
	
	@FindBy(name = "un")
	WebElement searchNewsTextField;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButtonTop;
	
	@FindBy(name = "Search")
	WebElement searchButton;
	
	@FindBy(xpath = "//a[@class='btn btn-default btn-fix']")
	WebElement searchResetButton;
	
	@FindBy(id = "news")
	WebElement updateTextArea;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")
	WebElement updatedCell;
	
	
	public void clickOnNewButton() {
		gu.clickOnElement(newButton);
	}
	
	public void clickOnDeleteButton() {
		gu.clickOnElement(deleteButton);
	}
	
	public void clickOnSaveButton() {
		gu.clickOnElement(saveButton);
	}
	
	public void clickOnCancelButton() {
		gu.clickOnElement(cancelButton);
	}
	
	public void enterTextToNewsTextArea(String text) {
		gu.inputDataToTextField(newsTextArea, text);
	}
	
	public List<String> getTextOfNewsColumn()  {
		
		return gu.getListOfWebElementsTextWithoutEmptyString(newsTableColumn);
	}
	
	public boolean checkListConatainsText(List<String> list,String text) {
		return gu.verifyListOfStringContainsText(list, text);
	}
	
	public boolean checkListIncludesText(List<String> list,String text) {
		return gu.verifyListOfStringText(list, text);
	}
	
	public String getPageHeadingText() {
		return gu.getElementText(pageHeading);
	}
	
	public void acceptDeleteAlert() {
		gu.acceptAlert(driver);
	}
	
	public void dismissDeleteAlert() {
		gu.dismissAlert(driver);
	}
	
	public String getDeleteConfirmAlertText() {
		return gu.getElementText(deleteConfirmAlert);
	}
	
	public void cilckOnTopSearchButton() {
		gu.clickOnElement(searchButtonTop);
	}
	
	public void cilckOnSearchButton() {
		gu.clickOnElement(searchButton);
	}
	
	public void inputTextToSearchTextField(String text) {
		gu.inputDataToTextField(searchNewsTextField, text);
	}
	
	public void cilckOnSearchResetButton() {
		gu.clickOnElement(searchResetButton);
	}
	
	public void cilckOnUpdateButton() {
		gu.clickOnElement(updateButton);
	}
	public void cilckOnUpdateButtonOnPage() {
		gu.clickOnElement(updateButtonOnPage);
	}
	
	public void inputTextToUpdateTextField(String text) {
		gu.inputDataToTextField(updateTextArea, text);
	}
	
	public String getTextOfUpdatedCell() {
		return gu.getElementText(updatedCell);
	}
	
	public void clearUpdateTextArea() {
		gu.clearTextField(updateTextArea);
	}


}
