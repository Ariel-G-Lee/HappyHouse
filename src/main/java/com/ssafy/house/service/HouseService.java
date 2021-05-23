package com.ssafy.house.service;

import java.util.List;

import com.ssafy.house.dto.HouseDto;

public interface HouseService {
	public List<HouseDto> searchByDong(String dongCode);
	public List<HouseDto> searchByName(String aptName);
}
