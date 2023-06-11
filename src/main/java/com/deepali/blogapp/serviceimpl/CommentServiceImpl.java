package com.deepali.blogapp.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepali.blogapp.exception.ResourceNotFoundException;
import com.deepali.blogapp.model.Comment;
import com.deepali.blogapp.model.Post;
import com.deepali.blogapp.paylods.CommentDto;
import com.deepali.blogapp.repository.CommentRepo;
import com.deepali.blogapp.repository.PostRepo;
import com.deepali.blogapp.service.CommentService;

@Service
public class CommentServiceImpl implements  CommentService{
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {

		Post post=this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "Post id", postId));
		
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		
		comment.setPost(post);
		
		Comment savedComment = this.commentRepo.save(comment);
		
		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {

		Comment com=this.commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "CommentId", commentId));
		
		this.commentRepo.delete(com);
		
	}

}
