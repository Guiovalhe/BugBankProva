package Tasks;

import org.openqa.selenium.WebDriver;

import Framework.Utils.FileOperation;
import PageObjects.TransfPage;
import Validations.TransfValidation;


public class TransfTask {
	private WebDriver driver;
	private TransfPage transfPage;
	private TransfValidation transfValidation;
	
	public TransfTask(WebDriver driver) {
		this.driver = driver;
		transfPage = new TransfPage(this.driver);
		transfValidation = new TransfValidation(this.driver);
	}
	
	
	public void transfTask() {
		transfPage.transfButton().click();
		transfValidation.validationTransferPage();
		transfPage.accountTransf().sendKeys(FileOperation.getProperties("accountinfo").getProperty("firstAccount"));
		transfPage.digitTransf().sendKeys(FileOperation.getProperties("accountinfo").getProperty("firstDigit"));
		transfPage.valueTransf().sendKeys("300");
		transfPage.descTransf().sendKeys("Pagamento jogo do bicho");
		transfValidation.validationInsertedData();
		transfPage.buttonConfirmTransf().click();
		transfValidation.validationModalConfirmation();
		transfPage.closeModalTransf().click();
		
	}
}
