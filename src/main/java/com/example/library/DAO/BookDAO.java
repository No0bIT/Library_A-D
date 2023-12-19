package com.example.library.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.model.Item.Book;

public interface BookDAO extends JpaRepository<Book, Integer>{

}
