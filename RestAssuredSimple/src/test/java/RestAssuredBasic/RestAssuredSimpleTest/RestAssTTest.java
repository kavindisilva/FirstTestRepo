package RestAssuredBasic.RestAssuredSimpleTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssTTest {
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
//	  WebDriverManager.chromedriver().setup();
//	  driver = new ChromeDriver();
//	  driver.manage().window().maximize();
//	 driver.get("https://www.saucedemo.com/");
//	  
	
	 WebDriverManager.chromedriver().setup();

	    ChromeOptions options = new ChromeOptions();

	    // Detect CI environment (GitHub Actions sets this automatically)
	    String ci = System.getenv("CI");

	    if (ci != null && ci.equalsIgnoreCase("true")) {
	        options.addArguments("--headless=new");
	        options.addArguments("--no-sandbox");
	        options.addArguments("--disable-dev-shm-usage");
	        options.addArguments("--disable-gpu");
	    }

	    driver = new ChromeDriver(options);

	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.get("https://www.saucedemo.com/");
}


@AfterMethod
public void afterMethod() {
	  driver.quit();
}
}
