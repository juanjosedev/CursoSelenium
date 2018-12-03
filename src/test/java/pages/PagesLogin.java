package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import helpers.Helpers;

public class PagesLogin {
	
	private WebDriver driver;
	private By campoUsuario;
	private By campoPassword;
	private By botonLogin;
	
	public PagesLogin(WebDriver driver) {
		this.driver = driver;
		this.campoUsuario = By.className("userName");
		this.campoPassword = By.className("password");
		this.botonLogin = By.className("login");
	}
	
	public void login(String user, String pass) {
		buscarElemento(campoUsuario).sendKeys(user);
		buscarElemento(campoPassword).sendKeys(pass);
		buscarElemento(botonLogin).click();
		Helpers.esperarUnMomento(4);
	}
	
	public WebElement buscarElemento(By elemento) {
		return driver.findElement(elemento);
	}
	
}
