package HybridJsonSelFrameTest.JsonSelTestSat;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class DeserializationTest {
	WebDriver driver;
  @Test
  public void f() {
new RestAssured();
//	  Response response = new RestAssured().get("https://automationexercise.com/api/productsList");
//	  List<ObjtClass> ojcls = response.jsonPath().getList("products", ObjtClass.class);
//
//	  for(ObjtClass cls:ojcls ) {
//		  if("Women".equalsIgnoreCase(cls.category.usertype.usertype)) {
//			  System.out.println("Respective category type is:"+cls.category.category);
//
//		  }
//
//
//
//	  }
//
//	  driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(ojcls.get(0).name);
  Response response = RestAssured.get("https://automationexercise.com/api/productsList");
  List<ObjtClass> ob = response.jsonPath().getList("products",ObjtClass.class);

  for( ObjtClass object : ob) {
	  if("women".equalsIgnoreCase(object.category.usertype.usertype)) {
		  System.out.println("Respective category type is:"+object.category.category);
	  }
  }
  }
  @BeforeMethod
  public void beforeMethod() {
//	  WebDriverManager.chromedriver().setup();
//	  driver = new ChromeDriver();
//	  driver.manage().window().maximize();
//	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//	  driver.get("https://www.saucedemo.com/");

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
