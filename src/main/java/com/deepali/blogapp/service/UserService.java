package com.deepali.blogapp.service;

import java.util.List;

import com.deepali.blogapp.paylods.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto userDto);
	UserDto updateUser(UserDto user,Long uid);
	UserDto getUserById(Long userId);
	List<UserDto> getAllUsers();
	void deleteUser(Long userId);
	
}
