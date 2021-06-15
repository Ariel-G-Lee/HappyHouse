package com.ssafy.house.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.house.dto.AreaDto;

@Mapper
public interface AreaDao {

	List<AreaDto> sido();

	List<AreaDto> gugun(String sidoCode);

	List<AreaDto> dong(String gugunCode);

}
