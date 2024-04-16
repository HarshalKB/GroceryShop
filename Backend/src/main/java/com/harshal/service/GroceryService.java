package com.harshal.service;

import java.util.List;

import com.harshal.dto.GroceryDto;
import com.harshal.dto.GrocerySourceDto;

public interface GroceryService {
	List<GrocerySourceDto> getSource();
	List<GroceryDto> getGrocery();
	GroceryDto createGrocery(GroceryDto groceryDto);
	GroceryDto updateGrocery(String id, GroceryDto updatedGrocery);
	void deleteGrocery(String id);
}
