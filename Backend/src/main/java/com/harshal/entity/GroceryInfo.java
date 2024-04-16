package com.harshal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "grocery_info")
public class GroceryInfo {

	@Id
	private String id;
	@Column(name = "name")
	private String name;
	@Column(name = "type")
	private String type;
	@Column(name = "source")
	private String source;
	@Column(name = "cost_per_item")
	private float costPerItem;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public float getCostPerItem() {
		return costPerItem;
	}
	public void setCostPerItem(float costPerItem) {
		this.costPerItem = costPerItem;
	}
	public GroceryInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GroceryInfo(String id, String name, String type, String source, float costPerItem) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.source = source;
		this.costPerItem = costPerItem;
	}
	
	
}
