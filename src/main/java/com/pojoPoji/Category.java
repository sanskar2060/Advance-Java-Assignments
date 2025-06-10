package com.pojoPoji;

public class Category {
	
	
	int id;
	String categoryNAme ;
	String description ;
	String imageUrl ;
	
	public Category(int id, String categoryNAme, String description, String imageUrl) {
		super();
		this.id = id;
		this.categoryNAme = categoryNAme;
		this.description = description;
		this.imageUrl = imageUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getCategoryNAme() {
		return categoryNAme;
	}

	public void setCategoryNAme(String categoryNAme) {
		this.categoryNAme = categoryNAme;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	
	
	

}
