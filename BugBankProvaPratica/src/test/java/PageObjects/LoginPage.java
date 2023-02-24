package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.Browser.Waits;

public class LoginPage {

	private WebDriver driver;
	private Waits wait;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new Waits(this.driver);
	}


	public WebElement buttonBackLogin() {
		return driver.findElement(By.id("btnBackButton"));
	}

	public WebElement loginEmail() {
		return driver.findElement(By.xpath(
				"//div[@id='__next']/div/div/div/div[@class='card__login']/form/div/input[@placeholder='Informe seu e-mail']"));

	}

	public WebElement loginPassword() {
		return driver.findElement(By.xpath(
				"//div[@id='__next']/div/div/div/div[@class='card__login']/form/div/div/input[@placeholder='Informe sua senha']"));

	}

	public WebElement buttonLogin() {
		return wait.visibilityOfElement(By.xpath("//div[@class='login__buttons']/button[@type='submit']"));

	}
	
	public WebElement getLoggedAccount() {
		return driver.findElement(By.xpath("//div/div/div[@class='home__Footer-sc-1auj767-16 eeLkgF']/p[@class='home__Text-sc-1auj767-9 jjmPHj']"));
	}
	
	public WebElement exitAccount() {
		return driver.findElement(By.id("btnExit"));

	}
	

}