package main.java.ru.clevertec.check;

public class Product {

	private final int id;
	private final String description;
	private final double price;
	private final int quantityInStock;
	private final boolean isWholesale;

	private Product(ProductBuilder builder) {
		this.id = builder.id;
		this.description = builder.description;
		this.price = builder.price;
		this.quantityInStock = builder.quantityInStock;
		this.isWholesale = builder.isWholesale;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantityInStock() {
		return quantityInStock;
	}

	public boolean isWholesale() {
		return isWholesale;
	}

	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", description='" + description + '\'' +
				", price=" + price +
				", quantityInStock=" + quantityInStock +
				", isWholesale=" + isWholesale +
				'}';
	}

	public static class ProductBuilder {
		private int id;
		private String description;
		private double price;
		private int quantityInStock;
		private boolean isWholesale;

		public ProductBuilder setId(int id) {
			this.id = id;
			return this;
		}

		public ProductBuilder setDescription(String description) {
			this.description = description;
			return this;
		}

		public ProductBuilder setPrice(double price) {
			this.price = price;
			return this;
		}

		public ProductBuilder setQuantityInStock(int quantityInStock) {
			this.quantityInStock = quantityInStock;
			return this;
		}

		public ProductBuilder setIsWholesale(boolean isWholesale) {
			this.isWholesale = isWholesale;
			return this;
		}

		public Product build() {
			return new Product(this);
		}
	}
}
