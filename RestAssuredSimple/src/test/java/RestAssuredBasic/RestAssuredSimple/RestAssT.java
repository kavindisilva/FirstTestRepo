package RestAssuredBasic.RestAssuredSimple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssT {
	WebDriver driver;
  @Test
  public void f() {
	  Response response = RestAssured.given()
			  .when()
			  .get("https://automationexercise.com/api/brandsList");
	  String msg = response.jsonPath().getString("brands[0].brand");
	  driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(msg);
	  
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
