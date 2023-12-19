package com.example.library.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.model.Item.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer>{

}
