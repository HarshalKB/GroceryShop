package com.harshal.dto;

public class GrocerySourceDto {
	private String id;
	private String source;
	public GrocerySourceDto() {
		super();
	}
	public GrocerySourceDto(String id, String source) {
		super();
		this.id = id;
		this.source = source;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
}
