package com.ssafy.house.service;

import com.ssafy.house.dto.AnimalResultDto;

public interface AnimalHptService {

	AnimalResultDto selectStats();

	AnimalResultDto searchByDongName(String dongCode);



}
