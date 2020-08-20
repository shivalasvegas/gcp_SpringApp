package com.qa.hobbyproject.sfgsitetest;


import org.junit.After;

import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.WebDriver;


//@RunWith()
@RunWith(SpringRunner.class) 
@SpringBootTest
//@SeleniumTest(driver = ChromeDriver.class, baseUrl = "http://localhost:3003")
public class BasePage {
	
	private WebDriver driver;
	

	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shiva\\Documents\\AA_PROJECTS\\AA_hobbyProject\\JAVA\\HobbyProject\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();

	}
	
	WebElement target;
	//private final static Logger LOGGER = Logger.getLogger(BasePage.class.getName());
	//String logMessage;
	
//	@Test
//    public void test1() throws InterruptedException {
//        driver.get("http://google.com");
//    }
	
	@Test
	public void test2() throws InterruptedException {
		driver.get("http://localhost:3003/index.html");
		//target = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
		Thread.sleep(3000);
		//target.sendKeys();
		//target.submit();
//		target = driver.findElement(By.linkText("Images")); 
//		target.click();
		//Thread.sleep(9000);
	}
	
	@After
    public void after() {
        driver.quit();
    }
    
    

}
