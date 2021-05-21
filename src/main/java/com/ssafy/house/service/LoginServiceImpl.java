package com.ssafy.house.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.house.dao.LoginDao;
import com.ssafy.house.dto.UserDto;


@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginDao loginDao;
	
	@Override
	public UserDto login(UserDto dto) {
		
		UserDto userDto = loginDao.login(dto.getUserId());
		if( userDto != null && userDto.getUserPwd().equals(dto.getUserPwd())) 
			return userDto;
		else
			return null;
	}
}