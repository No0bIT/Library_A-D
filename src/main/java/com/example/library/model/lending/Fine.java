package com.example.library.model.lending;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Fine {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	private int amount;
	
	@OneToOne(mappedBy = "fine")
	private  ItemLending itemLending;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public ItemLending getItemLending() {
		return itemLending;
	}

	public void setItemLending(ItemLending itemLending) {
		this.itemLending = itemLending;
	} 
	
	
}
