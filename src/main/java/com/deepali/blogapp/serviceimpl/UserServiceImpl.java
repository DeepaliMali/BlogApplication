package com.deepali.blogapp.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.deepali.blogapp.exception.ResourceNotFoundException;
import com.deepali.blogapp.model.User;
import com.deepali.blogapp.paylods.UserDto;
import com.deepali.blogapp.repository.UserRepo;
import com.deepali.blogapp.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user = this.modelMapper.map(userDto, User.class);
		User saveduser = userRepo.save(user);
			
			return this.modelMapper.map(saveduser, UserDto.class);
		
			}

	@Override
	public UserDto updateUser(UserDto userDto, Long userId) {
		
		 User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updateduser = this.userRepo.save(user);
		
		return this.modelMapper.map(updateduser, UserDto.class);	
		}

	@Override
	public UserDto getUserById(Long userId) {
User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "Id", userId));
		
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		List<UserDto> usersdtos = users.stream().map(user -> this.modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
		return usersdtos;	
		
	}

	@Override
	public void deleteUser(Long userId) {
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		
		this.userRepo.delete(user);
		
	}

		
}
