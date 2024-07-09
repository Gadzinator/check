package main.java.ru.clevertec.check;

public class DefaultProductFactory implements ProductFactory {

	@Override
	public Product createProduct(String[] values) {
		int id = Integer.parseInt(values[0]);
		String description = values[1];
		double price = Double.parseDouble(values[2]);
		int quantityInStock = Integer.parseInt(values[3]);
		boolean isWholesale = Boolean.parseBoolean(values[4]);
		return new Product(id, description, price, quantityInStock, isWholesale);
	}
}
