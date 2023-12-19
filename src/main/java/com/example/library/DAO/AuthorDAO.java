package com.example.library.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.model.Item.Author;

public interface AuthorDAO extends JpaRepository<Author, Integer> {

}
