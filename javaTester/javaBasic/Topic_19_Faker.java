package javaBasic;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

public class Topic_19_Faker {

	public static void main(String[] main) {
		Faker faker = new Faker();

		faker.address().firstName();
		faker.finance().creditCard(CreditCardType.VISA);
	}
}
