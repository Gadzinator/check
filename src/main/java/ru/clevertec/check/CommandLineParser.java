package main.java.ru.clevertec.check;

import java.util.HashMap;
import java.util.Map;

public class CommandLineParser {

	private static final String DISCOUNT_CARD_PREFIX = "discountCard=";
	private static final String BALANCE_DEBIT_CARD_PREFIX = "balanceDebitCard=";
	private static final String ARG_SEPARATOR = " ";
	private static final String EQUALS_SIGN_SEPARATOR = "=";
	private static final String DASH_SEPARATOR = "-";
	private final Map<Integer, Integer> products;
	private String discountCard;
	private double balance;

	public CommandLineParser(String[] args) throws IllegalArgumentException {
		products = new HashMap<>();
		parseArgs(args);
	}

	private void parseArgs(String[] args) throws IllegalArgumentException {
		for (String arg : args) {
			String[] productStrings = arg.split(ARG_SEPARATOR);
			for (String productString : productStrings) {
				if (productString.startsWith(DISCOUNT_CARD_PREFIX)) {
					parseDiscountCard(productString);
				} else if (productString.startsWith(BALANCE_DEBIT_CARD_PREFIX)) {
					parseBalance(productString);
				} else {
					parseProduct(productString);
				}
			}
		}
	}

	private void parseDiscountCard(String discountCardArg) {
		discountCard = discountCardArg.split(EQUALS_SIGN_SEPARATOR)[1];
	}

	private void parseBalance(String balanceArg) throws IllegalArgumentException {
		try {
			balance = Double.parseDouble(balanceArg.split(EQUALS_SIGN_SEPARATOR)[1]);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Invalid balance format: " + balanceArg.split(EQUALS_SIGN_SEPARATOR)[1]);
		}
	}

	private void parseProduct(String productString) throws IllegalArgumentException {
		if (productString.contains(DASH_SEPARATOR)) {
			String[] parts = productString.split(DASH_SEPARATOR);
			if (parts.length != 2) {
				throw new IllegalArgumentException("Invalid product format: " + productString);
			}
			try {
				int id = Integer.parseInt(parts[0]);
				int quantity = Integer.parseInt(parts[1]);
				if (quantity <= 0) {
					throw new IllegalArgumentException("Quantity must be greater than zero: " + quantity);
				}
				products.put(id, products.getOrDefault(id, 0) + quantity);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("Invalid id or quantity format: " + productString);
			}
		}
	}

	public Map<Integer, Integer> getProducts() {
		return products;
	}

	public String getDiscountCard() {
		return discountCard;
	}

	public double getBalance() {
		return balance;
	}
}
