package PageMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class KeywordSet {
	
	WebDriver driver;
	
	public void  type(WebDriver driver, String lcoator, String data) {
		try {
			WebElement element = driver.findElement(By.xpath(lcoator));
			element.clear();
			element.sendKeys(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void click(WebDriver driver , String lcoator) {
		try {
			WebElement element = driver.findElement(By.xpath(lcoator));
			element.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void VerifyText(WebDriver driver,String locator, String extText) {
		WebElement element = driver.findElement(By.xpath(locator));
		String actText = driver.findElement(By.xpath(locator)).getText();
		
		Assert.assertEquals(extText, actText);
		Assert.assertTrue(element.isDisplayed());
	}

}
