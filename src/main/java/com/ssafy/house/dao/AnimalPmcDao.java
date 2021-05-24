package com.ssafy.house.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.house.dto.AnimalPmcDto;
import com.ssafy.house.dto.AnimalStatsDto;

@Mapper
public interface AnimalPmcDao {

	List<AnimalStatsDto> selectStats();

	List<AnimalPmcDto> searchByDongName(String dongCode);

	int searchByDongNameCount(String dongCode);

}
