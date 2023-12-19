package com.example.library.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.DAO.AuthorDAO;
import com.example.library.DAO.BookDAO;
import com.example.library.DAO.CategoryDAO;
import com.example.library.DAO.ItemDAO;
import com.example.library.DAO.MegazineDAO;
import com.example.library.model.Item.Author;
import com.example.library.model.Item.Book;
import com.example.library.model.Item.Category;
import com.example.library.model.Item.Item;
import com.example.library.model.Item.Megazine;


@Service
public class ItemService {

	@Autowired
	AuthorDAO authorDAO;
	@Autowired
	BookDAO bookDAO;
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	ItemDAO itemDAO;
	@Autowired
	MegazineDAO megazineDAO;
	
	//create
	public Author createAuthor(Author author ) {
		List<Author> authors=authorDAO.findAll();
		for(Author au:authors)
		{
			if(au.getName().equals(author.getName()))
				return au;
		}
		authorDAO.save(author);
		return author;
	}
	public Category createCategory(Category category)
	{
		List<Category> categories= categoryDAO.findAll();
		for(Category cat:categories)
		{
			if(cat.getName().equals(category.getName()))
				return cat;
		}
		categoryDAO.save(category);
		return category;
	}
	//createBook
	public Book createBook(Book book) {
		List<Book> books= bookDAO.findAll();
		for(Book b:books) {
			if(b.getTitle().equals(book.getTitle()))
				return null;
		}
		Category category = createCategory(book.getCategory());
		book.setCategory(category);
		Author author = createAuthor(book.getAuthor());
		book.setAuthor(author);
		bookDAO.save(book);
		return book;
	}
	//createItem
	public Item createItem(Item item) {
		List<Item> items= itemDAO.findAll();
		for(Item i:items) {
			if(i.getTitle().equals(item.getTitle()))
				return null;
		}
		Category category = createCategory(item.getCategory());
		item.setCategory(category);
		Author author = createAuthor(item.getAuthor());
		item.setAuthor(author);
		itemDAO.save(item);
		return item;
	}
	//createMegazine
	public Megazine createMegazine(Megazine megazine)
	{
		List<Megazine> megazines= megazineDAO.findAll();
		for(Megazine m:megazines) {
			if(m.getTitle().equals(megazine.getTitle()))
				return null;
		}
		Category category = createCategory(megazine.getCategory());
		megazine.setCategory(category);
		Author author = createAuthor(megazine.getAuthor());
		megazine.setAuthor(author);
		megazineDAO.save(megazine);
		return megazine;
	}
	
	//editBook
		public Item editItem(Item item) {
			Item i= itemDAO.getById(item.getId());
			i.setBardCode(item.getBardCode());
			i.setDes(item.getDes());
			i.setLinkImage(item.getLinkImage());
			i.setPageNumber(item.getPageNumber());
			i.setQuantity(item.getQuantity());
			itemDAO.save(i);
			return i;
		}
		
	//editBook
	public Book editBook(Book book) {
		Book b= bookDAO.getById(book.getId());
		b.setBardCode(book.getBardCode());
		b.setDes(book.getDes());
		b.setLinkImage(book.getLinkImage());
		b.setPageNumber(book.getPageNumber());
		b.setQuantity(book.getQuantity());
		bookDAO.save(book);
		return b;
	}
	
	//edit Megazine
	public Megazine editMegazine(Megazine megazine) {
		Megazine m= megazineDAO.getById(megazine.getId());
		m.setBardCode(megazine.getBardCode());
		m.setDes(megazine.getDes());
		m.setLinkImage(megazine.getLinkImage());
		m.setPageNumber(megazine.getPageNumber());
		m.setQuantity(megazine.getQuantity());
		megazineDAO.save(m);
		return m;
	}
	//delete
	public boolean deleteItem(Item item) {
		itemDAO.deleteById(item.getId());
		return true;
	}
	public boolean deleteBook(Book book) {
		bookDAO.deleteById(book.getId());
		return true;
	}
	public boolean deleteMegazine(Megazine megazine) {
		megazineDAO.deleteById(megazine.getId());
		return true;
	}
	// get
	public Item getItem(int id) {
		return itemDAO.getById(id);
	}
	//getALL
	public List<Item> getAll() {
		return itemDAO.findAll();
	}
}
