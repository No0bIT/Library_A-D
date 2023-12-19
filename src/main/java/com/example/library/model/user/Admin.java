package com.example.library.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("ADMIN")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Admin extends User {
    private String des;

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

    // Constructors, getters, setters, etc.
    
}