package Tasks;

import org.openqa.selenium.WebDriver;

import Framework.Utils.FakersGeneration;
import Framework.Utils.FileOperation;
import PageObjects.RegisterPage;
import Validations.GenericValidation;
import Validations.RegisterValidation;

public class RegisterTask {
	private WebDriver driver;
	private RegisterPage registerPage;
	private FakersGeneration fakers;
	private RegisterValidation registerValidation;
	private GenericValidation genericValidation;
	
	public RegisterTask(WebDriver driver) {
		this.driver = driver;
		registerPage = new RegisterPage(this.driver);
		fakers = new FakersGeneration();
		registerValidation = new RegisterValidation(this.driver);
		genericValidation = new GenericValidation(this.driver);
	}

	public void registerFirstAccount() {
		
		genericValidation.validationHomePage();;
		//Primeira Conta FIRST ACCOUNT (random nome, senha e email)
		String accountName = fakers.accountName();
		String accountPassword = fakers.accountPassword(); 
		String accountEmail = fakers.accountEmail();
		FileOperation.setProperties("form", "firstAccountName", accountName);
		FileOperation.setProperties("form", "firstAccountPassword", accountPassword);
		FileOperation.setProperties("form", "firstAccountEmail", accountEmail);
		
		registerPage.buttonRegister().click();
		registerPage.registerEmail().sendKeys(accountEmail);
		registerPage.registerName().sendKeys(accountName);
		registerPage.registerPassword().sendKeys(accountPassword);
		registerPage.registerPasswordConfirm().sendKeys(accountPassword);
		registerValidation.toggleMoneyConfirm();
		registerPage.addMoneyAccount().click();
		registerPage.confirmAccount().click();
		registerValidation.validationAccountCreated();
		
		// salva o numero da conta e digito para ser usado posteriormente
		String accountInfo = registerPage.getTextModalConfirm().getAttribute("innerHTML").replaceAll("[\\D]", "");
		int account = accountInfo.length();
		String number = accountInfo.substring(0,account-1);
		String digit = accountInfo.substring((account-1), account);
		FileOperation.setProperties("accountinfo", "firstAccount", number);
		FileOperation.setProperties("accountinfo", "firstDigit", digit);
		registerPage.closeModal().click();
	}

	public void registerSecondAccount() {
		//Segunda conta SECOND ACCOUNT (random nome, senha e email)
		String accountName = fakers.accountName();
		String accountPassword = fakers.accountPassword(); 
		String accountEmail = fakers.accountEmail();
		FileOperation.setProperties("form", "secondAccountName", accountName);
		FileOperation.setProperties("form", "secondAccountPassword", accountPassword);
		FileOperation.setProperties("form", "secondAccountEmail", accountEmail);
		
		registerPage.buttonRegister().click();
		registerPage.registerEmail().clear();
		registerPage.registerName().clear();
		registerPage.registerPassword().clear();
		registerPage.registerPasswordConfirm().clear();
		registerPage.registerEmail().sendKeys(accountEmail);
		registerPage.registerName().sendKeys(accountName);
		registerPage.registerPassword().sendKeys(accountPassword);
		registerPage.registerPasswordConfirm().sendKeys(accountPassword);
		registerPage.confirmAccount().click();
		
		// salva o numero da conta e digito para ser usado posteriormente
		String accountInfo = registerPage.getTextModalConfirm().getAttribute("innerHTML").replaceAll("[\\D]", "");
		int account = accountInfo.length();
		String number = accountInfo.substring(0,account-1);
		String digit = accountInfo.substring((account-1), account);
		FileOperation.setProperties("accountinfo", "secondAccount", number);
		FileOperation.setProperties("accountinfo", "secondDigit", digit);
		
		registerValidation.validationAccountCreated();
		registerPage.closeModal().click();

	}
}