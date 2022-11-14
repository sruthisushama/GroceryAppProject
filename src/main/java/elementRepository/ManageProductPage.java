package elementRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageProductPage {

	WebDriver driver;

	GeneralUtilities gu = new GeneralUtilities();

	public ManageProductPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;

	@FindBy(id = "cat_id")
	WebElement dropDownCategory;

	@FindBy(id = "purpose")
	WebElement radioButton;

	@FindBy(xpath = "//select[@name='sub_id']")
	WebElement subCategoryDropDown;

	@FindBy(id = "grp_id")
	WebElement groupDropDown;

	@FindBy(xpath = "//input[@name='unlimitw[]']")
	WebElement checkboxUnlimitedStock;

	@FindBy(id = "w_price")
	WebElement textFieldPrice;
	
	@FindBy(xpath="//button[@data-original-title='Picture']")
	WebElement descriptionPictureButton;
	
	@FindBy(xpath="(//i[@class='fas fa-trash-alt'])[1]")
	WebElement actionDeleteButton;
	
	@FindBy(xpath="(//span[@class='badge bg-warning'])[2]")
	WebElement statusInactiveButton;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;

	public void clickOnNewButton() {
		gu.clickOnElement(newButton);
	}

	public void selectCategoryDropDown(String text) {
		gu.selectDropDownByVisibleText(dropDownCategory, text);
	}

	public String getCategoryDropDownSelectedText() {
		return gu.getDropDownSelectedText(dropDownCategory);
	}

	public void selectPriceTypeRadioButton() {
		gu.clickOnElement(radioButton);
	}

	public boolean isSelectedPriceTypeRadioButton() {
		return gu.isElementSelected(radioButton);
	}

	public void selectSubCategoryDropDown(String text) throws InterruptedException {
		Thread.sleep(3000);
		gu.selectDropDownByVisibleText(subCategoryDropDown, text);
	}

	public String getSubCategoryDropDownText() {
		return gu.getDropDownSelectedText(subCategoryDropDown);
	}

	public void selectGroupDropDown(String text) {
		gu.selectDropDownByVisibleText(groupDropDown, text);
	}

	public String getGroupDropDownText() {
		return gu.getDropDownSelectedText(groupDropDown);
	}

	public void selectCheckboxUnlimitedStock() throws InterruptedException {
		gu.addScrolling(driver,"window.scrollBy(0,3500)");
		gu.clickOnElement(checkboxUnlimitedStock);
		
	}

	public boolean isSelectedCheckboxUnlimitedStock() {
		return gu.isElementSelected(checkboxUnlimitedStock);
	}

	public String getPriceTextFieldAttributeValue(String attributeName) {
		return gu.getElementAttributeValue(textFieldPrice, attributeName);
	}
	
	public String getDescriptionPictureButtonToolTip(String attributeName) {
		return gu.getElementAttributeValue(descriptionPictureButton,attributeName);
	}
	
	public void clickOnActionDeleteButton() {
		gu.clickOnElement(actionDeleteButton);
	}
	
	public String getActionDeleteButtonAlertText() {
		return gu.getAlertText(driver);
	}
	
	public void dismissActionDeleteButtonAlert() {
		gu.dismissAlert(driver);
	}
	
	public String getStatusInactiveButtonFontSize(String cssProperty) {
		return gu.getCssValueOfElement(statusInactiveButton, cssProperty);
	}
	
	public String getSearchButtonBackgroundColor(String cssProperty) {
		return gu.getCssValueOfElement(searchButton, cssProperty);
	}

}
