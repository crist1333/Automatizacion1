package com.qualitystream.tutorial;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		/*  Paso a paso  metodo y contenido setUp()
		    se da set a las propiedades, se crea un nuevo chrome driver para utilizar la instancia de chrome, se maximiza ventana, y se pide get para traer google
		 */
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/");
	}
	
	@Test
	public void testGooglePage() {
		
		WebElement searchbox= driver.findElement(By.name("q"));
		
		searchbox.clear();
		
		searchbox.sendKeys("quality-stream Introduccion a la Automatizacion de Pruebas de Software");
		
		searchbox.submit();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		assertEquals("quality-stream Introduccion a la Automatizacion de Pruebas de Software",driver.getTitle());
		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
		
}
