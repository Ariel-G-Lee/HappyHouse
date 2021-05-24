package com.ssafy.house.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.house.dto.AnimalHptDto;
import com.ssafy.house.dto.AnimalStatsDto;

@Mapper
public interface AnimalHptDao {

	List<AnimalStatsDto> selectStats();

	List<AnimalHptDto> searchByDongName(String dongCode);

	int searchByDongNameCount(String dongCode);

}
