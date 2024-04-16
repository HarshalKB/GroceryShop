package com.harshal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "grocery_source")
public class GrocerySource {
	@Id
	private String id;
	@Column(name = "source")
	private String source;
	
	public GrocerySource() {
		super();
	}

	public GrocerySource(String id, String source) {
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
