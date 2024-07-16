package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private LocalDate moment;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> orderItems = new ArrayList<>();
	
	public Order(LocalDate localDate, OrderStatus orderStatus, Client client) {
		this.moment = localDate;
		this.status = orderStatus;
		this.client = client;
	}

	public LocalDate getMoment() {
		return moment;
	}

	public void setMoment(LocalDate moment) {
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
}
