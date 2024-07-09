package main.java.ru.clevertec.check;

public class DefaultDiscountCardFactory implements DiscountCardFactory {

	@Override
	public DiscountCard createDiscountCard(String[] values) {
		String cardNumber = values[0];
		double discountRate = Double.parseDouble(values[1]);
		return new DiscountCard(cardNumber, discountRate);
	}
}
