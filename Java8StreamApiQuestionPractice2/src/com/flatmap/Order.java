package com.flatmap;

import java.util.List;

public class Order {
	private int id;
	private List<String> item;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<String> getItem() {
		return item;
	}
	public void setItem(List<String> item) {
		this.item = item;
	}
	
	
	public Order(int id, List<String> item) {
		super();
		this.id = id;
		this.item = item;
	}
	
	
		public static void main(String[] args) {
			List<Order> order= List.of(
													new Order(101, List.of("TV","Cooler","Mobile")),
													new Order(102, List.of("Laptop","Mouse","charger")),
													new Order(103,List.of("Remote","Iron"))					
					);
			List<String> orderList = order.stream().
																flatMap(p->p.getItem().stream())
																.toList();
			System.out.println(orderList);
		}
}
