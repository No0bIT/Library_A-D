package com.example.library.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.model.user.Address;

public interface AddressDAO extends JpaRepository<Address, Integer>{

}
