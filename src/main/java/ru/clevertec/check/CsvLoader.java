package main.java.ru.clevertec.check;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CsvLoader {

	private static final String COMMA_SEPARATOR = ",";

	public static Map<Integer, Product> loadProducts(String filePath) throws IOException {
		Map<Integer, Product> products = new HashMap<>();
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] values = line.split(COMMA_SEPARATOR);
				int id = Integer.parseInt(values[0]);
				String description = values[1];
				double price = Double.parseDouble(values[2]);
				int quantityInStock = Integer.parseInt(values[3]);
				boolean isWholesale = Boolean.parseBoolean(values[4]);
				Product product = new Product(id, description, price, quantityInStock, isWholesale);
				products.put(id, product);
			}

			return products;
		}
	}

	public static Map<String, DiscountCard> loadDiscountCards(String filePath) throws IOException {
		Map<String, DiscountCard> discountCards = new HashMap<>();
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] values = line.split(COMMA_SEPARATOR);
				String cardNumber = values[0];
				double discountRate = Double.parseDouble(values[1]);
				DiscountCard discountCard = new DiscountCard(cardNumber, discountRate);
				discountCards.put(cardNumber, discountCard);
			}
		}

		return discountCards;
	}
}
