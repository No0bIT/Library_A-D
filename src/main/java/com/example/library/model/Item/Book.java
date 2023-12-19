package com.example.library.model.Item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("BOOK")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book extends Item{

}
