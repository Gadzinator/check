package main.java.ru.clevertec.check;

import java.io.IOException;

public class CheckRunner {

	public static void main(String[] args) {
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
