package com.example.library.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.model.lending.Feedback;

public interface FeedbackDAO  extends JpaRepository<Feedback, Integer>{

}
