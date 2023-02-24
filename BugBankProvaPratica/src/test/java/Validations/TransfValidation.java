package Validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.TransfPage;

public class TransfValidation {

	private WebDriver driver;
	private Waits wait;
	private TransfPage transfPage;

	public TransfValidation(WebDriver driver) {

		this.driver = driver;
		transfPage = new TransfPage(this.driver);
		wait = new Waits(this.driver);

	}

	public void validationTransferPage() {

		try {
			wait.visibilityOfElement(By.id("btnBack"));
			Assertions.assertTrue(transfPage.getBackButton().isDisplayed());
			Report.log(Status.INFO, "Pagina de transferência acessada.");
		} catch (Exception e) {

			Report.log(Status.FAIL, e.getMessage(), Screenshot.capture(driver));

		}
	}

	public void validationInsertedData() {

		try {
			wait.visibilityOfElement(By.id("btnBack"));
			Assertions.assertTrue(transfPage.getBackButton().isDisplayed());
			Report.log(Status.PASS, "Inseriu os dados para transferir.", Screenshot.captureBase64(driver));
		} catch (Exception e) {

			Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));

		}
	}

	public void validationModalConfirmation() {

		try {
			String message = wait.loadElement(transfPage.getModalConfirmTransfer()).getAttribute("innerHTML");
			Assertions.assertTrue(message != "");
			Report.log(Status.INFO, "Status da transferência: " + message);

		} catch (Exception e) {
			Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
		}

	}
}