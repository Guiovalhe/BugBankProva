package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.Browser.Waits;

public class TransfPage {

	private WebDriver driver;
	private Waits wait;

	public TransfPage(WebDriver driver) {		
		this.driver = driver;
		this.wait = new Waits(this.driver);
	}
	   public WebElement transfButton() {	   
		   return driver.findElement(By.xpath("//div[@id='__next']//a[@class='home__Button-sc-1auj767-15 heVuFC']"));
		   
	   }
		
	   public WebElement accountTransf() {
		   return driver.findElement(By.xpath("//div[@id='__next']/div/div/form/div/div/input[@placeholder='Informe o número da conta']"));
	   }
	   
	   public WebElement digitTransf() {	   
		   return driver.findElement(By.xpath("//div[@id='__next']/div/div/form/div/div/input[@name='digit']"));
		   
	   }
		
	   public WebElement valueTransf() {	   
		   return driver.findElement(By.xpath("//div[@id='__next']/div/div/form/div/input[@placeholder='Informe o valor da transferência']"));
		   
	   }
	   
	   public WebElement descTransf() {
		   return driver.findElement(By.xpath("//div[@id='__next']/div/div/form/div/input[@placeholder='Informe uma descrição']"));
	   }
	   
	   public WebElement buttonConfirmTransf() {	   
		   return wait.visibilityOfElement(By.xpath("//div[@id='__next']/div/div/form/button"));
		   
	   }
	   
	   public WebElement closeModalTransf() {	   
		   return driver.findElement(By.id("btnCloseModal"));   
	   }
	   
		public WebElement getBackButton() {
			return driver.findElement(By.id("btnBack"));

		}

		public WebElement getModalConfirmTransfer() {
			return driver.findElement(By.id("modalText"));
		}
}
