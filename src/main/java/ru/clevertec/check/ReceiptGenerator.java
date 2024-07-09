package main.java.ru.clevertec.check;

import java.io.IOException;
import java.util.Map;

public class ReceiptGenerator {

	public void run(String[] args) throws IOException {
		Map<Integer, Product> products = CsvLoader.loadProducts("./src/main/resources/products.csv");
		Map<String, DiscountCard> discountCards = CsvLoader.loadDiscountCards("./src/main/resources/discountCards.csv");

		CommandLineParser parser = new CommandLineParser(args);
		Receipt receipt = generateReceipt(parser, products, discountCards);
		ReceiptPrint.printReceipt(receipt, parser.getDiscountCard(), discountCards);
		ReceiptPrint.writeReceipt(receipt, parser.getDiscountCard(), discountCards);
	}

	private Receipt generateReceipt(CommandLineParser parser, Map<Integer, Product> products, Map<String, DiscountCard> discountCards) {
		Receipt receipt = new Receipt();

		for (Integer productId : parser.getProducts().keySet()) {
			int quantity = parser.getProducts().get(productId);

			if (!products.containsKey(productId)) {
				throw new IllegalArgumentException("Product ID not found: " + productId);
			}

			Product product = products.get(productId);
			double discountRate = 0.0;

			if (product.isWholesale() && quantity >= 5) {
				double wholesaleDiscountRate = 10.0;
				ReceiptItem item = new ReceiptItem(product, quantity, wholesaleDiscountRate);
				receipt.addItem(item);
			} else {
				if (parser.getDiscountCard() != null && discountCards.containsKey(parser.getDiscountCard())) {
					discountRate = discountCards.get(parser.getDiscountCard()).getDiscountRate();
				}
				ReceiptItem item = new ReceiptItem(product, quantity, discountRate);
				receipt.addItem(item);
			}
		}

		return receipt;
	}
}
