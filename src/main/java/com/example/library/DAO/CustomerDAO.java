package com.example.library.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.model.user.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {

}
