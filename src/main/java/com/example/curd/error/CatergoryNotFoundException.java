package com.example.curd.error;

public class CatergoryNotFoundException extends RuntimeException {

	public CatergoryNotFoundException(Long id) {
		super("Category id not found : " + id);
	}
}
