package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.Item.Book;
import com.example.library.model.Item.Item;
import com.example.library.model.Item.Megazine;
import com.example.library.service.ItemService;

@RestController
@RequestMapping("/api/item")
public class ItemControler {

	@Autowired
	ItemService itemService;
	//create
	@PostMapping("/createItem")
	public Item createBook(@RequestBody Item item)
	{
		return itemService.createItem(item);
	}
	@PostMapping("/createBook")
	public Book createBook(@RequestBody Book book)
	{
		return itemService.createBook(book);
	}
	@PostMapping("/createMegazine")
	public Megazine createMegazine(@RequestBody Megazine megazine)
	{
		return itemService.createMegazine(megazine);
	}
	//edit
	@PostMapping("/editItem")
	public Item editBook(@RequestBody Item item)
	{
		return itemService.editItem(item);
	}
	@PostMapping("/editBook")
	public Book editBook(@RequestBody Book book)
	{
		return itemService.editBook(book);
	}
	@PostMapping("/editMegazine")
	public Megazine editMegazine(@RequestBody Megazine megazine)
	{
		return itemService.editMegazine(megazine);
	}
	//delete
	@PostMapping("/deleteItem")
	public boolean deleteItem(@RequestBody Item item)
	{
		return itemService.deleteItem(item);
	}
	@PostMapping("/deleteBook")
	public boolean deleteItem(@RequestBody Book book)
	{
		return itemService.deleteBook(book);
	}
	@PostMapping("/deleteMegazine")
	public boolean deleteMegazine(@RequestBody Megazine megazine)
	{
		return itemService.deleteMegazine(megazine);
	}
	
	
	
	@GetMapping("/getItem")
	public Item getItem(@RequestParam int idItem ) {
		return itemService.getItem(idItem);
	}
	@GetMapping("/getAll")
	public List<Item> getAll(@RequestParam int idCus ) {
		return itemService.getAll();
	}
}
