package com.ssafy.house.service;

import java.util.List;

import com.ssafy.house.dto.AreaDto;

public interface AreaService {

	List<AreaDto> sido();
	
	List<AreaDto> gugun(String sidoCode);
	
	List<AreaDto> dong(String gugunCode);

}
