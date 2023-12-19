package com.example.library.model.user;

import java.util.ArrayList;
import java.util.List;

import com.example.library.model.lending.Feedback;
import com.example.library.model.lending.ItemLending;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("CUSTOMER")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer extends User {
    private String des;

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	} 
    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Feedback> feedbacks =new ArrayList<>();
    
    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<ItemLending> itemLendings =new ArrayList<>();
    // Constructors, getters, setters, etc.

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public List<ItemLending> getItemLendings() {
		return itemLendings;
	}

	public void setItemLendings(List<ItemLending> itemLendings) {
		this.itemLendings = itemLendings;
	}
    
    
}
