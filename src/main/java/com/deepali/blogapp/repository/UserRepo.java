package com.deepali.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepali.blogapp.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
