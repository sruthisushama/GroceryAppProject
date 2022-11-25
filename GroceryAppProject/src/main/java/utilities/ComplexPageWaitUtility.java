package utilities;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComplexPageWaitUtility {
	
	public boolean waitForJStoLoad(WebDriver driver) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	    // wait for jQuery to load
	    ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
	      @Override
	      public Boolean apply(WebDriver driver) {
	        try {
	        	 return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
	        }
	        catch (Exception e) {
	          return true;
	        }
	      }
	    };

	    // wait for Javascript to load
	    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
	      @Override
	      public Boolean apply(WebDriver driver) {
	    	  return ((JavascriptExecutor)driver).executeScript("return document.readyState")
	    		       .toString().equals("complete");
	      }
	    };

	  return wait.until(jQueryLoad) && wait.until(jsLoad);
	}
	
	 // wait for Ajax to load
	public  void waitForAjax(WebDriver driver) {
	    new WebDriverWait(driver, Duration.ofSeconds(50)).until(new ExpectedCondition<Boolean>(){
	        public Boolean apply(WebDriver driver) {
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            return (Boolean) js.executeScript("return jQuery.active == 0");
	        }
	    });	
	}

}
