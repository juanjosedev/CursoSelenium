package test;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import helpers.Helpers;
import pages.PagesLogin;

public class Tests {
	
	private WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.newtours.demoaut.com/");
	
		Helpers.esperarUnMomento(3);

		
	}
	
	@Test
	public void pruebaUno() {
		
		PagesLogin pl = new PagesLogin(driver);
		pl.login("user", "user");
		
		String xpathExpression = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p/font/b";
		Assert.assertTrue(driver.findElement(By.xpath(xpathExpression)).getText().contains("Welcome back to"));
	}
	
	@Test
	public void pruebaDos() {
		
		PagesLogin pl = new PagesLogin(driver);
		pl.login("mercury", "mercury");
		
		String xpathExpression = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font";
		
		String resultado = driver.findElement(By.xpath(xpathExpression)).getText();
		String esperado = "Use our Flight Finder";
		
		Assert.assertTrue(resultado.contains(esperado));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
