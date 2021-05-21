package com.ssafy.house.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.house.dto.UserDto;
import com.ssafy.house.service.LoginService;

@CrossOrigin(
		origins = "http://localhost:5500", 
		allowCredentials = "true", 
		allowedHeaders = "*", 
		methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.OPTIONS}
)
@RestController
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@PostMapping(value="/login")
	public ResponseEntity<UserDto> login(@RequestBody UserDto dto, HttpSession session){
		
		UserDto userDto = service.login(dto);
		if( userDto != null ) {
			session.setAttribute("userDto", userDto);
			return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
		}
		return new ResponseEntity<UserDto>(userDto, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value="/logout")
	public ResponseEntity<UserDto> logout(HttpSession session){
		 UserDto userDto = (UserDto) session.getAttribute("userDto");
		 if( userDto != null ) {
			 session.invalidate();
			return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
		}
		return new ResponseEntity<UserDto>(userDto, HttpStatus.NOT_FOUND);
		 
	}
}
