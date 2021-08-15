package com.example.curd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curd.model.Category;
import com.example.curd.repository.CatergoryRepository;

@Service
public class Catergoryservice {

	@Autowired
	private CatergoryRepository categoryRepositrory;

	public Category save(Category newCategory) {

		return categoryRepositrory.save(newCategory);

	}

	public List<Category> findCategories() {

		return categoryRepositrory.findAll();

	}

}
