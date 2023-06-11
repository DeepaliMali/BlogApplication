package com.deepali.blogapp.paylods;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.deepali.blogapp.model.Category;
import com.deepali.blogapp.model.Comment;
import com.deepali.blogapp.model.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	
	private Integer postId;
	
	private String title;
	
	private String content;
	
	private String imageName;
	
	private Date addedDate;
	
	private CategoryDto category;
	
	private UserDto user;
	
	private Set<CommentDto> comments=new HashSet<>();
	
	
	

}
