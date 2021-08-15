package com.example.curd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_Id")
	private long categoryId;

	@Column(name = "Name", nullable = false)
	private String name;

	@Column(name = "Description")
	private String description;

	@Autowired
	@Column(name = "attribute")
	private Attribute attribute;

	public Category(String name, String description, Attribute attribute) {
		super();
		this.name = name;
		this.description = description;
		this.attribute = attribute;
	}

	public Category() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	public long getCategoryId() {
		return categoryId;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name + ", description=" + description + ", attribute="
				+ attribute + "]";
	}

}
