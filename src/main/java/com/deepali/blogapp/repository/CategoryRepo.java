package com.deepali.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepali.blogapp.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>
{

}
