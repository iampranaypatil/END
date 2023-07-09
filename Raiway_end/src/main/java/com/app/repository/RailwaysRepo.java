package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Category;
import com.app.entities.Railway;

public interface RailwaysRepo extends JpaRepository<Railway, Long>{

		List<Railway>findByCategory(Category cat);
	
}
