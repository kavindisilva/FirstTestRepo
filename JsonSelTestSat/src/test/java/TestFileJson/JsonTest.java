package TestFileJson;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import JsonReaderFile.ReaderJsonTest;
import PageMethod.KeywordSetTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JsonTest {
	WebDriver driver;
	String locator_uname = "//input[@id='user-name']";
	  String locator_pwd = "//input[@id='password']";
	  String locator_login = "//input[@id='login-button']";
	  String expTxt = "//span[text()='Products']";
	 // String locator_verifyelement = "//div[text()='29.99']";
	 // String locator_selectItem = "//div[text()='Sauce Labs Backpack']";
  @Test
  public void f() throws JsonProcessingException, IOException {
	  JsonNode nd = ReaderJsonTest.ReadJsonData().get("cred");
	  for(JsonNode node: nd) {
		  String name = nd.get("usrname").asText();
		  String pd = nd.get("pwd").asText();
		  String exp = nd.get("expText").asText();


		  KeywordSetTest key =  new KeywordSetTest();
		  key.type(driver, locator_uname, name);
		  key.type(driver, locator_pwd, pd);
		  key.click(driver, locator_login);
		  key.VerifyText(driver, expTxt, exp);
	  }
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.saucedemo.com/");

  }


  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
