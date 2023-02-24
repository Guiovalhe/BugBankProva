package Validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;

public class RegisterValidation {
	
	
	private WebDriver driver;
	private Waits wait;
	private RegisterPage registerPage;
	private LoginPage loginPage;
	
	public RegisterValidation(WebDriver driver) {
		
		this.driver = driver;
		registerPage = new RegisterPage(this.driver);
		loginPage = new LoginPage(this.driver);
		wait = new Waits(this.driver);

	}
	
	public void validationAccountCreated() {
		
		try {
			wait.loadElement(registerPage.getGreenAccount());
			Report.log(Status.PASS, "Conta criada com sucesso", Screenshot.captureBase64(driver));
		}catch(Exception e) {
			
			Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
		}
	}
	
	
	public void accountLogged() {
		
		try {
			wait.visibilityOfElement(By.id("btn-TRANSFERÊNCIA"));
			Assertions.assertTrue(loginPage.exitAccount().isDisplayed());
			wait.loadElement(loginPage.getLoggedAccount());
			Report.log(Status.PASS, "A conta está logada", Screenshot.captureBase64(driver));
		}catch(Exception e) {
			
			Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
		}
	}
	
	public void validationModalRegisterConfirm() {

		try {
			String message = wait.loadElement(registerPage.getModalRegisterConfirm()).getAttribute("innerHTML");
			Assertions.assertTrue(message != "");
			Report.log(Status.PASS, "Conta criada com sucesso");
		} catch (Exception e) {
			Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
		}

	}
	public void toggleMoneyConfirm() {

		try {
			wait.loadElement(registerPage.addMoneyAccount());
			Report.log(Status.INFO, "A conta sera criada com dinheiro.", Screenshot.captureBase64(driver));
		} catch (Exception e) {
			Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));

		}
	}
}
