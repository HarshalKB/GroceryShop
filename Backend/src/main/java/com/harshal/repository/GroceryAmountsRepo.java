package com.harshal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshal.entity.GroceryAmounts;

public interface GroceryAmountsRepo extends JpaRepository<GroceryAmounts, String>{

}
