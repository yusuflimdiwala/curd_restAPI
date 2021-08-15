package com.example.curd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.curd.model.Category;

public interface CatergoryRepository extends JpaRepository<Category, Long> {

}
