package com.ssafy.house.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.house.dto.HouseDto;
import com.ssafy.house.dto.HouseParamDto;

@Mapper
public interface HouseDao {
	
	public List<HouseDto> searchAll(HouseParamDto houseParamDto);
	public int searchAllTotalCount();

	public List<HouseDto> searchByDongName(HouseParamDto houseParamDto);
	public int searchByDongNameTotalCount(HouseParamDto houseParamDto);

	public List<HouseDto> searchByAptName(HouseParamDto houseParamDto);
	public int searchByAptNameTotalCount(HouseParamDto houseParamDto);
	
	public HouseDto houseDetail(int no);
}
