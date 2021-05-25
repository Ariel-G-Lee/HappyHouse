package com.ssafy.house.service;

import com.ssafy.house.dto.AnimalResultDto;

public interface AnimalService {

	AnimalResultDto selectStats();

	AnimalResultDto searchByDongNameHpt(String dongCode);
	
	AnimalResultDto searchByDongNamePmc(String dongCode);

}
