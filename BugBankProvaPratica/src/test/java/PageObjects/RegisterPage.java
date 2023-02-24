package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.Browser.Waits;

public class RegisterPage {

	private WebDriver driver;
	private Waits wait;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new Waits(this.driver);
	}

	public WebElement buttonRegister() {
		return driver.findElement(By.xpath("//div[@class='login__buttons']/button[@type='button']"));

	}

	public WebElement registerEmail() {
		return driver.findElement(
				By.xpath("//div[@id='__next']/div/div/div/div[@class='card__register']/form/div/input[@type='email']"));

	}

	public WebElement registerName() {
		return driver.findElement(
				By.xpath("//div[@id='__next']/div/div/div/div[@class='card__register']/form/div/input[@type='name']"));
	}

	public WebElement registerPassword() {
		return driver.findElement(By.xpath(
				"//div[@id='__next']/div/div/div/div[@class='card__register']/form/div/div/input[@placeholder='Informe sua senha']"));
	}

	public WebElement registerPasswordConfirm() {
		return driver.findElement(By.xpath(
				"//div[@id='__next']/div/div/div/div[@class='card__register']/form/div/div/input[@placeholder='Informe a confirmação da senha']"));
	}

	public WebElement addMoneyAccount() {
		return driver
				.findElement(By.xpath("//div[@id='__next']//label[@class='styles__Container-sc-1pngcbh-0 kIwoPV']"));
	}

	public WebElement toggleMoneyConfirm() {
		return driver.findElement(By.xpath("//label[@class='styles__Container-sc-1pngcbh-0 hsmFIT']"));
	}

	public WebElement confirmAccount() {
		return wait.visibilityOfElement(By.xpath(
				"//div[@id='__next']//button[@class='style__ContainerButton-sc-1wsixal-0 CMabB button__child']"));

	}

	public WebElement getTextModalConfirm() {
		return driver.findElement(By.id("modalText"));
	}

	public WebElement closeModal() {
		return wait.visibilityOfElement(By.id("btnCloseModal"));

	}

	public WebElement getHomeTextSpan() {

		return driver.findElement(By.xpath("//div/div/div/h1[@class='pages__Title-sc-1ee1f2s-4 cFmqIK']"));

	}

	public WebElement getGreenAccount() {
		return driver.findElement(By.xpath("//*[@style='color: green;']"));
	}

	public WebElement getModalRegisterConfirm() {
		return driver.findElement(By.id("modalText"));
	}

}