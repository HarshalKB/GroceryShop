package com.harshal.mapper;

import com.harshal.dto.GroceryDto;
import com.harshal.dto.GrocerySourceDto;
import com.harshal.entity.GroceryAmounts;
import com.harshal.entity.GroceryInfo;
import com.harshal.entity.GrocerySource;

public class GroceryMapper {

	public static GroceryDto mapToGroceryDto(GroceryInfo groceryInfo, GroceryAmounts groceryAmounts) {
		return new GroceryDto(
			groceryInfo.getId(),
			groceryInfo.getName(),
			groceryInfo.getType(),
			groceryInfo.getCostPerItem(),
			groceryInfo.getSource(),
			groceryAmounts.getItemsAvailable()
		);
	}
	
	public static GroceryInfo mapToGroceryInfo(GroceryDto groceryDto) {
		return new GroceryInfo(
			groceryDto.getId(),
			groceryDto.getName(),
			groceryDto.getType(),
			groceryDto.getSource(),
			groceryDto.getCostPerItem()
		);
	}
	
	public static GroceryAmounts mapToGroceryAmounts(GroceryDto groceryDto) {
		return new GroceryAmounts(
			groceryDto.getId(),
			groceryDto.getItemsAvailable(),
			groceryDto.getItemsAvailable()*groceryDto.getCostPerItem()
		);
	}
	
	public static GrocerySourceDto mapToGrocerySourceDto(GrocerySource grocerySource) {
		return new GrocerySourceDto(
			grocerySource.getId(),
			grocerySource.getSource()
		);
	}
}
