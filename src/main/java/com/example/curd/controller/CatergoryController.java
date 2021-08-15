package com.example.curd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.curd.error.InvalidCategoryRequestException;
import com.example.curd.model.Category;
import com.example.curd.model.Item;
import com.example.curd.service.CategoryLabelItemAttributeMappingService;
import com.example.curd.service.Catergoryservice;
import com.example.curd.service.ItemService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//import com.example.curd.model.Category;

@RestController
@RequestMapping("/api/v1")
public class CatergoryController {

	@Autowired
	private Catergoryservice catergoryservice;

	@Autowired
	private ItemService itemService;

	@Autowired
	private CategoryLabelItemAttributeMappingService categoryLabelItemAttributeMappingService;

	/*
	 * Controller method to handle category creation
	 */
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/categories")
	Category createNewCategory(@RequestBody String newCategoryString)
			throws JsonMappingException, JsonProcessingException {

		Category newCategory = null;

		try {

			if (newCategoryString == null || newCategoryString.length() == 0
					|| newCategoryString.toString().equals("{}")) {

				throw new InvalidCategoryRequestException("Request can not be Empty ");

			}

			ObjectMapper mapper = new ObjectMapper();
			newCategory = mapper.readValue(newCategoryString, Category.class);
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		}

		return catergoryservice.save(newCategory);

	}

	@GetMapping("/categories")
	List<Category> getCategory() {

		return catergoryservice.findCategories();

	}

	/*
	 * method to fetch all items for given category
	 */

	@GetMapping("/categories/{categoryId}/items")
	// TODO implement this method and test it
	public List<Item> getItemsByCatergory(@PathVariable(value = "categoryId") Long categoryId,
			@RequestBody String item) {

		return null;
	}

	// TODO implement this method and test it
	@PostMapping("/catergoties/{categoryId}/items")
	public Item createNewItem(@PathVariable Long categoryId, @RequestBody String newItemString) {

		// map this new item to item object

		// save this item

		// return this item

		return null;
	}

	// TODO implement this method and test it
	@PatchMapping("/items/item")
	public Item updateExistngItem(@RequestBody String newItem) {

		// map this new item to item object

		// save this item

		// return this item

		return null;
	}

}
