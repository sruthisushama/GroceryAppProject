package elementRepository;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;


public class ManageCategoryPage {
	
	WebDriver driver;
	
	GeneralUtilities gu = new GeneralUtilities();
	
	ExplicitWait wait=new ExplicitWait();
	
	public ManageCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	
	@FindBy(id = "category")
	WebElement categoryTextBox;
	
	@FindBy(id="main_img")
	WebElement chooseFileButton;
	
	@FindBy(name = "create")
	WebElement saveButton;
	
	@FindBy(id="imagePreview")
	WebElement imagePreview;
	
	@FindBy(id = "2-selectable")
	WebElement selectGroup1;
	
	@FindBy(id = "5-selectable")
	WebElement selectGroup2;
	
	@FindBy(xpath = "///div[@class='alert alert-success alert-dismissible']//h5[text()=' Alert!']")
	WebElement saveAlert;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")
	WebElement newAddedCategory;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	WebElement searchedCategory;
	
	@FindBy(xpath = "//a[@type='button']")
	WebElement cancelButton;
	
	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	WebElement pageHeading;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButtonTop;
	
	@FindBy(name = "Search")
	WebElement searchButton;
	
	@FindBy(name = "un")
	WebElement searchCategoryTextBox;
	
	@FindBy(xpath = "//a[@class='btn btn-default btn-fix']")
	WebElement resetButtonOnSearch;
	
	@FindBy(xpath = "//h4[text()='List Categories']")
	WebElement pageSubHeading;
	
	@FindBy(xpath = "//div[@class='ms-selection']//ul//li")
	List<WebElement> selectedGroupsLabel;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[3]//a[@role='button']")
	WebElement statusActiveOrInactiveButton;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[4]//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement editCategoryButton;
	
	@FindBy(xpath = "//a[text()='Cancel']")
	WebElement cancelButtonEditCategory;
	
	@FindBy(xpath = "//footer[@class='main-footer text-sm']//strong")
	WebElement footerLabel;
	
	@FindBy(xpath = "//input[@name='top_menu' and @value='yes']")
	WebElement topMenuYesRadioButton;
	
	@FindBy(xpath = "//input[@name='top_menu' and @value='no']")
	WebElement topMenuNoRadioButton;
	
	@FindBy(xpath = "//input[@name='show_home' and @value='no']")
	WebElement leftMenuNoRadioButton;
	
	@FindBy(xpath = "//input[@name='show_home' and @value='yes']")
	WebElement leftMenuYesRadioButton;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//td[1]")
	List<WebElement> categoryColumn;
	
	
	
	
	public void enterCategoryTextBox(String text) {
		gu.inputDataToTextField(searchCategoryTextBox, text);
	}
	
	public void clickOnButtonEditCategory() {
		gu.clickOnElement(editCategoryButton);
	}
	
	public void clickOnCancelButtonEditCategory() {
		ExplicitWait wait=new ExplicitWait();
		wait.elementToBeClickable(driver, cancelButtonEditCategory);
		gu.clickOnElement(cancelButtonEditCategory);
	}
	
	public void clickOnNewButton() {
		gu.clickOnElement(newButton);
	}
	
	public void clickOnSearchButton() {
		gu.clickOnElement(searchButton);
	}
	
	public void clickOnTopSearchButton() {
		gu.clickOnElement(searchButtonTop);
	}
	
	public void clickOnSaveButton() throws InterruptedException {
		gu.mediumDelay();
		wait.elementToBeClickable(driver, saveButton);
		gu.addScrolling(driver,"window.scrollBy(0,3500)");
		gu.mediumDelay();
		gu.moveToElementAction(saveButton, driver);
		//gu.clickOnElement(saveButton);
	}
	
	public void inputDataOnCategoryTextBox(String data) {
		gu.inputDataToTextField(categoryTextBox, data);
	}
	
	public void uploadProductImage(String path) throws AWTException, InterruptedException {
		//gu.mediumDelay();
		gu.fileUpload(chooseFileButton, driver, path);
	}
	
	public void selectGroup1() {
		gu.clickOnElement(selectGroup1);
		

	}
	
	public String getSelectGroup1Text() {
		String s=gu.getElementText(selectGroup1);
		//System.out.println(s);
		return s;
		
	}
	
	public String getSaveAlertText() {
		return gu.getElementText(saveAlert);
	}
	
	public void selectGroup2() {
		gu.clickOnElement(selectGroup2);
		
	}
	
	public String getSelectGroup2Text() {
		return gu.getElementText(selectGroup2);
	}
	
	public String getNewAddedCategoryText() throws InterruptedException {
		gu.mediumDelay();
		return gu.getElementText(newAddedCategory);
	}
	
	public String getSearchedCategoryText() {
		return gu.getElementText(searchedCategory);
	}
	
	public void clickOnCancelButton() {
		gu.clickOnElement(cancelButton);
	}
	
	public void clickOnResetButton() {
		gu.clickOnElement(resetButtonOnSearch);
	}
	
	public void clickOnStatusActiveOrInactiveButton() {
		gu.clickOnElement(statusActiveOrInactiveButton);
	}
	
	public String getTextOfStatusActiveOrInactiveButton() {
		return gu.getElementText(statusActiveOrInactiveButton);
	}
	
	public String getPageHeadingText() {
		return gu.getElementText(pageHeading);
	}
	
	public String getPageSubHeadingText() {
		return gu.getElementText(pageSubHeading);
	}
	
	public List<String> getListOfStringsOfSelectedGropus(){
		return gu.getListOfWebElementsTextWithoutEmptyString(selectedGroupsLabel);
	}
	
	public boolean compareSelectedGroupItems(List<String> list,String item1,String item2) {
		return gu.verifyListOfStringTextWithTwoValues(list, item1, item2);
	}
	
	public String verifyBackgroundColorOfEditButton(String cssValue) {
		return gu.getCssValueOfElement(editCategoryButton,cssValue);
	}
	
	public boolean checkStatusButtonWorking(String text,String key1,String key2) {
		return gu.verifyKeyChange(text,key1,key2,statusActiveOrInactiveButton);
	}
	
	public String verifyFontSizeOfPageHeading(String cssProperty) {
		return gu.getCssValueOfElement(pageHeading, cssProperty);
	}
	
	public String getFooterLabelText() {
		return gu.getElementText(footerLabel);
	}
	
	public void clickOnTopMenuYesRadioButton() {
		gu.clickOnElement(topMenuYesRadioButton);
	}
	
	public void clickOnTopMenuNoRadioButton() throws InterruptedException {
		gu.mediumDelay();
		wait.elementToBeClickable(driver, topMenuNoRadioButton);
		gu.mediumDelay();
		gu.addScrolling(driver, "window.scrollBy(0,3800)");
		gu.mediumDelay();
		gu.clickOnElement(topMenuNoRadioButton);
	}
	
	public void clickOnLeftMenuNoRadioButton() throws InterruptedException {
		wait.elementToBeClickable(driver, leftMenuNoRadioButton);
		gu.addScrolling(driver, "window.scrollBy(0,3800)");
		gu.mediumDelay();
		gu.clickOnElement(leftMenuNoRadioButton);
	}
	
	public void clickOnLeftMenuYesRadioButton() {
		gu.clickOnElement(leftMenuYesRadioButton);
	}
	
	public List<String> getTextStringOfCategoryColumn() {
		return gu.getListOfWebElementsText(categoryColumn);
	}
	
	public boolean checkListCategoriesConatainsText(List<String> list,String text) {
		return gu.verifyListOfStringContainsText(list, text);
	}
	
	

}
