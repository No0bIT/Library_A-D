package com.example.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.user.Account;
import com.example.library.model.user.Customer;
import com.example.library.model.user.User;
import com.example.library.service.UserService;

@RequestMapping("/api/user")
@RestController
public class UserController {

	
	@Autowired
	UserService userService;
	
	
	@PostMapping("/createCustomer")
	public Customer createCustomer(@RequestBody Customer customer)
	{
		return userService.createCustomer(customer);
	}
	@GetMapping("/getCustomer")
	public Customer getCustomer(@RequestParam int id)
	{
		return userService.getCustomer(id);
	}
	@PostMapping("/login")
	public User login(@RequestBody Account account )
	{
		return userService.loggin(account);
	}
}
