package Framework.Utils;

import java.util.Locale;

import com.github.javafaker.Faker;

public class FakersGeneration {
	
	
	private Faker faker;
	private String accountName;
	private String accountPassword;
	private String accountEmail;

	
	public FakersGeneration() {
		
		faker = new Faker(new Locale("pt-BR"));
		
	}
	
	public String accountName() {
		accountName = faker.name().fullName();
		return accountName;
	}

	
	public String accountPassword() {
		accountPassword = faker.gameOfThrones().house();
		return accountPassword;
	}
	
	public String accountEmail() {
		accountEmail = faker.internet().emailAddress();
		return accountEmail;
	}
}
