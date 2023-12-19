package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.Item.Item;
import com.example.library.model.lending.Feedback;
import com.example.library.model.lending.ItemLending;
import com.example.library.service.LendingService;

@RestController
@RequestMapping("/api/lending")
public class LendingController {

	@Autowired
	LendingService lendingService;
	// tao feedback
	@PostMapping("/createFeedback")
	public Feedback createFeedback(@RequestBody Feedback feedback)
	{
		return lendingService.createFeedback(feedback);
	}
	@GetMapping("/getAllFeedback")
	public List<Feedback> getAllFeedback (@RequestParam int idItem)
	{
		return lendingService.getAllFeedback(idItem);
	}
	// muon sach
	@PostMapping("/lendingItem")
	public ItemLending lending(@RequestBody ItemLending itemLending) {
		return lendingService.createItemLending(itemLending);
	}
	//tra sach
	@PostMapping("/returnItem")
	public ItemLending returnItem(@RequestBody ItemLending itemLending) {
		return lendingService.returnItem(itemLending);
	}
	// lay tat ca sach dang muon(chua tra) cua customer
	@GetMapping("/getItemLending")
	public List<ItemLending> getItemLending(@RequestParam int idCus){
		return lendingService.getItemLending(idCus);
	}
	// lay tat ca sach da va dang muon) cua customer
	@GetMapping("/getItemLended")
	public List<ItemLending> getItemLendied(@RequestParam int idCus){
		return lendingService.getItemLended(idCus);
	}
	
	@GetMapping("/admin/getItemLending")
	public List<ItemLending> getItemLendingADmin(){
		return lendingService.getItemLendingAdmin();
	}
	
	
}
