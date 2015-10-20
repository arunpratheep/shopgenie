package com.shopgenie.entities;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Category {

	@Id
	@SequenceGenerator(name = "category_seq", sequenceName = "category_seq", allocationSize    = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
	Long categoryId;
	String categoryName;
	
	Collection<Category> subCategory = new HashSet<Category>();

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Collection<Category> getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(Collection<Category> subCategory) {
		this.subCategory = subCategory;
	}

	public boolean addCategory(Category newCategory) {
		return this.subCategory.add(newCategory);
	}

}
