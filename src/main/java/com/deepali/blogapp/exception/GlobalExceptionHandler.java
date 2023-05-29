package com.deepali.blogapp.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.deepali.blogapp.paylods.ApiResponse;

@RestControllerAdvice 
public class GlobalExceptionHandler {

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> ResourceNotFoundExceptionHandler(ResourceNotFoundException rx)
	{
		String message=rx.getMessage();
		ApiResponse response=new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
		
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex)
	{
		Map<String, String> resp=new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error) -> 
		{ String fieldname=((FieldError)error).getField();   //Typecated error to fielderror
		String message = error.getDefaultMessage();
		resp.put(fieldname, message);
		});
		
		
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
		
		
	}
		
}
