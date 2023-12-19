package com.example.library.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.model.user.Admin;

public interface AdminDAO extends JpaRepository<Admin, Integer>{

}
