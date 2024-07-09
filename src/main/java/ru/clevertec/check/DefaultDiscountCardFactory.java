package main.java.ru.clevertec.check;

public class DefaultDiscountCardFactory implements DiscountCardFactory {

	@Override
	public DiscountCard createDiscountCard(String[] values) {
		return new DiscountCard.DiscountCardBuilder()
				.setCardNumber(values[0])
				.setDiscountRate(Double.parseDouble(values[1]))
				.build();
	}
}
