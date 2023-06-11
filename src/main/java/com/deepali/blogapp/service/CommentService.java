package com.deepali.blogapp.service;

import com.deepali.blogapp.paylods.CommentDto;

public interface CommentService {
	
	CommentDto createComment(CommentDto commentDto,Integer postId);
	
	void deleteComment(Integer commentId);

}
