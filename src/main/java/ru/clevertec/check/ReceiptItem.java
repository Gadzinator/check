package main.java.ru.clevertec.check;

public class ReceiptItem {

	private Product product;
	private int quantity;
	private double subtotal;
	private double discount;
	private double total;

	public ReceiptItem(Product product, int quantity, double discountRate) {
		this.product = product;
		this.quantity = quantity;
		this.subtotal = product.getPrice() * quantity;
		if (product.isWholesale() && quantity >= 5) {
			this.discount = subtotal * 0.1;
		} else {
			this.discount = subtotal * discountRate;
		}
		this.total = subtotal - this.discount;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "ReceiptItem{" +
				"product=" + product +
				", quantity=" + quantity +
				", subtotal=" + subtotal +
				", discount=" + discount +
				", total=" + total +
				'}';
	}
}
