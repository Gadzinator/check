package main.java.ru.clevertec.check;

public class DiscountCard {

	private String cardNumber;
	private double discountRate;

	public DiscountCard(String cardNumber, double discountRate) {
		this.cardNumber = cardNumber;
		this.discountRate = discountRate;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	@Override
	public String toString() {
		return "DiscountCard{" +
				"cardNumber='" + cardNumber + '\'' +
				", discountRate=" + discountRate +
				'}';
	}
}
