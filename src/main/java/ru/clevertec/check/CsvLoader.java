package main.java.ru.clevertec.check;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CsvLoader {

	private static final String COMMA_SEPARATOR = ",";
	private final ProductFactory productFactory;
	private final DiscountCardFactory discountCardFactory;

	public CsvLoader(ProductFactory productFactory, DiscountCardFactory discountCardFactory) {
		this.productFactory = productFactory;
		this.discountCardFactory = discountCardFactory;
	}

	public  Map<Integer, Product> loadProducts(String filePath) throws IOException {
		Map<Integer, Product> products = new HashMap<>();
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] values = line.split(COMMA_SEPARATOR);
				final Product product = productFactory.createProduct(values);
				products.put(product.getId(), product);
			}

			return products;
		}
	}

	public Map<String, DiscountCard> loadDiscountCards(String filePath) throws IOException {
		Map<String, DiscountCard> discountCards = new HashMap<>();
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] values = line.split(COMMA_SEPARATOR);
				final DiscountCard discountCard = discountCardFactory.createDiscountCard(values);
				discountCards.put(discountCard.getCardNumber(), discountCard);
			}
		}

		return discountCards;
	}
}
