package utilities;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;


public class GeneralUtilities {
	
	public String getElementText(WebElement element) {
		return element.getText();
	}
	
	public boolean isElementDisplayed(WebElement element) {
		 return element.isDisplayed();
	}
	
	public boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}
	
	public void inputDataToTextField(WebElement element,String data) {
		 element.sendKeys(data);
	}
	
	public void clickOnElement(WebElement element) {
		element.click();
	}
	
	public void selectDropDownByValue(WebElement element,String value) {
		Select select=new Select(element);
		select.selectByValue(value);
	}
	
	public void selectDropDownByIndex(WebElement element,int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	public void selectDropDownByVisibleText(WebElement element,String text) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	
	public String getDropDownSelectedText(WebElement element) {
		Select select=new Select(element);
		return select.getFirstSelectedOption().getText();
	}
	
	public void moveToElementAction(WebElement element,WebDriver driver) {
		Actions action=new Actions(driver);
		action.moveToElement(element).click().perform();
	}
	
	public String getElementAttributeValue(WebElement element,String attributeName) {
		return element.getAttribute(attributeName);
	}
	
	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public String getCssValueOfElement(WebElement element,String cssProperty) {
		return element.getCssValue(cssProperty);
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public List<String> getListOfWebElementsText(List<WebElement> listWebElement) {
		List<String> listString = new ArrayList<String>();
		for (WebElement list : listWebElement) {
			listString.add(list.getText());
		}
		return listString;
	}
	
	public List<String> getListOfWebElementsTextWithoutEmptyString(List<WebElement> listWebElement) {
		List<String> listString = new ArrayList<String>();
		for (WebElement list : listWebElement) {
			if(!list.getText().equals("")) {
				listString.add(list.getText());
			}
		}
		return listString;
	}
	
	public boolean verifyListOfStringText(List<String> list, String text) {
		boolean actual = true;
		for (String str : list) {
			if (!str.equals(text)) {
				actual = false;
				break;
			}
		}
		return actual;
	}
	
	public boolean verifyListOfStringContainsText(List<String> list, String text) {
		boolean actual = true;
		for (String str : list) {
			if (!str.contains(text)) {
				actual = false;
				break;
			}
		}
		return actual;
	}
	
	public boolean verifyListOfStringTextWithTwoValues(List<String> list, String item1,String item2) {
		boolean actual = true;
		for (String str : list) {
			if (!str.equals(item1)) {
				if(!str.equals(item2)) {
					actual=false;
					break;
				}
			}
		}
		return actual;
	}
	
	public boolean verifyKeyChange(String text,String key1,String key2,WebElement element) {
		boolean status=false;
		if(text.equals(key1)) {
			String actual=getElementText(element);
			if(actual.equals(key2)) {
				status=true;
			}
			else {
				status=false;
			}
		}
		else if(text.equals(key2)) {
			String actual=getElementText(element);
			if(actual.equals(key1)) {
				status=true;
			}
			else {
				status=false;
			}
		}
		return status;
	}
	
	public void mediumDelay() throws InterruptedException {
		Thread.sleep(2000);
	}
	
	public void addScrolling(WebDriver driver,String parameter) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(parameter);
		
	}
	
	public void fileUpload(WebElement element,WebDriver driver,String path) throws AWTException {
		
		Actions action=new Actions(driver);
		action.moveToElement(element).click().perform();
		
		StringSelection ss = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		Robot robot = new Robot(); // it is a java class to perform mouse and keyboard actions.
		robot.delay(250);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(250);

		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public boolean verifyElementIsPresent(WebElement element) {
		return element.isDisplayed();
	}
	
	public void clearTextField(WebElement element) {
		element.clear();
	}
	
	
	
	
	

}
