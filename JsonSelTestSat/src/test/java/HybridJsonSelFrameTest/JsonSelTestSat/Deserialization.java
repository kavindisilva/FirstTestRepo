package HybridJsonSelFrameTest.JsonSelTestSat;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Deserialization {
	WebDriver driver;
  @Test
  public void f() {
	  Response response = new RestAssured().get("https://automationexercise.com/api/productsList");
	  List<ObjtClass> ojcls = response.jsonPath().getList("products", ObjtClass.class);
	  
	  for(ObjtClass cls:ojcls ) {
		  if("Women".equalsIgnoreCase(cls.category.usertype.usertype)) {
			  System.out.println("Respective category type is:"+cls.category.category);
			  
		  }
		  
		
		  
	  }
	  
	  driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(ojcls.get(0).name);
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  driver.get("https://www.saucedemo.com/");
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
