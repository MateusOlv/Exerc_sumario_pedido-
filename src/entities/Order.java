package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	
	private LocalDateTime moment;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> orderItems = new ArrayList<>();
	
	public Order(LocalDateTime localDateTime, OrderStatus orderStatus, Client client) {
		this.moment = localDateTime;
		this.status = orderStatus;
		this.client = client;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderItem() {
		return orderItems;
	}

	public void addItem(OrderItem orderItem) {
		orderItems.add(orderItem);
	}
	
	public void removeItem(OrderItem orderItem) {
		orderItems.remove(orderItem);
	}
	
	public Double total() {
		Double Total = 0.0;
		for(OrderItem o : orderItems) {
			Total += o.subTotal();
		}
		return Total;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY:\n");
		sb.append("Order moment: " + moment.format(fmt) + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append("Client: " + client.getName());
		sb.append(" (" + client.getBirthDate() + ") - " + client.getEmail() + "\n");
		sb.append("Order items:\n");
		for(OrderItem o : orderItems) {
			sb.append(o.getProduct().getName() + ", ");
			sb.append(String.format("$%.2f",o.getPrice()) + ", ");
			sb.append("Quantity: " + o.getQuantity() + ", ");
			sb.append(String.format("Subtotal: $%.2f\n",o.subTotal()));
		}
		sb.append(String.format("Total price: $%.2f", total()));
		
		return sb.toString();
	}
	
	
}
