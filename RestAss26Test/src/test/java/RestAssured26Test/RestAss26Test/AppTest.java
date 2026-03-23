package RestAssured26Test.RestAss26Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

//import io.restassured.RestAssured;

/**
 * Unit test for simple App.
 */
public class AppTest {
	WebDriver driver;

    @Test
    public void test() {
    	Response response = RestAssured.given()
    	.when()
    		.get("https://automationexercise.com/api/createAccount");
    	System.out.println(response.getBody().asString());

    	response.then()
    		.statusCode(200);
    		//.body("email", equalTo("test@test.com"));
    		
    	
    	
//    	String name = response.jsonPath().getString("products[0].name");
//    	//System.setProperty("webdriver.chrome.driver", "/Users/udarajayawardhane/Documents/KavindiEclipse/Selenium libs/chromedriver-mac-arm64/chromedriver");
//    	WebDriverManager.chromedriver().setup();
//    	driver = new ChromeDriver();
//    	driver.get("https://www.saucedemo.com/");
//    	driver.findElement(By.id("user-name")).sendKeys(name);
//       
    }
}
