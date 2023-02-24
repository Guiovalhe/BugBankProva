package Validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.RegisterPage;

public class GenericValidation {
	
	
	private WebDriver driver;
	private Waits wait;
	private RegisterPage homePage;
	
	public GenericValidation(WebDriver driver) {
		
		this.driver = driver;
		homePage = new RegisterPage(this.driver);
		wait = new Waits(this.driver);

	}
	public void validationHomePage() {
		
		try {
			wait.loadElement(homePage.getHomeTextSpan());
			String label = homePage.getHomeTextSpan().getText();
			Assertions.assertEquals("O banco com bugs e falhas do seu jeito", label);
			Report.log(Status.PASS, "Acessou a pagina principal do banco!", Screenshot.captureBase64(driver));
		}catch(Exception e) {
			
			Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
		}
	}
	
	public void loggoutLoginValidationSA() {
		
		try {
			wait.loadElement(homePage.getHomeTextSpan());
			String label = homePage.getHomeTextSpan().getText();
			Assertions.assertEquals("O banco com bugs e falhas do seu jeito", label);
			Report.log(Status.PASS, "Deslogou da conta pagadora e acessou a pagina principal do banco.", Screenshot.captureBase64(driver));
		}catch(Exception e) {
			
			Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
		}
	}
	public void loggoutLoginValidationFA() {
		
		try {
			wait.loadElement(homePage.getHomeTextSpan());
			String label = homePage.getHomeTextSpan().getText();
			Assertions.assertEquals("O banco com bugs e falhas do seu jeito", label);
			Report.log(Status.PASS, "Deslogou da conta que recebeu e acessou a pagina principal do banco.", Screenshot.captureBase64(driver));
		}catch(Exception e) {
			
			Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
		}
	}
}