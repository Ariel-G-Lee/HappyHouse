
package com.ssafy.house.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ssafy.house.dto.UserDto;

public interface UserService {

	public UserDto userDetail(String userId);

	public int userInsert(UserDto dto, MultipartHttpServletRequest request);

	public int userUpdate(UserDto dto, MultipartHttpServletRequest request);

	public int userDelete(String userId);

}
