package elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class ManageOrdersPage {
	
	WebDriver driver;

	GeneralUtilities gu = new GeneralUtilities();

	public ManageOrdersPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement serachButtonLabel;
	
	@FindBy(id="od")
	WebElement orderId;
	
	@FindBy(name="Search")
	WebElement searchButton;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")
	WebElement oderIdCellOnTable;
	
	@FindBy(xpath="//h4[text()='Search List Orders']")
	WebElement serchListOrdersLabel;
	
	@FindBy(name="Reset")
	WebElement resetButton;
	
	@FindBy(xpath="(//a[@class='btn btn-block btn-outline-info btn-sm'])[1]")
	WebElement viewButton;
	
	@FindBy(xpath="//h1[@class='m-0 text-dark']")
	WebElement pageHeadingLabel;
	
	@FindBy(xpath = "//span[@id='back']//a[@class='btn btn-default']")
	WebElement backButton;
	
	@FindBy(xpath = "(//a[@class='btn btn-success btn-sm'])[1]")
	WebElement changeStatusButton;
	
	@FindBy(xpath = "(//div[@class='modal-body']//select[@id='status'])[1]")
	WebElement statusDropDown;
	
	@FindBy(name="Update_st")
	WebElement updateButton;
	
	@FindBy(name="assign_del")
	WebElement deliveryBoyUpdateButton;
	
	@FindBy(name = "Update_st")
	WebElement deliveryDateUpdateButton;
	
	@FindBy(xpath = "//span[text()='Canceled']")
	WebElement statusLabel;
	
	@FindBy(xpath="(//a[@class='btn btn-sm btn btn-danger btncss'])[1]")
	WebElement deleteButton;
	
	@FindBy(id="pt")
	WebElement paymentModeDropDown;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[5]")
	List<WebElement> paymentModeColomn;
	
	@FindBy(xpath="(//a[@class='btn btn-warning btn-sm'])[1]")
	WebElement assignDeliveryBoyButton;
	
	@FindBy(id="delivery_boy_id")
	WebElement deliveryBoyDropDown;
	
	@FindBy(xpath = "//span[text()='Test Delivery Boy']")
	WebElement deliveryBoyNameDisplay;
	
	@FindBy(xpath = "(//a[@class='btn btn-primary btn-sm'])[2]")
	WebElement changeDeliveryDateButton;
	
	@FindBy(xpath="(//div[@class='modal-content']//form[@action='http://groceryapp.uniqassosiates.com/admin/Order/update_date']//div[@class='jquery-datepicker']//input[@name='del_up_date'])[1]")
	WebElement deliveryDateField;
	
	@FindBy(xpath = "//div[@class='col text-left']")
	WebElement orderDetails;
	
	public void clickOnTopSearchButtonLabel() {
		gu.clickOnElement(serachButtonLabel);
	}
	
	public void enterOrderId(String id) {
		gu.inputDataToTextField(orderId, id);
	}
	
	public void clickOnSearchButton() {
		gu.clickOnElement(searchButton);
	}
	
	public void clickOnResetButton() {
		gu.clickOnElement(resetButton);
	}
	
	public void clickOnViewButton() {
		gu.clickOnElement(viewButton);
	}
	
	public void clickBackButtonOnOderDetailsPage() {
		gu.clickOnElement(backButton);
	}
	
	public void clickOnChangeStatusButton() {
		gu.clickOnElement(changeStatusButton);
	}
	
	public void selectStatusDropDown(String text) {
		gu.selectDropDownByVisibleText(statusDropDown, text);
	}
	
	public void clickOnStatusChangeUpdateButton() {
		gu.clickOnElement(updateButton);
	}
	
	public void clickOnDeleteButton() {
		gu.clickOnElement(deleteButton);
	}
	
	public void dismissDeleteButtonAlert() {
		gu.dismissAlert(driver);
	}
	
	public void clickOnAssignDeliveryBoyButton() {
		gu.clickOnElement(assignDeliveryBoyButton);
	}
	
	public void selectDeliveryBoyDropDown(String text) {
		gu.selectDropDownByVisibleText(deliveryBoyDropDown, text);
	}
	
	public void clickOnDeliveryBoyUpdateButton() {
		gu.clickOnElement(deliveryBoyUpdateButton);
	}
	
	public void clickOnChangeDeliveryDateButton() {
		gu.clickOnElement(changeDeliveryDateButton);
	}
	
	public String getDeliveryBoyNameDisplayLabelText() {
		return gu.getElementText(deliveryBoyNameDisplay);
	}
	
	public String getTextFromOderIdCellOnTable() {
		return gu.getElementText(oderIdCellOnTable);
	}
	
	public String getTextOfSerchListOrdersLabel() {
		return gu.getElementText(serchListOrdersLabel);
	}
	
	public String getTextOfPageHeadingLabel() {
		return gu.getElementText(pageHeadingLabel);
	}
	
	public String getCurrentPageTitle() {
		return gu.getPageTitle(driver);
	}
	
	public String getStatusDropDownSelectedText() {
		return gu.getDropDownSelectedText(statusDropDown);
	}
	
	public String getStatusLabelText() {
		return gu.getElementText(statusLabel);
	}
	
	public String getTextOfDeleteButtonAlert() {
		return gu.getAlertText(driver);
	}
	
	
	public String getPageHeadingLabelText() {
		return gu.getElementText(pageHeadingLabel);
	}
	
	public void selectPaymentModeDropDown(String text) {
		gu.selectDropDownByVisibleText(paymentModeDropDown, text);
	}
	
	public List<String> getPaymentModeColomnText() {
		return gu.getListOfWebElementsText(paymentModeColomn);
	}
	
	public String getOrderDetails() {
		return gu.getElementText(orderDetails);
	}
	
	public void enterNewDeliveryDate(String date) {
		gu.inputDataToTextField(deliveryDateField, date);
	}
	
	public void clickOnDeliveryDateUpdateButton() {
		gu.clickOnElement(deliveryDateUpdateButton);
	}
	
	public boolean verifyPaymentModeColumnText(List<String> list,String text) {
		return gu.verifyListOfStringText(list,text);
	}
	
	public String getBackgroundColorOfDeleteButton(String cssValue) {
		return gu.getCssValueOfElement(deleteButton, cssValue);
	}
	
	public boolean verifyDeliveryDateFieldIsPresent() {
		
		return gu.verifyElementIsPresent(deliveryDateField);
	}
	
	public void callMediumDelay() throws InterruptedException {
		gu.mediumDelay();
	}
	
	public void callExplicitWait() {
		ExplicitWait wait=new ExplicitWait();
		wait.visibilityOfElement(driver, deliveryDateField);
	}
	
	

}
