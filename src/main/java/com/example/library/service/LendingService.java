package com.example.library.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.DAO.CustomerDAO;
import com.example.library.DAO.FeedbackDAO;
import com.example.library.DAO.FineDAO;
import com.example.library.DAO.ItemDAO;
import com.example.library.DAO.ItemLandingDAO;
import com.example.library.model.Item.Item;
import com.example.library.model.lending.Feedback;
import com.example.library.model.lending.Fine;
import com.example.library.model.lending.ItemLending;
import com.example.library.model.user.Customer;

@Service
public class LendingService {

	@Autowired
	CustomerDAO customerDAO;
	@Autowired
	ItemDAO itemDAO;
	@Autowired
	FeedbackDAO feedbackDAO;
	@Autowired
	FineDAO fineDAO;
	@Autowired
	ItemLandingDAO itemLendingDAO;
	
	// feedBack
	public Feedback createFeedback(Feedback feedback)
	{
		Customer customer = customerDAO.getById(feedback.getCustomer().getId());
		Item item = itemDAO.getById(feedback.getItem().getId());
		feedback.setCustomer(customer);
		feedback.setItem(item);
		feedbackDAO.save(feedback);
		return feedback;
	}
	// lay tat ca feedback cua item
	public List<Feedback> getAllFeedback(int idItem){
		Item item = itemDAO.getById(idItem);
		return item.getFeedbacks();
	}
	
	//muon sach lending
	public ItemLending createItemLending(ItemLending itemLending) {
		Customer customer = customerDAO.getById(itemLending.getCustomer().getId());
		//cap nhat lai so luong cua item
		Item item = itemDAO.getById(itemLending.getItem().getId());
		int quantity=item.getQuantity()-itemLending.getQuantity();
		if(quantity<0)
			return null;
		item.setQuantity(quantity);
		itemDAO.save(item);
		
		
		itemLending.setCustomer(customer);
		itemLending.setItem(item);
		LocalDateTime l=LocalDateTime.now();
		itemLending.setCreationDate(l);
		itemLending.setDueDate(l.plusDays(4));
		itemLendingDAO.save(itemLending);
		return itemLending;
	}
	//tra sach
	public ItemLending returnItem(ItemLending itemLending) {
		int id=itemLending.getId();
		itemLending=itemLendingDAO.getById(id);
		Customer customer = customerDAO.getById(itemLending.getCustomer().getId());
		//cap nhat lai so luong cua item
		Item item = itemDAO.getById(itemLending.getItem().getId());
		int quantity=item.getQuantity()+itemLending.getQuantity();
		item.setQuantity(quantity);
		itemDAO.save(item);
		
		LocalDateTime l=LocalDateTime.now();
		itemLending.setReturnDate(l);
		if(l.isAfter(itemLending.getDueDate()))//true thi la bi muon
		{
			Fine fine= new Fine();
			long soNgay=l.until(itemLending.getDueDate(), ChronoUnit.DAYS);
			fine.setAmount((int)soNgay*50000);
			fineDAO.save(fine);
			itemLending.setFine(fine);
		}
		itemLendingDAO.save(itemLending);
		return itemLending;
	}
	// lay ra tat ca sach dang muon cua customer
	public List<ItemLending> getItemLending(int idCus)
	{
		Customer customer= customerDAO.getById(idCus);
		List<ItemLending> itemLendings = customer.getItemLendings();
		List<ItemLending> result = new ArrayList<>();
		for(ItemLending itemLending:itemLendings) {
			if(itemLending.getReturnDate()==null)
				result.add(itemLending);
		}
		return result;
 	}
	//lay ra tat cac sach da muon cua customer
	public List<ItemLending> getItemLended(int idCus)
	{
		Customer customer= customerDAO.getById(idCus);
		List<ItemLending> itemLendings = customer.getItemLendings();	
		return itemLendings;
 	}
	
	// lay ra tat ca sach dang muon cho admin
	public List<ItemLending> getItemLendingAdmin()
	{
		
		List<ItemLending> itemLendings =itemLendingDAO.findAll();
		List<ItemLending> result = new ArrayList<>();
		for(ItemLending itemLending:itemLendings) {
			if(itemLending.getReturnDate()==null)
				result.add(itemLending);
		}
		return result;
 	}
	
	
}
