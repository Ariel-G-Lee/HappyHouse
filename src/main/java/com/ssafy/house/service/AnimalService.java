package com.ssafy.house.service;

import java.util.List;

import com.ssafy.house.dto.AnimalResultDto;
import com.ssafy.house.dto.AnimalStatsDto;

public interface AnimalService {

	AnimalResultDto selectStats();

	AnimalResultDto searchByDongNameHpt(String dongCode);
	
	AnimalResultDto searchByDongNamePmc(String dongCode);

	List<AnimalStatsDto> searchAnmimalNameStats();

}
