package com.example.library.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.model.Item.Megazine;

public interface MegazineDAO extends JpaRepository<Megazine, Integer>{

}
