package com.example.library.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.model.lending.Fine;

public interface FineDAO extends JpaRepository<Fine, Integer>{

}
