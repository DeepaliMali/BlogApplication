package com.deepali.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepali.blogapp.model.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
