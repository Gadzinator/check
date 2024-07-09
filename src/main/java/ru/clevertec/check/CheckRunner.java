package main.java.ru.clevertec.check;

import java.io.IOException;

public class CheckRunner {

	public static void main(String[] args) {
		args = new String[]{"3-1 2-5 5-1 discountCard=1111 balanceDebitCard=100"};
		try {
			ReceiptGenerator generator = new ReceiptGenerator();
			generator.run(args);
		} catch (IOException e) {
			System.err.println("Error reading CSV files: " + e.getMessage());
		} catch (IllegalArgumentException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
