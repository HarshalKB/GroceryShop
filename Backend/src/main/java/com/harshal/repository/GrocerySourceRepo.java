package com.harshal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshal.entity.GrocerySource;

public interface GrocerySourceRepo extends JpaRepository<GrocerySource, String>{

}
