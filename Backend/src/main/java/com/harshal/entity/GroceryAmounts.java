package com.harshal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "grocery_amounts")
public class GroceryAmounts {

	@Id
	private String id;
	@Column(name = "items_available")
	private int itemsAvailable;
	@Column(name = "total_cost_of_item")
	private float totalCostOfItem;
	
	public GroceryAmounts() {
		super();
	}
	
	public GroceryAmounts(String id, int itemsAvailable, float totalCostOfItem) {
		super();
		this.id = id;
		this.itemsAvailable = itemsAvailable;
		this.totalCostOfItem = totalCostOfItem;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getItemsAvailable() {
		return itemsAvailable;
	}
	public void setItemsAvailable(int itemsAvailable) {
		this.itemsAvailable = itemsAvailable;
	}
	public float getTotalCostOfItem() {
		return totalCostOfItem;
	}
	public void setTotalCostOfItem(float totalCostOfItem) {
		this.totalCostOfItem = totalCostOfItem;
	}
	
}
