package com.qualitystream.tutorial;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryTours_AutomatedTest {
	
	private WebDriver driver;
	By registerLinkLocator= By.linkText("REGISTER");  /*localizador registro en codigo html */
	By registerPageLocator= By.xpath("//img[@src='images/mast_register.gif']"); /* localizador que busca en la ruta para encontrar imagne de registro*/
	By usernameLocator= By.id("email");
	By passwordLocator= By.name("password");
	By confirmPasswordLocator= By.cssSelector("input[name='confirmPassword']");
	By registerBtnlocator= By.name("submit");
	By userLocator= By.name("userName");
	By passLocator= By.name("password");
	By signInBtnLocator= By.name("submit");
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/");
	}

	@After
	public void tearDown() throws Exception {
		//hacer despues del setUp(), salir ventana quit
		//driver.quit();	
		
	}
	//se procede a automatizar escenarios escenario con registerUser:
	 
	  //1. Dar clic en Regiter
	  //2. Completar campos para registrar usuario
	 // 3. Confirmar mensaje del usuario registrado


	@Test
	public void registerUser() throws InterruptedException {
		driver.findElement(registerLinkLocator).click();
		Thread.sleep(2000);
		if(driver.findElement(registerPageLocator).isDisplayed()) {
			driver.findElement(usernameLocator).sendKeys("qualityadmin");
			driver.findElement(passwordLocator).sendKeys("pass1");
			driver.findElement(confirmPasswordLocator).sendKeys("pass1");
			driver.findElement(registerBtnlocator).click();
			
		}
		else {
			System.out.print("Register pages was not found");
		}
	
		List<WebElement> fonts = driver.findElements(By.tagName("font"));
		
		assertEquals("",fonts.get(7).getText());
	}
	@Test
	public void singIn() {
		
	}

}
