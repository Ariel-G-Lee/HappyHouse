
package com.ssafy.house.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ssafy.house.dto.ProfileFileDto;
import com.ssafy.house.dto.UserDto;

@Mapper
public interface UserDao {

	public UserDto userDetail(String userId);
	
	public int userInsert(UserDto dto);

	public int profileFileInsert(ProfileFileDto profileFileDto);

	public void userUpdate(UserDto dto);

	public List<String> profileFileUrlDeleteList(String userId);

	public void profileFileDelete(String userId);

	public int userDelete(String userId);

}
