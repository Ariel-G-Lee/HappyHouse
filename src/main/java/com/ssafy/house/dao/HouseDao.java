package com.ssafy.house.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.house.dto.HouseDto;

@Mapper
public interface HouseDao {
	
	public List<HouseDto> searchByDong(String dongCode);
	public List<HouseDto> searchByName(String aptName);
	public List<HouseDto> searchAll();
}
