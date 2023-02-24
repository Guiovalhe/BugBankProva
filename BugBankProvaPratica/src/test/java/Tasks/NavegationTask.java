package Tasks;

import org.openqa.selenium.WebDriver;

import Framework.Utils.FakersGeneration;
import Framework.Utils.FileOperation;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import PageObjects.StatementPage;
import PageObjects.TransfPage;
import Validations.GenericValidation;
import Validations.RegisterValidation;
import Validations.StatementValidation;

public class NavegationTask {
	private WebDriver driver;
	private LoginPage loginPage;
	private RegisterValidation loginValidation;
	private GenericValidation genericValidation;
	private TransfPage transfPage;
	private StatementPage statementPage;
	private StatementValidation statementValidation;
	
	public NavegationTask(WebDriver driver) {
		this.driver = driver;
		loginPage = new LoginPage(this.driver);
		transfPage = new TransfPage(this.driver);
		statementPage = new StatementPage(this.driver);
		loginValidation = new RegisterValidation(this.driver);
		statementValidation = new StatementValidation(this.driver);
		genericValidation = new GenericValidation(this.driver);
	}
	
	public void navTaskSecondAccount() {
		transfPage.getBackButton().click();
		statementValidation.menuNavSecondAccount();
		statementPage.statementButton().click();
		statementValidation.validBalanceSA();
		loginPage.exitAccount().click();		
		genericValidation.loggoutLoginValidationSA();
		
	}
	public void navTaskFirstAccount() {
		loginPage.loginEmail().sendKeys(FileOperation.getProperties("form").getProperty("firstAccountEmail"));
		loginPage.loginPassword().sendKeys(FileOperation.getProperties("form").getProperty("firstAccountPassword"));
		loginPage.buttonLogin().click();
		loginValidation.accountLogged();
		statementPage.statementButton().click();
		statementValidation.validBalanceFA();
		loginPage.exitAccount().click();		
		genericValidation.loggoutLoginValidationFA();
	}
}