package com.ssafy.house.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.house.dto.UserDto;

@Mapper
public interface LoginDao {
	public UserDto login(String userId);
}
