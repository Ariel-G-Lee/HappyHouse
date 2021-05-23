package com.ssafy.house.service;

import com.ssafy.house.dto.HouseParamDto;
import com.ssafy.house.dto.HouseResultDto;

public interface HouseService {
	public HouseResultDto searchByDongName(HouseParamDto houseParamDto);
	public HouseResultDto searchByAptName(HouseParamDto houseParamDto);
	public HouseResultDto searchAll(HouseParamDto houseParamDto);
	public HouseResultDto houseDetail(int no);
}
