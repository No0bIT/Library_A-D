package com.example.library.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.model.user.User;

public interface UserDAO extends JpaRepository<User, Integer> {

}
