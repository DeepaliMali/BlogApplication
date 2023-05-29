package com.deepali.blogapp.service;

import java.util.List;

import com.deepali.blogapp.paylods.CategoryDto;

public interface CategoryService {
	
	//create
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	
	
	//delete
	public void deleteCategory(Integer categoryId);
	
	//get
	public CategoryDto getCategory(Integer CategoryId);
	
	
	//get all
	public List<CategoryDto> getAllCategories();
	
	
	

}
