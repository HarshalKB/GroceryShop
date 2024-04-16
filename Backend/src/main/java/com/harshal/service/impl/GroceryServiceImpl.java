package com.harshal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshal.dto.GroceryDto;
import com.harshal.dto.GrocerySourceDto;
import com.harshal.entity.GroceryAmounts;
import com.harshal.entity.GroceryInfo;
import com.harshal.entity.GrocerySource;
import com.harshal.exception.ResourceNotFoundException;
import com.harshal.mapper.GroceryMapper;
import com.harshal.repository.GroceryAmountsRepo;
import com.harshal.repository.GroceryInfoRepo;
import com.harshal.repository.GrocerySourceRepo;
import com.harshal.service.GroceryService;

@Service
public class GroceryServiceImpl implements GroceryService{
	
	@Autowired
	private GrocerySourceRepo grocerySourceRepo;
	@Autowired
	private GroceryAmountsRepo groceryAmountsRepo;
	@Autowired
	private GroceryInfoRepo groceryInfoRepo;

	@Override
	public List<GrocerySourceDto> getSource() {
		List<GrocerySource> sources = grocerySourceRepo.findAll();
		return sources.stream().map((source) -> GroceryMapper.mapToGrocerySourceDto(source)).toList();
	}

	@Override
	public GroceryDto createGrocery(GroceryDto groceryDto) {
		GroceryInfo groceryInfo = GroceryMapper.mapToGroceryInfo(groceryDto);
		GroceryAmounts groceryAmounts = GroceryMapper.mapToGroceryAmounts(groceryDto);
		
		GroceryAmounts savedGroceryAmount = groceryAmountsRepo.save(groceryAmounts);
		GroceryInfo savedGroceryInfo = groceryInfoRepo.save(groceryInfo);
		
		return GroceryMapper.mapToGroceryDto(savedGroceryInfo, savedGroceryAmount);
	}

	@Override
	public void deleteGrocery(String id) {
		GroceryAmounts groceryAmounts = groceryAmountsRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Grocery does not exists by the given id : " + id));
		GroceryInfo groceryInfo = groceryInfoRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Grocery does not exists by the given id : " + id));
		
		groceryAmountsRepo.deleteById(id);
		groceryInfoRepo.deleteById(id);
	}

	@Override
	public List<GroceryDto> getGrocery() {
		List<GroceryInfo> groceryInfo = groceryInfoRepo.findAll();
		List<GroceryAmounts> groceryAmount = groceryAmountsRepo.findAll();
		List<GroceryDto> groceryDto = new ArrayList<GroceryDto>();
		for (int i = 0; i < groceryInfo.size(); i++) {
			groceryDto.add(GroceryMapper.mapToGroceryDto(groceryInfo.get(i), groceryAmount.get(i)));
		}
		return groceryDto;
	}

	@Override
	public GroceryDto updateGrocery(String id, GroceryDto updatedGrocery) {
		GroceryInfo groceryInfo = groceryInfoRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Grocery does not exists by the given id : " + id));
		GroceryAmounts groceryAmounts = groceryAmountsRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Grocery does not exists by the given id : " + id));
		
		groceryInfo.setName(updatedGrocery.getName());
		groceryInfo.setSource(updatedGrocery.getSource());
		groceryInfo.setType(updatedGrocery.getType());
		groceryInfo.setCostPerItem(updatedGrocery.getCostPerItem());
		groceryAmounts.setItemsAvailable(updatedGrocery.getItemsAvailable());
		groceryAmounts.setTotalCostOfItem(updatedGrocery.getItemsAvailable() * updatedGrocery.getCostPerItem());
		
		GroceryInfo updatedGroceryInfo = groceryInfoRepo.save(groceryInfo);
		GroceryAmounts updatedGroceryAmounts = groceryAmountsRepo.save(groceryAmounts);
		
		return GroceryMapper.mapToGroceryDto(updatedGroceryInfo, updatedGroceryAmounts);
	}

	
}
