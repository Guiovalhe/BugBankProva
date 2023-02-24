package Tasks;

import org.openqa.selenium.WebDriver;
import Framework.Utils.FileOperation;
import PageObjects.LoginPage;
import Validations.RegisterValidation;

public class LoginTask {
	private WebDriver driver;
	private RegisterValidation loginValidation;
	private LoginPage loginPage;
	
	public LoginTask(WebDriver driver) {
		this.driver = driver;
		loginPage = new LoginPage(this.driver);
		loginValidation = new RegisterValidation(this.driver);
	}


	public void loginFirstAccount() {
		loginPage.loginEmail().sendKeys(FileOperation.getProperties("form").getProperty("firstAccountEmail"));
		loginPage.loginPassword().sendKeys(FileOperation.getProperties("form").getProperty("firstAccountPassword"));
		loginPage.buttonLogin().click();
		loginValidation.accountLogged();
	}

	public void exitLogin() {
		loginPage.exitAccount().click();
	}

	public void loginSecondAccount() {
		loginPage.loginEmail().sendKeys(FileOperation.getProperties("form").getProperty("secondAccountEmail"));
		loginPage.loginPassword().sendKeys(FileOperation.getProperties("form").getProperty("secondAccountPassword"));
		loginPage.buttonLogin().click();
		loginValidation.accountLogged();
	}

}