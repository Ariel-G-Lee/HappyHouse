package com.ssafy.house.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.house.dto.AnimalHptDto;
import com.ssafy.house.dto.AnimalPmcDto;
import com.ssafy.house.dto.AnimalStatsDto;

@Mapper
public interface AnimalDao {

	List<AnimalStatsDto> selectHptStats();

	List<AnimalStatsDto> selectPmcStats();

	List<AnimalPmcDto> searchByDongNamePmc(String dongCode);

	int searchByDongNamePmcCount(String dongCode);
	
	List<AnimalHptDto> searchByDongNameHpt(String dongCode);

	int searchByDongNameHptCount(String dongCode);

	List<AnimalStatsDto> searchAnmimalNameStats();
	
}
