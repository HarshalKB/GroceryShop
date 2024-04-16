package com.harshal.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harshal.dto.GroceryDto;
import com.harshal.dto.GrocerySourceDto;
import com.harshal.service.GroceryService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class GroceryController {
	
	private GroceryService groceryService;
	
	public GroceryController(GroceryService groceryService) {
		super();
		this.groceryService = groceryService;
	}
	
	@GetMapping("/sources")
	public ResponseEntity<List<GrocerySourceDto>> getAllSources() {
		List<GrocerySourceDto> grocerySourceDto = groceryService.getSource();
		return ResponseEntity.ok(grocerySourceDto);
	}
	
	@GetMapping("/grocery")
	public ResponseEntity<List<GroceryDto>> getAllGrocery() {
		List<GroceryDto> groceryDto = groceryService.getGrocery();
		return ResponseEntity.ok(groceryDto);
	}
	
	@PostMapping("/add")
	public ResponseEntity<GroceryDto> createGrocery(@RequestBody GroceryDto groceryDto) {
		GroceryDto savedGrocery = groceryService.createGrocery(groceryDto);
		return ResponseEntity.ok(savedGrocery);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<GroceryDto> updateGrocery(@PathVariable("id") String id, @RequestBody GroceryDto updatedGrocery) {
		GroceryDto groceryDto = groceryService.updateGrocery(id, updatedGrocery);
		return ResponseEntity.ok(groceryDto);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteGrocery(@PathVariable("id") String id) {
		groceryService.deleteGrocery(id);
		return ResponseEntity.ok("Grocery deleted Successfully.");
	}
}
