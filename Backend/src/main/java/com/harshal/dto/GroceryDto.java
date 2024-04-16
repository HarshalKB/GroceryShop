package com.harshal.dto;

public class GroceryDto {

	private String id;
	private String name;
	private String type;
	private float costPerItem;
	private String source;
	private int itemsAvailable;
	
	public GroceryDto() {
		super();
	}
	
	public GroceryDto(String id, String name, String type, float costPerItem, String source, int itemsAvailable) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.costPerItem = costPerItem;
		this.source = source;
		this.itemsAvailable = itemsAvailable;
	}
	
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
	public float getCostPerItem() {
		return costPerItem;
	}
	public void setCostPerItem(float costPerItem) {
		this.costPerItem = costPerItem;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public int getItemsAvailable() {
		return itemsAvailable;
	}
	public void setItemsAvailable(int itemsAvailable) {
		this.itemsAvailable = itemsAvailable;
	}

}
