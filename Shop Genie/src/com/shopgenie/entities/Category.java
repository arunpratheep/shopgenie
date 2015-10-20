package com.shopgenie.entities;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Category {

	@Id
	@SequenceGenerator(name = "seq_category", sequenceName = "seq_category", allocationSize    = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_category")
	Long categoryId;
	String categoryName;
	
	@OneToMany(mappedBy="parentCategory",cascade=CascadeType.ALL)
	Collection<Category> subCategory = new HashSet<Category>();

	@ManyToOne(cascade=CascadeType.ALL)
	private Category parentCategory;
	
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
		newCategory.setParentCategory(this);
		return this.subCategory.add(newCategory);
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

}
