package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.Browser.Waits;

public class StatementPage {

	private WebDriver driver;
	private Waits wait;

	public StatementPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new Waits(this.driver);
	}

	public WebElement statementButton() {
		return driver.findElement(By.id("btn-EXTRATO"));
	}
	public WebElement getBalanceWithdrawal() {

		return driver.findElement(By.xpath("//div[@class='bank-statement__Transaction-sc-7n8vh8-13 fUCxBP']//p[@type='withdrawal']"));
	}
	public WebElement getBalanceInput() {

		return driver.findElement(By.xpath("//div[@class='bank-statement__Transaction-sc-7n8vh8-13 fUCxBP']//p[@type='input']"));
	}
}
