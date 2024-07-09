package main.java.ru.clevertec.check;

public class DefaultProductFactory implements ProductFactory {

	@Override
	public Product createProduct(String[] values) {
		return new Product.ProductBuilder()
				.setId(Integer.parseInt(values[0]))
				.setDescription(values[1])
				.setPrice(Double.parseDouble(values[2]))
				.setQuantityInStock(Integer.parseInt(values[3]))
				.setIsWholesale(Boolean.parseBoolean(values[4]))
				.build();
	}
}
