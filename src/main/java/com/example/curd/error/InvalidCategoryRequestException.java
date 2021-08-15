package com.example.curd.error;

public class InvalidCategoryRequestException extends RuntimeException {

	public InvalidCategoryRequestException(String msg) {
		super(msg);
	}
}
