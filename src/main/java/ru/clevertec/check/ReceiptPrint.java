package main.java.ru.clevertec.check;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class ReceiptPrint {

	private static final String DATE_TIME_HEADER = "Date; Time";
	private static final String ITEM_HEADER = "QTY;DESCRIPTION;PRICE;DISCOUNT;TOTAL";
	private static final String DISCOUNT_CARD_HEADER = "DISCOUNT CARD;DISCOUNT PERCENTAGE";
	private static final String TOTAL_HEADER = "TOTAL PRICE;TOTAL DISCOUNT;TOTAL WITH DISCOUNT";
	private static final String DATE_PATTERN = "dd.MM.yyyy;HH:mm:ss";

	public static void printReceipt(Receipt receipt, String discountCard, Map<String, DiscountCard> discountCards) {
		printDateTimeHeader(System.out);
		printReceiptDetails(receipt, discountCard, discountCards);
	}

	public static void writeReceipt(Receipt receipt, String discountCard, Map<String, DiscountCard> discountCards) throws IOException {
		try (PrintWriter writer = new PrintWriter(new FileWriter("result.csv"))) {
			printDateTimeHeader(writer);
			printReceiptDetailsToFile(writer, receipt, discountCard, discountCards);
			System.out.println("Receipt has been saved to file: result.csv");
		}
	}

	private static String getFormattedCurrentDateTime(String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		LocalDateTime now = LocalDateTime.now();
		return now.format(formatter);
	}

	private static void printDateTimeHeader(Appendable appendable) {
		String formattedDateTime = getFormattedCurrentDateTime(DATE_PATTERN);
		try {
			appendable.append(DATE_TIME_HEADER).append("\n");
			appendable.append(formattedDateTime).append("\n");
			appendable.append("\n");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static void printReceiptDetails(Receipt receipt, String discountCard, Map<String, DiscountCard> discountCards) {
		System.out.println(ITEM_HEADER);
		for (ReceiptItem item : receipt.getItems()) {
			System.out.println(formatReceiptItem(item));
		}
		System.out.println();
		printDiscountCardDetails(System.out, discountCard, discountCards);
		printTotalDetails(System.out, receipt);
	}

	private static void printReceiptDetailsToFile(PrintWriter writer, Receipt receipt, String discountCard, Map<String, DiscountCard> discountCards) {
		writer.println(ITEM_HEADER);
		for (ReceiptItem item : receipt.getItems()) {
			writer.println(formatReceiptItem(item));
		}
		writer.println();
		printDiscountCardDetails(writer, discountCard, discountCards);
		printTotalDetails(writer, receipt);
	}

	private static String formatReceiptItem(ReceiptItem item) {
		Product product = item.getProduct();
		int quantity = item.getQuantity();
		double price = product.getPrice();
		double discount = item.getDiscount();
		double total = item.getTotal();
		return String.format("%d;%s;%.2f$;%.2f;%.2f", quantity, product.getDescription(), price, discount, total);
	}

	private static void printDiscountCardDetails(Appendable appendable, String discountCard, Map<String, DiscountCard> discountCards) {
		if (discountCard != null && !discountCard.isEmpty()) {
			try {
				appendable.append(DISCOUNT_CARD_HEADER).append("\n");
				DiscountCard card = discountCards.get(discountCard);
				if (card != null) {
					appendable.append(String.format("%s;%.0f%%%n%n", discountCard, card.getDiscountRate()));
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	private static void printTotalDetails(Appendable appendable, Receipt receipt) {
		try {
			appendable.append(TOTAL_HEADER).append("\n");
			appendable.append(String.format("%.2f;%.2f;%.2f%n",
					receipt.getTotal(), receipt.getDiscount(), receipt.getFinalTotal()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
