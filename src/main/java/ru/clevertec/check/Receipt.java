package main.java.ru.clevertec.check;

import java.util.ArrayList;
import java.util.List;

public class Receipt {

	private List<ReceiptItem> items;
	private double total;
	private double discount;
	private double finalTotal;

	public Receipt() {
		items = new ArrayList<>();
	}

	public void addItem(ReceiptItem item) {
		items.add(item);
		total += item.getSubtotal();
		discount += item.getDiscount();
		finalTotal += item.getTotal();
	}

	public List<ReceiptItem> getItems() {
		return items;
	}

	public void setItems(List<ReceiptItem> items) {
		this.items = items;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getFinalTotal() {
		return finalTotal;
	}

	public void setFinalTotal(double finalTotal) {
		this.finalTotal = finalTotal;
	}
}
