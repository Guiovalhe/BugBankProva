package Validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.StatementPage;

public class StatementValidation {

	private WebDriver driver;
	private StatementPage statementPage;
	private Waits wait;

	public StatementValidation(WebDriver driver) {

		this.driver = driver;
		statementPage = new StatementPage(this.driver);
		wait = new Waits(this.driver);

	}

	public void menuNavSecondAccount() {

		try {
			wait.visibilityOfElement(By.id("btn-TRANSFERÊNCIA"));
			Assertions.assertTrue(statementPage.statementButton().isDisplayed());
			Report.log(Status.INFO, "A conta pagadora voltou ao menu principal", Screenshot.captureBase64(driver));
		} catch (Exception e) {

			Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
		}
	}

	// segunda conta criada
	public void validBalanceSA() {

		try {
			wait.visibilityOfElement(By.id("textDescription"));
			Assertions.assertTrue(statementPage.getBalanceWithdrawal().isDisplayed());
			Report.log(Status.INFO, "Entrou no menu de extrato.");
			Report.log(Status.PASS, "Validou a transferência da conta pagadora com sucesso.",
					Screenshot.captureBase64(driver));
		} catch (Exception e) {

			Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));

		}
	}

	// primeira conta criada
	public void validBalanceFA() {

		try {
			wait.visibilityOfElement(By.id("textDescription"));
			Assertions.assertTrue(statementPage.getBalanceInput().isDisplayed());
			Report.log(Status.INFO, "Entrou no menu de extrato.");
			Report.log(Status.PASS, "Validou a transferência da conta recebedora com sucesso.",
					Screenshot.captureBase64(driver));
		} catch (Exception e) {

			Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));

		}
	}
}