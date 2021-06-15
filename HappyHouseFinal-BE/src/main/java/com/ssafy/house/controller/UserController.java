package com.ssafy.house.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ssafy.house.dto.UserDto;
import com.ssafy.house.service.UserService;

@CrossOrigin(origins = "http://localhost:5500", // allowCredentials = "true" 일 경우, orogins="*" 는 X
		allowCredentials = "true", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST,
				RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.HEAD, RequestMethod.OPTIONS })
// @CrossOrigin // 이것만으로는 오류 발생 <-- allowCredentials = "true"
@RestController
public class UserController {

	@Autowired
	UserService userService;

	private static final int SUCCESS = 1;
	private static final int FAIL = -1;

	// 회원 가입
	@PostMapping("/users")
	public ResponseEntity<Integer> userInsert(UserDto dto, MultipartHttpServletRequest request) {
		int res = userService.userInsert(dto, request);
//		System.out.println(res);
		if (res == SUCCESS) {
			return new ResponseEntity<Integer>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<Integer>(res, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// 회원 정보 조회
	@GetMapping("/users/{userId}")
	public ResponseEntity<Integer> userDetail(@PathVariable String userId) {
		UserDto userDto = userService.userDetail(userId);
		System.out.println(userDto);
		if (userDto != null) {
			System.out.println(1);
			return new ResponseEntity<Integer>(1, HttpStatus.OK);
		} else {
			System.out.println(-1);
			return new ResponseEntity<Integer>(-1, HttpStatus.NOT_FOUND);
		}
	}

	// 회원 정보 수정
	@PostMapping("/users/{userId}")
	public ResponseEntity<UserDto> userUpdate(@PathVariable String userId, UserDto dto,
			HttpSession session, MultipartHttpServletRequest request) {
		UserDto userDto = userService.userUpdate(dto, request);
		if (userDto != null) {
			session.setAttribute("userDto", userDto);
			System.out.println(dto);
			return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<UserDto>(userDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// 회원 정보 삭제
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<Integer> userDelete(@PathVariable String userId, HttpSession session) {
		int res = userService.userDelete(userId);
		if(res == SUCCESS) {
			session.invalidate();
			return new ResponseEntity<Integer>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<Integer>(res, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
