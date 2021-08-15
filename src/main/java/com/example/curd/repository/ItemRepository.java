package com.example.curd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.curd.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
