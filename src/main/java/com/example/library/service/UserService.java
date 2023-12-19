package com.example.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.DAO.AddressDAO;
import com.example.library.DAO.AdminDAO;
import com.example.library.DAO.CustomerDAO;
import com.example.library.DAO.UserDAO;
import com.example.library.model.user.Account;
import com.example.library.model.user.Admin;
import com.example.library.model.user.Customer;
import com.example.library.model.user.User;

@Service
public class UserService {

	@Autowired
	UserDAO userDAO;
	@Autowired
	CustomerDAO customerDAO;
	@Autowired
	AdminDAO adminDAO;
	@Autowired
	AddressDAO addressDAO;
	
	//create
	public User createUser(User user) {
		userDAO.save(user);
		return user;
	}
	public Customer createCustomer(Customer customer)
	{
		List<User> users= userDAO.findAll();
		for(User user:users) {
			if(user.getAccount().getUsername().equals(customer.getAccount().getUsername()))
				return null;
		}
		customer.setRole("customer");
		customerDAO.save(customer);
		return customer;
	}
	public Admin createAdmin(Admin admin)
	{
		admin.setRole("admin");
		adminDAO.save(admin);
		return admin;
	}
	// edit
	public User editUser(User user) {
		userDAO.save(user);
		return user;
	}
	public Customer editCustomer(Customer customer)
	{
		customerDAO.save(customer);
		return customer;
	}
	public Admin editAdmin(Admin admin)
	{
		adminDAO.save(admin);
		return admin;
	}
	//login
	public User loggin(Account account) {
		List<User> users= userDAO.findAll();
		for(User user:users) {
			if(user.getAccount().getUsername().equals(account.getUsername()) & 
					user.getAccount().getPassword().equals(account.getPassword()))
				return user;
		}
		return null;
	}
	//get customer
	public Customer getCustomer(int id)
	{
		return customerDAO.getById(id);
//		return new Customer();
	}
	
}
