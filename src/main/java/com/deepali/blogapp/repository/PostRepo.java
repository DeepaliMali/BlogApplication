package com.deepali.blogapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.deepali.blogapp.model.Category;
import com.deepali.blogapp.model.Post;
import com.deepali.blogapp.model.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user);
	
	List<Post> findBycategory(Category category);
	
	@Query("select p from Post p where p.title like :key")
	List<Post> findByTitle(@Param("key") String title);
	
	
	
}
