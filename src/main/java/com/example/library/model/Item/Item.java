package com.example.library.model.Item;

import java.util.ArrayList;
import java.util.List;

import com.example.library.model.lending.Feedback;
import com.example.library.model.lending.ItemLending;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Item {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	   
	    private String title;
	    private int quantity;
	    private String des;
	    private String linkImage;
	    private int pageNumber;
	    private String bardCode;
	    
	    @ManyToOne
	    @JoinColumn(name = "author_id")
	    private Author author;
	    

	    @ManyToOne
	    @JoinColumn(name = "category_id")
	    private Category category;
	    
	    @OneToMany(mappedBy = "item")
	    @JsonIgnore
	    private List<Feedback> feedbacks =new ArrayList<>();
	    
	    @OneToMany(mappedBy = "item")
	    @JsonIgnore
	    private List<ItemLending> itemLendings =new ArrayList<>();
	    //author, category

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public String getDes() {
			return des;
		}

		public void setDes(String des) {
			this.des = des;
		}

		public String getLinkImage() {
			return linkImage;
		}

		public void setLinkImage(String linkImage) {
			this.linkImage = linkImage;
		}

		public int getPageNumber() {
			return pageNumber;
		}

		public void setPageNumber(int pageNumber) {
			this.pageNumber = pageNumber;
		}

		public String getBardCode() {
			return bardCode;
		}

		public void setBardCode(String bardCode) {
			this.bardCode = bardCode;
		}

		public Author getAuthor() {
			return author;
		}

		public void setAuthor(Author author) {
			this.author = author;
		}

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

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
