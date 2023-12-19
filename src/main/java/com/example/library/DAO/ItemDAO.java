package com.example.library.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.model.Item.Item;

public interface ItemDAO extends JpaRepository<Item, Integer>{

}
