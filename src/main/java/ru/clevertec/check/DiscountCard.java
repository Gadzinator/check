package main.java.ru.clevertec.check;

public class DiscountCard {

	private String cardNumber;
	private double discountRate;

	private DiscountCard(DiscountCardBuilder builder) {
		this.cardNumber = builder.cardNumber;
		this.discountRate = builder.discountRate;
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

	public static class DiscountCardBuilder {
		private String cardNumber;
		private double discountRate;

		public DiscountCardBuilder setCardNumber(String cardNumber) {
			this.cardNumber = cardNumber;
			return this;
		}

		public DiscountCardBuilder setDiscountRate(double discountRate) {
			this.discountRate = discountRate;
			return this;
		}

		public DiscountCard build() {
			return new DiscountCard(this);
		}
	}
}
