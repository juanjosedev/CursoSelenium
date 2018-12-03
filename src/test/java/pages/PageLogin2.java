package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helpers.Helpers;

public class PageLogin2 {
	
	private WebDriver driver;
	private WebElement campoUsuario;
	private WebElement campoPassword;
	private WebElement botonLogin;
	
	public PageLogin2(WebDriver driver) {
		this.driver = driver;
		this.campoUsuario = null;
		this.campoPassword = null;
		this.botonLogin = null;
	}
	
	public void login(String user, String pass) {
		campoUsuario = buscarElemento("userName");
		campoPassword = buscarElemento("password");
		botonLogin = buscarElemento("btn_login");
		
		campoUsuario.sendKeys(user);
		campoPassword.sendKeys(pass);
		botonLogin.click();
		
		Helpers.esperarUnMomento(4);
	}
	
	public WebElement buscarElemento(String elemento) {
		return driver.findElement(By.id(elemento));
	}
	
	
}
