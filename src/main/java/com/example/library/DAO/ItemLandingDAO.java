package com.example.library.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.model.lending.ItemLending;

public interface ItemLandingDAO extends JpaRepository<ItemLending, Integer>{

}
