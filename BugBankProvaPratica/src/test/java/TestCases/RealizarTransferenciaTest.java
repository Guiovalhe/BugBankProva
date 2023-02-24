package TestCases;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import Framework.TestBase;
import Framework.Report.Report;
import Framework.Report.ReportType;
import Framework.Report.Screenshot;
import Tasks.LoginTask;
import Tasks.NavegationTask;
import Tasks.RegisterTask;
import Tasks.TransfTask;
import Validations.RegisterValidation;

public class RealizarTransferenciaTest extends TestBase {
	private WebDriver driver = this.getDriverManager();

	RegisterTask registerTask = new RegisterTask(driver);
	LoginTask loginTask = new LoginTask(driver);
	TransfTask transfTask = new TransfTask(driver);
	RegisterValidation loginValidation = new RegisterValidation(driver);
	NavegationTask navegationTask = new NavegationTask(driver);

	@Test
	public void realizarCompra() {

		try {

			Report.createTest("Realizando transferências entre contas", ReportType.GROUP);
			Report.createStep("Registrando as contas.");
			registerTask.registerFirstAccount();
			registerTask.registerSecondAccount();
			Report.createStep("Login na primeira conta para verificação (essa conta receberá).");
			loginTask.loginFirstAccount();
			loginTask.exitLogin();
			Report.createStep("Login na segunda conta para realizar a transferência (essa conta pagará).");
			loginTask.loginSecondAccount();
			transfTask.transfTask();
			Report.createStep("Verificando extrato da conta pagadora.");
			navegationTask.navTaskSecondAccount();
			Report.createStep("Logando na conta que recebeu e verificando extrato.");
			navegationTask.navTaskFirstAccount();
			

		} catch (Exception e) {

			Report.log(Status.FAIL, e.getMessage(), Screenshot.capture(driver));
		}
	}
}
