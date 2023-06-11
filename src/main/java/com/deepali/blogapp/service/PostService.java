package com.deepali.blogapp.service;

import java.util.List;

import com.deepali.blogapp.model.Post;
import com.deepali.blogapp.paylods.PostDto;
import com.deepali.blogapp.paylods.PostResponse;

public interface PostService {

	
	//create
	PostDto createPost(PostDto postDto,Long userId,Integer categoryId);
	
	//update
	PostDto updatePost(PostDto postDto,Integer postId);
	
	//delete
	void deletePost(Integer postId);
	
	//get All posts
	PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);
	
	//get single post
	PostDto getPostById(Integer PostId);
	
	//get all posts by category
	List<PostDto> getPostBycategory(Integer categoryId);
	
	//get all posts by user
	List<PostDto> getPostByUser(Long userId);
	
	//search post
	List<PostDto> searchPost(String keyword);
	
	
}
