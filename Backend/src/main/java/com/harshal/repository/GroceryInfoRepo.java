package com.harshal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshal.entity.GroceryInfo;

public interface GroceryInfoRepo extends JpaRepository<GroceryInfo, String>{

}
